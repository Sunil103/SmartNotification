package com.example.smartnotify;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class Student_Dialog extends AppCompatDialogFragment {
    private EditText usn,dept,sem;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.student_layout,null);
        builder.setView(view).setTitle("Add")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        }


                });
        usn=view.findViewById(R.id.usn);
        dept=view.findViewById(R.id.dept);
        sem=view.findViewById(R.id.sem);
        return builder.create();
    }

   /* private boolean validate() {
        boolean invalid=false;
        if(usn.getText().toString().trim().length() <= 0){
           Toast.makeText(Student_Dialog.this,"ERROR",Toast.LENGTH_LONG).show();
            return true;
        }*/
    //return false;
    }



