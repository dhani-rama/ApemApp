package id.research.apemapp.materials.FunctionMaterials.FunctionVariableMaterial

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivitySecondVariableBinding
import id.research.apemapp.home.OnlineCompiler.OnlineCompilerActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class SecondVariableActivity : AppCompatActivity() {

    private lateinit var mSecondVariableBinding: ActivitySecondVariableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondVariableBinding = ActivitySecondVariableBinding.inflate(layoutInflater)
        setContentView(mSecondVariableBinding.root)

        mSecondVariableBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstVariableActivity::class.java))
            finish()
        }
        mSecondVariableBinding.btnNext.setOnClickListener {
            customChooseDialog()
//            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
//            finish()
        }
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