package ma.douaij.littlelemon.components
import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ma.douaij.littlelemon.ui.theme.CustomeTextFieldcolors
import ma.douaij.littlelemon.ui.theme.Radiuses

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextInput(modifier : Modifier,label :( @Composable ()-> Unit )?,  onchange: (String ) -> Unit, raduis : Radiuses, colors : CustomeTextFieldcolors, text : String ="", hint : String?, ){

Column (  horizontalAlignment =  Alignment.Start){
    if(hint != null)
    Box(modifier = modifier.padding(start  = 5.dp)){
        Text(text = hint , color = colors.textColor ,   style =   MaterialTheme.typography.headlineMedium)
        // make some height box here
        Spacer(modifier = Modifier.height(3.dp))}


    TextField(
        modifier = modifier.border(1.3.dp ,color=  colors.borderColor , RoundedCornerShape(raduis.radius))    ,
        value = text,
        textStyle =    MaterialTheme.typography.bodyLarge,
        singleLine = true ,
        shape = RoundedCornerShape(raduis.radius),
        onValueChange = { onchange(it); },
        colors =  TextFieldDefaults.textFieldColors(containerColor = colors.containerColor  , cursorColor = colors.borderColor , textColor = colors.textColor ,  focusedIndicatorColor = Color.Transparent , unfocusedIndicatorColor =  Color.Transparent) ,
       leadingIcon = label
    )

}
}
