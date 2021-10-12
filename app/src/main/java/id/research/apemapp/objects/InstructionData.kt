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

    private val firstNumber = arrayOf(
        "1.",
        "1.",
        "1.",
        "1.",
        "1."
    )

    private val secondNumber = arrayOf(
        "2.",
        "",
        "",
        "",
        "2."
    )

    private val thirdNumber = arrayOf(
        "3.",
        "",
        "",
        "",
        ""
    )
    private val fourthNumber = arrayOf(
        "4.",
        "",
        "",
        "",
        ""
    )

    private val firstExplanation = arrayOf(
        "Menu materi digunakan untuk mengakses materi pemrograman dasar yang ada di media pembelajran A-PEM.",
        "Pada halaman materi ini, terdapat 3 menu yaitu perulangan, array, dan fungsi yang digunakan untuk mengakses materi pembelajaran.",
        "Pada halaman kuis ini, kamu dapat mengasah kemampuanmu dengan mengakses 3 latihan soal yaitu perulangan, array, dan fungsi.",
        "Pada halaman kamus ini, terdapat tombol yang digunakan untuk mencari kata - kata seputar pemrograman dasar.",
        "Pada halaman akun saya, kamu dapat mengganti foto profil dengan menekan tulisan Ganti Foto Profil."
    )

    private val secondExplanation = arrayOf(
        "Pada halaman beranda ini, kamu dapat berlatih menulis program C++ dengan menggunakan compiler online.",
        "",
        "",
        "",
        "Pada halaman akun saya, kamu dapat mengganti profil kamu dengan menekan tombol Ubah Profil."
    )

    private val thirdExplanation = arrayOf(
        "Pada halaman beranda ini, kamu dapat mengetahui cara menggunakan aplikasi ini dengan mengakses menu Petunjuk Penggunaan.",
        "",
        "",
        "",
        ""
    )

    private val fourthExplanation = arrayOf(
        "Pada halaman beranda ini, kamu dapat mengetahui informasi tentang pengembang aplikasi ini dengan mengakses menu Profil Pengembang.",
        "",
        "",
        "",
        ""
    )

    val listData: ArrayList<InstructionItemEntity>
        get() {
            val list = arrayListOf<InstructionItemEntity>()
            for(position in name.indices){
                val instructionItem = InstructionItemEntity()

                instructionItem.name = name[position]
                instructionItem.image = images[position]
                instructionItem.firstNumber = firstNumber[position]
                instructionItem.secondNumber = secondNumber[position]
                instructionItem.thirdNumber= thirdNumber[position]
                instructionItem.fourthNumber = fourthNumber[position]
                instructionItem.firstExplanation = firstExplanation[position]
                instructionItem.secondExplanation = secondExplanation[position]
                instructionItem.thirdExplanation = thirdExplanation[position]
                instructionItem.fourthExplanation = fourthExplanation[position]

                list.add(instructionItem)
            }
            return list
        }
}