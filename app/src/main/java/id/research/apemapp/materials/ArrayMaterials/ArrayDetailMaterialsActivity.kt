package id.research.apemapp.materials.ArrayMaterials

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityArrayDetailMaterialsBinding

class ArrayDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mArrayDetailMaterialsBinding: ActivityArrayDetailMaterialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mArrayDetailMaterialsBinding = ActivityArrayDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mArrayDetailMaterialsBinding.root)

        mArrayDetailMaterialsBinding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}