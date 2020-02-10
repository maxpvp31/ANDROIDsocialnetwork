package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_modify_post.*


class ModifyPost : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_post)
        mAuth = FirebaseAuth.getInstance()
    }


    public fun modifyPost(view: View) {
        val write = WriteData()
        mAuth = FirebaseAuth.getInstance()
        val read2 = ReadData()
        val currentUser = mAuth.currentUser


/*        val foo = Intent(context, ModifyPost::class.java)
        foo.putExtra("idPost", post.id_post)*/

        write.editPost(Constant.actualPostId, currentUser!!.uid,modifiedPost.text.toString())
        Constant.actualPostId = ""

        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)


    }
}