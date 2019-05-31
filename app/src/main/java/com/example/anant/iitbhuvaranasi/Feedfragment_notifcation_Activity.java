package com.example.anant.iitbhuvaranasi;

import android.app.ActivityOptions;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;

import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Feedfragment_notifcation_Activity extends AppCompatActivity {

    ImageView image_event;
    TextView title_event,description_event,date_event,venue_event,time_event;
    int image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedfragment_notifcation_);




        title_event=findViewById(R.id.event_page_title);
        date_event=findViewById(R.id.event_page_date);
        image_event=findViewById(R.id.event_picture_2);
        title_event.setText(getIntent().getStringExtra("title"));
        date_event.setText(getIntent().getStringExtra("date"));
        image2=getIntent().getIntExtra("image",0);
        image_event.setImageResource(image2);
        final Pair[] pairs=new Pair[1];
        pairs[0]=new Pair<View,String>(image_event,"fullscreen");


                image_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Full_screen_imageActivity.class);
                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(Feedfragment_notifcation_Activity.this, pairs);
                intent.putExtra("image",image2);
                startActivity(intent,options.toBundle());
            }
        });

      /*

        description_event=findViewById(R.id.event_page_description);

        venue_event=findViewById(R.id.event_page_venue);
        time_event=findViewById(R.id.event_page_time);
        */




    }
}
