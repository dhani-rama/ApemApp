package id.research.apemapp.materials.LoopingMaterials.WhileMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityThirdWhileBinding

class ThirdWhileActivity : AppCompatActivity() {

    private lateinit var mThirdWhileBinding: ActivityThirdWhileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mThirdWhileBinding = ActivityThirdWhileBinding.inflate(layoutInflater)
        setContentView(mThirdWhileBinding.root)

        mThirdWhileBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, SecondWhileActivity::class.java))
            finish()
        }
        mThirdWhileBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FourthWhileActivity::class.java))
            finish()
        }
    }
}