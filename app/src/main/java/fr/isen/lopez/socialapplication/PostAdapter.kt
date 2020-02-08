package fr.isen.lopez.androidtoolbox

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import fr.isen.lopez.socialapplication.HomeActivity
import fr.isen.lopez.socialapplication.PostActivity
import fr.isen.lopez.socialapplication.PostModel
import fr.isen.lopez.socialapplication.R
import kotlinx.android.synthetic.main.recycler_view_post_cell.view.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity





class PostAdapter (val posts: ArrayList<PostModel>,val context: Context): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_post_cell, parent, false)
        return PostViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)


    }



    class PostViewHolder(val view: View, val context: Context): RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel) {
            view.postDisplayContentView.text = post.text

            view.imageClick.setOnClickListener {
                Toast.makeText(context,"TEST Click listener",Toast.LENGTH_SHORT).show()
                val i = adapterPosition
                Log.d("listener", "tessssssssssssssssssssssssssst")

                //context.startActivity(Intent(context, HomeActivity::class.java))
                val foo = Intent(context, PostActivity::class.java)
                foo.putExtra("mySecondKey", "mySecondValue")
                context.startActivity(foo)
            }
        }



    }



}

