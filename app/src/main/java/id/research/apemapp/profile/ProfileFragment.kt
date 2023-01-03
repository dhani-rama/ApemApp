package id.research.apemapp.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dev.shreyaspatil.MaterialDialog.MaterialDialog
import es.dmoral.toasty.Toasty
import id.research.apemapp.R
import id.research.apemapp.auth.SignInActivity
import id.research.apemapp.databinding.FragmentProfileBinding
import id.research.apemapp.objects.Constants
import id.research.apemapp.utils.MySharedPreferences
import java.io.File


class ProfileFragment : Fragment() {

    private lateinit var myPreferences: MySharedPreferences
    private lateinit var settingsBinding: FragmentProfileBinding
    private lateinit var mDatabaseReference: DatabaseReference
    private lateinit var studentId: String
    private lateinit var mImageUri: Uri
    private lateinit var mStorageReference: StorageReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        settingsBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return settingsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myPreferences = MySharedPreferences(this@ProfileFragment.requireContext())
        settingsBinding.tvName.text = myPreferences.getValue(Constants.STUDENT_FIRST_NAME)


        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Student")
        mStorageReference = FirebaseStorage.getInstance().reference
        studentId = myPreferences.getValue(Constants.STUDENT_ID)!!

        val foto = myPreferences.getValue(Constants.STUDENT_PHOTO)

        Glide.with(requireActivity())
            .load(foto)
            .apply(RequestOptions().override(250))
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user)
            .into(settingsBinding.imgUser)

        settingsBinding.tvChangePhoto.setOnClickListener {
            pictPhoto()
        }

        settingsBinding.btnEditProfile.setOnClickListener {
            startActivity(Intent(this.requireActivity(), UpdateProfileActivity::class.java))
        }

        settingsBinding.btnLogout.setOnClickListener {

            val mDialog = MaterialDialog.Builder(requireContext() as Activity)
                .setTitle("Keluar")
                .setMessage("Apakah Anda Yakin Ingin Keluar ?")
                .setCancelable(true)
                .setPositiveButton(
                    "Tidak", R.drawable.ic_cancel
                ) { dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                .setNegativeButton(
                    "Ya", R.drawable.ic_exit
                ) { dialogInterface, _ ->
                    //Menyimpan data bahwa siswa telah berhasil masuk
                    myPreferences.setValue(Constants.STUDENT, "")

                    //menyimpan data siswa yang sudah masuk
                    myPreferences.setValue(Constants.STUDENT_ID, " ")
                    myPreferences.setValue(Constants.STUDENT_FIRST_NAME, " ")
                    myPreferences.setValue(Constants.STUDENT_LAST_NAME, " ")
                    myPreferences.setValue(Constants.STUDENT_NIS, " ")
                    myPreferences.setValue(Constants.STUDENT_PASSWORD, " ")
                    myPreferences.setValue(Constants.STUDENT_PHOTO, " ")
                    myPreferences.setValue(Constants.STUDENT_LOOPING_QUIZ_SCORE, " ")
                    myPreferences.setValue(Constants.STUDENT_ARRAY_QUIZ_SCORE, " ")
                    myPreferences.setValue(Constants.STUDENT_FUNCTION_QUIZ_SCORE, " ")

                    val goOut = Intent(this@ProfileFragment.context, SignInActivity::class.java)
                    startActivity(goOut)
                    activity?.finish()
                }
                .build()
            //show dialog
            mDialog.show()
        }

//        settingsBinding.btnAlarm.setOnClickListener {
//            startActivity(Intent(this.requireActivity(), AlarmActivity::class.java))
//            activity?.finish()
//        }


//        settingsBinding.btnEditPassword.setOnClickListener {
//            startActivity(Intent(this.requireActivity(), UpdatePasswordActivity::class.java))
//        }

//        settingsBinding.btnProfilDeveloper.setOnClickListener {
//            startActivity(Intent(this.requireActivity(), DeveloperProfileActivity::class.java))
//        }

//        settingsBinding.btnInstructionUsed.setOnClickListener {
//            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG)
//                .show()
//        }

//        settingsBinding.btnUploadImage.setOnClickListener {
//            startActivity(Intent(this.requireActivity(), TestingUploadImageActivity::class.java))
//        }


    }

    private fun pictPhoto() {
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
                        settingsBinding.imgUser.setImageURI(fileUri)
                        val file: File? = ImagePicker.getFile(data)
                        val filePath: String = ImagePicker.getFilePath(data).toString()

                        uploadPhoto(mImageUri)
                    }
                    ImagePicker.RESULT_ERROR -> {
                        Toasty.error(
                            this.requireActivity(),
                            ImagePicker.getError(data),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        Toasty.info(
                            this.requireActivity(),
                            "Pilih Foto Dibatalkan",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
    }

    private fun uploadPhoto(uri: Uri) {

        val fileRef = mStorageReference.child(
            System.currentTimeMillis().toString() + "." + getFileExtension(uri)
        )

        fileRef.putFile(uri).addOnSuccessListener {
            fileRef.downloadUrl.addOnSuccessListener { uri ->

                mDatabaseReference.child(studentId).child("image").setValue(uri.toString())

                Toasty.success(
                    this.requireActivity(),
                    "Berhasil Menyimpan Perubahan Foto Profil Anda",
                    Toast.LENGTH_SHORT
                ).show()

                myPreferences.setValue(Constants.STUDENT_PHOTO, uri.toString())
            }
                .addOnFailureListener {
                    Toasty.error(
                        this.requireActivity(),
                        "Gagal Menyimpan Perubahan Foto Profil Anda", Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    private fun getFileExtension(mUri: Uri): String? {
        val mContentResolver = requireActivity().contentResolver
        val mime = MimeTypeMap.getSingleton()

        return mime.getExtensionFromMimeType(mContentResolver.getType(mUri))
    }
}