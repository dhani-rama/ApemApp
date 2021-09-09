package id.research.apemapp.materials.ArrayMaterials.FirstArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFirstArrayFirstDimensionBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.objects.Constants

class FirstArrayFirstDimensionActivity : YouTubeBaseActivity() {

    private lateinit var mFirstArrayBinding: ActivityFirstArrayFirstDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstArrayBinding = ActivityFirstArrayFirstDimensionBinding.inflate(layoutInflater)
        setContentView(mFirstArrayBinding.root)

        mFirstArrayBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }

        mFirstArrayBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondArrayFirstDimensionActivity::class.java))
            finish()
        }

        mFirstArrayBinding.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("jhdzBkRfCzs")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(
                        this@FirstArrayFirstDimensionActivity,
                        "$result",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            })
    }
}