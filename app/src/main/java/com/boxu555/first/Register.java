package com.boxu555.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputLayout registerUserame = findViewById(R.id.registerUserame);
        TextInputLayout registerEmail = findViewById(R.id.registerEmail);
        TextInputLayout registerPassword = findViewById(R.id.registerPassword);
        TextInputLayout confirmPassword = findViewById(R.id.confirmPassword);
        Button registerButton = findViewById(R.id.registerButton);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = String.valueOf(registerUserame.getEditText().getText());
                String userEmail = String.valueOf(registerEmail.getEditText().getText());
                String userPassword = String.valueOf(registerPassword.getEditText().getText());
                String userPasswordCheck = String.valueOf(confirmPassword.getEditText().getText());

                if (!userPassword.equals(userPasswordCheck)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Tus contraseñas no coincide", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (userName.isEmpty()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Introduce tu usuario", Toast.LENGTH_SHORT);
                        toast.show();

                } else if (userEmail.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Introduce tu correo electrónico", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("user", userName);
                    editor.putString("password", userPassword);
                    editor.putString("checkPassword", userPasswordCheck);
                    editor.putString("email", userEmail);

                    editor.apply();
                    launchActivity();
                }
            }
        });
    }

    public void launchActivity(){
        Intent intent = new Intent(Register.this,Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}