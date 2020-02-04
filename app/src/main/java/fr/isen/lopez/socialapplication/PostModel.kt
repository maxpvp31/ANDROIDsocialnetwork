package fr.isen.lopez.socialapplication

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PostModel{


    val database = FirebaseDatabase.getInstance()
    companion object {
        private const val TAG = "Activity"
    }

    var text: String? = ""
    var img: String? = ""
    var date : String?=""
    var comments : ArrayList<Int>? = ArrayList<Int>()
    var likes : ArrayList<Int>? = ArrayList<Int>()

   fun InitPostModel(date: String?, text: String?, img: String?, comments: ArrayList<Int>?, likes: ArrayList<Int>? ){

        this.text = text
       this.img = img
       this.date = date
       this.comments = comments
       this.likes = likes

    }


    fun writeNewPost( date: String?, text: String?, img : String?) {

        val dataPost = database.getReference("Posts")
        val newId = dataPost.push().key.toString()
        val post = InitPostModel(date, text, img, null, null)
        dataPost.child(newId).setValue(post)
    }


    fun ReadPosts() {

        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(value in dataSnapshot.children ) {

                    Log.d(PostModel.TAG, "Value is: ${value}")
                }


            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(PostModel.TAG, "Failed to read value.", error.toException())
            }
        })

    }


}