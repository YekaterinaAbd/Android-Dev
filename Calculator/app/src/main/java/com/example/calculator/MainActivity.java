package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

enum State {
    NULL,
    NUMBER,
    OPERATION,
    EQUAL
}

public class MainActivity extends AppCompatActivity {




    TextView calcText;
    TextView operText;
    String text;

    double firstNum;
    double secondNum;
    double answer;
    String operation = " ";

    boolean isDouble = false;
    boolean zeroUsed = false;
    boolean isError = false;

    State state= State.NULL;

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        firstNum = savedInstanceState.getDouble("firstNum");
        secondNum= savedInstanceState.getDouble("secondNum");
        isDouble = savedInstanceState.getBoolean("isDouble");
        zeroUsed = savedInstanceState.getBoolean("zeroUsed");
        isError = savedInstanceState.getBoolean("isError");
        answer= savedInstanceState.getDouble("answer");
        state = (State)savedInstanceState.getSerializable("state");
        operation = savedInstanceState.getString("operation");

        text = savedInstanceState.getString("calcText");
        calcText.setText(text);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("firstNum", firstNum);
        outState.putDouble("secondNum", secondNum);
        outState.putDouble("answer", answer);
        outState.putString("operation", operation);

        outState.putBoolean("isDouble", isDouble);
        outState.putBoolean("zeroUsed", zeroUsed);
        outState.putBoolean("isError", isError);

        outState.putSerializable("state", state);
        outState.putString("calcText", calcText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcText = findViewById(R.id.calcText);
        operText = findViewById(R.id.opView);
        final Button bt0 = findViewById(R.id.btn0);
        final Button bt1 = findViewById(R.id.btn1);
        final Button bt2 = findViewById(R.id.btn2);
        final Button bt3 = findViewById(R.id.btn3);
        final Button bt4 = findViewById(R.id.btn4);
        final Button bt5 = findViewById(R.id.btn5);
        final Button bt6 = findViewById(R.id.btn6);
        final Button bt7 = findViewById(R.id.btn7);
        final Button bt8 = findViewById(R.id.btn8);
        final Button bt9 = findViewById(R.id.btn9);
        final Button btPercent = findViewById(R.id.btn_percent);
        final Button btDot = findViewById(R.id.btn_dot);
        final Button btEqual = findViewById(R.id.btn_equal);
        final Button btMinus = findViewById(R.id.btn_minus);
        final Button btDivide = findViewById(R.id.btn_divide);
        final Button btPlus = findViewById(R.id.btn_plus);
        final Button btMult = findViewById(R.id.btn_multiply);
        final Button btDeleteAll = findViewById(R.id.btn_c);
        final Button btDeleteOne = findViewById(R.id.btn_del);
        final Button btRoot = findViewById(R.id.btn_root);
        final Button btSquared = findViewById(R.id.btn_square);

        final Button btFactorial = findViewById(R.id.btn_factorial);
        final Button btPowerN = findViewById(R.id.btn_powern);
        final Button btNRoot = findViewById(R.id.btn_nroot);
        final Button btTenPow = findViewById(R.id.btn_tenPow);

        final Button btSin = findViewById(R.id.btn_sin);
        final Button btCos = findViewById(R.id.btn_cos);
        final Button btTan = findViewById(R.id.btn_tan);
        final Button btLn = findViewById(R.id.btn_ln);
        final Button btLog = findViewById(R.id.btn_log);



      View.OnClickListener calcOnclick = new View.OnClickListener() {
          @Override

          public void onClick(View v) {
              int id = v.getId();

              if(state==State.OPERATION){

                  zeroUsed=false;
                  isDouble=false;
                  firstNum = Double.parseDouble(calcText.getText().toString());
                  calcText.setText("");
              }

              switch (id){

                  case R.id.btn0:
                      state=State.NUMBER;
                      if(!zeroUsed) {
                          zeroUsed = true;
                          calcText.append("0");

                      }
                      else if(isDouble || calcText.getText().charAt(0) !='0') {
                          zeroUsed = false;
                          calcText.append("0");
                      }
                      break;

                  case R.id.btn1:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("1");
                          isError = false;
                      }
                          else
                              calcText.append("1");
                      break;


                  case R.id.btn2:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          isError = false;
                          calcText.setText("2");
                      }
                      else
                          calcText.append("2");
                      break;


                  case R.id.btn3:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("3");
                          isError = false;
                      }
                      else
                          calcText.append("3");
                      break;


                  case R.id.btn4:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("4");
                          isError = false;
                      }
                      else
                          calcText.append("4");
                      break;


