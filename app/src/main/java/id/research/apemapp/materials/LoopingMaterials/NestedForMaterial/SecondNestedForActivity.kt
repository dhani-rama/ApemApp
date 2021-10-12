package id.research.apemapp.materials.LoopingMaterials.NestedForMaterial

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivitySecondNestedForBinding
import id.research.apemapp.home.OnlineCompiler.OnlineCompilerActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.objects.Constants

class SecondNestedForActivity : YouTubeBaseActivity() {

    private lateinit var mSecondNestedBinding: ActivitySecondNestedForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondNestedBinding = ActivitySecondNestedForBinding.inflate(layoutInflater)
        setContentView(mSecondNestedBinding.root)

        mSecondNestedBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstNestedForActivity::class.java))
            finish()
        }

        mSecondNestedBinding.btnNext.setOnClickListener {
            customChooseDialog()
//            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
//            finish()
        }

        mSecondNestedBinding.videoFirst.initialize(
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
                        youtubePlayer!!.cueVideo("Wspa4loCEzo")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@SecondNestedForActivity, "$result", Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }

    private fun customChooseDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.item_alert_finish)

        val btnChooseYes = dialog.findViewById<MaterialButton>(R.id.btn_next)
        val btnChooseNo = dialog.findViewById<MaterialButton>(R.id.btn_dismiss)

        btnChooseYes.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, OnlineCompilerActivity::class.java))
            finish()
        }

        btnChooseNo.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        dialog.show()
    }
}