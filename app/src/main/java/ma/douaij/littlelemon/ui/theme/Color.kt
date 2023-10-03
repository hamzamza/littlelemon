package ma.douaij.littlelemon.ui.theme

import androidx.compose.ui.graphics.Color


val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val yellow100 = Color(0xFFC4B216)
val yellow400 = Color(0xFF987A35)// for borders
val gray100 = Color(0xFFABABAB)
val gray400 = Color(0xFF576662)
val bhallkhder = Color(0xFF576662)
val likeBlack = Color(0xFF212121)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val errorColor = Color(
    0.914f,
    0.118f,
    0.388f,
    1.0f
)
val green400  = Color(0xFF16C456)
val transparentBlack = Color(0.0f, 0.0f, 0.0f, 0.235f)

sealed class CustomButtonColors(val containerColor  : Color ,  val textColor : Color ,val borderColor: Color   ){
    object errorcontent : CustomButtonColors(containerColor = errorColor , textColor = Color.White  , borderColor = Color.Red   )
    object greencontent : CustomButtonColors(containerColor = green400 , textColor =  Color.White , borderColor = Color.Green   )
    object yellowContent : CustomButtonColors(containerColor = yellow100 , textColor = Color.White, borderColor = Color.Transparent  )
    object blackContent : CustomButtonColors(containerColor = Color.Black , textColor = yellow100, borderColor = Color.Transparent  )
    object blackBodyredText : CustomButtonColors(containerColor = Color.Black , textColor = errorColor, borderColor = Color.Transparent  )
}

sealed class CustomeTextFieldcolors(val containerColor  : Color ,  val textColor : Color ,val borderColor: Color ,val cursorColor : Color  ){
    object yellowstrocked : CustomeTextFieldcolors(containerColor = Color.White , textColor = gray400 , borderColor = yellow400 , cursorColor = gray100   )
    object graystrocked : CustomeTextFieldcolors(containerColor = Color.White , textColor = gray400, borderColor = gray400 , cursorColor = gray100   )
}