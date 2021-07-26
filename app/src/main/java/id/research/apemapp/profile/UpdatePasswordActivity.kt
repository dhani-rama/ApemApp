package id.research.apemapp.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import es.dmoral.toasty.Toasty
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityUpdatePasswordBinding
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences

class UpdatePasswordActivity : AppCompatActivity() {

    private lateinit var mUpdatePasswordBinding: ActivityUpdatePasswordBinding
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var studentId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUpdatePasswordBinding = ActivityUpdatePasswordBinding.inflate(layoutInflater)
        setContentView(mUpdatePasswordBinding.root)

        myPreferences = MySharedPreferences(this)
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Student")
        studentId = myPreferences.getValue(Constants.STUDENT_ID)!!

        mUpdatePasswordBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mUpdatePasswordBinding.btnNext.setOnClickListener {
            if (validate()) {
                val studentPassword = mUpdatePasswordBinding.etPassword.text.toString()
                val studentPasswordAgain = mUpdatePasswordBinding.etPasswordAgain.text.toString()

                if (studentPassword == studentPasswordAgain) {
                    updatePassword(studentPassword)
                } else {
                    Toasty.error(
                        this,
                        "Kata Sandi Tidak Cocok, Silahkan Periksa Kembali",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun updatePassword(mPassword: String) {

        mDatabaseReference.child(studentId).child("password").setValue(mPassword)
        myPreferences.setValue(
            Constants.STUDENT_PASSWORD,
            mUpdatePasswordBinding.etPassword.text.toString()
        )

        Toasty.success(this, "Password Berhasil Disimpan", Toast.LENGTH_SHORT).show()

        val goHome = Intent(this, HomeActivity::class.java)
        startActivity(goHome)
        finish()
    }

    private fun validate(): Boolean {
        if (mUpdatePasswordBinding.etPassword.text.toString() == "") {
            mUpdatePasswordBinding.etPassword.error = "Harap isi kata sandi terlebih dahulu"
            mUpdatePasswordBinding.etPassword.requestFocus()
            return false
        } else if (mUpdatePasswordBinding.etPasswordAgain.text.toString() == "") {
            mUpdatePasswordBinding.etPasswordAgain.error = "Harap isi kata sandi lagi"
            mUpdatePasswordBinding.etPasswordAgain.requestFocus()
            return false
        }

        return true
    }
}