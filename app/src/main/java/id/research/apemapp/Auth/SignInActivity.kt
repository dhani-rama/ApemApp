@file:Suppress("DEPRECATION")

package id.research.apemapp.Auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import id.research.apemapp.HomeActivity
import id.research.apemapp.R
import id.research.apemapp.Models.AuthenticationItementity
import id.research.apemapp.databinding.ActivitySignInBinding
import id.research.apemapp.util.MySharedPreferences

class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding
    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding.root)

//        with(mLoading){
//            ProgressDialog(this@SignInActivity)
//            setCancelable(false)
//            setMessage("Loading....")
//        }
        mLoading = ProgressDialog(this@SignInActivity)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        mDatabase = FirebaseDatabase.getInstance().getReference("Murid")
        myPreferences = MySharedPreferences(this@SignInActivity)

        //cek apakah murid sudah sign in atau belum
        //Jika sudah maka akan langsung Intent ke Home Activity
        if (myPreferences.getValue("murid").equals("signIn")) {
            val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
            finish()
            return //Agar program di bawah line ini tidak dijalankan
        }

        signInBinding.tvComeIn.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            finish()
        }

        signInBinding.btnLanjut.setOnClickListener {
            if (validate()) {
                val mNis = signInBinding.etNis.text.toString()
                val mPassword = signInBinding.etPassword.text.toString()

                cekDaftar(mNis, mPassword)
            }
        }
    }

    private fun validate(): Boolean {
        if (signInBinding.etNis.text.isEmpty()) {

            with(signInBinding.etNis){
                requestFocus()
                error = "Masukkan NIS terlebih dahulu"
            }

            return false
        }

        if (signInBinding.etPassword.text.isEmpty()) {

            with(signInBinding.etPassword){
                requestFocus()
                error = "Masukkan Password terlebih dahulu"
            }
            return false
        }
        return true
    }

    private fun cekDaftar(mNis: String, mPassword: String) {
        //Menampilkan loading
        mLoading.show()

        //cek apakah nis sudah terdaftar atau belum
        val cekNis = mDatabase.orderByChild("nis").equalTo(mNis)

        cekNis.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.value != null) {
                    var murid: AuthenticationItementity? = null

                    for (item in snapshot.children) {
                        //mengisi varaibel pada model student
                        murid = item.getValue(AuthenticationItementity::class.java)
                    }

                    if (murid!!.password == mPassword) {
                        //Menyimpan data ke shared preferences bahwa murid telah berhasil masuk

                        myPreferences.setValue("murid", "signIn")

                        //Menyimpan data murid yang sudah masuk ke shared preferences
                        myPreferences.setValue("id", murid.id)
                        myPreferences.setValue("nama", murid.nama)
                        myPreferences.setValue("nis", murid.nis)
                        myPreferences.setValue("password", murid.password)

                        //Intent ke home activity
                        val goHome = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(goHome)
                        finish()

                        //Menghilangkan Loading
                        mLoading.dismiss()
                    } else {
                        //Menghilangkan loading
                        mLoading.dismiss()
                        Toast.makeText(this@SignInActivity, "Password Salah", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    //Menghilangkan loading
                    mLoading.dismiss()
                    Toast.makeText(this@SignInActivity, "NIS belum terdaftar", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //Menghilangkan loading
                mLoading.dismiss()
                Toast.makeText(this@SignInActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}