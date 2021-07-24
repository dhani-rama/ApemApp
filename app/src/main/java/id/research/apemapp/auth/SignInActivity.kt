@file:Suppress("DEPRECATION")

package id.research.apemapp.auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty
import id.research.apemapp.HomeActivity
import id.research.apemapp.models.AuthenticationItementity
import id.research.apemapp.databinding.ActivitySignInBinding
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences

class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding
    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding.root)


        mLoading = ProgressDialog(this@SignInActivity)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        mDatabase = FirebaseDatabase.getInstance().getReference("Student")
        myPreferences = MySharedPreferences(this@SignInActivity)

        //cek apakah murid sudah sign in atau belum
        //Jika sudah maka akan langsung Intent ke Home Activity
        if (myPreferences.getValue("student").equals("signIn")) {
            val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
            finish()
            return //Agar program di bawah line ini tidak dijalankan
        }

        signInBinding.tvComeIn.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            finish()
        }

        signInBinding.btnForward.setOnClickListener {
            if (validate()) {
                val mNis = signInBinding.etNis.text.toString()
                val mPassword = signInBinding.etPassword.text.toString()

                signUpCheck(mNis, mPassword)
            }
        }
    }

    private fun validate(): Boolean {

        if(signInBinding.etNis.text.toString() == "") {
            signInBinding.etNis.error = "Harap isi nomor telepon terlebih dahulu"
            signInBinding.etNis.requestFocus()

            return false
        }
        else if(signInBinding.etPassword.text.toString() == "") {
            signInBinding.etPassword.error = "Harap isi kata sandi terlebih dahulu"
            signInBinding.etPassword.requestFocus()

            return false
        }
        return true
    }

    private fun signUpCheck(mNis: String, mPassword: String) {
        //Menampilkan loading
        mLoading.show()

        //cek apakah nis sudah terdaftar atau belum
        val nisCheck = mDatabase.orderByChild("nis").equalTo(mNis)

        nisCheck.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.value != null) {
                    var student: AuthenticationItementity? = null

                    for (item in snapshot.children) {
                        //mengisi varaibel pada model student
                        student = item.getValue(AuthenticationItementity::class.java)
                    }

                    if (student!!.password == mPassword) {
                        //Menyimpan data ke shared preferences bahwa murid telah berhasil masuk

                        myPreferences.setValue(Constants.STUDENT, Constants.LOGIN)

                        //Menyimpan data murid yang sudah masuk ke shared preferences
                        myPreferences.setValue(Constants.STUDENT_ID, student.id)
                        myPreferences.setValue(Constants.STUDENT_FIRST_NAME, student.first_name)
                        myPreferences.setValue(Constants.STUDENT_LAST_NAME, student.last_name)
                        myPreferences.setValue(Constants.STUDENT_NIS, student.nis)
                        myPreferences.setValue(Constants.STUDENT_PASSWORD, student.password)
                        myPreferences.setValue(
                            Constants.STUDENT_LOOPING_QUIZ_SCORE,
                            student.looping_quiz_score
                        )
                        myPreferences.setValue(
                            Constants.STUDENT_ARRAY_QUIZ_SCORE,
                            student.array_quiz_score
                        )
                        myPreferences.setValue(
                            Constants.STUDENT_FUNCTION_QUIZ_SCORE,
                            student.function_quiz_score
                        )

                        //Intent ke home activity
                        val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(goHome)
                        finish()

                        //Menghilangkan Loading
                        mLoading.dismiss()
                    } else {
                        //Menghilangkan loading
                        mLoading.dismiss()
                        Toasty.error(this@SignInActivity, "Password Salah", Toast.LENGTH_SHORT).show()
//                        Toast.makeText(this@SignInActivity, "Password Salah", Toast.LENGTH_SHORT)
//                            .show()
                    }
                } else {
                    //Menghilangkan loading
                    mLoading.dismiss()
                    Toasty.error(this@SignInActivity, "NIS belum terdaftar", Toast.LENGTH_SHORT).show()
//                    Toast.makeText(this@SignInActivity, "NIS belum terdaftar", Toast.LENGTH_SHORT)
//                        .show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //Menghilangkan loading
                mLoading.dismiss()
                Toasty.error(this@SignInActivity, error.message, Toast.LENGTH_SHORT).show()
//                Toast.makeText(this@SignInActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}