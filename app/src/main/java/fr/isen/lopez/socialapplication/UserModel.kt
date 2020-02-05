package fr.isen.lopez.socialapplication



class UserModel {

    var email : String? = ""
    var  nom : String? = ""
    var prenom : String? = ""
    var ddnaissance :String? = ""
    var photo: String? = ""
    var posts : ArrayList<Int>? = ArrayList<Int>()


    constructor( email: String?,  nom: String?,  prenom: String?,  ddnaissance: String?,  photo: String?){

        this.email = email
        this.nom = nom
        this.prenom = prenom
        this.ddnaissance = ddnaissance
        this.photo = photo

    }





}