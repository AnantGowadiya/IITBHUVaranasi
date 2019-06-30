package com.example.anant.iitbhuvaranasi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Full_screen_imageActivity extends AppCompatActivity {

    private ImageView full_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        full_image=findViewById(R.id.fullscree_nmageView);
      /*  image=getIntent().getIntExtra("image",0);
        full_image.setImageResource(image);*/
    }
}
