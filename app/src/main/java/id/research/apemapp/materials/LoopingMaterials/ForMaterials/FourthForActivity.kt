package id.research.apemapp.materials.LoopingMaterials.ForMaterials

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFourthForBinding

class FourthForActivity : AppCompatActivity() {

    private lateinit var mFourthForBinding: ActivityFourthForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFourthForBinding = ActivityFourthForBinding.inflate(layoutInflater)
        setContentView(mFourthForBinding.root)
    }
}