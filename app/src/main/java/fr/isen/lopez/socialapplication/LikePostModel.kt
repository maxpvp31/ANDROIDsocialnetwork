package fr.isen.lopez.socialapplication



class LikePostModel {

    var user_id : String? = ""
    var  post_id : String? = ""
    var type : Int? = null
    var date_added : String? = ""




    constructor( user_id: String?,  post_id: String?,  type : Int?, date_added : String?){

        this.user_id = user_id
        this.post_id = post_id
        this.type = type
        this.date_added = date_added

    }



}