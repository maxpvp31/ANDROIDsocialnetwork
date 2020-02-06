package fr.isen.lopez.socialapplication


class PostModel{




    var text: String? = ""
    var img: String? = ""
    var date : String?=""
    var user_id :  String?=""
    var comments : ArrayList<Int>? = ArrayList<Int>()
    var likes : ArrayList<String>? = ArrayList<String>()

constructor(text: String?, img :String?, date : String?,user_id :  String?, comments : ArrayList<Int>?, likes : ArrayList<String>? ){
    this.text = text
    this.img = img
    this.date = date
    this.comments = comments
    this.likes =likes
    this.user_id = user_id

}


}