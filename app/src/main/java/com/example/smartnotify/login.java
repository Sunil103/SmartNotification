package com.example.smartnotify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
EditText username,password;
Button login,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        cancel=findViewById(R.id.cancel);
    }

    public void login(View view) {
        if(!validate()) {
            final Progress_Login p = new Progress_Login(login.this, view);
            p.buttonActivated();
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  p.buttonFinished();
                                  Handler h1 = new Handler();
                                  h1.postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent i = new Intent(login.this, feeds.class);
                                          startActivity(i);
                                      }
                                  }, 1000);
                              }
                          }
                    , 3000);
        }
    }

    private boolean validate() {
        boolean invalid=false;
        if(username.getText().toString().trim().length() <= 0){
            Toast.makeText(login.this,"Please enter Username!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(password.getText().toString().trim().length() <= 0){
            Toast.makeText(login.this,"Please enter Password !",Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }
}
