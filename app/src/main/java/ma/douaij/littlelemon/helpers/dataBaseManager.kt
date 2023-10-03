package ma.douaij.littlelemon.helpers

import android.content.Context
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ma.douaij.littlelemon.screens.Categories

class MenuRepository(val applicationContext: ComponentActivity) {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
    private val database by lazy {

        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }
    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        var response : MenuNetwork = MenuNetwork (listOf())
        try {
            response  = httpClient.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json") .body()
            return response.menu
        }catch (e : Exception ){
            Log.e("error fetching data ",  e.message.toString() );
        }
        Log.d("fetching but not updating ui", "but no data are in ")
       return  listOf()
    }
    fun init( menuliveData: MutableLiveData<List<MenuItemRoom>>){
        applicationContext.lifecycleScope.launch(Dispatchers.IO) {
                fetchMenu().also { it ->
                    Log.d("fetching but not updating ui", "Fetching menu from network ")
                    menuliveData.postValue(it.map { it.toMenuItemRoom() })
                    Log.d("fetching but not updating ui", "fetching after ui update ")
                }
            }
            }
    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
        database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
    }


    fun filterbycategory(categoryIndex : Int , menuliveData: MutableLiveData<List<MenuItemRoom>>)  {
        if( categoryIndex == 0 )
            applicationContext.lifecycleScope.launch(Dispatchers.IO) {
                fetchMenu().also { it ->
                    menuliveData.postValue(it.map { it.toMenuItemRoom() } )
                }
            }
        else{
            applicationContext.lifecycleScope.launch(Dispatchers.IO) {
                fetchMenu().also { it ->
                    menuliveData.postValue(it.map { it.toMenuItemRoom() }.filter { it.category == Categories.getCategoriesList()[categoryIndex].toString })
                }
            }
        }
    }

    fun filterbySearching(searchString : String , menuliveData: MutableLiveData<List<MenuItemRoom>>)  {
        applicationContext.lifecycleScope.launch(Dispatchers.IO) {
            fetchMenu().also { it ->
                menuliveData.postValue(it.map { it.toMenuItemRoom() }.filter { it.title.contains(searchString) })
            }
    }}
}
