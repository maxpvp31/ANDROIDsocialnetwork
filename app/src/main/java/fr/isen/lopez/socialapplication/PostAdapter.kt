package fr.isen.lopez.androidtoolbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.isen.lopez.socialapplication.PostModel
import fr.isen.lopez.socialapplication.R
import kotlinx.android.synthetic.main.recycler_view_post_cell.view.*


class PostAdapter (val posts: ArrayList<PostModel>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_post_cell, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    class PostViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel) {
            view.postDisplayContentView.text = post.text
        }

    }



}