package com.chahatgoel.scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
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

public class DisplayActivity extends AppCompatActivity {
    Button logout;
    Button over;
    Button findMe;
    trial t;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    public static final String TAG = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        over = findViewById(R.id.over);
        findMe= findViewById(R.id.findMe);
        setContentView(R.layout.activity_display);

       findMe.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent ii = new Intent(DisplayActivity.this, findme.class);
               startActivity(ii);
           }
       });


        over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t = new trial();
                String pass = t.sendTrial();
                sendRequests(pass);

            }
        });




        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent (DisplayActivity.this, LoginActivity.class);
                startActivity(i2);
            }
        });
    }
    private void sendRequests(String password) {
        requestQueue= Volley.newRequestQueue(this

        );
        stringRequest= new StringRequest(Request.Method.GET,getString(R.string.server)+
                "/parking/delete/" + password , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i(TAG, "onResponse: "+ response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

}

