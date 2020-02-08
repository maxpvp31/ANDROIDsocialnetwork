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

    var UserArray :  ArrayList<UserModel> =  ArrayList<UserModel>()

    fun ReadPosts() : ArrayList<PostModel>  {

        var user : UserModel?
        val posts : ArrayList<PostModel>  =  ArrayList<PostModel>()
        val myRef = database.getReference("Posts")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for(value in dataSnapshot.children ) {

                   val post = value.getValue(PostModel::class.java)
                    user = FindUserPost(post!!.user_id)
                    Log.d(ReadData.TAG, user.toString())
                  posts.add(post!!)
                 UserArray.add(user!!)

                }


            }
            override fun onCancelled(error: DatabaseError) {

                Log.w(ReadData.TAG, "Failed to read value.", error.toException())
            }
        })

        return posts

    }

    fun getUserPost() :  ArrayList<UserModel>{
        return this.UserArray

    }

    fun FindUserPost(user_id: String?) : UserModel?{
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