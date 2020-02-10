package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_modify_profile.*
import kotlinx.android.synthetic.main.activity_profile.*

class ModifyProfileActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_profile)

        mAuth = FirebaseAuth.getInstance()

    }


    public fun modifyValid(view: View){

        val write = WriteData()
        mAuth = FirebaseAuth.getInstance()


        var read = ReadData()
        val currentUser = mAuth.currentUser


        write.editProfil(currentUser!!.uid,newName.text.toString(),newSurmane.text.toString(),newEmail.text.toString())



        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)


    }
}
