package com.chahatgoel.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Chahat goel on 22-04-2018.
 */

public class findme extends AppCompatActivity {
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    public static final String TAG = "a";
    String s;
    TextView text1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.findme);
        text1 = findViewById(R.id.text1);
        btn = findViewById(R.id.btn);
        requestQueue= Volley.newRequestQueue(this

        );
        stringRequest= new StringRequest(Request.Method.GET,getString(R.string.server)+
                "/parking/delete/" + "122", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                s= response.toString();
                text1.setText(s);


                Log.i(TAG, "onResponse: "+ response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(findme.this, DisplayActivity.class);
                startActivity(i4);
            }
        });
    }

    }