                  case R.id.btn5:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("5");
                          isError = false;
                      }
                      else
                          calcText.append("5");
                      break;


                  case R.id.btn6:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("6");
                          isError = false;
                      }
                      else
                          calcText.append("6");
                      break;


                  case R.id.btn7:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("7");
                          isError = false;
                      }
                      else
                          calcText.append("7");
                      break;


                  case R.id.btn8:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("8");
                          isError = false;
                      }
                      else
                          calcText.append("8");
                      break;


                  case R.id.btn9:
                      state=State.NUMBER;
                      if((calcText.getText().toString().equals("0")&& !isDouble) || isError) {
                          calcText.setText("9");
                          isError = false;
                      }
                      else
                      calcText.append("9");
                      break;

                  case R.id.btn_dot:

                      if(!isDouble) {
                          isDouble = true;
                          if(state == State.NUMBER)calcText.append(".");
                          else calcText.setText("0.");
                      }
                      else {}
                      state=State.NUMBER;
                      break;


                  case R.id.btn_plus:
                      if(state!=State.NULL){
                      if(state != State.OPERATION)
                          state=State.OPERATION;
                      else state=State.NUMBER;
                      operation += '+'; }
                    break;


                  case R.id.btn_minus:
                      if(state!=State.NULL){
                      if(state != State.OPERATION)
                          state=State.OPERATION;
                      else state=State.NUMBER;
                      operation += '-'; }
                    break;


                  case R.id.btn_multiply:
                      if(state!=State.NULL){
                      if(state != State.OPERATION)
                          state=State.OPERATION;
                      else state=State.NUMBER;
                      operation += '*'; }
                      break;

                  case R.id.btn_divide:
                      if(state!=State.NULL){
                      if(state != State.OPERATION)  state=State.OPERATION;
                      else state=State.NUMBER;
                      operation += '/'; }
                      break;

                  case R.id.btn_powern:
                      if(state!=State.NULL){
                          //if(state != State.OPERATION)
                              state=State.OPERATION;
                         // else state=State.NUMBER;
                          operation = "n";
                          operText.setText(calcText.getText().toString() + "^");
                      }
                      break;

                  case R.id.btn_nroot:
                      if(state!=State.NULL) {
                          //if (state != State.OPERATION)
                              state = State.OPERATION;
                          //else state = State.NUMBER;
                          operation = "b";
                          operText.setText(calcText.getText().toString() + "^(1/");
                      }
                      break;


                  case R.id.btn_equal:

                      if(calcText.getText().toString().equals("")){
                          operation="";
                          firstNum=0;
                          state=State.NULL;
                          isError=true;
                          calcText.setText("Error");
                      }

                      else {

                          if (state != State.NULL) {

                              if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                                  operText.setText("");

                              state = State.EQUAL;
                              secondNum = Double.parseDouble(calcText.getText().toString());

                              if (operation == " ") {}


                              NumberFormat nf = new DecimalFormat("#.######");

                              switch (operation.charAt(operation.length() - 1)) {

                                  case '+':
                                      answer = firstNum + secondNum;
                                      calcText.setText(nf.format(answer));
                                      break;
                                  case '-':
                                      answer = firstNum - secondNum;
                                      calcText.setText(nf.format(answer));
                                      break;
                                  case '*':
                                      answer = firstNum * secondNum;
                                      calcText.setText(nf.format(answer));
                                      break;
                                  case '/':
                                      if (secondNum == 0) {
                                          answer = 0;
                                          calcText.setText("Error");
                                          isError = true;
                                      } else {
                                          answer = firstNum / secondNum;
                                          calcText.setText(nf.format(answer));
                                      }
                                      break;
                                  case 'r':
                                      answer = Math.sqrt(secondNum);
                                      calcText.setText(nf.format(answer));
                                      break;
                                  case '^':
                                      answer = secondNum * secondNum;
                                      calcText.setText(nf.format(answer));
                                      break;
                                  case ' ':
                                      answer = secondNum;
                                      calcText.setText(nf.format(answer));
                                      break;
                                  case '%':

                                      answer = secondNum / 100;
                                      calcText.setText(nf.format(answer));
                                      break;

                                  case '!':
                                      answer = 1;
                                      if (secondNum < 0 || secondNum > 100) {

                                          calcText.setText("Error");
                                          isError = true;
                                      } else {
                                          if (secondNum == 0) answer = 1;
                                          else {
                                              for (int i = 1; i <= secondNum; i++) {
                                                  answer *= i;
                                              }
                                          }
                                          calcText.setText(nf.format(answer));
                                      }
                                      break;

                                  case 'n':
                                      answer = Math.pow(firstNum, secondNum);
                                      calcText.setText(nf.format(answer));
                                      break;

                                  case 'b':
                                      //nroot
                                      if (secondNum == 0) {
                                          calcText.setText("Error");
                                          isError = true;
                                      } else {
                                          answer = Math.pow(firstNum, 1 / secondNum);
                                          calcText.setText(nf.format(answer));
                                      }
                                      break;

                                  case 't':
                                      //tenPower 10^a
                                      answer = Math.pow(10, secondNum);
                                      calcText.setText(nf.format(answer));
                                      break;

                                  case 's':
                                      //sin
                                      answer = Math.sin(Math.toRadians(secondNum));

                                      calcText.setText(nf.format(answer));
                                      break;

                                  case 'c':
                                      //cos
                                      answer = Math.cos(Math.toRadians(secondNum));
                                      calcText.setText(nf.format(answer));
                                      break;

                                  case 'a':
                                      //tan
                                      answer = Math.tan(Math.toRadians(secondNum));
                                      calcText.setText(nf.format(answer));
                                      break;

                                  case 'l':
                                      answer = Math.log(secondNum);
                                      calcText.setText(nf.format(answer));
                                      break;

                                  case 'g':
                                      answer = Math.log10(secondNum);
                                      calcText.setText(nf.format(answer));
                                      break;
                              }

                          firstNum = answer;
                          secondNum = 0;
                          isDouble = false;
                          zeroUsed = false;
                          operation = " ";
                          state = State.NUMBER;
                          }
                      }
                      break;

                  case R.id.btn_c:
                      calcText.setText("");
                      firstNum=0;
                      secondNum=answer=0;
                      operation=" ";
                      state=State.NULL;
                      zeroUsed=false;
                      isDouble=false;
                      if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                      operText.setText("");
                      break;

                  case R.id.btn_del:
                      String s = calcText.getText().toString();
                      int len = s.length();
                      if(len > 0) {
                          s = s.substring(0,len - 1);
                          calcText.setText(s);
                      }else{


                      }
                      break;

                  case R.id.btn_root:
                      if(state!=State.NULL){
                      operation="r"; }
                      break;

                  case R.id.btn_square:
                      if(state!=State.NULL){
                      operation="^";
                      }
                      break;

                  case R.id.btn_percent:
                      if(state!=State.NULL){
                          operation="%"; }
                      break;

                  case R.id.btn_factorial:
                      if(state!=State.NULL){
                          operation="!";
                          operText.setText("!");}
                      break;

                  case R.id.btn_tenPow:
                      if(state!=State.NULL){
                          operation="t";
                          operText.setText("10^");
                      }
                      break;


                  case R.id.btn_sin:

                      state=State.NUMBER;
                      operation += 's';
                      operText.setText("sin");
                    break;

                  case R.id.btn_cos:
                      operation="c";
                      operText.setText("cos");
                      break;

                  case R.id.btn_tan:
                      operation="a";
                      operText.setText("tan");
                      break;

                  case R.id.btn_ln:
                      operation="l";
                      operText.setText("ln");
                      break;
                  case R.id.btn_log:
                      operation="g";
                      operText.setText("log");
                      break;
              }
          }
      };

        bt0.setOnClickListener(calcOnclick);
        bt1.setOnClickListener(calcOnclick);
        bt2.setOnClickListener(calcOnclick);
        bt3.setOnClickListener(calcOnclick);
        bt4.setOnClickListener(calcOnclick);
        bt5.setOnClickListener(calcOnclick);
        bt6.setOnClickListener(calcOnclick);
        bt7.setOnClickListener(calcOnclick);
        bt8.setOnClickListener(calcOnclick);
        bt9.setOnClickListener(calcOnclick);
        btPlus.setOnClickListener(calcOnclick);
        btMinus.setOnClickListener(calcOnclick);
        btMult.setOnClickListener(calcOnclick);
        btDivide.setOnClickListener(calcOnclick);
        btEqual.setOnClickListener(calcOnclick);
        btDeleteAll.setOnClickListener(calcOnclick);
        btDeleteOne.setOnClickListener(calcOnclick);
        btDot.setOnClickListener(calcOnclick);
        btSquared.setOnClickListener(calcOnclick);
        btRoot.setOnClickListener(calcOnclick);
        btPercent.setOnClickListener(calcOnclick);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btFactorial.setOnClickListener(calcOnclick);
            btPowerN.setOnClickListener(calcOnclick);
            btNRoot.setOnClickListener(calcOnclick);
            btTenPow.setOnClickListener(calcOnclick);

            btSin.setOnClickListener(calcOnclick);
            btCos.setOnClickListener(calcOnclick);
            btTan.setOnClickListener(calcOnclick);
            btLn.setOnClickListener(calcOnclick);
            btLog.setOnClickListener(calcOnclick);
        }
    }
}
