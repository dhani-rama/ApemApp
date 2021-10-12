package id.research.apemapp.materials.LoopingMaterials.ForMaterial

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import es.dmoral.toasty.Toasty
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityFourthForBinding
import id.research.apemapp.home.OnlineCompiler.OnlineCompilerActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.objects.Constants

class FourthForActivity : YouTubeBaseActivity() {

    private lateinit var mFourthForBinding: ActivityFourthForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFourthForBinding = ActivityFourthForBinding.inflate(layoutInflater)
        setContentView(mFourthForBinding.root)

        mFourthForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ThirdForActivity::class.java))
            finish()
        }

        mFourthForBinding.btnNext.setOnClickListener {
            customChooseDialog()
//            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
//            finish()
        }

        mFourthForBinding.videoSecond.initialize(
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
                        youtubePlayer!!.cueVideo("zaG-D4qIOvI")
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Toasty.info(this@FourthForActivity, "$result", Toast.LENGTH_SHORT)
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