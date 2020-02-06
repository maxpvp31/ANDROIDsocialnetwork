package fr.isen.lopez.socialapplication



class CommentModel {

    var text : String? = ""
    var  id_user : String? = ""
    var id_post : String? = ""
    var date_added : String? = ""



    constructor( text: String?,  id_user: String?,  id_post: String?, date_added : String?){

        this.text = text
        this.id_user = id_user
        this.id_post = id_post
        this.date_added = date_added
    }



}