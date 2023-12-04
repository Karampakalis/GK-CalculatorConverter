package com.gkcalculator2.gkcalculator2;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import java.util.Arrays;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;




public class ConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    double data,final_fromRate, final_toRate, result;
    int fromSave, toSave;
    String fromCur, toCur;
    String[] currencies = new String[101];


    TextView dataTv;
    Spinner spinTo, spinFrom;
    TextView resultTv;

    RequestQueue queue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        //Method for initial state.
        initialization();

        final TextView data_tv = findViewById(R.id.data_tv);
        final TextView result_tv = findViewById(R.id.result_tv);

        final Button btn_convert = findViewById(R.id.btn_convert);
        final Button btn_allClear = findViewById(R.id.btn_allClear);
        final Button btn_back = findViewById(R.id.btn_back);
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
        final ImageView btn_change = findViewById(R.id.btn_change);

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

        btn_allClear.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                data_tv.setText("");
                result_tv.setText("");
            }
        });

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result_tv.setVisibility(View.VISIBLE);
                if (dataTv.getText().toString().isEmpty()) {
                    popup("Set amount");
                } else if (fromCur.length() == 0) {
                    popup("Set currency to convert FROM");
                } else if (toCur.length() == 0) {
                    popup("Set currency to convert TO");
                } else {

                    data = Double.parseDouble(dataTv.getText() + "");

                    String url = "http://data.fixer.io/api/latest?access_key=7c282ab4e8d7ba3f98baee801ff657c3";
                    //Request to Fixer
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Json json = new Gson().fromJson(response, Json.class);
                                    Log.i("RESPONSE", response);

                                    //Considering Fixer offers the exchange rate data related only to EUR,
                                    //we calculate the conversion as follows
                                    final_fromRate = 1 / json.rates.get(fromCur);
                                    final_toRate = json.rates.get(toCur);
                                    if (fromCur.equals(toCur)) {
                                        result = data;
                                    } else {
                                        result = final_fromRate * final_toRate * data;
                                    }

                                    String strResult = String.valueOf(result);
                                    resultTv.setText(strResult);
                                }

                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            popup("Sorry, an error has occurred");
                            error.printStackTrace();
                        }
                    });
                    queue.add(stringRequest);
                }
            }
        });


        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinFrom.setSelection(toSave);
                spinTo.setSelection(fromSave);
            }
        });

    }

    private void initialization() {

        dataTv = findViewById(R.id.data_tv);
        spinFrom = findViewById(R.id.fromValue);
        spinTo = findViewById(R.id.toValue);
        resultTv = findViewById(R.id.result_tv);
        queue = Volley.newRequestQueue(this);

        fromCur = "";
        toCur = "";

        currencies[0] = "";

        String url = "http://data.fixer.io/api/latest?access_key=7c282ab4e8d7ba3f98baee801ff657c3";
        //Request to Fixer
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int i = 1;
                        Json json = new Gson().fromJson(response, Json.class);
                        Log.i("RESPONSE", response);

                        // Fill array with currencies brought from API
                        for (String cur : json.rates.keySet()) {
                            //Get max 100 currencies
                            if (i < 101) {
                                currencies[i] = cur;
                                i++;
                            }
                        }
                        Arrays.sort(currencies);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                popup(error.toString());
                error.printStackTrace();
            }
        });

        queue.add(stringRequest);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Setting the currencies in the "TO" Spinner
        spinTo.setAdapter(adapter);
        spinTo.setOnItemSelectedListener(this);

        // Setting the currencies in the "FROM" Spinner
        spinFrom.setAdapter(adapter);
        spinFrom.setOnItemSelectedListener(this);


    }

    public void popup (String popup){

        int l = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast.makeText(context, popup, l).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.fromValue) {
            //For FROM spinner, save the currency to switch it if necessary
            fromCur = parent.getItemAtPosition(position).toString();
            fromSave = position;
        } else if (parent.getId() == R.id.toValue) {

            //For FROM spinner, save the currency to switch it if necessary
            toCur = parent.getItemAtPosition(position).toString();
            toSave = position;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}