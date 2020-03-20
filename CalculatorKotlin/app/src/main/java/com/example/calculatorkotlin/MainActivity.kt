package com.example.calculatorkotlin

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import kotlin.math.*

enum class State{
    NULL,
    NUMBER,
    OPERATION,
    EQUAL

}

class MainActivity : AppCompatActivity() {

    private var calcText: TextView? = null
    private var operText: TextView? = null
    private var text: String? = null

    private var firstNum = 0.0
    private var secondNum = 0.0
    private var answer = 0.0
    private var operation: String? = " "

    private var isDouble = false
    private var zeroUsed = false
    private var isError = false

    private var state: State? = State.NULL




    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        firstNum = savedInstanceState.getDouble("firstNum")
        secondNum = savedInstanceState.getDouble("secondNum")
        isDouble = savedInstanceState.getBoolean("isDouble")
        zeroUsed = savedInstanceState.getBoolean("zeroUsed")
        isError = savedInstanceState.getBoolean("isError")
        answer = savedInstanceState.getDouble("answer")
        state = savedInstanceState.getSerializable("state") as State?
        operation = savedInstanceState.getString("operation")
        text = savedInstanceState.getString("calcText")
        calcText!!.text = text
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("firstNum", firstNum)
        outState.putDouble("secondNum", secondNum)
        outState.putDouble("answer", answer)
        outState.putString("operation", operation)
        outState.putBoolean("isDouble", isDouble)
        outState.putBoolean("zeroUsed", zeroUsed)
        outState.putBoolean("isError", isError)
        outState.putSerializable("state", state)
        outState.putString("calcText", calcText?.text.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calcText = findViewById(R.id.calcText)
        operText = findViewById(R.id.opView)


        val bt0: Button = findViewById(R.id.btn0)
        val bt1: Button = findViewById(R.id.btn1)
        val bt2: Button = findViewById(R.id.btn2)
        val bt3: Button = findViewById(R.id.btn3)
        val bt4: Button = findViewById(R.id.btn4)
        val bt5: Button = findViewById(R.id.btn5)
        val bt6: Button = findViewById(R.id.btn6)
        val bt7: Button = findViewById(R.id.btn7)
        val bt8: Button = findViewById(R.id.btn8)
        val bt9: Button = findViewById(R.id.btn9)

        val btPercent: Button = findViewById(R.id.btn_percent)
        val btDot: Button = findViewById(R.id.btn_dot)
        val btEqual: Button = findViewById(R.id.btn_equal)
        val btMinus: Button = findViewById(R.id.btn_minus)
        val btDivide: Button = findViewById(R.id.btn_divide)
        val btPlus: Button = findViewById(R.id.btn_plus)
        val btMult: Button = findViewById(R.id.btn_multiply)
        val btDeleteAll: Button = findViewById(R.id.btn_c)
        val btDeleteOne: Button = findViewById(R.id.btn_del)
        val btRoot: Button = findViewById(R.id.btn_root)
        val btSquared: Button = findViewById(R.id.btn_square)


        val btFactorial: Button? = findViewById(R.id.btn_factorial)
        val btPowerN: Button? = findViewById(R.id.btn_powern)
        val btNRoot: Button? = findViewById(R.id.btn_nroot)
        val btTenPow: Button? = findViewById(R.id.btn_tenPow)

        val btSin: Button? = findViewById(R.id.btn_sin)
        val btCos: Button? = findViewById(R.id.btn_cos)
        val btTan: Button? = findViewById(R.id.btn_tan)
        val btLn: Button? = findViewById(R.id.btn_ln)
        val btLog: Button? = findViewById(R.id.btn_log)




        val calcOnClick = View.OnClickListener { view ->
            val id: Int = view.id

            if (state == State.OPERATION) {
                zeroUsed = false
                isDouble = false
                firstNum = calcText?.text.toString().toDouble()
                calcText?.text = ""
            }

            when (id) {
                R.id.btn0 -> {

                    state = State.NUMBER
                    if (!zeroUsed) {
                        zeroUsed = true
                        calcText?.append("0")
                    } else if (isDouble || calcText?.text?.get(0) != '0') {
                        zeroUsed = false
                        calcText?.append("0")
                    }
                }

                R.id.btn1 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "1"
                        isError = false
                    } else calcText?.append("1")
                }
                R.id.btn2 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "2"
                        isError = false
                    } else calcText?.append("2")
                }

                R.id.btn3 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "3"
                        isError = false
                    } else calcText?.append("3")
                }
                R.id.btn4 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "4"
                        isError = false
                    } else calcText?.append("4")
                }
                R.id.btn5 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "5"
                        isError = false
                    } else calcText?.append("5")
                }
                R.id.btn6 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "6"
                        isError = false
                    } else calcText?.append("6")
                }
                R.id.btn7 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "7"
                        isError = false
                    } else calcText?.append("7")
                }
                R.id.btn8 -> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "8"
                        isError = false
                    } else calcText?.append("8")
                }
                R.id.btn9-> {
                    state = State.NUMBER
                    if ((calcText?.text.toString() == "0" && !isDouble) || isError) {
                        calcText?.text = "9"
                        isError = false
                    } else calcText?.append("9")
                }

                R.id.btn_dot-> {
                    if(!isDouble) {
                        isDouble = true
                        if(state == State.NUMBER)calcText?.append(".")
                        else calcText?.text = "0."
                    }
                    state=State.NUMBER
                }

                R.id.btn_plus -> {
                    if(state!=State.NULL){
                        if(state != State.OPERATION)
                            state=State.OPERATION
                        else state=State.NUMBER
                        operation += '+'; }
                }

                R.id.btn_minus -> {
                    if(state!=State.NULL){
                        if(state != State.OPERATION)
                            state=State.OPERATION
                        else state=State.NUMBER
                        operation += '-'; }
                }

                R.id.btn_multiply -> {
                    if(state!=State.NULL){
                        if(state != State.OPERATION)
                            state=State.OPERATION
                        else state=State.NUMBER
                        operation += '*'; }
                }
                R.id.btn_divide -> {
                    if(state!=State.NULL){
                        if(state != State.OPERATION)
                            state=State.OPERATION
                        else state=State.NUMBER
                        operation += '/'; } }

                R.id.btn_root -> {
                    if(state!=State.NULL){
                        operation="r" }
                }

                R.id.btn_square -> {
                    if(state!=State.NULL){
                        operation="^"
                    }
                }
                R.id.btn_percent -> {
                    if(state!=State.NULL){
                        operation="%"}
                }

                R.id.btn_powern -> {
                    if(state!=State.NULL){
                        state=State.OPERATION
                        operation = "n"
                        operText?.text = calcText?.text.toString() + "^"
                    }}

                R.id.btn_nroot -> {
                      if(state!=State.NULL) {
                              state = State.OPERATION
                          operation = "b"
                          operText?.text = calcText?.text.toString() + "^(1/"
                      }}

                R.id.btn_factorial -> {
                    if (state != State.NULL) {
                        operation = "!"
                        operText?.text = "!"
                    } }

                R.id.btn_tenPow -> {
                      if(state!=State.NULL){
                          operation="t"
                          operText?.text = "10^"
                      }}


                R.id.btn_sin -> {

                    state = State.NUMBER
                    operation += 's'
                    operText?.text = "sin"
                }

                R.id.btn_cos -> {
                    operation = "c"
                    operText?.text = "cos"
                }

                R.id.btn_tan -> {
                    operation = "a"
                    operText?.text = "tan"
                }

                R.id.btn_ln -> {
                    operation = "l"
                    operText?.text = "ln"
                }
                R.id.btn_log -> {
                    operation = "g"
                    operText?.text = "log"
                }

                R.id.btn_equal -> {
                    if (calcText?.text.toString() == "") {
                        operation = ""
                        firstNum = 0.0
                        state = State.NULL
                        isError = true
                        calcText?.text = getString(R.string.error)
                    } else {
                        if (state != State.NULL) {
                            state = State.EQUAL
                            secondNum = calcText?.text.toString().toDouble()

                            if (operation == " ") { }

                            val nf: NumberFormat = DecimalFormat("#.######")

                            when (operation?.get(operation!!.length - 1)) {
                                '+' -> {
                                    answer = firstNum + secondNum
                                    calcText?.text = nf.format(answer)
                                }
                                '-' -> {
                                    answer = firstNum - secondNum
                                    calcText?.text = nf.format(answer)
                                }
                                '*' -> {
                                    answer = firstNum * secondNum
                                    calcText?.text = nf.format(answer)
                                }
                                '/' -> {
                                    if (secondNum == 0.0) {
                                        answer = 0.0
                                        calcText?.text = getString(R.string.error)
                                        isError = true
                                    } else {
                                        answer = firstNum / secondNum
                                        calcText?.text = nf.format(answer)
                                    }
                                }
                                'r' -> {
                                    answer = sqrt(secondNum)
                                    calcText?.text = nf.format(answer)
                                }
                                '^' -> {
                                    answer = secondNum * secondNum
                                    calcText?.text = nf.format(answer)
                                }
                                ' ' -> {
                                    answer = secondNum
                                    calcText?.text = nf.format(answer)
                                }
                                '%' -> {
                                    answer = secondNum / 100
                                    calcText?.text = nf.format(answer)
                                }
                                '!' -> {
                                    answer = 1.0
                                    if (secondNum < 0 || secondNum > 100) {

                                        calcText?.text = getString(R.string.error)
                                        isError = true
                                    } else {
                                        if (secondNum == 0.0) answer = 1.0
                                        else {
                                            for (i in 1..secondNum.toInt()) {
                                                answer *= i
                                            }
                                        }
                                        calcText?.text = nf.format(answer)
                                    }
                                }

                                'n' -> {
                                    answer = firstNum.pow(secondNum)
                                    calcText?.text = nf.format(answer)
                                }


                                'b' -> {
                                    //nroot
                                    if (secondNum == 0.0) {
                                        calcText?.text = getString(R.string.error)
                                        isError = true
                                    } else {
                                        answer = firstNum.pow( 1 / secondNum)
                                        calcText?.text = nf.format(answer)
                                    }
                                }

                                't' -> {
                                    //tenPower 10^a
                                    answer = (10.0).pow( secondNum)
                                    calcText?.text = nf.format(answer)
                                }

                                's' -> {
                                    //sin
                                    answer = sin(Math.toRadians(secondNum))
                                    calcText?.text = nf.format(answer)
                                }

                                'c' -> {
                                    //cos
                                    answer = cos(Math.toRadians(secondNum))
                                    calcText?.text = nf.format(answer)
                                }

                                'a' -> {
                                    //tan
                                    answer = tan(Math.toRadians(secondNum))
                                    calcText?.text = nf.format(answer)
                                }

                                'l' -> {
                                    //log2
                                    answer = log2(secondNum)
                                    calcText?.text = nf.format(answer)
                                }

                                'g' -> {
                                    //log10
                                    answer = log10(secondNum)
                                    calcText?.text = nf.format(answer)
                                }
                            }

                        }

                        firstNum = answer
                        secondNum = 0.0
                        isDouble = false
                        zeroUsed = false
                        operation = " "
                        state = State.NUMBER


                    }
                }


                R.id.btn_c -> {
                    calcText?.text = ""
                    firstNum=0.0
                    secondNum=0.0
                    answer=0.0
                    operation=" "
                    state=State.NULL
                    zeroUsed=false
                    isDouble=false

                    if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
                        operText?.text = ""
                }

                R.id.btn_del -> {
                     var s: String = calcText?.text.toString()
                     val len: Int = s.length
                    if(len > 0) {
                        s = s.substring(0,len - 1)
                        calcText?.text = s
                    }
                }

            }
        }

        bt0.setOnClickListener(calcOnClick)
        bt1.setOnClickListener(calcOnClick)
        bt2.setOnClickListener(calcOnClick)
        bt3.setOnClickListener(calcOnClick)
        bt4.setOnClickListener(calcOnClick)
        bt5.setOnClickListener(calcOnClick)
        bt6.setOnClickListener(calcOnClick)
        bt7.setOnClickListener(calcOnClick)
        bt8.setOnClickListener(calcOnClick)
        bt9.setOnClickListener(calcOnClick)

        btPlus.setOnClickListener(calcOnClick)
        btMinus.setOnClickListener(calcOnClick)
        btMult.setOnClickListener(calcOnClick)
        btDivide.setOnClickListener(calcOnClick)
        btEqual.setOnClickListener(calcOnClick)
        btDeleteAll.setOnClickListener(calcOnClick)
        btDeleteOne.setOnClickListener(calcOnClick)
        btDot.setOnClickListener(calcOnClick)
        btSquared.setOnClickListener(calcOnClick)
        btRoot.setOnClickListener(calcOnClick)
        btPercent.setOnClickListener(calcOnClick)

       if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            btFactorial!!.setOnClickListener(calcOnClick)
            btPowerN!!.setOnClickListener(calcOnClick)
            btNRoot!!.setOnClickListener(calcOnClick)
            btTenPow!!.setOnClickListener(calcOnClick)
            btSin!!.setOnClickListener(calcOnClick)
            btCos!!.setOnClickListener(calcOnClick)
            btTan!!.setOnClickListener(calcOnClick)
            btLn!!.setOnClickListener(calcOnClick)
            btLog!!.setOnClickListener(calcOnClick)
        }
    }

}

