package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import fr.isen.lopez.androidtoolbox.PostAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {



    public fun switchPageProfile(view: View){

        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)

    }

    public fun switchPageHome(view:View){

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    public fun switchPageDisconnect(view:View){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var postList = ArrayList<PostModel>()
        var userListPost = ArrayList<UserModel>()
        var likePost = ArrayList<String>()
        val read = ReadData()
        val read_user = ReadData()

        val write = WriteData()

        read.ReadPosts {
            postList = it
            for(value in postList){
                Log.d("UserId", value.user_id.toString())
                read_user.getUser(value.user_id){
                    Log.d("tdest","tstddddddddddddddddddddddd")
                    userListPost.add(it)
                    Log.d("TEST", it.nom.toString())
                    read_user.NumberLikeOnPost(value.id_post.toString()){
                        val number_like = (it-1).toString()
                        likePost.add(number_like)
                        postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                        postRecyclerView.adapter = PostAdapter(likePost, userListPost, postList, this)
                    }
                }
            }


        }



    }


}