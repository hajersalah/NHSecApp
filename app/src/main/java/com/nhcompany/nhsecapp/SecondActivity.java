package com.nhcompany.nhsecapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView helloUser;
    Button profession, editData;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        helloUser=findViewById(R.id.helloUser);
        profession=findViewById(R.id.profession);
        editData=findViewById(R.id.editData);


        name = getIntent().getStringExtra("name");
        // two ways to set text in a text view
        // 1- set text >>> remove old text and set the new text..
        helloUser.setText("Hello " + name);
        // 2- append >>> add new text behind the old text ..
        //helloUser.append( name);


        profession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, EditData.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            String result = data.getStringExtra("profession");
            helloUser.append("\n you are a " + result);
        }

    }
}
