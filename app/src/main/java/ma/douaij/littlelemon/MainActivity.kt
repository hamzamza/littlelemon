package ma.douaij.littlelemon

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import ma.douaij.littlelemon.helpers.MenuItemRoom
import ma.douaij.littlelemon.helpers.MenuRepository
import ma.douaij.littlelemon.router.Navigation
import ma.douaij.littlelemon.screens.RegisterScreen
import ma.douaij.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitUi(context = applicationContext  , this)
        }
    }
}
@Serializable
data class Account(
    val name :String
)
@Composable
fun InitUi(context : Context , avivity : ComponentActivity) {
    LittleLemonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
        Navigation(avivity)
        }
    }
}

