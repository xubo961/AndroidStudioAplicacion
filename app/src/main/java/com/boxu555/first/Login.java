package com.boxu555.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        Button loginButton = findViewById(R.id.loginButton);
        TextView loginRegisterText = findViewById(R.id.loginRegister);
        TextInputLayout Usuario = findViewById(R.id.loginUsernameTIL);
        TextInputLayout Contraseña = findViewById(R.id.loginPasswordTIL);
        SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String logUser = String.valueOf(Usuario.getEditText().getText());
                String logPassword = String.valueOf(Contraseña.getEditText().getText());
                String regUser = preferences.getString("user", "");
                String regPassword = preferences.getString("password", "");

                if (!logUser.equals(regUser)) {
                    Toast toastUser = Toast.makeText(getApplicationContext(), "Introduce el Usuario o el Usuario no coinciden", Toast.LENGTH_SHORT);
                    toastUser.show();
                } else if (!logPassword.equals(regPassword)) {
                    Toast toastPassword = Toast.makeText(getApplicationContext(), "Introduce la Contraseña o la Contraseña no coinciden", Toast.LENGTH_SHORT);
                    toastPassword.show();
                } else {
                    launchMain();
                }
            }
        });

        loginRegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRegister();
            }
        });

    }

        public void launchMain(){
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        public void launchRegister(){
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        }
}