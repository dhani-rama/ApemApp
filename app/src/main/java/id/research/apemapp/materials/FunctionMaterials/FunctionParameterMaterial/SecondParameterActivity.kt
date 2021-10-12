package id.research.apemapp.materials.FunctionMaterials.FunctionParameterMaterial

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
import id.research.apemapp.databinding.ActivitySecondParameterBinding
import id.research.apemapp.home.OnlineCompiler.OnlineCompilerActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.objects.Constants

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
            customChooseDialog()
//            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
//            finish()
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
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }

        dialog.show()
    }
}