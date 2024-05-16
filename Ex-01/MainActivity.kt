package com.example.lab1guicomponents

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t=findViewById<TextView>(R.id.txt)
        val b1=findViewById<Button>(R.id.fsize)
        val b2=findViewById<Button>(R.id.fcolor)
        val b3=findViewById<Button>(R.id.bgcolor)
        val linearLayout : LinearLayout = findViewById(R.id.body)

        var a=false
        b1.setOnClickListener()
        {
            if(!a) {
                t.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100f)
                a=true
            }
            else
            {
                t.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50f)
                a=false
            }
                Toast.makeText(applicationContext, "Font size is changed", Toast.LENGTH_LONG).show()

        }
        var f=false
        b2.setOnClickListener()
        {
            if(!f) {
                t.setTextColor(Color.rgb(255, 7, 0))
                f=true
            }
            else
            {
                t.setTextColor(Color.parseColor("#03A9F4"))
                f=false
            }
            Toast.makeText(applicationContext,"Font Color is changed",Toast.LENGTH_LONG).show()
        }

        var f1=false
        b3.setOnClickListener()
        {
            if(!f1) {
                linearLayout.setBackgroundColor(Color.BLACK)
                f1=true
            }
            else
            {
                linearLayout.setBackgroundColor(Color.WHITE)
                f1=false
            }
            Toast.makeText(applicationContext,"Background Color is changed",Toast.LENGTH_LONG).show()
        }
    }
}