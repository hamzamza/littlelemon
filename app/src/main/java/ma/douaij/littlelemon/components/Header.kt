package ma.douaij.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import ma.douaij.littlelemon.R

@Composable
fun Header(modifier: Modifier = Modifier){
    Image(
        painterResource(id = R.drawable.logo),
        contentDescription = "logo",
        modifier = modifier.padding(20.dp).height(40.dp),
    )
}
