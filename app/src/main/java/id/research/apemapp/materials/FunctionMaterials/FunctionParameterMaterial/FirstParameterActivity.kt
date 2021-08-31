package id.research.apemapp.materials.FunctionMaterials.FunctionParameterMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFirstParameterBinding
import id.research.apemapp.utils.Constants

class FirstParameterActivity : YouTubeBaseActivity() {

    private lateinit var mFirstParameter: ActivityFirstParameterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstParameter = ActivityFirstParameterBinding.inflate(layoutInflater)
        setContentView(mFirstParameter.root)

        mFirstParameter.btnBack.setOnClickListener {
            startActivity(Intent(this, ParameterGoalsActivity::class.java))
            finish()
        }

        mFirstParameter.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondParameterActivity::class.java))
            finish()
        }

        mFirstParameter.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("5j3M-oYokGE")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@FirstParameterActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}