package com.example.tunetwirlmadproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val log=findViewById<Button>(R.id.log)
        val signup=findViewById<Button>(R.id.sgnup)

        log.setOnClickListener{

            val p1= Intent(this,login::class.java)
            startActivity(p1)
        }
        signup.setOnClickListener{
            val p2= Intent(this,Signup::class.java)
            startActivity(p2)
        }
    }
}