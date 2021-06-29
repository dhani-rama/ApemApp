@file:Suppress("DEPRECATION")

package id.research.apemapp.Auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import id.research.apemapp.R
import id.research.apemapp.Models.AuthenticationItementity
import id.research.apemapp.databinding.ActivitySignInBinding
import id.research.apemapp.databinding.ActivitySignUpBinding
import id.research.apemapp.util.MySharedPreferences
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.sign

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

        mDatabase = FirebaseDatabase.getInstance().getReference("Murid")
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
                val mNamaLengkap = signUpBinding.etName.text.toString()
                val mNis = signUpBinding.etNis.text.toString()
                val mPaswword = signUpBinding.etPassword.text.toString()

                daftar(mNamaLengkap, mNis, mPaswword)
            }
        }
    }

    private fun validate(): Boolean {
        //cek apakah form sudah terisi atau belum
        if (signUpBinding.etName.text.isEmpty()) {
            with(signUpBinding.etName){
                requestFocus()
                error = "Masukkan nama lengkap terlebih dahulu"
            }
//            et_nama.requestFocus()
//            et_nama.error = "Masukkan nama lengkap terlebih dahulu"
            return false
        }

        if (signUpBinding.etNis.text.isEmpty()) {

            with(signUpBinding.etNis){
                requestFocus()
                error = "Masukkan NIS terlebih dahulu"
            }

            return false
        }

        if (signUpBinding.etPassword.text.isEmpty()) {
            with(signUpBinding.etPassword){
                requestFocus()
                error = "Masukkan password terlebih dahulu"
            }
            return false
        }
        return true
    }

    private fun daftar(mNamaLengkap: String, mNis: String, mPassword: String) {
        //Menampilkan loading
        mLoading.show()

        //Cek apakah nis sudah digunakan atau belum
        val cekNis = mDatabase.orderByChild("nis").equalTo(mNis)

        cekNis.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.value == null) {
                    //mengambil data tanggal dan jam daftar
                    val mCurrentTime = SimpleDateFormat("yyyyMMdd:HHmmss", Locale.getDefault()).format(Date())

                    val murid = AuthenticationItementity(mCurrentTime, mNamaLengkap, mNis, mPassword)

                    //Mengisi variabel pada model student
                    mDatabase.child(mCurrentTime).setValue(murid)

//                    //Menyimpan data ke shared preferences bahwa murid telah berhasil masuk
//                    myPreferences.setValue("murid", "signIn")
//
//                    //Menyimpan data siswa yang sudah masuk ke shared preferences
//                    myPreferences.setValue("id", murid.id)
//                    myPreferences.setValue("nama", murid.nama)
//                    myPreferences.setValue("nis", murid.nis)
//                    myPreferences.setValue("password", murid.password)

                    startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                    finish()

                    mLoading.dismiss()
                } else {
                    //Menghilangkan Loading
                    mLoading.dismiss()
                    Toast.makeText(this@SignUpActivity, "nis sudah digunakan", Toast.LENGTH_SHORT).show()
                }
            }

            //menghilangkan Loading
            override fun onCancelled(error: DatabaseError) {
                mLoading.dismiss()
                Toast.makeText(this@SignUpActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}