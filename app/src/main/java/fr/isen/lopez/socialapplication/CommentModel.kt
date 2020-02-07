package fr.isen.lopez.socialapplication

class CommentModel {

    var text: String? = ""
    var d_user: String? = ""
    var id_post: String? = ""


    constructor(text: String?, d_user :String?, id_post : String?){
        this.text = text
        this.d_user = d_user
        this.id_post = id_post
    }


}