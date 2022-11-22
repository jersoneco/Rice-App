package com.sven.riceapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView textView_sign_up;
    private EditText userPassword;
    public EditText userEmail;
    private Button loginButton;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private static final int duration = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findId();

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            homeIntent();
        }
        textView_sign_up.setOnClickListener(v -> {
            checkConnectivity();
            finish();
            Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerActivity);
        });

        loginButton.setOnClickListener(v -> {
            String inputName = userEmail.getText().toString().trim();
            String inputPassword = userPassword.getText().toString().trim();

            Confirmation(inputName, inputPassword);
        });
    }

    private void Confirmation(String userName, String userPassword){

        if (userName.isEmpty() || userPassword.isEmpty()){
            Toast.makeText(MainActivity.this, "Please fill up the blank!", Toast.LENGTH_SHORT).show();
        }
        else {
            checkConnectivity();
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            Validation(userName, userPassword);
        }
        checkConnectivity();
    }

    private void Validation(String Email, String Password){
        firebaseAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Log In Successfully",
                                Toast.LENGTH_SHORT).show();
                        finish();
                        homeIntent();
                    }else {
                        new Handler().postDelayed(() -> progressDialog.dismiss(),duration);
                        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                            Toast.makeText(this, "Invalid Password or Email", Toast.LENGTH_SHORT).show();
                        }else if (task.getException() instanceof FirebaseAuthInvalidUserException){
                            Toast.makeText(this, "Email not in use", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void homeIntent(){
        Intent homeActivity = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(homeActivity);
    }

    private void findId(){
        textView_sign_up = findViewById(R.id.tvRegister);
        userEmail = findViewById(R.id.etUsername);
        userPassword = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.btnLogin);
    }

    private void checkConnectivity(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null!=activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(MainActivity.this, "Internet Connected", Toast.LENGTH_SHORT).show();

            }else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                Toast.makeText(MainActivity.this, "Internet Connected", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}