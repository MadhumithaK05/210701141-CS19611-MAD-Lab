package com.example.lab6formvalidation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<EditText>(R.id.name)
        val uid=findViewById<EditText>(R.id.uid)
        val loginbtn=findViewById<Button>(R.id.login)
        val clr=findViewById<Button>(R.id.clr)


        loginbtn.setOnClickListener{
            val a=name.text.toString()
            val b= uid.text.toString()
            if(a=="" || b=="")
            {
                Toast.makeText(this, "ALl fields are required", Toast.LENGTH_SHORT).show()
            }
            else if(!(a.all { it.isLetter() }))
            {
                Toast.makeText(this, "Name should only contain Alphabet", Toast.LENGTH_SHORT).show()
            }
            else if(!(b.all { it.isDigit() }) || b.length!=4)
            {
                Toast.makeText(this, "Uid should only contain Digits and length should be 4", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent= Intent(this,Success::class.java)
                startActivity(intent)
            }
        }
        clr.setOnClickListener{
            name.text.clear()
            uid.text.clear()
        }
    }
}