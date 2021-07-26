package id.research.apemapp.profile

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import es.dmoral.toasty.Toasty
import id.research.apemapp.HomeActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityUpdateProfileBinding
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences
import java.io.File

class UpdateProfileActivity : AppCompatActivity() {

    private lateinit var mUpdateProfileBinding: ActivityUpdateProfileBinding
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var studentId: String
    private lateinit var mImageUri: Uri
    private lateinit var mStorageReference: StorageReference
    private lateinit var mLoading: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUpdateProfileBinding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(mUpdateProfileBinding.root)

        mLoading = ProgressDialog(this)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

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
        val foto = myPreferences.getValue(Constants.STUDENT_PHOTO)

        Glide.with(this)
            .load(foto)
            .apply(RequestOptions().override(250))
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user)
            .into(mUpdateProfileBinding.imgUser)

        mUpdateProfileBinding.etFirstName.setText(mFirstName)
        mUpdateProfileBinding.etLastName.setText(mLastName)
        mUpdateProfileBinding.etNis.setText(mNis)


        mUpdateProfileBinding.btnChooseImage.setOnClickListener {
            selectPhoto()
            //selectImage()
        }

        mUpdateProfileBinding.btnNext.setOnClickListener {
            if (validate()) {
                val studentFirstName = mUpdateProfileBinding.etFirstName.text.toString()
                val studentLastName = mUpdateProfileBinding.etLastName.text.toString()
                val studentNis = mUpdateProfileBinding.etNis.text.toString()

//                if(foto != null){
                updateProfile(studentFirstName, studentLastName, studentNis, mImageUri)
//                }

//                else{
//                    Toasty.error(this, "Gambar belum DiUpload", Toast.LENGTH_SHORT).show()
//                }

            }
        }

    }

    private fun selectPhoto() {
        ImagePicker.with(this)
            .cropSquare()
            .compress(1024)
            .maxResultSize(720, 720)
            .galleryMimeTypes(
                mimeTypes = arrayOf(
                    "image/png",
                    "image/jpg",
                    "image/jpeg"
                )
            )
            .start { resultCode, data ->
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        val fileUri = data?.data
                        this.mImageUri = fileUri!!
                        mUpdateProfileBinding.imgUser.setImageURI(fileUri)
                        val file: File? = ImagePicker.getFile(data)
                        val filePath: String = ImagePicker.getFilePath(data).toString()
                    }
                    ImagePicker.RESULT_ERROR -> {
                        Toasty.error(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toasty.info(this, "Pilih Foto Dibatalkan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    private fun getFileExtension(mUri: Uri): String? {
        val mContentResolver = contentResolver
        val mime = MimeTypeMap.getSingleton()

        return mime.getExtensionFromMimeType(mContentResolver.getType(mUri))
    }


    private fun updateProfile(mFirstName: String, mLastName: String, mNis: String, uri: Uri) {

        mLoading.show()

        val fileRef = mStorageReference.child(
            System.currentTimeMillis().toString() + "." + getFileExtension(uri)
        )

        fileRef.putFile(uri).addOnSuccessListener {
            fileRef.downloadUrl.addOnSuccessListener { uri ->

                mDatabaseReference.child(studentId).child("firstName").setValue(mFirstName)
                mDatabaseReference.child(studentId).child("lastName").setValue(mLastName)
                mDatabaseReference.child(studentId).child("nis").setValue(mNis)
                mDatabaseReference.child(studentId).child("image").setValue(uri.toString())

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
                myPreferences.setValue(Constants.STUDENT_PHOTO, uri.toString())


                val goHome = Intent(this, HomeActivity::class.java)
                startActivity(goHome)
                finish()
            }
        }
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
        }

        return true
    }

    //    private fun selectImage() {
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//
//        startActivityForResult(intent, 2)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 2 && resultCode == RESULT_OK) {
//            mImageUri = data?.data!!
//            mUpdateProfileBinding.imgUser.setImageURI(mImageUri)
//        }
//    }
}