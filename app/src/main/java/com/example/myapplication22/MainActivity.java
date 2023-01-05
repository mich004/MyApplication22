package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText message;
    Button encrypt, decrypt, rencrypt, rdecrypt;

    @SuppressLint("MissingIngInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encrypt = findViewById(R.id.cEncrypt);
        decrypt = findViewById(R.id.cDecrypt);
        rencrypt = findViewById(R.id.rEncrypt);
        rdecrypt = findViewById(R.id.rDecrypt);
        message = findViewById(R.id.enterText);

        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);
        rencrypt.setOnClickListener(this);
        rdecrypt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        String str = message.getText().toString();


        if (R.id.cEncrypt == btnId) {
            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("input", str);
            startActivity(i);
        }else if (R.id.cDecrypt == btnId) {
            Intent i = new Intent(this,MainActivity3.class);
            i.putExtra("input",str);
            startActivity(i);
        }else if (R.id.rEncrypt == btnId) {
            Intent i = new Intent(this,MainActivity4.class);
            i.putExtra("input", str);
            startActivity(i);
        }else if (R.id.rDecrypt == btnId) {
            Intent i = new Intent(this,MainActivity5.class);
            i.putExtra("input", str);
            startActivity(i);
        }
    }
}








