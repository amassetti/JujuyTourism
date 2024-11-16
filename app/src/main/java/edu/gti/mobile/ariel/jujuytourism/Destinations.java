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

public class Destinations extends AppCompatActivity {

    private static final String URL_PUNA = "https://www.turismo.jujuy.gob.ar/puna-2/";
    private static final String URL_VALLEY = "https://www.turismo.jujuy.gob.ar/valles-2/";
    private static final String URL_YUNGA = "https://www.turismo.jujuy.gob.ar/yungas-2/";
    private static final String URL_RAVINE = "https://www.turismo.jujuy.gob.ar/quebrada-2/";

    Button buttonMoreInfoPunaJ, buttonMoreInfoValleyJ, buttonMoreInfoYungasJ, buttonMoreInfoRavineJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_destinations);
        /* Code here */

        buttonMoreInfoPunaJ = findViewById(R.id.buttonPunaMoreInfo);
        buttonMoreInfoValleyJ = findViewById(R.id.buttonValleyMoreInfo);
        buttonMoreInfoYungasJ = findViewById(R.id.buttonYungasMoreInfo);
        buttonMoreInfoRavineJ = findViewById(R.id.buttonRavineMoreInfo);

        // More info Puna
        buttonMoreInfoPunaJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_PUNA));
                startActivity(browserIntent);
            }
        });

        // More info Valley
        buttonMoreInfoValleyJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_VALLEY));
                startActivity(browserIntent);

            }
        });

        // More info Yungas
        buttonMoreInfoYungasJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_YUNGA));
                startActivity(browserIntent);

            }
        });

        // More info Ravine
        buttonMoreInfoRavineJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_RAVINE));
                startActivity(browserIntent);

            }
        });

        /* Code here*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}