package com.fikrialfian.aplikasi_pertama

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity: AppCompatActivity() {
    lateinit var imageResult: ImageView
    lateinit var inputSearch: EditText
    lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initComponents()
        initEventListener()
    }
    fun initComponents() {
        imageResult = findViewById(R.id.resultImageView)
        inputSearch = findViewById(R.id.inputEdittext)
        textResult = findViewById(R.id.textResultTextView)
    }
    fun initEventListener() {
        inputSearch.addTextChangedListener {
            searchIt()
        }
    }
    fun searchIt() {
        val query = inputSearch.text.toString().trim().uppercase()
        when(query){
            "SEPEDA" -> {
                textResult.visibility = View.INVISIBLE
                textResult.text = ""
                imageResult.setImageResource(R.drawable.download)
            }
            "MOBIL" -> {
                textResult.visibility = View.INVISIBLE
                textResult.text = ""
                imageResult.setImageResource(R.drawable.mobil)
            }
            else -> {
                textResult.visibility = View.VISIBLE
                textResult.text = when {
                    query.length == 0 -> "masukkan inputan dengan benar"
                    else -> "Tidak ada hasil dari \"$query\""
                }
                imageResult.setImageResource(R.drawable.tanda_tanya)
            }
        }
    }
}