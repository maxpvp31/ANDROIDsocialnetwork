package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class PostActivity : AppCompatActivity() {

    var postId: String? = ""

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


    }

    override fun onStart() {
        super.onStart()
        postId = intent.getStringExtra("idPost") //ID DU POST
        //Log.d("IDdupost",postId)

    }
}
