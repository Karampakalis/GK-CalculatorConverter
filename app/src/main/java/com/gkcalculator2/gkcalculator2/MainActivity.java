package com.gkcalculator2.gkcalculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final String [] OPER_ORDER = {"/","×","\\+","-"};
    private int current_operation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView data_tv = findViewById(R.id.data_tv);
        final TextView result_tv = findViewById(R.id.result_tv);

        final Button mainConverterButton = findViewById(R.id.mainConverterButton);
        final Button btn_clear = findViewById(R.id.btn_clear);
        final Button btn_back = findViewById(R.id.btn_back);
        final Button btn_modulo = findViewById(R.id.btn_modulo);
        final Button btn_divide = findViewById(R.id.btn_divide);
        final Button btn_multiply = findViewById(R.id.btn_multiply);
        final Button btn_add = findViewById(R.id.btn_add);
        final Button btn_subtract = findViewById(R.id.btn_subtract);
        final Button btn_allClear = findViewById(R.id.btn_allClear);
        final Button btn_equal = findViewById(R.id.btn_equal);
        final Button btn_dot = findViewById(R.id.btn_dot);
        final Button btn_0 = findViewById(R.id.btn_0);
        final Button btn_1 = findViewById(R.id.btn_1);
        final Button btn_2 = findViewById(R.id.btn_2);
        final Button btn_3 = findViewById(R.id.btn_3);
        final Button btn_4 = findViewById(R.id.btn_4);
        final Button btn_5 = findViewById(R.id.btn_5);
        final Button btn_6 = findViewById(R.id.btn_6);
        final Button btn_7 = findViewById(R.id.btn_7);
        final Button btn_8 = findViewById(R.id.btn_8);
        final Button btn_9 = findViewById(R.id.btn_9);

        mainConverterButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
                startActivity(intent);
            }
        });


        btn_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + "9");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();
                data_tv.setText(datatvText + ".");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                data_tv.setText("");
            }
        });

        btn_allClear.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                data_tv.setText("");
                result_tv.setText("");
            }
        });

        btn_modulo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(!datatvText.isEmpty()){
                    final char getLastCharacter = datatvText.charAt(datatvText.length()-1);

                    if(getLastCharacter != '+' || getLastCharacter != '-' || getLastCharacter != '×' || getLastCharacter != '/'){
                        percentage(data_tv, result_tv, datatvText);


                    }
                }
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(datatvText.isEmpty()){
                    data_tv.setText("0+");
                }
                else{
                    final char getLastCharacter = datatvText.charAt(datatvText.length()-1);

                    if(getLastCharacter == '+' || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '/'){
                        data_tv.setText(datatvText.substring(0, datatvText.length()-1) + "+");
                    }
                    else{
                        data_tv.setText(datatvText + "+");
                    }
                }
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(datatvText.isEmpty()){
                    data_tv.setText("0-");
                }
                else{
                    final char getLastCharacter = datatvText.charAt(datatvText.length()-1);

                    if(getLastCharacter == '+' || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '/'){
                        data_tv.setText(datatvText.substring(0, datatvText.length()-1) + "-");
                    }
                    else{
                        data_tv.setText(datatvText + "-");
                    }
                }
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(datatvText.isEmpty()){
                    data_tv.setText("0×");
                }
                else{
                    final char getLastCharacter = datatvText.charAt(datatvText.length()-1);

                    if(getLastCharacter == '+' || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '/'){
                        data_tv.setText(datatvText.substring(0, datatvText.length()-1) + "×");
                    }
                    else{
                        data_tv.setText(datatvText + "×");
                    }
                }
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(datatvText.isEmpty()){
                    data_tv.setText("0/");
                }
                else{
                    final char getLastCharacter = datatvText.charAt(datatvText.length()-1);

                    if(getLastCharacter == '+' || getLastCharacter == '-' || getLastCharacter == '×' || getLastCharacter == '/'){
                        data_tv.setText(datatvText.substring(0, datatvText.length()-1) + "/");
                    }
                    else{
                        data_tv.setText(datatvText + "/");
                    }
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(!datatvText.isEmpty()){
                    data_tv.setText(datatvText.substring(0, datatvText.length()-1));
                }
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final String datatvText = data_tv.getText().toString();

                if(datatvText.contains("+") || datatvText.contains("-") || datatvText.contains("×") || datatvText.contains("/")){
                    
                    final char getLastCharacter = datatvText.charAt(datatvText.length()-1);

                    if(getLastCharacter != '+' || getLastCharacter != '-' || getLastCharacter != '×' || getLastCharacter != '/'){
                        calculateResult(data_tv, result_tv, datatvText);
                        /*double d = Double.parseDouble(datatvText);
                        if (d == 666){

                            popup("\n" + "\uD83D\uDE08");

                        }*/
                    }
                }

            }

        });


    }

    private void percentage(TextView data_tv, TextView result_tv, String datatvText) {

        result_tv.setVisibility(View.VISIBLE);

        double result_percentage;
        result_percentage = Double.parseDouble(datatvText) / 100;
        result_tv.setText(datatvText);
        data_tv.setText(String.valueOf(result_percentage));

    }

    private void calculateResult(TextView data_tv, TextView result_tv, String datatvText) {

        result_tv.setVisibility(View.VISIBLE);
        String datatvText2 = datatvText;

        //The priority of the operations is checked with OPER_ORDER[] and current_operation
        // ( / , * , + , - )

        while(true){

            if(current_operation == 2 && !datatvText2.contains("+")){
                current_operation++;
                continue;
            }
            else if(current_operation != 2 && !datatvText2.contains(OPER_ORDER[current_operation])){
                if(current_operation == 3){
                    break;
                }
                else{
                    current_operation++;
                    continue;
                }
            }

            String[] datatvArray = datatvText2.split(OPER_ORDER[current_operation]);

            if(datatvArray.length == 1 || datatvArray[0].isEmpty()){
                break;
            }


            //Getting the first and second number for /,*,+,- operations

            StringBuilder firstValue = new StringBuilder();
            StringBuilder secondValue = new StringBuilder();

            for (int i = datatvArray[0].length() - 1; i>=0; i--){
                if(datatvArray[0].charAt(i) == '+' || datatvArray[0].charAt(i) == '-' || datatvArray[0].charAt(i) == '×' ||datatvArray[0].charAt(i) == '/'){
                    break;
                } else {
                    firstValue.insert(0, datatvArray[0].charAt(i));
                }
            }

            for (int i = 0; i < datatvArray[1].length(); i++) {
                if(datatvArray[1].charAt(i) == '+' || datatvArray[1].charAt(i) == '-' || datatvArray[1].charAt(i) == '×' || datatvArray[1].charAt(i) == '/'){
                    break;
                } else{
                    secondValue.append(datatvArray[1].charAt(i));
                }
            }

            double results;

            //Operations
            switch (OPER_ORDER[current_operation]){
                case "/" :
                    results = Double.parseDouble(firstValue.toString()) / Double.parseDouble(secondValue.toString());
                    if(results == 666){
                        popup("\uD83D\uDE08\n");
                    }
                    break;

                case "×" :
                    results = Double.parseDouble(firstValue.toString()) * Double.parseDouble(secondValue.toString());
                    if(results == 666){
                        popup("\uD83D\uDE08\n");
                    }
                    break;

                case "+" :
                case "\\+" :
                    results = Double.parseDouble(firstValue.toString()) + Double.parseDouble(secondValue.toString());
                    if(results == 666){
                        popup("\uD83D\uDE08\n");
                    }
                    break;

                case "-" :
                    results = Double.parseDouble(firstValue.toString()) - Double.parseDouble(secondValue.toString());
                    if(results == 666){
                        popup("\uD83D\uDE08\n");
                    }
                    break;

                default:
                    results = 0;
            }


            datatvText2 = datatvText2.replaceFirst(firstValue + OPER_ORDER[current_operation] + secondValue, String.valueOf(results));

        }


        current_operation = 0;

        result_tv.setText(datatvText);

        String[] finalResultArray = datatvText2.split("\\.");

        if (finalResultArray[1].length() == 1 && finalResultArray[1].equals("0")){
            data_tv.setText(finalResultArray[0]);
        } else {
            data_tv.setText(datatvText2);
        }

    }

    public void popup (String popup){

        Context context = getApplicationContext();
        int len = Toast.LENGTH_SHORT;
        Toast.makeText(context, popup, len).show();

    }
}