package fr.isen.lopez.socialapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User
import fr.isen.lopez.androidtoolbox.MyPostAdapter
import fr.isen.lopez.androidtoolbox.PostAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.postRecyclerView

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

        var user : UserModel = UserModel()
        read.getUser(currentUser.uid){
            user = it

            nameUser.text = it.nom
            surnameUser.text = it.prenom
            emailUser.text = it.email
            birthDateUser.text = it.ddnaissance
        }



        var myPostList = ArrayList<PostModel>()

        val write = WriteData()

        read.ReadPosts{
            myPostList = it
            postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            postRecyclerView.adapter = MyPostAdapter(myPostList,this)
        }
    }


}
