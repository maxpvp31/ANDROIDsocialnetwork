package fr.isen.lopez.socialapplication

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
class WriteData {
    companion object {
        private const val TAG = "Activity"
    }

    val database = FirebaseDatabase.getInstance()

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

        editPostArray(newId,user_id)
        val comment : ArrayList<String> =  ArrayList<String>()
        comment.add("")
        val like : ArrayList<String> =  ArrayList<String>()
        like.add("0")
        val post = PostModel(newId,text, img, date, user_id,comment, like)
        dataPost.child(newId).setValue(post)


    }

    public fun editPostArray(id : String, id_user: String?){
        val dataPost = database.getReference("Users/" + id_user)
        val read = ReadData()
        var user : UserModel = UserModel()
            read.getUser(id_user){
                user = it

                var posts : ArrayList<String>? = user!!.posts
                posts!!.add(id)

                val childUpdates = HashMap<String, Any>()
                childUpdates.put("posts", posts)


                dataPost.updateChildren(childUpdates)
            }



    }

    fun editCommentArray(id : String, id_post: String?){

        val dataPost = database.getReference("Posts/" + id)
        val read = ReadData()
        var posts: PostModel = PostModel()
        read.getPost(id_post) {posts = it
            var comments : ArrayList<String>? = posts!!.comments
            comments!!.add(id)

            val childUpdates = HashMap<String, Any>()
            childUpdates.put("comments", comments)


            dataPost.updateChildren(childUpdates);

        }


    }
    fun editLikeArray(id : String, id_post: String?){
        val dataPost = database.getReference("Posts/" + id)
        val read = ReadData()
        var posts: PostModel = PostModel()
        read.getPost(id_post) {posts = it
            var likes : ArrayList<String>? = posts!!.likes
            likes!!.add(id)

            val childUpdates = HashMap<String, Any>()
            childUpdates.put("likes", likes)


            dataPost.updateChildren(childUpdates);
        }



    }
    fun editPost(id_post: String?,id_user: String?,text: String) {

                val dataPost = database.getReference("Posts/" + id_post)

                val childUpdates = HashMap<String, Any>()
                childUpdates.put("text", text)


                dataPost.updateChildren(childUpdates)




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
        editLikeArray(newId,post_id)
        val formatted = DateCurrent()
        val like = LikePostModel(newId,user_id, post_id, type, formatted )
        dataPost.child(newId).setValue(like)


    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun writeNewComment( text: String?, id_user: String?, id_post : String?) {

        val dataPost = database.getReference("Comments")
        val newId = dataPost.push().key.toString()
        editCommentArray(newId,id_post)
        val formatted = DateCurrent()
        val comment = CommentModel(newId,text, id_user, id_post, formatted)
        dataPost.child(newId).setValue(comment)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun Register(id: String, email: String?, nom: String?, prenom : String?, ddnaissance: String?) {
       val formatted = DateCurrent()
        val  posts : ArrayList<String>? = ArrayList<String>()
      writeNewPost("Salut je suis "+ nom +". Je suis nouveau sur ce réseau !", "",formatted, id)


        val dataPost = database.getReference("Users")
        val user = UserModel(id,email, nom, prenom, ddnaissance, "", posts,formatted )

        dataPost.child(id).setValue(user)

    }



    
}
