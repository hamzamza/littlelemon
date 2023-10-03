package ma.douaij.littlelemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ma.douaij.littlelemon.screens.Categories

import ma.douaij.littlelemon.ui.theme.bhallkhder
import ma.douaij.littlelemon.ui.theme.gray400

@Composable
fun Hero(
    modifier: Modifier = Modifier,
    selectedIndex:  Int ,
    onSelect: (Int ) -> Unit,
) {
        Column(modifier = modifier) {
            Text(text = "Order For Delvery !", modifier = Modifier.padding(start = 5.dp, top = 10.dp, bottom = 8.dp) , style = MaterialTheme.typography.headlineLarge , fontWeight = FontWeight.Bold, color = gray400)
            val items = Categories.getCategoriesList()
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(2.dp)
            ) {
                items.forEachIndexed { index, itemText ->
                    item {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp)
                                 ,
                            colors = ButtonDefaults.buttonColors( containerColor = if (selectedIndex == index) bhallkhder else Color(0xA9BEBEBE)  ,
                                contentColor = if (selectedIndex == index)  Color.White else bhallkhder),
                            onClick = {
                                onSelect(index)
                                // Handle item selection here
                            }
                        ) {
                            Text(
                                text = itemText.lable,
                                style = MaterialTheme.typography.headlineSmall,
                            )
                        }
                    }
                }
            }

}

        }





@Composable
fun GradientBackground(modifier: Modifier = Modifier, color : Color ) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(color, Color.Transparent),
        startY = 0.0f,
        endY = 100.0f // Adjust the endY value as needed for the desired gradient effect
    )

    Box(
        modifier = modifier
            .fillMaxWidth().background(brush = gradientBrush)
    ) {
        // Your content goes here
    }
}