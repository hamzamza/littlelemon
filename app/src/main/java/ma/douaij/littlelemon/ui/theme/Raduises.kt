package ma.douaij.littlelemon.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class Radiuses(val radius : Dp = 0.dp){
    object Rounded : Radiuses(30.dp)
    object Square : Radiuses( 5.dp)
    object Circle : Radiuses( 100.dp)
    object None : Radiuses(0.dp)
}
