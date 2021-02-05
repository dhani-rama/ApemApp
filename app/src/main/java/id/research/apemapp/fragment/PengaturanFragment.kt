package id.research.apemapp.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.research.apemapp.R
import id.research.apemapp.auth.Sign_in
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_pengaturan.*


class PengaturanFragment : Fragment() {

    private lateinit var myPreferences : MySharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengaturan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        
        myPreferences = MySharedPreferences(this@PengaturanFragment.requireContext())
        tv_nama.text = myPreferences.getValue("nama")

        layout_logout.setOnClickListener {
            //Menyimpan data bahwa siswa telah berhasil masuk
            myPreferences.setValue("murid", "")

            //menyimpan data siswa yang sudah masuk
            myPreferences.setValue("id", " ")
            myPreferences.setValue("nama", " ")
            myPreferences.setValue("nis", " ")
            myPreferences.setValue("password", " ")

            val keluar = Intent(this@PengaturanFragment.context, Sign_in::class.java)
            startActivity(keluar)
            getActivity()?.finish()
        }
    }
}