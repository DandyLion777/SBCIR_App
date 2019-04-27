package com.example.smallbusinesscyberincidenceresponse;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class Services extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        CardView cv = findViewById(R.id.cardView);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Services.this, "Yaaaaaasss", Toast.LENGTH_SHORT).show();

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_sms);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensms();

            }
        });
    }
    public  void opensms(){
        Intent sms = new Intent(Services.this,sms.class);
        startActivity(sms);
    }

    public void onClick(View view) {
        //Intent signUp = new Intent(MainActivity.this,SignUp.class);
        //startActivity(signUp);
    }


}
