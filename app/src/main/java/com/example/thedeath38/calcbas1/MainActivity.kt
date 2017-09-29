package com.example.thedeath38.calcbas1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var ceroEnable:Boolean=true
    var numOpr:Double=0.0
    var memAlm:Double=0.0
    var textnum:String="+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_ce.setOnClickListener(){
            ce()
        }
        bt_c.setOnClickListener(){
            c()
        }
        bt_igual.setOnClickListener(){
            igual()
        }
        bt_punt.setOnClickListener(){
            punt()
        }
        bt_mm.setOnClickListener(){
            memMas()
        }
        bt_mmen.setOnClickListener(){
            memMen()
        }
        bt_mc.setOnClickListener(){
            memCln()
        }
        bt_mr.setOnClickListener(){
            memRec()
        }
        bt_mm.setOnClickListener(){
            memMas()
        }
        bt_sig.setOnClickListener(){
            signo()
        }

    }


    fun number(v: View){
        val num=findViewById<Button>(v.id)
        val textNum=num.text.toString()
        if(!ceroEnable)
            et_display.setText("${et_display.text.toString()}${textNum}")
        else {
            et_display.setText("${textNum}")
            ceroEnable = false
        }
    }

    fun ce(){
        et_display.setText("")
        ceroEnable=true
    }

    fun c(){
        et_display.setText("")
        textnum="+"
        numOpr=0.0
        ceroEnable=true
    }

    fun signo(){
        if(et_display.text.toString().length!=0)
            if(!et_display.text.toString().contains("-"))
                et_display.setText("-${et_display.text.toString()}")
            else
                et_display.setText("${et_display.text.toString().removePrefix("-")}")

    }

    fun memMas(){
        if(et_display.text.toString().length!=0)
            memAlm+=et_display.text.toString().toDouble()
    }

    fun memMen(){
        if(et_display.text.toString().length!=0)
            memAlm-=et_display.text.toString().toDouble()
    }

    fun memRec(){
            et_display.setText("${memAlm}")
    }

    fun memCln(){
        if(et_display.text.toString().length!=0)
            memAlm=0.0
    }

    fun igual(){
        if(et_display.text.toString().length!=0){
            when (textnum) {
                "+" -> numOpr += et_display.text.toString().toDouble()
                "-" -> numOpr -= et_display.text.toString().toDouble()
                "*" -> numOpr *= et_display.text.toString().toDouble()
                "/" -> numOpr /= et_display.text.toString().toDouble()
            }
            et_display.setText("${numOpr}")
            textnum="+"
            numOpr=0.0
            ceroEnable=true
        }

    }

    fun punt(){
        if(!et_display.text.toString().contains("."))
            if(et_display.text.toString().length!=0)
                et_display.setText("${et_display.text.toString()}.")
            else{
                et_display.setText("0.")
                ceroEnable=false
            }

    }

    fun opr_arit(v:View){
        val num=findViewById<Button>(v.id)
        if(et_display.text.toString().length!=0) {
            when (textnum) {
                "+" -> numOpr += et_display.text.toString().toDouble()
                "-" -> numOpr -= et_display.text.toString().toDouble()
                "*" -> numOpr *= et_display.text.toString().toDouble()
                "/" -> numOpr /= et_display.text.toString().toDouble()
            }
            et_display.setText("${numOpr}")
            ceroEnable = true
        }
        textnum = num.text.toString()
    }



}
