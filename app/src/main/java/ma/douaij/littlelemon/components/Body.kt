package ma.douaij.littlelemon.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ma.douaij.littlelemon.R
import ma.douaij.littlelemon.ui.theme.CustomeTextFieldcolors
import ma.douaij.littlelemon.ui.theme.Radiuses
import ma.douaij.littlelemon.ui.theme.bhallkhder
import ma.douaij.littlelemon.ui.theme.gray100
import ma.douaij.littlelemon.ui.theme.yellow100


@Composable
fun Body(modifier : Modifier = Modifier,value : String , onsearch : (String ) -> Unit , onchange : (String ) -> Unit) {
 Card (  modifier = modifier .fillMaxWidth() , shape = RectangleShape,  colors = CardDefaults.cardColors(containerColor = bhallkhder)){
     Column(modifier = modifier
         .fillMaxWidth()
         .padding(10.dp)) {
         Text(text = "Little Lemon ", style = MaterialTheme.typography.displayMedium, fontFamily = FontFamily.Monospace, color = yellow100)
         Spacer(modifier = Modifier.height(10.dp) )

         Row (modifier = Modifier
             .fillMaxWidth()
               ){
             Column(modifier = Modifier
                 .padding(end = 20.dp)
                 .fillMaxWidth(0.6f)
             ) {
                 Text(text = "Chicago    \uD83C\uDF4B ", style = MaterialTheme.typography.bodyLarge, color = Color.White)
               Spacer(modifier = Modifier.height(10.dp) )
                 Text(text = "We are a family owned Mediterranean resaurant , focused on traditional recipes served with a modern twist  ", style = MaterialTheme.typography.bodyMedium, color = gray100)
             }
             RoundedImage(
                 painterResource(id = R.drawable.littlelemonchicago),
                 contentDescription = "croissant",
                 modifier = Modifier
                     .padding(5.dp)
             )
         }
         Spacer(modifier = Modifier.height(10.dp) )
         CustomTextInput( modifier = Modifier.fillMaxWidth(), onchange = onchange,  raduis = Radiuses.Circle, label = {
             Icon(Icons.Default.Search , contentDescription = null)
         } ,  colors = CustomeTextFieldcolors.graystrocked , hint = null , text = value)

     }
 }
    }

