package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ClubFeed extends AppCompatActivity {

   private TextView club_name;
   private CircleImageView feed_clubimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_feed);

        InitializeControllers();


    }

    private void InitializeControllers() {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);

        LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.club_bar_layout, null);

        club_name = findViewById(R.id.feed_clubname);
        feed_clubimage = findViewById(R.id.feed_clubimage);


        actionBar.setCustomView(v);
    }
}

