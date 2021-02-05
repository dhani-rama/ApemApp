@file:Suppress("DEPRECATION")

package id.research.apemapp.auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import id.research.apemapp.activity.HomeActivity
import id.research.apemapp.R
import id.research.apemapp.model.student
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.btn_lanjut
import kotlinx.android.synthetic.main.activity_sign_in.et_nis
import kotlinx.android.synthetic.main.activity_sign_in.et_password
import kotlinx.android.synthetic.main.activity_sign_in.tv_masuk
import kotlinx.android.synthetic.main.activity_sign_up.*

class Sign_in : AppCompatActivity() {
    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mLoading = ProgressDialog(this@Sign_in)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        mDatabase = FirebaseDatabase.getInstance().getReference("Murid")
        myPreferences = MySharedPreferences(this@Sign_in)

        //cek apakah murid sudah sign in atau belum
        //Jika sudah maka akan langsung Intent ke Home Activity
        if (myPreferences.getValue("murid").equals("signIn")) {
            val goHome = Intent(this@Sign_in, HomeActivity::class.java)
            startActivity(goHome)
            finish()
            return //Agar program di bawah line ini tidak dijalankan
        }

        tv_masuk.setOnClickListener {
            startActivity(Intent(this@Sign_in, Sign_up::class.java))
            finish()
        }

        btn_lanjut.setOnClickListener {
            if (validate()) {
                val mNis = et_nis.text.toString()
                val mPassword = et_password.text.toString()

                cekDaftar(mNis, mPassword)
            }
        }
    }

    private fun validate(): Boolean {
        if (et_nis.text.isEmpty()) {
            et_nis.requestFocus()
            et_nis.error = "Masukkan NIS terlebih dahulu"
            return false
        }

        if (et_password.text.isEmpty()) {
            et_password.requestFocus()
            et_password.error = "Masukkan Password terlebih dahulu"
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
                    var murid: student? = null

                    for (item in snapshot.children) {
                        //mengisi varaibel pada model student
                        murid = item.getValue(student::class.java)
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
                        val goHome = Intent(this@Sign_in, HomeActivity::class.java)
                        startActivity(goHome)
                        finish()

                        //Menghilangkan Loading
                        mLoading.dismiss()
                    } else {
                        //Menghilangkan loading
                        mLoading.dismiss()
                        Toast.makeText(this@Sign_in, "Password Salah", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    //Menghilangkan loading
                    mLoading.dismiss()
                    Toast.makeText(this@Sign_in, "NIS belum terdaftar", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //Menghilangkan loading
                mLoading.dismiss()
                Toast.makeText(this@Sign_in, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}