package com.boxu555.first;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView addedTetx = findViewById(R.id.addedText);

        SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String name = preferences.getString("user", "");
        String password = preferences.getString("password", "");

        welcomeText.setText("Hola: " + name);
        addedTetx.setText(("Tu contraseña es: " + password));
    }
}