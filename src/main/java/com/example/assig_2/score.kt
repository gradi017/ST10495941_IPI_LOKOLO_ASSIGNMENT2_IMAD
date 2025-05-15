package com.example.assig_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class score : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scorenum = findViewById<TextView>(R.id.dispScore)
        val message = findViewById<TextView>(R.id.messagetext)
        val reviewtext = findViewById<TextView>(R.id.revText)
        val revbtn = findViewById<Button>(R.id.revbtn)
        val retrybtn = findViewById<Button>(R.id.retrybtn)
        val exbtn = findViewById<Button>(R.id.exbtn)
        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 5)

        scorenum.text = "you scored: ${score} out of ${totalQuestions}"

        if(score >= 3){
            message.text = "that was amazing!!"
        }else{
            message.text = "come back stronger"
        }

        val questionList = listOf(
            "Nelson Mandela was the president in 1994.",
            "World War II ended in 1945.",
            "The Berlin Wall fell in 1989.",
            "The first moon landing was in 1969.",
            "The Titanic sank in 1912."
        )
        val answerList = listOf(
            true,  // Nelson Mandela was president in 1994
            true,  // WWII ended in 1945
            true,  // Berlin Wall fell in 1989
            true,  // First moon landing was 1969
            true   // Titanic sank in 1912
        )

        revbtn.setOnClickListener {
            val reviewtextview = StringBuilder()
            for (i in questionList.indices){
                reviewtextview.append("Question ${i + 1}: ${questionList[i]}\n")
                reviewtextview.append("Correct answer: ${if (answerList[i]) "True" else "False"}\n\n")
            }
            reviewtext.text = reviewtextview.toString()
        }
       retrybtn.setOnClickListener {
           val intent = Intent(this,MainActivity::class.java)
           startActivity(intent)
       }
        exbtn.setOnClickListener {
            finishAffinity()
        }
    }
}