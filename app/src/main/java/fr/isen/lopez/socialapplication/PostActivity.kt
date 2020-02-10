package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.lopez.androidtoolbox.PostAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    var postId: String? = ""
    var name_string: String? = ""


    public fun switchPageProfile(view: View){

        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)

    }

    public fun switchPageHome(view: View){

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    public fun switchPageDisconnect(view: View){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        var post = PostModel()
        postId = intent.getStringExtra("idPost") //ID DU POST
        name_string = intent.getStringExtra("name_string") //ID DU POST
        name_text.text = name_string
        Log.d("IDdupost",postId)
        val read = ReadData()
        val write = WriteData()

        read.getPost(postId){
            post = it
            postContent.text = post.text.toString()
            Toast.makeText(this,post.text.toString().toString(),Toast.LENGTH_SHORT).show()


        }

        var commentList = ArrayList<CommentModel>()



    }



}
