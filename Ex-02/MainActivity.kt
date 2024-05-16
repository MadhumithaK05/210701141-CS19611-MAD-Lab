package com.example.lab2simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var input1 :Double = 0.0
    var input2 :Double = 0.0
    var addition : Boolean = false
    var subtraction : Boolean = false
    var multiplication : Boolean = false
    var division : Boolean = false
    var decimal : Boolean = false
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t1=findViewById<Button>(R.id.btOne)
        val t2=findViewById<Button>(R.id.btTwo)
        val t3=findViewById<Button>(R.id.btThree)
        val t4=findViewById<Button>(R.id.btFour)
        val t5=findViewById<Button>(R.id.btFive)
        val t6=findViewById<Button>(R.id.btSix)
        val t7=findViewById<Button>(R.id.btSeven)
        val t8=findViewById<Button>(R.id.btEight)
        val t9=findViewById<Button>(R.id.btNine)
        val t0=findViewById<Button>(R.id.btZero)
        val tadd=findViewById<Button>(R.id.btAdd)
        val tdif=findViewById<Button>(R.id.btMinus)
        val tmul=findViewById<Button>(R.id.btMul)
        val tdiv=findViewById<Button>(R.id.btDiv)
        val tdot=findViewById<Button>(R.id.btdot)
        val teql=findViewById<Button>(R.id.btEqual)
        val tclr=findViewById<Button>(R.id.btclr)

        val te=findViewById<TextView>(R.id.exp)
        val tr=findViewById<TextView>(R.id.res)

        t1.setOnClickListener()
        {
            te.setText("${te.text}1")
        }
        t2.setOnClickListener()
        {
            te.setText("${te.text}2")
        }
        t3.setOnClickListener()
        {
            te.setText("${te.text}3")
        }
        t4.setOnClickListener()
        {
            te.setText("${te.text}4")
        }
        t5.setOnClickListener()
        {
            te.setText("${te.text}5")
        }
        t6.setOnClickListener()
        {
            te.setText("${te.text}6")
        }
        t7.setOnClickListener()
        {
            te.setText("${te.text}7")
        }
        t8.setOnClickListener()
        {
            te.setText("${te.text}8")
        }
        t9.setOnClickListener()
        {
            te.setText("${te.text}9")
        }
        t0.setOnClickListener()
        {
            te.setText("${te.text}0")
        }

        tadd.setOnClickListener()
        {
            if (te.getText().length != 0)
            { input1 = "${te.text}".toDouble()
                addition = true
                decimal = false
                te.setText(null) }
            /*if(te.text!="")
            {
                var y = te.text.toString().toInt()

                te.setText("")
                tr.setText(x)
            }*/
        }
        tdif.setOnClickListener()
        {
            if (te.getText().length != 0) {
                input1 = "${te.text}".toDouble()
                subtraction = true
                decimal = false
                te.setText(null) }
        }
        tmul.setOnClickListener()
        {
            if (te.getText().length != 0) {
                input1 = "${te.text}".toDouble()
                multiplication = true
                decimal = false
                te.setText(null) }
        }
        tdiv.setOnClickListener()
        {
            if (te.getText().length != 0) {
                input1 = "${te.text}".toDouble()
                division = true
                decimal = false
                te.setText(null) }
        }
        tdot.setOnClickListener()
        {
            if(!decimal) {
                te.setText("${te.text}.")
                decimal = true }
        }
        tclr.setOnClickListener()
        {
            te.setText("")
            tr.setText("")
        }

        teql.setOnClickListener()
        {
            input2 = "${te.text}".toDouble()
            if (addition) {
                te.setText("${input1} + ${input2}")
                val raddition : Double = input1 + input2
                tr.setText("${raddition}")
                addition = false
        }
            if (subtraction) {
                te.setText("${input1} - ${input2}")
                val rsubtraction : Double = input1 - input2
                tr.setText("${rsubtraction}")
                subtraction = false
            }
            if (multiplication)
            { te.setText("${input1} * ${input2}")
                val rmultiplication : Double = input1 * input2
                tr.setText("${rmultiplication}")
                multiplication = false
            }
            if (division) {
                te.setText("${input1} / ${input2}")
                val rdivision : Double = input1 / input2
                tr.setText("${rdivision}")
                division = false
            }
        }
    }
}