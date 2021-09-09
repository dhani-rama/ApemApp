package id.research.apemapp.profile

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import es.dmoral.toasty.Toasty
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityUploadImageBinding
import id.research.apemapp.objects.Constants
import id.research.apemapp.utils.MySharedPreferences
import java.io.File

class TestingUploadImageActivity : AppCompatActivity() {

    private lateinit var mUploadImageBinding: ActivityUploadImageBinding
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var mStorageReference: StorageReference
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var userId: String
    private lateinit var mImageUri: Uri
    private lateinit var mLoading: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUploadImageBinding = ActivityUploadImageBinding.inflate(layoutInflater)
        setContentView(mUploadImageBinding.root)

        mLoading = ProgressDialog(this)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        myPreferences = MySharedPreferences(this)
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Student")
        mStorageReference = FirebaseStorage.getInstance().getReference()
        userId = myPreferences.getValue(Constants.STUDENT_ID)!!


        mUploadImageBinding.btnSelect.setOnClickListener {
//            selectImage()
            selectPhoto()
        }

        mUploadImageBinding.btnUpload.setOnClickListener {
            uploadImage(mImageUri)
            Toasty.success(this, "Gambar Berhasil Di Upload", Toast.LENGTH_LONG).show()
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
                        mUploadImageBinding.imgUser.setImageURI(fileUri)
                        val file: File? = ImagePicker.getFile(data)
                        val filePath: String = ImagePicker.getFilePath(data).toString()
                    }
                    ImagePicker.RESULT_ERROR -> {
                        Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    private fun uploadImage(uri: Uri) {

        mLoading.show()
        val fileRef = mStorageReference.child(
            System.currentTimeMillis().toString() + "." + getFileExtension(uri)
        )

        fileRef.putFile(uri).addOnSuccessListener {
            fileRef.downloadUrl.addOnSuccessListener { uri ->

//                val model = AuthenticationItementity(userId, uri.toString())

                mDatabaseReference.child(userId).child("image").setValue(uri.toString())
                myPreferences.setValue(Constants.STUDENT_PHOTO, uri.toString())

//                val modelId = mDatabaseReference.push().key

//                mDatabaseReference.child(modelId!!).setValue(model)
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }

    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 2 && resultCode == RESULT_OK) {
            mImageUri = data?.data!!
            mUploadImageBinding.imgUser.setImageURI(mImageUri)
        }
    }

    private fun getFileExtension(mUri: Uri): String? {
        val mContentResolver = contentResolver
        val mime = MimeTypeMap.getSingleton()

        return mime.getExtensionFromMimeType(mContentResolver.getType(mUri))
    }
}

