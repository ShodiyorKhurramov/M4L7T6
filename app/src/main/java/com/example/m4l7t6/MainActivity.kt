package com.example.m4l7t6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.tv_task6text)
        val btUrl = findViewById<View>(R.id.b_searchurl) as Button
        btUrl.isAllCaps = false
        btUrl.setOnClickListener {
            val pattern = Pattern.compile(
                "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" +
                        "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" +
                        "|mil|biz|info|mobi|name|aero|jobs|museum" +
                        "|travel|[a-z]{2}))(:[\\d]{1,5})?" +
                        "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" +
                        "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                        "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" +
                        "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                        "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" +
                        "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b"
            )
            val matcher = pattern.matcher(text.text)
            // Check all occurrences
            while (matcher.find()) {
                val spannableStr = SpannableString(text.text)
                val foregroundColorSpan = ForegroundColorSpan(Color.BLUE)
                spannableStr.setSpan(
                    foregroundColorSpan,
                    matcher.start(),
                    matcher.end(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                text.text = spannableStr
            }
        }
    }
}