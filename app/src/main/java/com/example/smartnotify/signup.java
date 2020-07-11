package com.example.smartnotify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class signup extends AppCompatActivity {
    private EditText fullname, user, pass, cpass, email, phone;
    private RadioButton male, female, student, teaching, nonteaching;
    private Button back;
    private RadioButton stud, teach, non;
    private CardView signup;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = (EditText) findViewById(R.id.fullname);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        cpass = (EditText) findViewById(R.id.cpassword);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        stud = (RadioButton) findViewById(R.id.student);
        teach = (RadioButton) findViewById(R.id.teaching);
        non = (RadioButton) findViewById(R.id.non);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        signup = (CardView) findViewById(R.id.signup);


        stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });
        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeachDailog();
            }
        });
        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNonDialog();
            }
        });
    }

    private void openNonDialog() {
        Non_Teaching_Dialog n = new Non_Teaching_Dialog();
        n.show(getSupportFragmentManager(), "Teaching staff");
    }

    private void openTeachDailog() {
        Teaching_Dialog td = new Teaching_Dialog();
        td.show(getSupportFragmentManager(), "Teaching staff");
    }

    private void openDialog() {
        Student_Dialog stud = new Student_Dialog();
        stud.show(getSupportFragmentManager(), "student");
    }

    public void btn_back(View view) {
        finish();
    }


    public void signup(View view) {
        if (!validate()) {
            registerUser();

            final Progress_signup p = new Progress_signup(signup.this, view);
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
                                          Intent i = new Intent(signup.this, login.class);
                                          startActivity(i);
                                      }
                                  }, 1000);
                              }
                          }
                    , 3000);

        }
    }


    private void registerUser() {
    }


    public void card(View view) {
        if(!validate()){
        }
    }

    private boolean validate() {
        boolean invalid=false;
        if(fullname.getText().toString().trim().length() <= 0){
            Toast.makeText(signup.this,"Please enter your Name!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(user.getText().toString().trim().length() <= 0){
            Toast.makeText(signup.this,"Please enter your Username!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(pass.getText().toString().trim().length() <= 0){
            Toast.makeText(signup.this,"Please enter your Password!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(cpass.getText().toString().trim().length() <= 0){
            Toast.makeText(signup.this,"confirm Password can not be empty!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(email.getText().toString().trim().length() <= 0){
            Toast.makeText(signup.this,"Please enter your Email Address!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(phone.getText().toString().trim().length() <= 0){
            Toast.makeText(signup.this,"Please enter your Phone number!",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(male.isChecked()!=true && female.isChecked()!=true){
            Toast.makeText(signup.this,"Please select the gender",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(stud.isChecked()!=true && teach.isChecked()!=true && non.isChecked()!=true){
            Toast.makeText(signup.this,"Please select the role",Toast.LENGTH_LONG).show();
            return true;
        }


        return false;
    }





}
