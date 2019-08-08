package com.example.a03bbundle_sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tilUsuario, tilEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilUsuario = findViewById(R.id.tilUsuario);
        tilEmail = findViewById(R.id.tilEmail);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("Usuario", tilUsuario.getEditText().getText().toString());
        outState.putString("Email", tilEmail.getEditText().getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String usuario = savedInstanceState.getString("Usuario");
        String email = savedInstanceState.getString("Email");

        tilUsuario.getEditText().setText(usuario);
        tilEmail.getEditText().setText(email);
    }
}
