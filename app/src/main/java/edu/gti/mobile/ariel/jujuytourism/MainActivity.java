package edu.gti.mobile.ariel.jujuytourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonDestinationsJ, buttonWhatToDoJ, buttonCelebrationsJ, buttonInformationJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /* Start code here */

        buttonDestinationsJ = findViewById(R.id.buttonDestinations);
        buttonWhatToDoJ = findViewById(R.id.buttonWhatToDo);
        buttonCelebrationsJ = findViewById(R.id.buttonCelebrations);
        buttonInformationJ = findViewById(R.id.buttonInformation);

        // Destinations
        buttonDestinationsJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Destinations.class));
            }
        });

        // What to Do
        buttonWhatToDoJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WhatToDoActivity.class));
            }
        });

        // Celebrations
        buttonCelebrationsJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CelebrationsActivity.class));
            }
        });

        // Information
        buttonInformationJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InformationActivity.class));
            }
        });

        /* End code here */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}