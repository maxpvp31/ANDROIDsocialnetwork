package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
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

    override fun onStart() {
        super.onStart()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var postList = ArrayList<PostModel>()
        setContentView(R.layout.activity_home)
        val read = ReadData()
        val write = WriteData()

       read.ReadPosts{
           postList = it
           postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
           postRecyclerView.adapter = PostAdapter(postList,this)}


    }


}