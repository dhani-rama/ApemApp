package id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial

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
import id.research.apemapp.databinding.ActivitySecondArrayConceptBinding
import id.research.apemapp.home.OnlineCompiler.OnlineCompilerActivity
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.objects.Constants

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
            customChooseDialog()
//            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
//            finish()
        }

        mSecondBinding.videoFirst.initialize(
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
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }

        dialog.show()
    }

}