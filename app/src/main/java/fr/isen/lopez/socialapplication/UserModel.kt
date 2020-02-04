package fr.isen.lopez.socialapplication

import android.util.Log
import com.google.firebase.database.FirebaseDatabase

class UserModel {

    var email : String? = ""
    var  nom : String? = ""
    var prenom : String? = ""
    var ddnaissance :String? = ""
    var photo: String? = ""
    var posts : ArrayList<Int>? = ArrayList<Int>()

    val database = FirebaseDatabase.getInstance()

constructor( email: String?,  nom: String?,  prenom: String?,  ddnaissance: String?,  photo: String?){

    this.email = email
    this.nom = nom
    this.prenom = prenom
    this.ddnaissance = ddnaissance
    this.photo = photo

    }





}