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
import kotlinx.android.synthetic.main.recycler_view_my_post_cell.view.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import fr.isen.lopez.socialapplication.*
import kotlin.math.log


class MyPostAdapter (val posts: ArrayList<PostModel>, val context: Context): RecyclerView.Adapter<MyPostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_my_post_cell, parent, false)
        return PostViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)


    }



    class PostViewHolder(val view: View,val context: Context): RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel) {
            view.postDisplayContentView.text = post.text
            Toast.makeText(context,post.id_post.toString(),Toast.LENGTH_SHORT).show()

            view.button_edit.setOnClickListener {
               // val i = adapterPosition

                val foo = Intent(context, ModifyPost::class.java)
                foo.putExtra("idPost", post.id_post)
                Log.d("THIS IS THE ID",post.id_post)

                Constant.actualPostId = post.id_post.toString()

                context.startActivity(foo)

            }
        }



    }



}

