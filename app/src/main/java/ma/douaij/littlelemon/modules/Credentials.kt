package ma.douaij.littlelemon.modules

class Credentials(
    var firstName: String,
    var lastName: String,
    var email: String,
    var loading : Boolean = false) {

    fun allfieldsNotEmpty(): Boolean {
        return !(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty())
    }
    fun copy(firstName: String?= null , lastName: String? =null, email : String ? =null, loading : Boolean?=null): Credentials {
        return Credentials(firstName ?: this.firstName, lastName ?: this.lastName, email ?: this.email, loading ?: this.loading)
    }

}
