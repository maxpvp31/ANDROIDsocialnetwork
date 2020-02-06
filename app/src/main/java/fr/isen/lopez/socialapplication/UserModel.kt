package fr.isen.lopez.socialapplication



class UserModel {

    var email : String? = ""
    var  nom : String? = ""
    var prenom : String? = ""
    var ddnaissance :String? = ""
    var photo: String? = ""
    var posts : ArrayList<String?>? = ArrayList<String?>()
    var date_added : String? =""


    constructor( email: String?,  nom: String?,  prenom: String?,  ddnaissance: String?,  photo: String?, posts : ArrayList<String?>?, date_added : String?){

        this.email = email
        this.nom = nom
        this.prenom = prenom
        this.ddnaissance = ddnaissance
        this.photo = photo
        this.posts = posts
        this.date_added = date_added
    }






}