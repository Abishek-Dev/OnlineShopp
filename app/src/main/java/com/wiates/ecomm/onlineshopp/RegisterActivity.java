package com.wiates.ecomm.onlineshopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText address, email, pwd, phn, fn, ln, doorno;
    TextView login;
    FirebaseAuth firebaseAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = (Button) findViewById(R.id.bregister);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        pwd = (EditText) findViewById(R.id.pass);
        phn = (EditText) findViewById(R.id.phn);
        fn = (EditText) findViewById(R.id.firstname);
        ln = (EditText) findViewById(R.id.lastname);
        doorno = (EditText) findViewById(R.id.doorno);
        firebaseAuth = FirebaseAuth.getInstance();
        mUser=firebaseAuth.getCurrentUser();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode();
            }
        });
    }
    public void sendVerificationCode(){
        mUser.sendEmailVerification().addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(RegisterActivity.this,"Verification code is sent to"+mUser.getEmail(),Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this,"Sorry your verification is failed please try again",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
