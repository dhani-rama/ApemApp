package id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityThirdLoopingConceptBinding
import id.research.apemapp.utils.Constants

class ThirdLoopingConceptActivity : YouTubeBaseActivity() {

    private lateinit var mThirdLoopingBinding: ActivityThirdLoopingConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mThirdLoopingBinding = ActivityThirdLoopingConceptBinding.inflate(layoutInflater)
        setContentView(mThirdLoopingBinding.root)

        mThirdLoopingBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, SecondLoopingConceptActivity::class.java))
            finish()
        }

        mThirdLoopingBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FourthLoopingConceptActivity::class.java))
            finish()
        }

        mThirdLoopingBinding.ytFirstVideo.initialize(Constants.API_YT_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    youTubePlayer: YouTubePlayer?,
                    wasRestored: Boolean
                ) {
                    if (wasRestored) {
                        youTubePlayer!!.play()
                    } else {
                        youTubePlayer!!.cueVideo("4vXAiT9IMbc")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@ThirdLoopingConceptActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }
            })

//        mThirdLoopingBinding.ytSecondVideo.initialize(Constants.API_YT_KEY,
//            object : YouTubePlayer.OnInitializedListener{
//                override fun onInitializationSuccess(
//                    provider: YouTubePlayer.Provider?,
//                    youTubePlayer: YouTubePlayer?,
//                    wasRestored: Boolean
//                ) {
//                    if(wasRestored){
//                        youTubePlayer!!.play()
//                    }
//                    else{
//                        youTubePlayer!!.cueVideo("UnjN6paBra0")
//                    }
//                }
//
//                override fun onInitializationFailure(
//                    provider: YouTubePlayer.Provider?,
//                    result: YouTubeInitializationResult?
//                ) {
//                    Toasty.info(this@ThirdLoopingConceptActivity, "$result", Toast.LENGTH_SHORT).show()
//                }
//            })
    }
}