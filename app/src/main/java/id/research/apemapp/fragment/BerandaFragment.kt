package id.research.apemapp.fragment

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DatabaseReference
import id.research.apemapp.R
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_beranda.*


class BerandaFragment : Fragment() {

    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var muridId: String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //inialisasi variabel
        mLoading = ProgressDialog(this@BerandaFragment.context)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        myPreferences = MySharedPreferences(this@BerandaFragment.requireContext())
        muridId = myPreferences.getValue("id")!!

        //mengambil data dari shared preferences
        tv_nama.text = myPreferences.getValue("nama")

    }

}