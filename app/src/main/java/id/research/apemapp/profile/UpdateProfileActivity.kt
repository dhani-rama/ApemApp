package id.research.apemapp.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import es.dmoral.toasty.Toasty
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityUpdateProfileBinding
import id.research.apemapp.models.AuthenticationItementity
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences

class UpdateProfileActivity : AppCompatActivity() {

    private lateinit var mUpdateProfileBinding: ActivityUpdateProfileBinding
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUpdateProfileBinding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(mUpdateProfileBinding.root)

        myPreferences = MySharedPreferences(this)
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Student")
        userId = myPreferences.getValue("id")!!

        mUpdateProfileBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        val mFirstName = myPreferences.getValue(Constants.STUDENT_FIRST_NAME)
        val mLastName = myPreferences.getValue(Constants.STUDENT_LAST_NAME)
        val mNis = myPreferences.getValue(Constants.STUDENT_NIS)

        mUpdateProfileBinding.etFirstName.setText(mFirstName)
        mUpdateProfileBinding.etLastName.setText(mLastName)
        mUpdateProfileBinding.etNis.setText(mNis)

        mUpdateProfileBinding.btnNext.setOnClickListener {
            if (validate()) {
                val studentFirstName = mUpdateProfileBinding.etFirstName.text.toString()
                val studentLastName = mUpdateProfileBinding.etLastName.text.toString()
                val studentNis = mUpdateProfileBinding.etNis.text.toString()
                val studentPassword = mUpdateProfileBinding.etPassword.text.toString()
                val studentPasswordAgain = mUpdateProfileBinding.etPasswordAgain.text.toString()

                if (studentPassword == studentPasswordAgain) {
                    updateProfile(studentFirstName, studentLastName, studentNis, studentPassword)
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

    private fun updateProfile(
        mFirstname: String,
        mLastName: String,
        mNis: String,
        mPassword: String
    ) {

        val update = AuthenticationItementity(userId, mFirstname, mLastName, mNis, mPassword)
        mDatabaseReference.child(userId).setValue(update)

        myPreferences.setValue(
            Constants.STUDENT_FIRST_NAME,
            mUpdateProfileBinding.etFirstName.text.toString()
        )
        myPreferences.setValue(
            Constants.STUDENT_LAST_NAME,
            mUpdateProfileBinding.etLastName.text.toString()
        )
        myPreferences.setValue(Constants.STUDENT_NIS, mUpdateProfileBinding.etNis.text.toString())
        myPreferences.setValue(
            Constants.STUDENT_PASSWORD,
            mUpdateProfileBinding.etPassword.text.toString()
        )

        val goHome = Intent(this, HomeActivity::class.java)
        startActivity(goHome)
        finish()
    }

    private fun validate(): Boolean {
        //cek apakah form sudah terisi atau belum
        if (mUpdateProfileBinding.etFirstName.text.toString() == "") {
            mUpdateProfileBinding.etFirstName.error = "Harap isi nama depan terlebih dahulu"
            mUpdateProfileBinding.etFirstName.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etLastName.text.toString() == "") {
            mUpdateProfileBinding.etLastName.error = "Harap isi nama belakang terlebih dahulu"
            mUpdateProfileBinding.etLastName.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etNis.text.toString() == "") {
            mUpdateProfileBinding.etNis.error = "Harap isi nomor telepon terlebih dahulu"
            mUpdateProfileBinding.etNis.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etPassword.text.toString() == "") {
            mUpdateProfileBinding.etPassword.error = "Harap isi kata sandi terlebih dahulu"
            mUpdateProfileBinding.etPassword.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etPasswordAgain.text.toString() == "") {
            mUpdateProfileBinding.etPasswordAgain.error = "Harap isi kata sandi lagi"
            mUpdateProfileBinding.etPasswordAgain.requestFocus()

            return false
        }
        return true
    }
}