package com.example.tunetwirlmadproject

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Signup : AppCompatActivity() {
    private lateinit var dbHelper: SQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val name=findViewById<EditText>(R.id.name)
        val mail=findViewById<EditText>(R.id.Email)
        val pass1=findViewById<EditText>(R.id.Password)
        val pass2=findViewById<EditText>(R.id.conpass)
        val btn=findViewById<Button>(R.id.signup)

        dbHelper = object : SQLiteOpenHelper(this, "TuneTwirl", null, 1) {
            override fun onCreate(db: SQLiteDatabase?) {
                db?.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR(25),email VARCHAR(50), password VARCHAR(20))")
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            }
        }

        btn.setOnClickListener{
            val db = dbHelper.writableDatabase
            val n = name.text.toString()
            val e = mail.text.toString()
            val p1 = pass1.text.toString()
            val p2=pass2.text.toString()

            if(p1==p2)
            {
                insertData(db, n, e, p1)
                Toast.makeText(this,"Signed up successfully",Toast.LENGTH_SHORT).show()
                val i= Intent(this,login::class.java)
                startActivity(i)
            }
            else{
                Toast.makeText(this, "Password and Confirm Password should be equal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun insertData(db: SQLiteDatabase, name: String, email:String, pwd:String) {
        db.execSQL("Insert into users values ('$name','$email','$pwd')")
    }
}