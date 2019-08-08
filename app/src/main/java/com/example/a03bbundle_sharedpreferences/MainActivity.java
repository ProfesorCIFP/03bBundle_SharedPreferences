package com.example.a03bbundle_sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

import java.util.prefs.PreferencesFactory;

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
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDatos = sharedPreferences.edit();

        String usuario = tilUsuario.getEditText().getText().toString();
        String email = tilEmail.getEditText().getText().toString();

        editorDatos.putString("Usuario", usuario);
        editorDatos.putString("Email", email);

        editorDatos.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String usuario = sharedPreferences.getString("Usuario", "");
        String email = sharedPreferences.getString("Email", "");

        tilUsuario.getEditText().setText(usuario);
        tilEmail.getEditText().setText(email);
    }
}
