package com.nhcompany.nhsecapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EditData extends AppCompatActivity implements EditDataDialog.CustomDialogInterface {
Button editData;
TextView userName1 , Email1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        editData = findViewById(R.id.editData);
        userName1 = findViewById(R.id.userNameedit);
        Email1 = findViewById(R.id.Emailedit);

        // the same way we made a custom toast !!!!!!!!!!!!!!!!!!!!!
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditDataDialog edit_DataDialog = new EditDataDialog();
                edit_DataDialog.show(getSupportFragmentManager(),"edit  Your Data");            }
            });

    }
    /*void showDialog() {
        LayoutInflater alertLayout = getLayoutInflater();
        View layout = alertLayout.inflate(R.layout.edit_data_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditDataDialog.this);
        alertDialog.setView(layout);
        alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name = getIntent().getStringExtra("username");
                        mail = getIntent().getStringExtra("email");
                        userName.setText(name);
                        Email.setText(mail);    }
});
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }*/

    @Override
    public void applyTexts(String userName, String email) {
        //name = getIntent().getStringExtra("username");
        //mail = getIntent().getStringExtra("email");
        userName1.setText(userName);
        Email1.setText(email);
    }


   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result1 = data.getStringExtra("username");
        String result2 = data.getStringExtra("email");
        userName.setText(name);
        Email.setText(mail);

    }*/
}
