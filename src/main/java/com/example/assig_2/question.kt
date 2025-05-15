package com.example.assig_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

       val questions = findViewById<TextView>(R.id.qlist)
        val truebtn = findViewById<Button>(R.id.truebtn)
        val falsebtn = findViewById<Button>(R.id.falsebtn)
        val nextq = findViewById<Button>(R.id.nextbtn)
        val feedb = findViewById<TextView>(R.id.fdview)


        val questionList = listOf(
            "Nelson Mandela was the president in 1994.",
            "World War II ended in 1945.",
            "The Berlin Wall fell in 1989.",
            "The first moon landing was in 1969.",
            "The Titanic sank in 1912."
        )
        val answerList = listOf(
            true,
            true,
            true,
            true,
            true
        )

        var currentquestionNum = 0
        var scores = 0

        questions.text = questionList[currentquestionNum]

        truebtn.setOnClickListener {
            if(answerList[currentquestionNum] == true){
                scores++
                feedb.text = "correct answer!!"
            }else{
                feedb.text = "incorrect answer!!"
            }
            falsebtn.isEnabled = false
            truebtn.isEnabled = false
            nextq.isEnabled = true

        }
        falsebtn.setOnClickListener {
            if(answerList[currentquestionNum] == false){
                scores++
                feedb.text = "correct answer!!"
            }else{
                feedb.text = "incorrect answer!!"
            }
            falsebtn.isEnabled = false
            truebtn.isEnabled = false
            nextq.isEnabled = true
        }

        nextq.setOnClickListener {

            currentquestionNum++

            if(currentquestionNum < questionList.size) {
                questions.text = questionList[currentquestionNum]
                falsebtn.isEnabled = true
                truebtn.isEnabled = true

            }else {
                val intent = Intent(this, score::class.java)
                intent.putExtra("SCORE", scores)
                intent.putExtra("TOTAL", 5)
                startActivity(intent)

            }
        }
    }
}