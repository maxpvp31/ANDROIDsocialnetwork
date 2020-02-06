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

  // fun FindUserOnPost(post_id: String?): String?{


   //}
    //  fun FindUserOnComment(comment_id : String?) : String?{
   //  }
    //  fun FindCommentOnPosts(post_id : String?) : String?{
   // }
   // fun FindPostsOnComment(comment_id : String?) : String?{
   // }
    //    fun FindPostsOnComment(comment_id : String?) : String?{
   //    }
    //   fun PostsbyUser(user_id : String?){
   //  }
    //     fun LikebyUser(user_id : String?){
    //     }

    fun CommentsbyUser(user_id : String?){
    }
    fun CommentsbyPosts(post_id : String?){
    }

    fun ReadPosts() : ArrayList<PostModel>  {
        val posts : ArrayList<PostModel>  =  ArrayList<PostModel>()
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(value in dataSnapshot.children ) {

                   val post = value.getValue(PostModel::class.java)

                  posts.add(post!!)

                }
                Log.d(ReadData.TAG, "Value is: ${posts}")

            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })

        return posts

    }

    fun ReadPostByUser(user_id: String?){
        val myRef = database.getReference("Users")


    }



}