package ma.douaij.littlelemon.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ma.douaij.littlelemon.ui.theme.CustomButtonColors
import ma.douaij.littlelemon.ui.theme.Radiuses

@Composable
fun CustomButton(modifier : Modifier , text : String, border : Radiuses, colors: CustomButtonColors, onclick : () -> Unit,  reload : Boolean = false  ){
    ElevatedButton(onClick = { onclick() ;  } , shape =  RoundedCornerShape(border.radius) , modifier = modifier
        .height(56.dp)
        .border(1.dp, color = colors.borderColor, RoundedCornerShape(border.radius))  , colors = ButtonDefaults.buttonColors( containerColor = colors.containerColor) ) {
          if ( reload )   {
              CircularProgressIndicator(
              modifier = Modifier.width(30.dp),
               color = colors.textColor,
                strokeWidth = 3.dp
          )
        }
          else  Text(text = text , color = colors.textColor , style =   MaterialTheme.typography.displaySmall)
    }
}
