package ma.douaij.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale



@Composable
fun RoundedImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    cornerRadius: Int = 16 // Adjust the corner radius as needed
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(shape = RoundedCornerShape(cornerRadius))
            .background(Color.Gray) // Background color of the rounded shape
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun AsyncRoundedImage(painter: Painter, contentDescription : String = "image description ", modifier: Modifier = Modifier, cornerRadius: Int = 16 // Adjust the corner radius as needed
){
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(shape = RoundedCornerShape(cornerRadius))
            .background(Color.Gray) // Background color of the rounded shape
    ) {

     Image(painter = painter , contentDescription = "deskc", modifier = Modifier.fillMaxSize() , contentScale = ContentScale.Crop)
    }
}

