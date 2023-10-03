package ma.douaij.littlelemon.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ma.douaij.littlelemon.components.CustomButton
import ma.douaij.littlelemon.components.CustomPupUp
import ma.douaij.littlelemon.components.CustomTextInput
import ma.douaij.littlelemon.components.Header
import ma.douaij.littlelemon.helpers.PreferencesManager
import ma.douaij.littlelemon.helpers.fakeDelay
import ma.douaij.littlelemon.modules.Credentials
import ma.douaij.littlelemon.router.Destinations
import ma.douaij.littlelemon.router.OnboardingDestinations
import ma.douaij.littlelemon.ui.theme.CustomButtonColors
import ma.douaij.littlelemon.ui.theme.CustomeTextFieldcolors
import ma.douaij.littlelemon.ui.theme.Radiuses
import ma.douaij.littlelemon.ui.theme.errorColor
import ma.douaij.littlelemon.ui.theme.gray100
import ma.douaij.littlelemon.ui.theme.green400
import ma.douaij.littlelemon.ui.theme.yellow100

@Composable
fun Profile(navController: NavHostController,preferencesManager: PreferencesManager) {
    var credentials by remember { mutableStateOf(preferencesManager.getCredential( )) }
    var popedup by remember { mutableStateOf(false) }
    var popedupError by remember { mutableStateOf(false) }
    var confrmationpopup by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val paddingandheight = Modifier
        .padding(horizontal = 30.dp)
        .fillMaxWidth()
    Column(modifier = Modifier
        .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally ) {
        Header()
        Surface(modifier = Modifier
            .fillMaxWidth()
         , color = Color.Black  ) {
            Column(
                modifier = Modifier.fillMaxWidth().height(70.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(modifier = Modifier.fillMaxWidth().padding(top = 10.dp), text = "Profile " ,  style =   MaterialTheme.typography.displayLarge, color = yellow100,textAlign  =  TextAlign.Companion.Center)
                 }
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextInput( modifier = paddingandheight  , text = credentials.firstName ,onchange = { credentials = credentials.copy(firstName = it) } ,
            raduis = Radiuses.Square  , label = null, colors = CustomeTextFieldcolors.graystrocked , hint = "First Name"    )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextInput( modifier = paddingandheight, text = credentials.lastName  ,onchange = { credentials =credentials.copy(lastName = it) } ,
            raduis = Radiuses.Square  ,label = null, colors = CustomeTextFieldcolors.graystrocked    ,hint = "Last Name")
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextInput( modifier = paddingandheight , text = credentials.email ,onchange = { credentials =credentials.copy(email = it) } ,
            raduis = Radiuses.Square ,label = null , colors = CustomeTextFieldcolors.graystrocked  , hint = "Email"    )

        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(modifier = paddingandheight , text = "Save changes" , border  = Radiuses.Square ,  colors = CustomButtonColors.blackContent , reload = credentials.loading,
            onclick = {
                credentials= credentials.copy(loading = true)
                if(credentials.allfieldsNotEmpty())
                {
                    coroutineScope.launch {
                        credentials= credentials.copy(loading = true)
                        preferencesManager.putCredential(credentials)
                        credentials= credentials.copy(loading = false)
                        popedup= true
                    }
                }
                else{
                    coroutineScope.launch {
                        fakeDelay()
                        credentials= credentials.copy(loading = false)
                        popedupError = true
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(modifier = paddingandheight , text = "Sign out" , border  = Radiuses.Square ,  colors = CustomButtonColors.blackBodyredText , reload = credentials.loading,
            onclick = {
                 confrmationpopup = true
            }
        )
    }
    CustomPupUp(   popedupError , error = true , {popedupError = it}){
        Text(
        text = "Please fill all fields",
        style = MaterialTheme.typography.headlineMedium, color = errorColor
    )
    }
    CustomPupUp(  confrmationpopup , error = false , {    confrmationpopup = it}){
        Column (modifier = Modifier.height(100.dp) , horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.SpaceBetween)    {
            Text(
                text = "Are you sure you want to sign out ?",
                style = MaterialTheme.typography.headlineLarge, color = green400
            )
            Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.End ){
                CustomButton(modifier = Modifier
                    .width(200.dp)
                    .height(50.dp), text = "Confirm", border = Radiuses.Rounded , colors = CustomButtonColors.greencontent, onclick = {
                    credentials= credentials.copy(loading = true)
                    confrmationpopup = false
                    coroutineScope.launch {
                        credentials= credentials.copy(loading = true)
                        preferencesManager.putCredential(Credentials("","",""))
                        credentials= credentials.copy(loading = false)
                        preferencesManager.clear()
                        popedup= true
                        navController.navigate(OnboardingDestinations.route)
                    }
                })

            }
        }

    }

    CustomPupUp(    popedup , error = false , {popedup = it} ){
        Text(
            text = "Updated Successfully ",
            style = MaterialTheme.typography.headlineMedium,
            color = green400
        )
    }
}

/*

    xw7q-MCts-GT4E
    qCcW-Eagx-7G5s
    2iy5-HbaS-CKDY
    KNts-aL2k-aTk4
    fWC9-kBq3-9jjE

 */
