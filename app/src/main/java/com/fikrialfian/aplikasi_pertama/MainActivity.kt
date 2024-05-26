package com.fikrialfian.aplikasi_pertama

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.timer

class MainActivity: AppCompatActivity() {
    lateinit var imageResult: ImageView
    lateinit var inputSearch: EditText
    lateinit var textResult: TextView
    lateinit var questionTextView: TextView
    lateinit var btnResetQuestion: Button
    lateinit var questionProgres: TextView
    val player = Player()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initComponents()
        initEventListener()
        updateQuestionComponent()
    }
    fun initComponents() {
        imageResult = findViewById(R.id.resultImageView)
        inputSearch = findViewById(R.id.inputEdittext)
        textResult = findViewById(R.id.textResultTextView)
        questionTextView = findViewById(R.id.question)
        btnResetQuestion = findViewById(R.id.btnResetQuestion)
        questionProgres = findViewById(R.id.questionProgres)
    }
    fun initEventListener() {
        inputSearch.addTextChangedListener {
            searchIt()
        }
        btnResetQuestion.setOnClickListener {
            player.newGame()
            updateQuestionComponent()
        }
    }

    fun updateQuestionComponent() {
        questionProgres.text = "${player.QUESTION_INDEX_ACTIVE+1}/${player.QUESTION_TOTAL}"
        questionTextView.text = player.getQuestion().question
        imageResult.setImageResource(R.drawable.tanda_tanya)
        inputSearch.text.clear()
    }
    fun searchIt() {
        val query = inputSearch.text.toString().trim().uppercase()
        when(query){
            player.getQuestion().correctKey.trim().uppercase() -> {
                textResult.visibility = View.INVISIBLE
                textResult.text = ""
                imageResult.setImageResource(player.getQuestion().image)

                val ctx = this
                GlobalScope.launch(Dispatchers.Main) {
                    delay(2000)
                    if (!player.isFinish()) {
                        player.updateQuestion()
                        updateQuestionComponent()
                    } else {
                        val intent = Intent(ctx, Congrat::class.java)
                        startActivity(intent)
                    }
                }

            }
            else -> {
                textResult.visibility = View.VISIBLE
                textResult.text = when {
                    query.length == 0 -> "masukkan inputan dengan benar"
                    else -> "jawaban anda salah"
                }
                imageResult.setImageResource(R.drawable.tanda_tanya)
            }
        }
    }
}

data class QuestionData(var BENAR: Int, val TOTAL_SOAL: Int)