package fr.isen.lopez.socialapplication

import com.google.firebase.database.FirebaseDatabase

class UserModel {
    val database = FirebaseDatabase.getInstance()
    var email : String? = ""
    var  nom : String? = ""
    var prenom : String? = ""
    var ddnaissance :String? = ""
    var photo: String? = ""
    var posts : ArrayList<Int>? = ArrayList<Int>()



    fun InitUser(email: String?, nom: String?, prenom: String?, ddnaissance: String?, photo: String?){

        this.email = email
        this.nom = nom
        this.prenom = prenom
        this.ddnaissance = ddnaissance
        this.photo = photo

    }


    fun Register( id: String, email: String?, nom: String?, prenom : String?, ddnaissance: String?) {

        val dataPost = database.getReference("Users")
        val post = InitUser(email, nom, prenom, ddnaissance, null)
        dataPost.child(id).setValue(post)
    }
    fun PostByUser(posts : ArrayList<Int>){
        this.posts =  posts
    }

}