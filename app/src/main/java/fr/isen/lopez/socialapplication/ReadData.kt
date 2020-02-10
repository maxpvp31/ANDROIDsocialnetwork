package fr.isen.lopez.socialapplication

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User

class ReadData {
    companion object {
        private const val TAG = "Activity"
    }
    val database = FirebaseDatabase.getInstance()

    var userarray :  ArrayList<UserModel> =  ArrayList<UserModel>()

    fun ReadPosts(callback: (ArrayList<PostModel>) -> Unit) {

        var user : UserModel = UserModel()
        val posts : ArrayList<PostModel>  =  ArrayList<PostModel>()
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(value in dataSnapshot.children ) {

                   val post = value.getValue(PostModel::class.java)!!

                    getUser(post.user_id){
                        user = it
                    }
                    Log.d(ReadData.TAG, user.toString())
                  posts.add(post)
                    userarray.add(user!!)


                }
                callback.invoke(posts)


            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })


    }

    fun getUserPosts() :  ArrayList<UserModel>{
        return this.userarray

    }




    fun ReadPostByUser(user_id : String, callback: (ArrayList<PostModel>) -> Unit){
        val posts : ArrayList<PostModel> =  ArrayList<PostModel>()

        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){
                    val postF = value.getValue(PostModel::class.java)!!

                    if(postF.user_id.equals(user_id)){

                        var  post  = value.getValue(PostModel::class.java)!!
                        posts.add(post)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        callback.invoke(posts)


    }

    fun CanEdit(user_id: String?,post_id : String?) : Boolean{
        var edit : Boolean = false
        var post : PostModel = PostModel()

        getPost(post_id) {post = it
            if(post.user_id.equals(user_id)){

                edit = true

            }

        }
        return edit
    }

    fun getPost(post_id : String?,  callback: (PostModel) -> Unit ){
        var post : PostModel = PostModel()
        val myRef = database.getReference("Post")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(post_id)){

                        post  = value.getValue(PostModel::class.java)!!

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
   callback.invoke(post)
    }

    fun getComment(comment_id : String?,   callback: (CommentModel) -> Unit ){
        var comment : CommentModel = CommentModel()
        val myRef = database.getReference("Comments")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(comment_id)){

                        comment  = value.getValue(CommentModel::class.java)!!

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        callback.invoke(comment)
    }
    fun getLike(like_id : String?,   callback: (LikePostModel) -> Unit ){
        var like : LikePostModel = LikePostModel()
        val myRef = database.getReference("Likes")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(like_id)){

                        like  = value.getValue(LikePostModel::class.java)!!

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        callback.invoke(like)
    }
    fun getUser(user_id: String?,callback: (UserModel) -> Unit ) {
        var user : UserModel = UserModel()
        val myRef = database.getReference("Users")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(user_id)){

                        user  = value.getValue(UserModel::class.java)!!

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        callback.invoke(user)

    }


    fun NumberLikeOnPost(post_id: String) : Int{

        var numberlike : Int = 0
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(post_id)){

                        var  post  = value.getValue(PostModel::class.java)
                        numberlike = post!!.likes!!.size

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return numberlike
    }

    fun NumberCommentOnPost(post_id: String) : Int{

        var numbercomment : Int = 0
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (value in dataSnapshot.children){

                    if(value.key.equals(post_id)){

                        var post = value.getValue(PostModel::class.java)
                        numbercomment = post!!.comments!!.size

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })
        return numbercomment
    }




}