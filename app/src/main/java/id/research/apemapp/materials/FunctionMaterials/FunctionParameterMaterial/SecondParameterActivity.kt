package id.research.apemapp.materials.FunctionMaterials.FunctionParameterMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondParameterBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class SecondParameterActivity : YouTubeBaseActivity() {

    private lateinit var mSecondParameterBinding: ActivitySecondParameterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondParameterBinding = ActivitySecondParameterBinding.inflate(layoutInflater)
        setContentView(mSecondParameterBinding.root)

        mSecondParameterBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstParameterActivity::class.java))
            finish()
        }
        mSecondParameterBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
        mSecondParameterBinding.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("ozL4Ct9TBGc")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@SecondParameterActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}