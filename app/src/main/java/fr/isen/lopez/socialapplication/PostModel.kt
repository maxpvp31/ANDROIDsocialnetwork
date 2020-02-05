package fr.isen.lopez.socialapplication

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PostModel{


    val database = FirebaseDatabase.getInstance()

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