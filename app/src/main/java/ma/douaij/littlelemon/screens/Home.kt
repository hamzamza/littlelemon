package ma.douaij.littlelemon.screens
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import ma.douaij.littlelemon.components.Body
import ma.douaij.littlelemon.components.FoodCard
import ma.douaij.littlelemon.components.Header
import ma.douaij.littlelemon.components.Hero
import ma.douaij.littlelemon.helpers.BackHandler
import ma.douaij.littlelemon.helpers.MenuItemRoom
import ma.douaij.littlelemon.helpers.MenuRepository
import ma.douaij.littlelemon.router.ProfileDestination
import ma.douaij.littlelemon.ui.theme.bhallkhder

@Composable
fun Home(navController: NavHostController , context : ComponentActivity) {
    val menuRepostory = MenuRepository(context)
    val menuliveData = MutableLiveData<List<MenuItemRoom>>()
    val menuItems = menuliveData.observeAsState(listOf())
    var searchStringState by remember { mutableStateOf("") }
    var selectedCategoryIndex by remember { mutableStateOf<Int>(0) }
    menuRepostory.init(menuliveData = menuliveData)
        BackHandler  {
            Column {
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(horizontal = 6.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment =  Alignment.CenterVertically ) {
    Header()
    FilledTonalIconButton(   onClick = {
        navController.navigate(ProfileDestination.route) } , colors = IconButtonDefaults.iconButtonColors(containerColor = bhallkhder)) {
        Icon(Icons.Default.Person, contentDescription = "Profile"  , tint = Color.White)
    }
}
                Body(onsearch = {}, onchange ={searchStringState = it ; menuRepostory.filterbySearching(it, menuliveData , )  }, value = searchStringState)
                Hero(modifier = Modifier , selectedIndex = selectedCategoryIndex ){
                    selectedCategoryIndex = it;
                    menuRepostory.filterbycategory(it , menuliveData)
                }
                MenuItemsList(menuItems.value)
            }
        }
}




@Composable
private fun MenuItemsList(items: List<MenuItemRoom>) {
    val state = rememberLazyListState()
    if (items.isEmpty()) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.Center) {
            Text(text = "No items found", color = Color.Blue)
        }
    }
      else {
        val listofasyncpainters = items.map { rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(it.image)
                .size(Size.ORIGINAL) // Set the target size to load the image at.
                .build()
        ) }
        LazyColumn(
            state = state,
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 20.dp)
        ) {
            items(
                count = items.size,
                itemContent = { index ->
                    FoodCard(
                        food = items[index],  painter = listofasyncpainters[index]
                    )
                }
            )
        }
    }

}

sealed class Categories(val  toString : String , val lable : String = toString ){
    object Starters : Categories("starters" , lable  = "Starters")
    object Main : Categories("mains" , lable  = "Mains"  )
    object Dessert : Categories("desserts" , lable  = "Desserts")
    object Drinks : Categories("Drinks"     , lable  = "Drinks")
    object All : Categories("All"   , lable  = "All")
  companion object  {
      fun getCategoriesList ()  : List<Categories>{
        return    listOf<Categories>(
            Categories.All,
            Categories.Starters,
            Categories.Dessert,
            Categories.Drinks,
            Categories.Main
        )
        }
     }
}


