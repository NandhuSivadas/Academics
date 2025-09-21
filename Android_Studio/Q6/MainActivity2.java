package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvWelcome = findViewById(R.id.tvWelcome);

        String email = getIntent().getStringExtra("email");
        tvWelcome.setText("Welcome, " + email + "!");
    }
}
