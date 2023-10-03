package ma.douaij.littlelemon.ui.theme



import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ma.douaij.littlelemon.R

private val QuickSand = FontFamily(
    Font( R.font.productsans_light, FontWeight.W300),
    Font(R.font.productsans_regular, FontWeight.W400),
    Font(R.font.productsans_medium, FontWeight.W500),
    Font(R.font.productsans_bold, FontWeight.W600),
    Font(R.font.productsans_regular, FontWeight.Normal),
)

val GoogleTypography =    Typography(
    displayLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),

    displayMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),

    displaySmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),

    headlineSmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),

    titleLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),

    titleMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),

    titleSmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = QuickSand,
        fontSize = 14.sp
    ),

    bodySmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    labelLarge = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),

    labelMedium = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),

    labelSmall = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )

)