package com.nhcompany.nhsecapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login , showToast , showAlert;
    EditText username , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.loginbutton);
        showToast=findViewById(R.id.showtoast);
        showAlert=findViewById(R.id.showalert);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if( name.trim().length()>0 && pass.trim().length() >0){
                    Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                    // to go to another activity but with data !!!
                    intent.putExtra("name", name);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this ,"please enter your name & your password", Toast.LENGTH_LONG).show();
                }
            }
        });
        // how to make a custom toast !!!!
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater toastLayout = getLayoutInflater();
                // we did cast here .. from View to >> viewGroup
                View layout = toastLayout.inflate(R.layout.custom_toast ,(ViewGroup)findViewById(R.id.layout));
                // the same way of writing toast .. but splitted !!!
                Toast toast = new Toast(MainActivity.this);
                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM , 0 , 0);
                toast.show();
            }
        });
        showAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                //write title like this >> alertDialog.setTitle("title");
                alertDialog.setTitle("Good Morning");
                //write the message like this >> alertDialog.setMessage("message");
                alertDialog.setMessage("hello!! \n how are you today ?");
                // yes or ok button ::
                alertDialog.setPositiveButton("Fine :)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                // no or cancel button ::
                alertDialog.setNegativeButton("not very good :(", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();
                // or just :
                //alertDialog.show();
            }
        });


    }
}
