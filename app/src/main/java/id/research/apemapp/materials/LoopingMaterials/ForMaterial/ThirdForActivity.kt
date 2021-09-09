package id.research.apemapp.materials.LoopingMaterials.ForMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityThirdForBinding
import id.research.apemapp.objects.Constants

class ThirdForActivity : YouTubeBaseActivity() {

    private lateinit var mThirdForBinding: ActivityThirdForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mThirdForBinding = ActivityThirdForBinding.inflate(layoutInflater)
        setContentView(mThirdForBinding.root)

        mThirdForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, SecondForActivity::class.java))
            finish()
        }

        mThirdForBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FourthForActivity::class.java))
            finish()
        }

        mThirdForBinding.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("Gw7nl35HF1I")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@ThirdForActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })


    }
}