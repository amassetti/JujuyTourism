package edu.gti.mobile.ariel.jujuytourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WhatToDoActivity extends AppCompatActivity {

    private static final String URL_ADVENTURE = "https://www.turismo.jujuy.gob.ar/aventura-y-naturaleza/";
    private static final String URL_CULTURE = "https://www.turismo.jujuy.gob.ar/cultural/";
    private static final String URL_FOOD = "https://www.turismo.jujuy.gob.ar/cocina-y-vinos/";
    private static final String URL_UNMISSABLE = "https://www.turismo.jujuy.gob.ar/imperdibles/";

    Button buttonFoodJ, buttonCultureJ, buttonAdventureJ, buttonUnmissableJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_what_to_do);
        /* Code */

        buttonFoodJ = findViewById(R.id.buttonFoodMoreInfo);
        buttonCultureJ = findViewById(R.id.buttonCultureMoreInfo);
        buttonAdventureJ = findViewById(R.id.buttonAdventureMoreInfo);
        buttonUnmissableJ = findViewById(R.id.buttonUnmissableMoreInfo);

        // Food
        buttonFoodJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_FOOD));
                startActivity(browserIntent);
            }
        });

        // Culture
        buttonCultureJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_CULTURE));
                startActivity(browserIntent);
            }
        });

        // Adventure
        buttonAdventureJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_ADVENTURE));
                startActivity(browserIntent);
            }
        });

        // Unmissable
        buttonUnmissableJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_UNMISSABLE));
                startActivity(browserIntent);
            }
        });

        /* Code */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}