package ma.douaij.littlelemon.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ma.douaij.littlelemon.components.CustomButton
import ma.douaij.littlelemon.components.CustomPupUp
import ma.douaij.littlelemon.components.CustomTextInput
import ma.douaij.littlelemon.components.Header
import ma.douaij.littlelemon.helpers.BackHandler
import ma.douaij.littlelemon.helpers.PreferencesManager
import ma.douaij.littlelemon.helpers.fakeDelay
import ma.douaij.littlelemon.modules.Credentials
import ma.douaij.littlelemon.router.HomeDestinations
import ma.douaij.littlelemon.ui.theme.CustomButtonColors
import ma.douaij.littlelemon.ui.theme.CustomeTextFieldcolors
import ma.douaij.littlelemon.ui.theme.Radiuses
import ma.douaij.littlelemon.ui.theme.errorColor
import ma.douaij.littlelemon.ui.theme.gray100
import ma.douaij.littlelemon.ui.theme.green400

@Composable
fun RegisterScreen(navController: NavHostController, preferencesManager: PreferencesManager ) {
    var credentials by remember { mutableStateOf(Credentials("", "", "")) }
    var popedup by remember { mutableStateOf(false) }
    var popedupError by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val paddingandheight = Modifier
        .padding(horizontal = 10.dp)
        .fillMaxWidth()
    BackHandler {


    Column(modifier = Modifier
        .fillMaxSize()
       , horizontalAlignment = Alignment.CenterHorizontally   ) {
        Header()
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) , color = gray100 , ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Let's Go To Know You ." ,  style =   MaterialTheme.typography.displayLarge)
            }
           }
                 Spacer(modifier = Modifier.height(20.dp))

        CustomTextInput( modifier = paddingandheight  , text = credentials.firstName ,onchange = { credentials = credentials.copy(firstName = it) } ,
            raduis = Radiuses.Square  , colors = CustomeTextFieldcolors.graystrocked ,label = null, hint = "First Name"    )
                Spacer(modifier = Modifier.height(10.dp))

        CustomTextInput( modifier = paddingandheight, text = credentials.lastName  ,onchange = { credentials =credentials.copy(lastName = it) } ,
            raduis = Radiuses.Square  , colors = CustomeTextFieldcolors.graystrocked    ,label = null,hint = "Last Name")

                 Spacer(modifier = Modifier.height(10.dp))
        CustomTextInput( modifier = paddingandheight , text = credentials.email ,onchange = { credentials =credentials.copy(email = it) } ,
            raduis = Radiuses.Square  , colors = CustomeTextFieldcolors.graystrocked ,label = null , hint = "Email"    )

        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(modifier = paddingandheight , text = "Register" , border  = Radiuses.Square ,  colors = CustomButtonColors.yellowContent , reload = credentials.loading,
           onclick = {

                credentials= credentials.copy(loading = true)
                if(credentials.allfieldsNotEmpty())
                {
                    coroutineScope.launch {
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
        }
    CustomPupUp(             popedupError , error = true , {popedupError = it}){
        Text(
            text = "Please fill all fields",
            style = MaterialTheme.typography.headlineMedium, color = errorColor
        )

    }
    CustomPupUp(    popedup , error = false , {popedup = it ; navController.navigate(HomeDestinations.route)} ){
        Text(
            text = "Updated Successfully ",
            style = MaterialTheme.typography.headlineMedium,
            color = green400
        )
    }
    }}








