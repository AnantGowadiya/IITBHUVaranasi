package com.example.anant.iitbhuvaranasi;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Full_screen_imageActivity extends AppCompatActivity {

    private ImageView full_image;
    private String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        full_image=findViewById(R.id.fullscree_nmageView);
       image=getIntent().getStringExtra("image");
        Glide.with(this)
                .load(image)
                .fitCenter() // scale to fit entire image within ImageView
                .into(full_image);
    }
}
