package id.research.apemapp.materials.LoopingMaterials.ForMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFourthForBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class FourthForActivity : YouTubeBaseActivity() {

    private lateinit var mFourthForBinding: ActivityFourthForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFourthForBinding = ActivityFourthForBinding.inflate(layoutInflater)
        setContentView(mFourthForBinding.root)

        mFourthForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ThirdForActivity::class.java))
            finish()
        }

        mFourthForBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mFourthForBinding.videoSecond.initialize(
            Constants.API_YT_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    youtubePlayer: YouTubePlayer?,
                    wasRestored: Boolean
                ) {
                    if (wasRestored) {
                        youtubePlayer!!.play()
                    } else {
                        youtubePlayer!!.cueVideo("4vXAiT9IMbc")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@FourthForActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }
}