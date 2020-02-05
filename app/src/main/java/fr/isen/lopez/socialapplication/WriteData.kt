package fr.isen.lopez.socialapplication

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class WriteData {
    companion object {
        private const val TAG = "Activity"
    }

    val database = FirebaseDatabase.getInstance()

    fun writeNewPost( date: String?, text: String?, img : String?) {

        val dataPost = database.getReference("Posts")
        val newId = dataPost.push().key.toString()

        val post = PostModel(date, text, img, null, null)
        dataPost.child(newId).setValue(post)
    }


    fun Register( id: String, email: String?, nom: String?, prenom : String?, ddnaissance: String?) {

        val dataPost = database.getReference("Users")
        val post = UserModel(email, nom, prenom, ddnaissance, null)

        dataPost.child(id).setValue(post)
        Log.d("OK", "Passé dataPost")
    }

    fun ReadPosts() {

        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(value in dataSnapshot.children ) {

                    Log.d(WriteData.TAG, "Value is: ${value}")
                }


            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(WriteData.TAG, "Failed to read value.", error.toException())
            }
        })

    }

    
}