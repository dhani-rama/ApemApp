package id.research.apemapp.Home

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DatabaseReference
import id.research.apemapp.databinding.FragmentHomeBinding
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var mLoading: ProgressDialog
    private lateinit var mDatabase: DatabaseReference
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var muridId: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //inialisasi variabel
        mLoading = ProgressDialog(this@HomeFragment.context)
        mLoading.setCancelable(false)
        mLoading.setMessage("Loading...")

        myPreferences = MySharedPreferences(this@HomeFragment.requireContext())
        muridId = myPreferences.getValue("id")!!

        //mengambil data dari shared preferences
        homeBinding.tvName.text = myPreferences.getValue("nama")
    }
}