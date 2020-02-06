package fr.isen.lopez.socialapplication

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ReadData {
    companion object {
        private const val TAG = "Activity"
    }
    val database = FirebaseDatabase.getInstance()




    fun ReadPosts() :  ArrayList<PostModel> {
        val posts : ArrayList<PostModel>  =  ArrayList<PostModel>()
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(value in dataSnapshot.children ) {
                    val post: PostModel? = value.getValue(PostModel::class.java)
                    posts.add(post!!)
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })

return posts
    }


/*    fun ReadUsers() :  ArrayList<ReadUsers> {
        val users : ArrayList<ReadUsers>  =  ArrayList<ReadUsers>()
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(value in dataSnapshot.children ) {
                    val post : PostModel? = value.getValue(PostModel::class.java)
                    posts.add(post!!)
                }


            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })

        return posts
    }*/



    fun ReadPostByUser(user_id: String?){


    }



}

