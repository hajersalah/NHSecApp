package com.nhcompany.nhsecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    EditText profession;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        profession=findViewById(R.id.enterprofession);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = profession.getText().toString() ;
                Intent intent = new Intent();
                intent.putExtra("profession" , message);
                setResult(RESULT_OK ,intent );
                finish();

            }
        });
    }
}
