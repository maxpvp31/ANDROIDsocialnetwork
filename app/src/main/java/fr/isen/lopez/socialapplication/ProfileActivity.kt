package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User

class ProfileActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth


    public fun switchPageProfile(view: View){

    }

    public fun switchPageHome(view:View){

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    public fun switchPageDisconnect(view:View){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    public fun switchPageModify(view:View){

        val intent = Intent(this, ModifyProfileActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        mAuth = FirebaseAuth.getInstance()


        var read = ReadData()
        val currentUser = mAuth.currentUser
        Log.d("dedede",currentUser!!.uid)
        var user : UserModel = read.getUser(currentUser!!.uid)!!

/*
        YourPostList = ReadPostByUser(currentUser.uid)
*/


        val name = user.nom
        val surname  = user.prenom
        val mail = user.email

        Log.d("dede",user.toString())





    }


}
