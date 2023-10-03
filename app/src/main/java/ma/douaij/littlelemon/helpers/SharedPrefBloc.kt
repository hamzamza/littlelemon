package ma.douaij.littlelemon.helpers

import android.content.Context
import android.content.SharedPreferences
import ma.douaij.littlelemon.modules.Credentials


class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =   context.getSharedPreferences(SharedPrefKeys.dataStoreName.key, Context.MODE_PRIVATE)

      fun getCredential(): Credentials {
        val firstName = sharedPreferences.getString(SharedPrefKeys.firstName.key, "") ?: ""
        val lastName = sharedPreferences.getString(SharedPrefKeys.lastName.key, "") ?: ""
        val email = sharedPreferences.getString(SharedPrefKeys.email.key, "") ?: ""
        return Credentials(firstName, lastName, email)
    }
    fun clear(){
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

      fun putCredential(credentials: Credentials) {
        val editor = sharedPreferences.edit()
        editor.putString(SharedPrefKeys.firstName.key , credentials.firstName)
        editor.putString(SharedPrefKeys.lastName.key, credentials.lastName)
        editor.putString(SharedPrefKeys.email.key  , credentials.email)
        editor.putBoolean(SharedPrefKeys.IsLoggedIn.key , true )
        editor.apply()
    }

      fun checkifUserExist(): Boolean {
          return sharedPreferences.getBoolean(SharedPrefKeys.IsLoggedIn.key, false)
    }
}
sealed class SharedPrefKeys(val key : String){
    object dataStoreName : SharedPrefKeys("mydataStore")
    object IsLoggedIn : SharedPrefKeys("isLoggedIn")
    object firstName : SharedPrefKeys("firstName")
    object lastName  : SharedPrefKeys("lastName")
    object email : SharedPrefKeys("email")
}