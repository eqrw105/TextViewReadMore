package com.macchiato.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.doOnLayout
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val moreTextView = findViewById<TextView>(R.id.more)

        textView.text = "1420914237901409143270891413\n123\n45\n54365\n5324\n5234524\n213"
        textView.post {
            Toast.makeText(this@MainActivity, textView.lineCount.toString(), Toast.LENGTH_SHORT).show()
            Log.d("라인", textView.lineCount.toString())
            val lineCount = textView.lineCount
            if(lineCount >= 5) {
                moreTextView.visibility = View.VISIBLE
            }else {
                moreTextView.visibility = View.GONE
            }
        }


        moreTextView.setOnClickListener {
                if(textView.maxLines == Int.MAX_VALUE) {
                    moreTextView.text = "더보기"
                    textView.maxLines = 5
                }
                else {
                    moreTextView.text = "줄이기"
                    textView.maxLines = Int.MAX_VALUE
                }
        }
    }
}