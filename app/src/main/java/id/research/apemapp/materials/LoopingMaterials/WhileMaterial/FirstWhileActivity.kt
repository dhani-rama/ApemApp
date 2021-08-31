package id.research.apemapp.materials.LoopingMaterials.WhileMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstWhileBinding

class FirstWhileActivity : AppCompatActivity() {

    private lateinit var mFirstWhileActivity: ActivityFirstWhileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstWhileActivity = ActivityFirstWhileBinding.inflate(layoutInflater)
        setContentView(mFirstWhileActivity.root)

        mFirstWhileActivity.btnBack.setOnClickListener {
            startActivity(Intent(this, WhileLearningGoalsActivity::class.java))
            finish()
        }
        mFirstWhileActivity.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondWhileActivity::class.java))
            finish()
        }
    }
}