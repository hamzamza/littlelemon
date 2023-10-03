package ma.douaij.littlelemon.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import ma.douaij.littlelemon.ui.theme.errorColor
import ma.douaij.littlelemon.ui.theme.green400
import ma.douaij.littlelemon.ui.theme.transparentBlack

@Composable
fun CustomPupUp(isShowen: Boolean,
                error: Boolean, isShowenChange: (Boolean) -> Unit, body:@Composable  () -> Unit
){
    val color = if(error)  errorColor else green400
    val icon = if(error ) Icons.Filled.Close else Icons.Default.CheckCircle
    if(isShowen){
        Surface(modifier = Modifier
            .fillMaxSize()
            .noRippleClickable { isShowenChange(false) } , color = transparentBlack) {
            Popup (
                alignment = Alignment.CenterStart,properties= PopupProperties(focusable = false ),
            ) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp), colors =  CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,) , elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)){
                    Column( modifier = Modifier.padding(horizontal = 20.dp, vertical = 40.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {  Icon(
                            icon,
                            contentDescription = "close",
                            tint = color,
                            modifier = Modifier
                                .padding(10.dp)
                                .size(50.dp)
                        )
                    body()}
                    }
                }
            }

        }
    }
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}