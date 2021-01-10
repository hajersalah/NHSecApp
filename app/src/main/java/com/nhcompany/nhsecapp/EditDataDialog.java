package com.nhcompany.nhsecapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditDataDialog extends AppCompatDialogFragment {
    EditText editUserName, editEmail;
    Button confirm;
    CustomDialogInterface customDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater alertLayout = getActivity().getLayoutInflater();
        View layout = alertLayout.inflate(R.layout.edit_data_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setView(layout);

        alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username = editUserName.getText().toString();
                String email = editEmail.getText().toString();
                customDialog.applyTexts(username , email);

            }
    });
        editUserName = layout.findViewById(R.id.editusername);
        editEmail = layout.findViewById(R.id.editemail);
        //confirm = layout.findViewById(R.id.confirm);

        /*confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUserName.getText().toString();
                String email = editEmail.getText().toString();
                customDialog.applyTexts(username , email);
            }
        });*/
        return alertDialog.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        customDialog = (CustomDialogInterface) context;
    }

    public interface CustomDialogInterface {
        void applyTexts(String userName, String email);
    }
    /*public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // editUserName = findViewById(R.id.editusername);
       // editEmail = findViewById(R.id.editemail);
       // confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = editUserName.getText().toString();
            String email = editEmail.getText().toString();
            customDialog.applyTexts(username , email);

                /*Intent intent = new Intent();
                intent.putExtra("username"  , username );
                intent.putExtra("email"  , email );
                //setResult(RESULT_OK ,intent );
                finish();*/
}
