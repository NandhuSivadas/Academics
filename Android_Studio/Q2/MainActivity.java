package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
        b=findViewById(R.id.b);
        tv=findViewById(R.id.tv);
        b.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                String n=et.getText().toString().trim();

                int num=Integer.parseInt(n);
                long fact=1;
                for(int i=1;i<=num;i++) {
                    fact *= i;
                }
                tv.setText("Factorial:"+fact);

            }


        });
    }
}