package ma.douaij.littlelemon.router

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ma.douaij.littlelemon.helpers.PreferencesManager
import ma.douaij.littlelemon.screens.Home
import ma.douaij.littlelemon.screens.Profile
import ma.douaij.littlelemon.screens.RegisterScreen

@Composable
fun Navigation( context : ComponentActivity) {
    val preferencesManager = remember { PreferencesManager(context) }
    //onboarding default screen if user is not logged in
    // home default screen if user  is logged in
    // profile child of home

    val navController = rememberNavController()
    // get if the user is logedin in from shared preferences
    val  isLoggedIn = preferencesManager.checkifUserExist()
    val router = if (isLoggedIn) {
        HomeDestinations.route
    } else {
        OnboardingDestinations.route
    }
    NavHost(
        navController = navController,
        startDestination = router,
        builder = {
            composable(HomeDestinations.route) {
                Home(navController = navController, context)
            }
            composable(OnboardingDestinations.route) {
                RegisterScreen(navController = navController, preferencesManager )
            }
            composable(ProfileDestination.route) {
                Profile(navController = navController, preferencesManager)
            }

        }
    )
}
