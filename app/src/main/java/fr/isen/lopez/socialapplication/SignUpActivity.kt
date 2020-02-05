package fr.isen.lopez.socialapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.firebase.auth.FirebaseUser
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.View
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
import java.util.*


class SignUpActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    var currentDate = Date()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()

        date_input.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus) {
                date_input.clearFocus()
                val dialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        onDateChoose(year, month, dayOfMonth)
                    },
                    1990,
                    7,
                    25)
                dialog.show()
            }
        }

    }


    fun updateUI(account: FirebaseUser?) {

        if (account != null) {

            Toast.makeText(this, "U Signed In successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            Toast.makeText(this, "U Didnt signed in", Toast.LENGTH_LONG).show()
        }
    }

    fun onDateChoose(year: Int, month: Int, day: Int) {
        date_input.setText(String.format("%02d/%02d/%04d", day, month+1, year))
        Toast.makeText(this,
            "date : ${date_input.text.toString()}",
            Toast.LENGTH_LONG).show()
    }

    fun getAge(year: Int, month: Int, day: Int): Int {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val dateString = formatter.format(currentDate)
        val components = dateString.split("/")
        var age = components[2].toInt() - year
        if(components[1].toInt() < month){
            age--
        } else if (components[1].toInt() == month &&
            components[0].toInt() < day){
            age --
        }
        return age
    }

    public fun createAccount(view: View) {

        val newuser = WriteData()
        if (input_confirm_password.text.toString() == input_password.text.toString()) {

            mAuth?.createUserWithEmailAndPassword(input_email.text.toString(), input_password.text.toString())?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Inscription", "createUserWithEmail:success")
                    val user = mAuth?.currentUser
                    newuser.Register(user!!.uid, input_email.text.toString(), input_familyname.text.toString(), input_surname.text.toString(), date_input.text.toString())
                    updateUI(user)


                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Inscription", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

            }
        }

    }




}
