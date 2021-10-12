package id.research.apemapp.home.InstructionUsing

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import id.research.apemapp.databinding.ActivityInstructionUsingBinding
import id.research.apemapp.models.InstructionItemEntity
import id.research.apemapp.objects.InstructionData

class InstructionUsingActivity : AppCompatActivity() {

    private lateinit var mInstructionBinding: ActivityInstructionUsingBinding
    private lateinit var mListInstruction: ArrayList<InstructionItemEntity>
    private lateinit var mInstructionAdapter: InstructionUsingAdapter

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mInstructionBinding = ActivityInstructionUsingBinding.inflate(layoutInflater)
        setContentView(mInstructionBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setSupportActionBar(mInstructionBinding.toolbarEditor)

        supportActionBar?.setTitle("Petunjuk Penggunaan")

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mInstructionAdapter = InstructionUsingAdapter()
        mListInstruction = arrayListOf<InstructionItemEntity>()

        showAdapter()
    }

    private fun showAdapter() {
        mListInstruction.addAll(InstructionData.listData)
        mInstructionAdapter.setListInstruction(mListInstruction)

        with(mInstructionBinding.viewPager){
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = mInstructionAdapter
        }

        mInstructionBinding.dotsIndicator.setViewPager2(mInstructionBinding.viewPager)

    }
}