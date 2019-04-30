package com.yuskay.mydictionary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etUsername,etGender,etPassword;
    private Button btnSignUp,btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        etGender=findViewById(R.id.etGender);

        btnSignUp=findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });
    }

    private void Signup(){
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("username",etUsername.getText().toString());
        editor.putString("password",etPassword.getText().toString());
        editor.putString("gender",etGender.getText().toString());
        editor.commit();


        Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
    }
}
