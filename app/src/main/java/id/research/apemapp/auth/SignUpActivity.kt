@file:Suppress("DEPRECATION")

package id.research.apemapp.auth

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySignUpBinding
import id.research.apemapp.models.AuthenticationItementity
import id.research.apemapp.utils.MySharedPreferences
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)

        //inialisasi variabel
        mLoading = ProgressDialog(this@SignUpActivity)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        mDatabase = FirebaseDatabase.getInstance().getReference("Student")
        myPreferences = MySharedPreferences(this@SignUpActivity)

        //OnClick text (sudah punya akun ? masuk)
        signUpBinding.tvComeIn.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            finish()
        }

        //onClick button sign up
        signUpBinding.btnForward.setOnClickListener {

            //Mennjalankan program pada fungsi validate()
            //Jika form terisi semua, maka program pada 'sign_up()' akan dijalankan
            if (validate()) {
                val mFirstName = signUpBinding.etFirstName.text.toString()
                val mLastName = signUpBinding.etLastName.text.toString()
                val mNis = signUpBinding.etNis.text.toString()
                val mPassword = signUpBinding.etPassword.text.toString()

                signUp(mFirstName, mLastName, mNis, mPassword)
            }
        }
    }

    private fun validate(): Boolean {
        //cek apakah form sudah terisi atau belum
        if (signUpBinding.etFirstName.text.toString() == "") {
            signUpBinding.etFirstName.error = "Harap isi nama depan terlebih dahulu"
            signUpBinding.etFirstName.requestFocus()

            return false
        }
        else if(signUpBinding.etLastName.text.toString() == "") {
            signUpBinding.etLastName.error = "Harap isi nama belakang terlebih dahulu"
            signUpBinding.etLastName.requestFocus()

            return false
        }
        else if(signUpBinding.etNis.text.toString() == "") {
            signUpBinding.etNis.error = "Harap isi nomor telepon terlebih dahulu"
            signUpBinding.etNis.requestFocus()

            return false
        }
        else if(signUpBinding.etPassword.text.toString() == "") {
            signUpBinding.etPassword.error = "Harap isi kata sandi terlebih dahulu"
            signUpBinding.etPassword.requestFocus()

            return false
        }
        return true
    }

    private fun signUp(mFirstname: String, mLastName: String,  mNis: String, mPassword: String) {
        //Menampilkan loading
        mLoading.show()

        //Cek apakah nis sudah digunakan atau belum
        val nisCheck = mDatabase.orderByChild("nis").equalTo(mNis)

        nisCheck.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.value == null) {
                    //mengambil data tanggal dan jam daftar
                    val mCurrentTime = SimpleDateFormat("yyyyMMdd:HHmmss", Locale.getDefault()).format(Date())

                    val student = AuthenticationItementity(
                        mCurrentTime,
                        mFirstname,
                        mLastName,
                        mNis,
                        mPassword,
                        "0",
                        "0",
                        "0",
                        "0"
                    )

                    //Mengisi variabel pada model student
                    mDatabase.child(mCurrentTime).setValue(student)

                    Toasty.success(
                        this@SignUpActivity,
                        "Akun Anda Berhasil Didaftarkan",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                    finish()

                    mLoading.dismiss()
                } else {
                    //Menghilangkan Loading
                    mLoading.dismiss()
                    Toasty.error(this@SignUpActivity, "NIS sudah digunakan", Toast.LENGTH_SHORT)
                        .show()
//                    Toast.makeText(this@SignUpActivity, "nis sudah digunakan", Toast.LENGTH_SHORT).show()
                }
            }

            //menghilangkan Loading
            override fun onCancelled(error: DatabaseError) {
                mLoading.dismiss()
                Toasty.error(this@SignUpActivity, error.message, Toast.LENGTH_SHORT).show()
//                Toast.makeText(this@SignUpActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}