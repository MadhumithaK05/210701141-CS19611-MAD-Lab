package com.example.tunetwirlmadproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val mel=findViewById<Button>(R.id.melody)
        val pop=findViewById<Button>(R.id.pop)
        val bgm=findViewById<Button>(R.id.bgm)
        val soup=findViewById<Button>(R.id.soup)
        val love=findViewById<Button>(R.id.love)
        val btn=findViewById<ImageButton>(R.id.pro)

        btn.setOnClickListener{
            val i6=Intent(this,ProfilePage::class.java)
            startActivity(i6)
        }

        mel.setOnClickListener{
            val i1=Intent(this,ViewPage::class.java)
            startActivity(i1)
        }

        pop.setOnClickListener{
            val i2=Intent(this,PopViewPage::class.java)
            startActivity(i2)
        }

        bgm.setOnClickListener{
            val i3=Intent(this,VintageViewPage::class.java)
            startActivity(i3)
        }

        soup.setOnClickListener{
            val i4=Intent(this,SoupViewPage::class.java)
            startActivity(i4)
        }

        love.setOnClickListener{
            val i5=Intent(this,LoveViewPage::class.java)
            startActivity(i5)
        }
    }
}