package edu.gti.mobile.ariel.jujuytourism;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CelebrationsActivity extends AppCompatActivity {

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



        /* */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}