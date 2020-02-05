package fr.isen.lopez.socialapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val  dataPost =  PostModel()
    val dataUser = UserModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataPost.writeNewPost("32/02/21","Post 2","Image")

    }





}



