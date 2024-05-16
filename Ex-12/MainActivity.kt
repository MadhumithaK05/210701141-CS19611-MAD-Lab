package com.example.lab12sendemail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val to=findViewById<EditText>(R.id.to)
        val sub=findViewById<EditText>(R.id.sub)
        val msg=findViewById<EditText>(R.id.msg)
        val btn=findViewById<Button>(R.id.send)

        btn.setOnClickListener{
            try{
                val a=to.text.toString()
                val b=sub.text.toString()
                val c=msg.text.toString()
                val intent=Intent(Intent.ACTION_SEND)

                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(a))
                intent.putExtra(Intent.EXTRA_SUBJECT, b)
                intent.putExtra(Intent.EXTRA_TEXT, c)
                intent.type = "message/rfc822"
                startActivity(Intent.createChooser(intent, "Choose an Email client"))

                Toast.makeText(applicationContext, "Email Sent", Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(applicationContext, "Not sent", Toast.LENGTH_SHORT).show()
            }
        }
    }
}