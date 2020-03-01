package com.wiates.ecomm.onlineshopp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    Button b1;
    TextView forgotpwd;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=(Button)findViewById(R.id.b1);
        forgotpwd=(TextView)findViewById(R.id.forgotpwd);
        signup=(TextView)findViewById(R.id.txtsignup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(LoginActivity.this,Main2Activity.class);
                startActivity(i1);
            }
        });
        /*forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(LoginActivity.this,Forgotpwd.class);
                startActivity(i1);
           }
        });*/
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i1);
            }
        });
    }
}
