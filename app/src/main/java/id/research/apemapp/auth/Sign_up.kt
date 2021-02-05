@file:Suppress("DEPRECATION")

package id.research.apemapp.auth

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import id.research.apemapp.R
import id.research.apemapp.model.student
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
import java.util.*

class Sign_up : AppCompatActivity() {

    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //inialisasi variabel
        mLoading = ProgressDialog(this@Sign_up)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        mDatabase = FirebaseDatabase.getInstance().getReference("Murid")
        myPreferences = MySharedPreferences(this@Sign_up)

        //OnClick text (sudah punya akun ? masuk)
        tv_masuk.setOnClickListener {
            startActivity(Intent(this@Sign_up, Sign_in::class.java))
            finish()
        }

        //onClick button sign up
        btn_lanjut.setOnClickListener {

            //Mennjalankan program pada fungsi validate()
            //Jika form terisi semua, maka program pada 'sign_up()' akan dijalankan
            if (validate()) {
                val mNamaLengkap = et_nama.text.toString()
                val mNis = et_nis.text.toString()
                val mPaswword = et_password.text.toString()

                daftar(mNamaLengkap, mNis, mPaswword)
            }
        }
    }

    private fun validate(): Boolean {
        //cek apakah form sudah terisi atau belum
        if (et_nama.text.isEmpty()) {
            et_nama.requestFocus()
            et_nama.error = "Masukkan nama lengkap terlebih dahulu"
            return false
        }

        if (et_nis.text.isEmpty()) {
            et_nis.requestFocus()
            et_nis.error = "Masukkan nis terlebih dahulu"
            return false
        }

        if (et_password.text.isEmpty()) {
            et_password.requestFocus()
            et_password.error = "Masukkan password terlebih dahulu"
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

                    val murid = student(mCurrentTime, mNamaLengkap, mNis, mPassword)

                    //Mengisi variabel pada model student
                    mDatabase.child(mCurrentTime).setValue(murid)

                    //Menyimpan data ke shared preferences bahwa murid telah berhasil masuk
                    myPreferences.setValue("murid", "signIn")

                    //Menyimpan data siswa yang sudah masuk ke shared preferences
                    myPreferences.setValue("id", murid.id)
                    myPreferences.setValue("nama", murid.nama)
                    myPreferences.setValue("nis", murid.nis)
                    myPreferences.setValue("password", murid.password)

                    //intent ke Home Activity
                    val goHome = Intent(this@Sign_up, Sign_in::class.java)
                    startActivity(goHome)
                    finish()

                    //Menghilangkan loading
                    mLoading.dismiss()
                } else {
                    //Menghilangkan Loading
                    mLoading.dismiss()
                    Toast.makeText(this@Sign_up, "nis sudah digunakan", Toast.LENGTH_SHORT).show()
                }
            }

            //menghilangkan Loading
            override fun onCancelled(error: DatabaseError) {
                mLoading.dismiss()
                Toast.makeText(this@Sign_up, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}