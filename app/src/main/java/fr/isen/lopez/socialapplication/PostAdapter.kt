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
import kotlinx.android.synthetic.main.recycler_view_post_cell.view.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import fr.isen.lopez.socialapplication.*


class PostAdapter (val number_like: ArrayList<String>, val userListPost: ArrayList<UserModel> ,val posts: ArrayList<PostModel>,val context: Context): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_post_cell, parent, false)
        return PostViewHolder(number_like, userListPost, view, context)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post, position)


    }



    class PostViewHolder(val number_like: ArrayList<String>, val userListPost: ArrayList<UserModel> ,val view: View,val context: Context): RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel,postition: Int) {
            view.postDisplayContentView.text = post.text
            view.name_surname.text = userListPost[postition].nom + " " + userListPost[postition].prenom
            view.like_number.text = number_like[postition]
            view.button_comment.setOnClickListener {

                val foo = Intent(context, PostActivity::class.java)
                foo.putExtra("idPost", post.id_post)
                foo.putExtra("name_string",userListPost[postition].nom + " " + userListPost[postition].prenom)
                foo.putExtra("numberlike", number_like[postition])

                context.startActivity(foo)

            }
        }



    }



}

