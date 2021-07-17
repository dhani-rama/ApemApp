package id.research.apemapp.Settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.research.apemapp.Auth.SignInActivity
import id.research.apemapp.databinding.FragmentSettingsBinding
import id.research.apemapp.util.Constants
import id.research.apemapp.util.MySharedPreferences
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
        settingsBinding.tvName.text = myPreferences.getValue(Constants.STUDENT_NAME)

        layout_logout.setOnClickListener {
            //Menyimpan data bahwa siswa telah berhasil masuk
            myPreferences.setValue(Constants.STUDENT, "")

            //menyimpan data siswa yang sudah masuk
            myPreferences.setValue(Constants.STUDENT_ID, " ")
            myPreferences.setValue(Constants.STUDENT_NAME, " ")
            myPreferences.setValue(Constants.STUDENT_NIS, " ")
            myPreferences.setValue(Constants.STUDENT_PASSWORD, " ")
            myPreferences.setValue(Constants.STUDENT_LOOPING_QUIZ_SCORE, " ")
            myPreferences.setValue(Constants.STUDENT_ARRAY_QUIZ_SCORE, " ")
            myPreferences.setValue(Constants.STUDENT_FUNCTION_QUIZ_SCORE, " ")

            val goOut = Intent(this@SettingsFragment.context, SignInActivity::class.java)
            startActivity(goOut)
            getActivity()?.finish()

        }
    }
}