package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var postList = ArrayList<PostModel>()
        Log.d("Erreur","erreur bis2")

        setContentView(R.layout.activity_home)
        Log.d("Erreur","erreur bis")
        val read = ReadData()
        Log.d("Erreur","erreur cheum")

        val write = WriteData()
        Log.d("okok","erreur bis")

        postList = read.ReadPosts()


        Log.d("Erreur","erreur 1")
        postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        Log.d("Erreur","erreur 2")
        postRecyclerView.adapter = PostAdapter(postList,this)

    }


}