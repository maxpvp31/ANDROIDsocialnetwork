package fr.isen.lopez.androidtoolbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.lopez.socialapplication.*
import kotlinx.android.synthetic.main.recycler_view_comment_cell.view.*


class CommentAdapter (val comments: ArrayList<CommentModel>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_comment_cell, parent, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comments.count()
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)


    }



    class CommentViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(comment: CommentModel) {
            view.commentDisplayContentView.text = comment.text


        }



    }



}

