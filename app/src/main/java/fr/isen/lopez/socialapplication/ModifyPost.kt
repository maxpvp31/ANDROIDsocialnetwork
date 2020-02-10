package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth



class ModifyPost : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_post)
        mAuth = FirebaseAuth.getInstance()
    }


    public fun modifyPost(view: View) {
        val write2 = WriteData()
       mAuth = FirebaseAuth.getInstance()
       // val read2 = ReadData()
       // val currentUser = mAuth.currentUser

        write2.editPost("-M-eH9XUvOruZUwq9oL9", "ZKy34dYdc4TuMSIHZ9ffBnpSeHF2", "on est laaaa")

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)


    }
}