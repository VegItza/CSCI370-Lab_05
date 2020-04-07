package com.example.lab5_carrillo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;


    private TextView defaultOne;
    private EditText enterNew;
    private Button changeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        defaultOne = findViewById(R.id.userNameTextId);
        enterNew = findViewById(R.id.enterUserNameId);
        changeButton = findViewById(R.id.button);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkPreferences();

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUserNameText = enterNew.getText().toString().trim();

                if(!newUserNameText.isEmpty()) {
                    defaultOne.setText(newUserNameText);
                    mEditor.putString(getString(R.string.enterUserNameId), newUserNameText);
                    mEditor.commit();
                }

            }
        });



    }

    private void checkPreferences(){
        String enterUserNameId = mPreferences.getString(getString(R.string.enterUserNameId),"defaultName");
            defaultOne.setText(enterUserNameId);

    }

}
