package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        msg = findViewById(R.id.view_value);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String val = extras.getString("input");
            String encryptedText = decrypt(val);
            msg.setText(encryptedText);
        }
    }
    public static String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <text.length(); i++) {
        char c = text.charAt(i);
        if (Character.isUpperCase(c)) {
            c = (char) ((c - 13 - 'A' + 26) % 26 + 'A');
        }else if (Character.isLowerCase(c)) {
            c = (char) ((c - 13 - 'a' + 26) % 26 + 'a');
        }
        sb.append(c);
        }
        return sb.toString();
    }
}
