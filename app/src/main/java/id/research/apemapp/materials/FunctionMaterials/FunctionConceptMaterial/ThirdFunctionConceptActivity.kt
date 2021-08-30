package id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityThirdFunctionConceptBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.utils.Constants

class ThirdFunctionConceptActivity : YouTubeBaseActivity() {

    private lateinit var mThirdFunctionBinding: ActivityThirdFunctionConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mThirdFunctionBinding = ActivityThirdFunctionConceptBinding.inflate(layoutInflater)
        setContentView(mThirdFunctionBinding.root)

        mThirdFunctionBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, SecondFunctionConceptActivity::class.java))
            finish()
        }
        mThirdFunctionBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }

        mThirdFunctionBinding.videoFirst.initialize(Constants.API_YT_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    youtubePlayer: YouTubePlayer?,
                    wasRestored: Boolean
                ) {
                    if (wasRestored) {
                        youtubePlayer!!.play()
                    } else {
                        youtubePlayer!!.cueVideo("zaG-D4qIOvI")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@ThirdFunctionConceptActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}