package id.research.apemapp.materials.LoopingMaterials.WhileMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFourthWhileBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class FourthWhileActivity : YouTubeBaseActivity() {

    private lateinit var mFourtWhileBinding: ActivityFourthWhileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFourtWhileBinding = ActivityFourthWhileBinding.inflate(layoutInflater)
        setContentView(mFourtWhileBinding.root)

        mFourtWhileBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ThirdWhileActivity::class.java))
            finish()
        }

        mFourtWhileBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mFourtWhileBinding.videoSecond.initialize(
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
                    Toasty.info(this@FourthWhileActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }
            })
    }
}