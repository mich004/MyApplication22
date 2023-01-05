package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        msg = findViewById(R.id.view_value);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String val = extras.getString("input");
            String encryptedText = decrypt(val, 3);
            msg.setText(encryptedText);
        }

    }
    public static String decrypt(String ciphertext, int shift) {
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            if (Character.isLetter(ch)) {
                char shift_ch = (char)(ch - shift);
                if (Character.isLowerCase(ch) && shift_ch < 'a' || Character.isUpperCase(ch) && shift_ch < 'A') {
                    shift_ch = (char)(shift_ch + 26);
                }
                plaintext += shift_ch;
            } else {
                plaintext += ch;
            }
        }
        return plaintext;
    }
}