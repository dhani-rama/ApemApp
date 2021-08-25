package id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondArrayConceptBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class SecondArrayConceptActivity : YouTubeBaseActivity() {

    private lateinit var mSecondBinding: ActivitySecondArrayConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondBinding = ActivitySecondArrayConceptBinding.inflate(layoutInflater)
        setContentView(mSecondBinding.root)

        mSecondBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstArrayConceptActivity::class.java))
            finish()
        }

        mSecondBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }

        mSecondBinding.videoFirst.initialize(Constants.API_YT_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    youtubePlayer: YouTubePlayer?,
                    wasRestored: Boolean
                ) {
                    if (wasRestored) {
                        youtubePlayer!!.play()
                    } else {
                        youtubePlayer!!.cueVideo("DwPE9zsX00w")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@SecondArrayConceptActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}