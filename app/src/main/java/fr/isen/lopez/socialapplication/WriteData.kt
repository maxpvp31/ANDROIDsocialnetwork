package fr.isen.lopez.socialapplication

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
class WriteData {
    companion object {
        private const val TAG = "Activity"
    }

    val database = FirebaseDatabase.getInstance()
    var newIDpost : String = ""
    fun getnewIDpost(): String{
        return this.newIDpost
    }
    fun  setnewIDpost(newIDpost : String){
        this.newIDpost = newIDpost
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun DateCurrent() : String{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        val formatted = current.format(formatter)
        return formatted
    }

    fun writeNewPost( text: String?, img: String?,  date : String?, user_id : String?) {

        val dataPost = database.getReference("Posts")
        val newId = dataPost.push().key.toString()
        setnewIDpost(newId)
        val comment : ArrayList<String> =  ArrayList<String>()
        comment.add("")
        val like : ArrayList<String> =  ArrayList<String>()
        like.add("0")
        val post = PostModel(newId,text, img, date, user_id,comment, like)
        dataPost.child(newId).setValue(post)


    }


    fun editPost(id_post: String?,id_user: String?,text: String) {
        val read = ReadData()
            if(read.CanEdit(id_user,id_post)){
                val dataPost = database.getReference("Posts/"+id_post)

                val childUpdates = HashMap<String, Any>()
                childUpdates.put("text", text)


                dataPost.updateChildren(childUpdates);

            }


    }

    fun editProfil(id_profil: String,nom: String, prenom: String, email: String) {

        val dataPost = database.getReference("Users/"+id_profil)

        val childUpdates = HashMap<String, Any>()
        childUpdates.put("nom", nom)
        childUpdates.put("prenom", prenom)
        childUpdates.put("email", email)

        dataPost.updateChildren(childUpdates);


    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun PutNewLike( user_id: String?, post_id: String?, type : Int?) {

        val dataPost = database.getReference("Likes")
        val newId = dataPost.push().key.toString()

        val formatted = DateCurrent()
        val like = LikePostModel(newId,user_id, post_id, type, formatted )
        dataPost.child(newId).setValue(like)


    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun writeNewComment( text: String?, id_user: String?, id_post : String?) {

        val dataPost = database.getReference("Comments")
        val newId = dataPost.push().key.toString()

        val formatted = DateCurrent()
        val comment = CommentModel(newId,text, id_user, id_post, formatted)
        dataPost.child(newId).setValue(comment)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun Register(id: String, email: String?, nom: String?, prenom : String?, ddnaissance: String?) {
       val formatted = DateCurrent()
        val  posts : ArrayList<String>? = ArrayList<String>()
      writeNewPost("Salut je suis "+ nom +". Je suis nouveau sur ce réseau !", "",formatted, id)
        val idPost : String = getnewIDpost()
        posts!!.add(idPost)

        val dataPost = database.getReference("Users")
        val user = UserModel(id,email, nom, prenom, ddnaissance, "", posts,formatted )

        dataPost.child(id).setValue(user)

    }



    
}