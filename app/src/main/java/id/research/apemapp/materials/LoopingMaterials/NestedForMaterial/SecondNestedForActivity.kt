package id.research.apemapp.materials.LoopingMaterials.NestedForMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondNestedForBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class SecondNestedForActivity : YouTubeBaseActivity() {

    private lateinit var mSecondNestedBinding: ActivitySecondNestedForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondNestedBinding = ActivitySecondNestedForBinding.inflate(layoutInflater)
        setContentView(mSecondNestedBinding.root)

        mSecondNestedBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstNestedForActivity::class.java))
            finish()
        }

        mSecondNestedBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mSecondNestedBinding.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("Wspa4loCEzo")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@SecondNestedForActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }
}