package fr.isen.lopez.socialapplication

import com.google.firebase.database.PropertyName


data class UserModel(
    @PropertyName("email") val email: String?,
    @PropertyName("nom") val nom: String?,
    @PropertyName("prenom") val prenom : String?,
    @PropertyName("ddnaissance") val ddnaissance :  String?,
    @PropertyName("photo") val photo :  String?,
    @PropertyName("posts") val posts : ArrayList<String>?,
    @PropertyName("date_added") val date_added :  String?)
{
    constructor() : this("","","","","",null,"")
}
