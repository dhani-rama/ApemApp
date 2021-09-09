package id.research.apemapp.materials.ArrayMaterials.ThirdArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFirstArrayThirdDimensionBinding
import id.research.apemapp.objects.Constants

class FirstArrayThirdDimensionActivity : YouTubeBaseActivity() {

    private lateinit var mFirstArray: ActivityFirstArrayThirdDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstArray = ActivityFirstArrayThirdDimensionBinding.inflate(layoutInflater)
        setContentView(mFirstArray.root)

        mFirstArray.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayThirdDimensionGoalsActivity::class.java))
            finish()
        }
        mFirstArray.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondArrayThirdDimensionActivity::class.java))
            finish()
        }

        mFirstArray.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("uji__z9wINY")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(
                        this@FirstArrayThirdDimensionActivity,
                        "$result",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            })

    }
}