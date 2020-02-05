package fr.isen.lopez.socialapplication


class PostModel{




    var text: String? = ""
    var img: String? = ""
    var date : String?=""
    var comments : ArrayList<Int>? = ArrayList<Int>()
    var likes : ArrayList<Int>? = ArrayList<Int>()

constructor(text: String?, img :String?, date : String?, comments : ArrayList<Int>?, likes : ArrayList<Int>? ){
    this.text = text
    this.img = img
    this.date = date
    this.comments = comments
    this.likes =likes

}


}