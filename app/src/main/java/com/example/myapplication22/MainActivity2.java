package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        msg = findViewById(R.id.view_value);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String  val = extras.getString("input");
            String encryptedText = encrypt(val, 3);
            msg.setText(encryptedText);
        }
    }
    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char shift_ch = (char) ((int) ch + shift);
                if (Character.isLowerCase(ch) && shift_ch > 'z' ||
                        Character.isUpperCase(ch) && shift_ch > 'Z') {
                    shift_ch -= 26;
                } else if (Character.isLowerCase(ch) && shift_ch < 'a' ||
                        Character.isUpperCase(ch) && shift_ch < 'A') {
                    shift_ch += 26;
                }
                ciphertext.append(shift_ch);
            } else {
                ciphertext.append(ch);
            }
        }
        return ciphertext.toString();
    }
}