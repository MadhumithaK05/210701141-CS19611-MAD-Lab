package com.example.lab8alertdialogbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textdisp=findViewById<EditText>(R.id.t)
        val clkdisp=findViewById<Button>(R.id.b)

        clkdisp.setOnClickListener{
            val alt=AlertDialog.Builder(this)
            alt.setTitle("MAD Lab")
            alt.setMessage(textdisp.text.toString())
            alt.setCancelable(false)
            alt.setPositiveButton("OK")
            {
                dialog, which -> dialog.cancel()
                Toast.makeText( this,"You Clicked Ok", Toast.LENGTH_SHORT).show()
            }
            alt.setNegativeButton("Cancel")
            {
                dialog , which->dialog.cancel()
                Toast.makeText( this,"You Clicked Cancel", Toast.LENGTH_SHORT).show()
            }
            val disp=alt.create()
            disp.show()
        }
    }
}