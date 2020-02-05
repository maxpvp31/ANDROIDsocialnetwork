package fr.isen.lopez.socialapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.lopez.androidtoolbox.PostAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val postList = ArrayList<PostModel>()

        val post1 = PostModel("@string/post_example","","",null,null)
        val post2 = PostModel("Fulltg","","",null,null)
        val post3 = PostModel("Fulltg","","",null,null)
        val post4 = PostModel("Fulltg","","",null,null)
        val post5 = PostModel("Fulltg","","",null,null)
        val post6 = PostModel("Fulltg","","",null,null)
        val post7 = PostModel("Fulltg","","",null,null)
        val post8 = PostModel("Fulltg","","",null,null)



        postList.add(post1)
        postList.add(post2)
        postList.add(post3)
        postList.add(post4)
        postList.add(post5)
        postList.add(post6)
        postList.add(post7)
        postList.add(post8)


        postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        postRecyclerView.adapter = PostAdapter(postList)

    }


}