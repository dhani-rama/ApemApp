package id.research.apemapp.materials.ArrayMaterials.SecondArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondArraySecondDimensionBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class SecondArraySecondDimensionActivity : YouTubeBaseActivity() {

    private lateinit var mSecondArrayBinding: ActivitySecondArraySecondDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondArrayBinding = ActivitySecondArraySecondDimensionBinding.inflate(layoutInflater)
        setContentView(mSecondArrayBinding.root)

        mSecondArrayBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstArraySecondDimensionActivity::class.java))
            finish()
        }
        mSecondArrayBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mSecondArrayBinding.videoSecond.initialize(
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
                        youtubePlayer!!.cueVideo("GH32IQbwPKk")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(
                        this@SecondArraySecondDimensionActivity,
                        "$result",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            })

    }
}