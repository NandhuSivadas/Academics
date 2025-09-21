package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPassword;
    Button btnLogin;
    CheckBox cbSaveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        cbSaveLogin = findViewById(R.id.cbSaveLogin);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (email.equals("Nandhu") && password.equals("12345")) {
                if (cbSaveLogin.isChecked()) {
                    Toast.makeText(this, "Login Successful (Saved)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("email", email);
                startActivity(i);

            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
