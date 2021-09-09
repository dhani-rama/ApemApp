package id.research.apemapp.materials.ArrayMaterials.SecondArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFirstArraySecondDimensionBinding
import id.research.apemapp.objects.Constants

class FirstArraySecondDimensionActivity : YouTubeBaseActivity() {

    private lateinit var mFirstArray: ActivityFirstArraySecondDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstArray = ActivityFirstArraySecondDimensionBinding.inflate(layoutInflater)
        setContentView(mFirstArray.root)

        mFirstArray.btnBack.setOnClickListener {
            startActivity(Intent(this, ArraySecondDimensionGoalsActivity::class.java))
            finish()
        }
        mFirstArray.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondArraySecondDimensionActivity::class.java))
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
                        youtubePlayer!!.cueVideo("UxbHSqawqBM")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(
                        this@FirstArraySecondDimensionActivity,
                        "$result",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            })

    }
}