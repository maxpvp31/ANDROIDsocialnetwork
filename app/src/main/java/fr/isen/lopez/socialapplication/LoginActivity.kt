package fr.isen.lopez.socialapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val trueId = "admin"
    var truePassword = "123"
    var userPref: SharedPreferences? = null
    val UserInfos= "UserInfos"
    val kPassword = "kpassword"
    val kIdentifier = "kidentifier"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userPref = getSharedPreferences(UserInfos, 0)
        val checkId = userPref?.getString(kPassword, null) ?: ""
        val checkPassword = userPref?.getString( kIdentifier, null) ?: ""


        if(canLog(checkId,checkPassword)){
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent);
        }


    }


    public fun switchPage(view: View){
        if(canLog(usernameChild.text.toString(), editPassword.text.toString())){
            val editor = userPref?.edit()
            editor?.putString(kIdentifier, trueId)
            editor?.putString(kPassword,truePassword)
            editor?.apply();

            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent);

        }else{
            Toast.makeText(this,"Identifiant ou Mot de Passe", Toast.LENGTH_LONG).show()
        }
    }

    public fun canLog(identifier: String, password: String): Boolean{
        return identifier == trueId && password == truePassword
    }

    public fun switchSignUp(view: View){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent);
    }

}