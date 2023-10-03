package ma.douaij.littlelemon.helpers

import android.app.Activity
import androidx.activity.OnBackPressedCallback

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun BackHandler(
    compose: @Composable () -> Unit
) {
    val context = LocalContext.current
    val dispatcherOwner = LocalOnBackPressedDispatcherOwner.current
    val onBackPressedDispatcher = dispatcherOwner?.let { rememberUpdatedState(it.onBackPressedDispatcher) }
    val lifecycleOwner = LocalLifecycleOwner.current


    DisposableEffect(lifecycleOwner) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (context as? Activity)?.finish()
            }
        }
        if (onBackPressedDispatcher != null) {
            onBackPressedDispatcher.value.addCallback(callback)
        }
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                callback.remove()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            callback.remove()
            lifecycleOwner.lifecycle.removeObserver(observer)
        }

    }
    compose()
}