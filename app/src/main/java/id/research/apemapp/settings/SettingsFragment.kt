package id.research.apemapp.settings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.shreyaspatil.MaterialDialog.MaterialDialog
import es.dmoral.toasty.Toasty
import id.research.apemapp.R
import id.research.apemapp.auth.SignInActivity
import id.research.apemapp.databinding.FragmentSettingsBinding
import id.research.apemapp.settings.Alarm.AlarmActivity
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    private lateinit var myPreferences : MySharedPreferences
    private lateinit var settingsBinding : FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        settingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)
        return settingsBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myPreferences = MySharedPreferences(this@SettingsFragment.requireContext())
//        settingsBinding.tvName.text = myPreferences.getValue(Constants.STUDENT_NAME)

        settingsBinding.btnAlarm.setOnClickListener {
            startActivity(Intent(this.requireActivity(), AlarmActivity::class.java))
//            activity?.finish()
        }

        settingsBinding.btnEditProfile.setOnClickListener {
            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG).show()
        }

//        settingsBinding.btnEditPass.setOnClickListener {
//            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG).show()
//        }

        settingsBinding.btnProfilDeveloper.setOnClickListener {
            startActivity(Intent(this.requireActivity(), DeveloperProfileActivity::class.java))
//            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG).show()
        }

        settingsBinding.btnInstructionUsed.setOnClickListener {
            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG).show()
        }


        settingsBinding.btnLogout.setOnClickListener {

            val mDialog = MaterialDialog.Builder(requireContext() as Activity)
                .setTitle("Keluar")
                .setMessage("Apakah Anda Yakin Ingin Keluar ?")
                .setCancelable(true)
                .setPositiveButton(
                    "Tidak", R.drawable.ic_cancel
                ){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                .setNegativeButton(
                    "Ya", R.drawable.ic_exit
                ){
                    dialogInterface, _ ->
                    //Menyimpan data bahwa siswa telah berhasil masuk
                    myPreferences.setValue(Constants.STUDENT, "")

                    //menyimpan data siswa yang sudah masuk
                    myPreferences.setValue(Constants.STUDENT_ID, " ")
                    myPreferences.setValue(Constants.STUDENT_FIRST_NAME, " ")
                    myPreferences.setValue(Constants.STUDENT_LAST_NAME, " ")
                    myPreferences.setValue(Constants.STUDENT_NIS, " ")
                    myPreferences.setValue(Constants.STUDENT_PASSWORD, " ")
                    myPreferences.setValue(Constants.STUDENT_LOOPING_QUIZ_SCORE, " ")
                    myPreferences.setValue(Constants.STUDENT_ARRAY_QUIZ_SCORE, " ")
                    myPreferences.setValue(Constants.STUDENT_FUNCTION_QUIZ_SCORE, " ")

                    val goOut = Intent(this@SettingsFragment.context, SignInActivity::class.java)
                    startActivity(goOut)
                    getActivity()?.finish()
                }
                .build()
            //show dialog
            mDialog.show()
        }
    }
}