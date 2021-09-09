package id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivitySecondFunctionConceptBinding
import id.research.apemapp.objects.Constants

class SecondFunctionConceptActivity : YouTubeBaseActivity() {

    private lateinit var mSecondFunctionBinding: ActivitySecondFunctionConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondFunctionBinding = ActivitySecondFunctionConceptBinding.inflate(layoutInflater)
        setContentView(mSecondFunctionBinding.root)

        mSecondFunctionBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstFunctionConceptActivity::class.java))
            finish()
        }
        mSecondFunctionBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ThirdFunctionConceptActivity::class.java))
            finish()
        }

        mSecondFunctionBinding.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("QwA_h87W4-0")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@SecondFunctionConceptActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }
}