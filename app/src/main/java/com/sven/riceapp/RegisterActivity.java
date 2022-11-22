package com.sven.riceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonRegister;
    private EditText fullName, userName, passWord, confirmPassword;
    private TextView signIn;
    private FirebaseAuth firebaseAuth;
    private static final int duration = 2000;
    String eName, eUsername, ePassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findId();

        firebaseAuth = FirebaseAuth.getInstance();

        buttonRegister.setOnClickListener(v -> {
            if (validate()){
                checkConnectivity();
                insertInformation();
            }
        });

        signIn.setOnClickListener(v -> {
            checkConnectivity();
            finish();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public void findId(){
        buttonRegister = findViewById(R.id.btnRegister);
        signIn = findViewById(R.id.tvSign_in);
        fullName = findViewById(R.id.etFirstName);
        userName = findViewById(R.id.etUsername);
        passWord = findViewById(R.id.etPassword);
        confirmPassword = findViewById(R.id.etConfirm_password);
    }

    private boolean validate(){
        boolean result = false;

        eName = fullName.getText().toString();
        eUsername = userName.getText().toString().trim();
        ePassword = passWord.getText().toString().trim();
        String eConfirm_password = confirmPassword.getText().toString().trim();

        if (eName.isEmpty() || eUsername.isEmpty() || ePassword.isEmpty() || eConfirm_password.isEmpty()){
            Toast.makeText(RegisterActivity.this, "Please fill up the blank!", Toast.LENGTH_SHORT).show();
        }else {
            //confirmPassword.setEnabled(true);
            if (!ePassword.equals(eConfirm_password)){
                Toast.makeText(RegisterActivity.this, "Confirmation password incorrect!", Toast.LENGTH_SHORT).show();
            }else {
                result = true;
            }
        }

        return result;
    }

    private void insertInformation(){
        firebaseAuth.createUserWithEmailAndPassword(eUsername, ePassword)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Register Successfully",
                                Toast.LENGTH_SHORT).show();
                        sendUserdata();
                        finish();
                        Intent backLogin = new Intent(RegisterActivity.this,
                                HomeActivity.class);
                        startActivity(backLogin);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof FirebaseAuthUserCollisionException){
                    Toast.makeText(RegisterActivity.this, "Email already in use",
                            Toast.LENGTH_SHORT).show();
                }else if (e instanceof FirebaseAuthWeakPasswordException){
                    Toast.makeText(RegisterActivity.this, "Password to weak",
                            Toast.LENGTH_SHORT).show();
                }else if (e instanceof FirebaseAuthInvalidCredentialsException){
                    Toast.makeText(RegisterActivity.this, "Invalid Email",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void sendUserdata(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(Objects.requireNonNull(firebaseAuth.getUid()));
        UserProfile userProfile = new UserProfile(eName, eUsername, ePassword);
        myRef.setValue(userProfile);
    }

    private void checkConnectivity(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if (null!=activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "Internet Connected", Toast.LENGTH_SHORT).show();

            }else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                Toast.makeText(this, "Internet Connected", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}