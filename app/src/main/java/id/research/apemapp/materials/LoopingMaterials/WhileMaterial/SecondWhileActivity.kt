package id.research.apemapp.materials.LoopingMaterials.WhileMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondWhileBinding
import id.research.apemapp.utils.Constants

class SecondWhileActivity : YouTubeBaseActivity() {

    private lateinit var mSecondWhileBinding: ActivitySecondWhileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondWhileBinding = ActivitySecondWhileBinding.inflate(layoutInflater)
        setContentView(mSecondWhileBinding.root)

        mSecondWhileBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstWhileActivity::class.java))
            finish()
        }

        mSecondWhileBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ThirdWhileActivity::class.java))
            finish()
        }

        mSecondWhileBinding.videoFirst.initialize(
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
                    Toasty.info(this@SecondWhileActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}