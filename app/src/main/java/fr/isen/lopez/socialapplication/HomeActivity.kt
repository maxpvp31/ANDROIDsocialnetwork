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
        val read = ReadData()
        read.ReadPosts()

        val postList = ArrayList<PostModel>()
        val temporaryText: String = getString(R.string.post_example)
        val post1 = PostModel(temporaryText,"","",null,null, null)
        val post2 = PostModel(temporaryText,"","",null,null, null)
        val post3 = PostModel(temporaryText,"","",null,null, null)
        val post4 = PostModel(temporaryText,"","",null,null, null)
        val post5 = PostModel(temporaryText,"","",null,null, null)
        val post6 = PostModel(temporaryText,"","",null,null, null)
        val post7 = PostModel(temporaryText,"","",null,null, null)
        val post8 = PostModel(temporaryText,"","",null,null, null)



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