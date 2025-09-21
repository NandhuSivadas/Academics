package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int a = 0, b = 0, op = 0; // op: 1=add, 2=subtract, 3=multiply, 4=divide
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.display);

        // Number buttons
        findViewById(R.id.a0).setOnClickListener(this);
        findViewById(R.id.a1).setOnClickListener(this);
        findViewById(R.id.a2).setOnClickListener(this);
        findViewById(R.id.a3).setOnClickListener(this);
        findViewById(R.id.a4).setOnClickListener(this);
        findViewById(R.id.a5).setOnClickListener(this);
        findViewById(R.id.a6).setOnClickListener(this);
        findViewById(R.id.a7).setOnClickListener(this);
        findViewById(R.id.a8).setOnClickListener(this);
        findViewById(R.id.a9).setOnClickListener(this);

        // Operation buttons
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.sub).setOnClickListener(this);
        findViewById(R.id.mul).setOnClickListener(this);
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.equals).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Numbers
        if (v.getId() == R.id.a0) {
            t.setText(t.getText() + "0");
        } 
        else if (v.getId() == R.id.a1)
         {
            t.setText(t.getText() + "1");

        } 
        else if (v.getId() == R.id.a2) 
        {
            t.setText(t.getText() + "2");
        } 
        else if (v.getId() == R.id.a3)
         {
            t.setText(t.getText() + "3");
        } 
        else if (v.getId() == R.id.a4) 
        {
            t.setText(t.getText() + "4");
        } else if (v.getId() == R.id.a5)
         {
            t.setText(t.getText() + "5");
        } 
        else if (v.getId() == R.id.a6)
         {
            t.setText(t.getText() + "6");
        }
         else if (v.getId() == R.id.a7) 
         {
            t.setText(t.getText() + "7");
        } else if (v.getId() == R.id.a8)
         {
            t.setText(t.getText() + "8");
        } 
        else if (v.getId() == R.id.a9) 
        {
            t.setText(t.getText() + "9");
        }

        // Operations
        else if (v.getId() == R.id.add) {
            a = Integer.parseInt(t.getText().toString());
            op = 1;
            t.setText("");
        } else if (v.getId() == R.id.sub) {
            a = Integer.parseInt(t.getText().toString());
            op = 2;
            t.setText("");
        } else if (v.getId() == R.id.mul) {
            a = Integer.parseInt(t.getText().toString());
            op = 3;
            t.setText("");
        } else if (v.getId() == R.id.div) {
            a = Integer.parseInt(t.getText().toString());
            op = 4;
            t.setText("");
        }

        // Equal
        else if (v.getId() == R.id.equals) {
            b = Integer.parseInt(t.getText().toString());
            if (op == 1) {
                t.setText(String.valueOf(a + b));
            } else if (op == 2) {
                t.setText(String.valueOf(a - b));
            } else if (op == 3) {
                t.setText(String.valueOf(a * b));
            } else if (op == 4) {
                if (b != 0)
                    t.setText(String.valueOf(a / b));
                else
                    t.setText("Error");
            }
        }

        // Clear
        else if (v.getId() == R.id.clear) {
            t.setText("");
            a = 0;
            b = 0;
            op = 0;
        }
    }
}
