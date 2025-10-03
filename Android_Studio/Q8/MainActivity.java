package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button btnCalc;
    ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.etSub1);
        et2 = findViewById(R.id.etSub2);
        et3 = findViewById(R.id.etSub3);
        btnCalc = findViewById(R.id.btnCalc);
        imgResult = findViewById(R.id.imgResult);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m1 = Integer.parseInt(et1.getText().toString());
                int m2 = Integer.parseInt(et2.getText().toString());
                int m3 = Integer.parseInt(et3.getText().toString());

                int total = m1 + m2 + m3;
                double percentage = (total / 3.0);

                imgResult.setVisibility(View.VISIBLE);

                if (percentage >= 50) {
                    imgResult.setImageResource(R.drawable.happy); // happy.png in drawable
                } else {
                    imgResult.setImageResource(R.drawable.sad); // sad.png in drawable
                }
            }
        });
    }
}
