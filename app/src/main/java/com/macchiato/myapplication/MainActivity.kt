package com.macchiato.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.doOnLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView).doOnLayout {
            Toast.makeText(this, findViewById<TextView>(R.id.textView).lineCount.toString(), Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.more).setOnClickListener {
            val textview = findViewById<TextView>(R.id.textView)
            textview.maxLines =
                if(textview.maxLines == Int.MAX_VALUE) {
                    (it as TextView).text = "더보기"
                    5
                }
                else {
                    (it as TextView).text = "줄이기"
                    Int.MAX_VALUE
                }
        }
    }
}