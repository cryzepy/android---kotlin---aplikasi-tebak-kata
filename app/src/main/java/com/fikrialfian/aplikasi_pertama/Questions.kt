package com.fikrialfian.aplikasi_pertama

class Questions {
    companion object {
        val questions = listOf<QuestionStructure>(
            QuestionStructure(R.drawable.bola, "Saya bulat, biasanya digunakan dalam permainan sepak bola. Apa saya?", "Bola"),
            QuestionStructure(R.drawable.buku, "Saya terbuat dari kertas dan sering dibaca oleh banyak orang. Apa saya?", "Buku"),
            QuestionStructure(R.drawable.laptop, "Saya memiliki layar dan keyboard, dan digunakan untuk bekerja atau bermain game. Apa saya?","Laptop"),
            QuestionStructure(R.drawable.kulkas, "Saya digunakan untuk menyimpan makanan agar tetap dingin. Apa saya?", "Kulkas"),
            QuestionStructure(R.drawable.pensil, "Saya sering digunakan untuk menulis atau menggambar. Apa saya?","Pensil"),
            QuestionStructure(R.drawable.jam_tangan, "Saya dapat menunjukkan waktu dengan jarum jam. Apa saya?", "Jam tangan"),
            QuestionStructure(R.drawable.mobil, "Saya memiliki roda dan bisa mengangkut orang atau barang. Apa saya?", "Mobil"),
            QuestionStructure(R.drawable.kompor, "Saya digunakan untuk memasak makanan. Apa saya?", "Kompor"),
            QuestionStructure(R.drawable.gunting, "Saya digunakan untuk memotong kertas atau kain. Apa saya?", "Gunting"),
            QuestionStructure(R.drawable.sepatu_boot, "Saya terbuat dari karet dan dipakai di kaki saat hujan. Apa saya?", "Sepatu boot"),
            QuestionStructure(R.drawable.kipas_angin, "Saya berputar untuk menghasilkan angin sejuk di ruangan. Apa saya?", "Kipas angin"),
            QuestionStructure(R.drawable.lampu, "Saya bisa dinyalakan untuk memberikan cahaya di malam hari. Apa saya?", "Lampu")
        )
    }
}

data class QuestionStructure(
    val image: Int,
    val question: String,
    val correctKey: String
)

