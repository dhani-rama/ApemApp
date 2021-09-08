package id.research.apemapp.home

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.database.DatabaseReference
import id.research.apemapp.R
import id.research.apemapp.databinding.FragmentHomeBinding
import id.research.apemapp.home.OnlineCompiler.OnlineCompilerActivity
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_home.*
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel


class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var mLoading: ProgressDialog
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var studentId: String


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
        studentId = myPreferences.getValue(Constants.STUDENT_ID)!!

        val foto = myPreferences.getValue(Constants.STUDENT_PHOTO)

        Glide.with(requireActivity())
            .load(foto)
            .apply(RequestOptions().override(250))
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user)
            .into(homeBinding.imgUser)

        //mengambil data dari shared preferences
        homeBinding.tvName.text = myPreferences.getValue(Constants.STUDENT_FIRST_NAME)


        firstImageSlider()

        homeBinding.cardCodeEditor.setOnClickListener {
            startActivity(Intent(this.requireActivity(), OnlineCompilerActivity::class.java))
        }

        homeBinding.imgUser.setOnClickListener {
            findNavController().navigate(R.id.action_home_fragment_to_profile_fragment)
        }

        homeBinding.cardLooping.setOnClickListener {
            startActivity(Intent(this.requireActivity(), LoopingCompetenceActivity::class.java))
        }

        homeBinding.cardArray.setOnClickListener {
            startActivity(Intent(this.requireActivity(), ArrayCompetenceActivity::class.java))
        }

        homeBinding.cardFunction.setOnClickListener {
            startActivity(Intent(this.requireActivity(), FunctionCompetenceActivity::class.java))
        }
    }

    private fun firstImageSlider() {
        val firstCarousel: ImageCarousel = requireView().findViewById(R.id.carousel_view_first)
        val firstList = mutableListOf<CarouselItem>()

        firstList.add(CarouselItem(imageDrawable = R.drawable.img_logo_kemdikbud))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_first_logo_um))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_second_logo_um))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_first_logo_vocational))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_second_logo_vocational))

        firstCarousel.addData(firstList)
    }
}