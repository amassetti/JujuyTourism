package edu.gti.mobile.ariel.jujuytourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CelebrationsActivity extends AppCompatActivity {

    private static final String URL_ERMITAS = "https://www.turismo.jujuy.gob.ar/event/ermitas-de-tilcara/";
    private static final String URL_WHITE_RIVER = "https://www.turismo.jujuy.gob.ar/event/fiesta-patronal-y-peregrinacion-a-la-virgen-de-rio-blanco-y-paypaya/";
    private static final String URL_NAUTIC = "https://www.turismo.jujuy.gob.ar/event/la-patrona-de-el-carmen-en-peregrinacion-nautica/";
    private static final String URL_MANGERS = "https://www.turismo.jujuy.gob.ar/event/tradicion-de-pesebres-y-adoracion-al-nino-dios/";

    ImageView imageViewMangersJ, imageViewWhiteRiverJ, imageViewNauticJ, imageViewErmitasJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_celebrations);
        /* */

        imageViewMangersJ = findViewById(R.id.imageViewMangers);
        imageViewWhiteRiverJ = findViewById(R.id.imageViewWhiteRiver);
        imageViewNauticJ = findViewById(R.id.imageViewNautic);
        imageViewErmitasJ = findViewById(R.id.imageViewErmitas);

        // Ermitas
        imageViewErmitasJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_ERMITAS));
                startActivity(browserIntent);

            }
        });

        // Nautic
        imageViewNauticJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_NAUTIC));
                startActivity(browserIntent);

            }
        });

        // White River
        imageViewWhiteRiverJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_WHITE_RIVER));
                startActivity(browserIntent);

            }
        });

        // Mangers
        imageViewMangersJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_MANGERS));
                startActivity(browserIntent);

            }
        });

        /* */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}