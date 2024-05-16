package com.example.lab11sendsms

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ph=findViewById<EditText>(R.id.phno)
        val msg=findViewById<EditText>(R.id.msg)
        val btn=findViewById<Button>(R.id.send)

        ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.SEND_SMS),1000)

        btn.setOnClickListener{
            val a=ph.text.toString()
            val b=msg.text.toString()

            try {
                val s=SmsManager.getDefault()
                s.sendTextMessage(a, null, b, null, null)
                Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_LONG).show()
            }catch(e:Exception){
                Toast.makeText(applicationContext, "Not sent", Toast.LENGTH_SHORT).show()
            }

        }
    }
}