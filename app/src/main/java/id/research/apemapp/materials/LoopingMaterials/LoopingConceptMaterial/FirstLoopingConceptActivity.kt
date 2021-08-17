package id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstLoopingConceptBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class FirstLoopingConceptActivity : AppCompatActivity() {

    private lateinit var mFirstConceptBinding: ActivityFirstLoopingConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFirstConceptBinding = ActivityFirstLoopingConceptBinding.inflate(layoutInflater)
        setContentView(mFirstConceptBinding.root)

        mFirstConceptBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mFirstConceptBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondLoopingConceptActivity::class.java))
            finish()
        }

//        mFirstConceptBinding.ytVideo.initialize(
//            Constants.API_YT_KEY,
//            object : YouTubePlayer.OnInitializedListener {
//                override fun onInitializationSuccess(
//                    provider: YouTubePlayer.Provider?,
//                    youtubePlayer: YouTubePlayer?,
//                    wasRestored: Boolean
//                ) {
//                    if (wasRestored) {
//                        youtubePlayer!!.play()
//                    } else {
//                        youtubePlayer!!.cueVideo("4vXAiT9IMbc")
//                    }
//                }
//
//                override fun onInitializationFailure(
//                    provider: YouTubePlayer.Provider?,
//                    result: YouTubeInitializationResult?
//                ) {
//                    Toasty.info(
//                        this@FirstLoopingConceptMaterialsActivity,
//                        "$result",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//            })


    }
}