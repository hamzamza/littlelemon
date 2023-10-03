package ma.douaij.littlelemon.router

interface Destinations {
    val route : String
    val lable: String
}
object HomeDestinations : Destinations {
    override val route: String = "/"
    override val lable: String = "Home"
}
object OnboardingDestinations : Destinations {
    override val route: String = "/onboarding"
    override val lable: String = "Register"
}

object ProfileDestination : Destinations {
    override val route: String = "/profile"
    override val lable: String = "Profile"
}