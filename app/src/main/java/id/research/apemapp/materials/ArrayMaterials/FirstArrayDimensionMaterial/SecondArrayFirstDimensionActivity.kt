package id.research.apemapp.materials.ArrayMaterials.FirstArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondArrayFirstDimensionBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.objects.Constants

class SecondArrayFirstDimensionActivity : YouTubeBaseActivity() {

    private lateinit var mSecondArrayBinding: ActivitySecondArrayFirstDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondArrayBinding = ActivitySecondArrayFirstDimensionBinding.inflate(layoutInflater)
        setContentView(mSecondArrayBinding.root)

        mSecondArrayBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstArrayFirstDimensionActivity::class.java))
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
                        youtubePlayer!!.cueVideo("HAnkYbMvLOo")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(
                        this@SecondArrayFirstDimensionActivity,
                        "$result",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            })
    }
}