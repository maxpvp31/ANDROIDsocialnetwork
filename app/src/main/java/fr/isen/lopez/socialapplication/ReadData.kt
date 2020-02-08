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

    var UsersArray :  ArrayList<UserModel> =  ArrayList<UserModel>()

    fun ReadPosts() : ArrayList<PostModel>  {

        var user : UserModel?
        val posts : ArrayList<PostModel>  =  ArrayList<PostModel>()
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(value in dataSnapshot.children ) {

                   val post = value.getValue(PostModel::class.java)
                    user = getUser(post!!.user_id)
                    Log.d(ReadData.TAG, user.toString())
                  posts.add(post!!)
                    UsersArray.add(user!!)

                }


            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })

        return posts

    }

    fun getUserPosts() :  ArrayList<UserModel>{
        return this.UsersArray

    }
    fun ReadPostByUser(user_id : String) : PostModel?{
        var post : PostModel? = PostModel()
        val myRef = database.getReference("Post")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){
                    val postF = value.getValue(PostModel::class.java)

                    if(postF!!.user_id.equals(user_id)){

                        post  = value.getValue(PostModel::class.java)

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return post

    }

    fun CanEdit(user_id: String?,post_id : String?) : Boolean{
        var edit : Boolean = false
        val post : PostModel? = getPost(post_id)
        if(post!!.user_id.equals(user_id)){

           edit = true

        }
        return edit
    }

    fun getPost(post_id : String?): PostModel?{
        var post : PostModel? = PostModel()
        val myRef = database.getReference("Post")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(post_id)){

                        post  = value.getValue(PostModel::class.java)

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return post
    }
    fun getComment(comment_id : String?): CommentModel?{
        var comment : CommentModel? = CommentModel()
        val myRef = database.getReference("Comments")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(comment_id)){

                        comment  = value.getValue(CommentModel::class.java)

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return comment
    }
    fun getLike(like_id : String?): LikePostModel?{
        var like : LikePostModel? = LikePostModel()
        val myRef = database.getReference("Likes")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(like_id)){

                        like  = value.getValue(LikePostModel::class.java)

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return like
    }
    fun getUser(user_id: String?) : UserModel?{
        var user : UserModel? = UserModel()
        val myRef = database.getReference("Users")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(user_id)){

                        user  = value.getValue(UserModel::class.java)

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return user

    }





}