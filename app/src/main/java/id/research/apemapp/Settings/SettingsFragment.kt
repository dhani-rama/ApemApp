package id.research.apemapp.Settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.research.apemapp.Auth.SignInActivity
import id.research.apemapp.databinding.FragmentSettingsBinding
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
        settingsBinding.tvName.text = myPreferences.getValue("nama")

        layout_logout.setOnClickListener {
            //Menyimpan data bahwa siswa telah berhasil masuk
            myPreferences.setValue("murid", "")

            //menyimpan data siswa yang sudah masuk
            myPreferences.setValue("id", " ")
            myPreferences.setValue("nama", " ")
            myPreferences.setValue("nis", " ")
            myPreferences.setValue("password", " ")

            val goOut = Intent(this@SettingsFragment.context, SignInActivity::class.java)
            startActivity(goOut)
            getActivity()?.finish()

        }
    }
}