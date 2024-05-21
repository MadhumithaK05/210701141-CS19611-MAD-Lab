package com.example.tunetwirlmadproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    private lateinit var dbHelper: SQLiteOpenHelper
    lateinit var mail: EditText
    lateinit var pass1: EditText
    lateinit var btn: Button
    lateinit var sharedPreferences: SharedPreferences
    var PREFS_KEY = "prefs"
    var EMAIL_KEY = "email"
    var PWD_KEY = "pwd"
    var email = ""
    var pwd = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail=findViewById<EditText>(R.id.email)
        pass1=findViewById<EditText>(R.id.pwd)
        btn=findViewById<Button>(R.id.login)

        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

        email = sharedPreferences.getString(EMAIL_KEY, "").toString()
        pwd = sharedPreferences.getString(PWD_KEY, "").toString()

        dbHelper = object : SQLiteOpenHelper(this, "TuneTwirl", null, 1){
            override fun onCreate(db: SQLiteDatabase?) {
                db?.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR(25),email VARCHAR(50), password VARCHAR(20))")
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            }
        }

        btn.setOnClickListener{
            val db = dbHelper.readableDatabase
            val c: Cursor = db.rawQuery("SELECT * FROM users where email=?",arrayOf(mail.text.toString()))
            while (c.moveToNext()) {
                val n = c.getString(c.getColumnIndex("name"))
                val e = c.getString(c.getColumnIndex("email"))
                val p = c.getString(c.getColumnIndex("password"))

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(EMAIL_KEY, mail.text.toString())
                editor.putString(PWD_KEY, pass1.text.toString())
                editor.apply()

                if(p==pass1.text.toString())
                {
                    val i= Intent(this,HomePage::class.java)
                    startActivity(i)
                    finish()
                }
                else {
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                }

            }
            c.close()

        }
    }
}