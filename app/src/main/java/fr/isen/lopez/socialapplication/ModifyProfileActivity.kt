package fr.isen.lopez.socialapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class ModifyProfileActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_profile)

        mAuth = FirebaseAuth.getInstance()


        var read = ReadData()
        val currentUser = mAuth.currentUser
        Log.d("dedede",currentUser!!.uid)
        var user : UserModel = read.getUser(currentUser!!.uid)!!

        val name = user.nom
        val surname  = user.prenom
        val mail = user.email

        Log.d("dede",user.toString())
    }
}
