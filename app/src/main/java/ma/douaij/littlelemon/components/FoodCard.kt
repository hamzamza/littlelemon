package ma.douaij.littlelemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ma.douaij.littlelemon.helpers.MenuItemRoom
import ma.douaij.littlelemon.ui.theme.bhallkhder
import ma.douaij.littlelemon.ui.theme.gray100


@Composable
fun FoodCard(modifier: Modifier = Modifier, food: MenuItemRoom,painter : Painter ) {
                Card (  modifier = modifier.fillMaxWidth() ,     shape = RectangleShape,  colors = CardDefaults.cardColors(containerColor = Color.White)){
                    Column(modifier = modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(vertical = 5.dp , horizontal = 10.dp)) {
                        Text(text = food.title, style = MaterialTheme.typography.headlineSmall,   color = bhallkhder)
                        Row (modifier = Modifier
                            .fillMaxWidth()
                        ){
                            Column(modifier = Modifier
                                .padding(end = 20.dp)
                                .fillMaxWidth(0.76f)
                            ) {
                                Text(text = food.description, style = MaterialTheme.typography.bodySmall, color = gray100)
                                Spacer(modifier = Modifier.height(10.dp) )
                                Text(text ="$ "+ food.price.toString(), style = MaterialTheme.typography.bodyLarge, color = bhallkhder , fontWeight = FontWeight.Medium)
                          }
                            AsyncRoundedImage(painter =  painter , contentDescription = food.title , modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp) , cornerRadius = 10)
                        }
                        HorizontalDivider(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp), color = Color(0xFFE0E0E0))
                    }
            }
        }

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    color : Color  = Color.Black,
    height: Dp = 1.dp
){
    Spacer(modifier = modifier
        .height(height)
        .background(color = color) ,   )
}
