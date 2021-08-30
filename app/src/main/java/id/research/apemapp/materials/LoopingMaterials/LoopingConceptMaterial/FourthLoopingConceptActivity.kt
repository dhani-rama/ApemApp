package id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFourthLoopingConceptBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class FourthLoopingConceptActivity : YouTubeBaseActivity() {

    private lateinit var mFourthLoopingBinding: ActivityFourthLoopingConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFourthLoopingBinding = ActivityFourthLoopingConceptBinding.inflate(layoutInflater)
        setContentView(mFourthLoopingBinding.root)

        mFourthLoopingBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ThirdLoopingConceptActivity::class.java))
            finish()
        }
        mFourthLoopingBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mFourthLoopingBinding.ytSecondVideo.initialize(
            Constants.API_YT_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    youTubePlayer: YouTubePlayer?,
                    wasRestored: Boolean
                ) {
                    if (wasRestored) {
                        youTubePlayer!!.play()
                    } else {
                        youTubePlayer!!.cueVideo("UnjN6paBra0")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@FourthLoopingConceptActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}