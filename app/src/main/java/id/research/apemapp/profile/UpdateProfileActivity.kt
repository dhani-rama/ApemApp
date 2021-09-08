package id.research.apemapp.profile

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import es.dmoral.toasty.Toasty
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityUpdateProfileBinding
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences

class UpdateProfileActivity : AppCompatActivity() {

    private lateinit var mUpdateProfileBinding: ActivityUpdateProfileBinding
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var studentId: String
    private lateinit var mStorageReference: StorageReference
    private lateinit var mLoading: ProgressDialog

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUpdateProfileBinding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(mUpdateProfileBinding.root)

        mLoading = ProgressDialog(this)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        myPreferences = MySharedPreferences(this)
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Student")
        mStorageReference = FirebaseStorage.getInstance().getReference()
        studentId = myPreferences.getValue(Constants.STUDENT_ID)!!

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
        mFirstName: String,
        mLastName: String,
        mNis: String,
        mPassword: String
    ) {
        mLoading.show()
//        val model = AuthenticationItementity(studentId, mFirstName, mLastName, mNis, mPassword)
//        mDatabaseReference.child(studentId).setValue(model)

        mDatabaseReference.child(studentId).child("firstName").setValue(mFirstName)
        mDatabaseReference.child(studentId).child("lastName").setValue(mLastName)
        mDatabaseReference.child(studentId).child("nis").setValue(mNis)
        mDatabaseReference.child(studentId).child("password").setValue(mPassword)

        myPreferences.setValue(
            Constants.STUDENT_FIRST_NAME,
            mUpdateProfileBinding.etFirstName.text.toString()
        )
        myPreferences.setValue(
            Constants.STUDENT_LAST_NAME,
            mUpdateProfileBinding.etLastName.text.toString()
        )

        myPreferences.setValue(
            Constants.STUDENT_NIS,
            mUpdateProfileBinding.etNis.text.toString()
        )

        myPreferences.setValue(
            Constants.STUDENT_PASSWORD,
            mUpdateProfileBinding.etPassword.text.toString()
        )

        Toasty.success(this, "Berhasil Menyimpan Perubahan Profil Anda", Toast.LENGTH_SHORT).show()

        val goHome = Intent(this, HomeActivity::class.java)
        startActivity(goHome)
        finish()
    }

    private fun validate(): Boolean {
        //cek apakah form sudah terisi atau belum
        if (mUpdateProfileBinding.etFirstName.text.toString() == "") {
            mUpdateProfileBinding.etFirstName.error = "Harap Isi Nama Depan Terlebih Dahulu"
            mUpdateProfileBinding.etFirstName.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etLastName.text.toString() == "") {
            mUpdateProfileBinding.etLastName.error = "Harap Isi Nama Belakang Terlebih Dahulu"
            mUpdateProfileBinding.etLastName.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etNis.text.toString() == "") {
            mUpdateProfileBinding.etNis.error = "Harap Isi Nomor Telepon Terlebih Dahulu"
            mUpdateProfileBinding.etNis.requestFocus()

            return false
        } else if (mUpdateProfileBinding.etPassword.text.toString() == "") {
            mUpdateProfileBinding.etPassword.error = "Harap Isi Kata Sandi Terlebih Dahulu"
            mUpdateProfileBinding.etPassword.requestFocus()
            return false
        } else if (mUpdateProfileBinding.etPasswordAgain.text.toString() == "") {
            mUpdateProfileBinding.etPasswordAgain.error = "Harap Isi Kata Sandi Lagi"
            mUpdateProfileBinding.etPasswordAgain.requestFocus()
            return false
        }

        return true
    }
}

