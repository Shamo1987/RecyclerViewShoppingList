package com.info.recyclerviewshoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.info.recyclerviewcalismasi.R;

public class MainActivity extends AppCompatActivity {
    private Button buttonEnkel,buttonDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnkel = (Button) findViewById(R.id.buttonEnkel);
        buttonDetail = (Button) findViewById(R.id.buttonDetail);


        buttonEnkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent = new Intent(MainActivity.this, EnkelRV.class);
                startActivity(ıntent);
            }
        });

        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent = new Intent(MainActivity.this, DetailRV.class);
                startActivity(ıntent);
            }
        });

    }
}
