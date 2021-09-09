package id.research.apemapp.objects

import id.research.apemapp.R
import id.research.apemapp.models.InstructionItemEntity

object InstructionData {

    private val name = arrayOf(
        "Halaman Beranda",
        "Halaman Materi",
        "Halaman Kuis",
        "Halaman Kamus",
        "Halaman Akun Saya"
    )

    private val images = intArrayOf(
        R.drawable.img_home,
        R.drawable.img_material,
        R.drawable.img_quiz,
        R.drawable.img_dictionary,
        R.drawable.img_profile
    )

    val listData: ArrayList<InstructionItemEntity>
        get() {
            val list = arrayListOf<InstructionItemEntity>()
            for(position in name.indices){
                val instructionItem = InstructionItemEntity()

                instructionItem.name = name[position]
                instructionItem.image = images[position]

                list.add(instructionItem)
            }
            return list
        }
}