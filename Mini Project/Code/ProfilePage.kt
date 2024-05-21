package com.example.tunetwirlmadproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ProfilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val logout=findViewById<TextView>(R.id.logout)



        logout.setOnClickListener{
            val i2= Intent(this,MainActivity::class.java)
            startActivity(i2)
        }
    }
}