package com.example.anant.iitbhuvaranasi;

import android.app.ActivityOptions;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Feedfragment_notifcation_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView image_event;
    TextView title_event, description_event, date_event, venue_event, time_event, going_count, view_count, interested_count;
    Button go_button, interested_button;
    ImageButton share_button, location_button, clock_button;
    int image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedfragment_notifcation_);

        title_event = findViewById(R.id.event_page_title);
        date_event = findViewById(R.id.event_page_date);
        image_event = findViewById(R.id.event_picture_2);
        share_button = (ImageButton) findViewById(R.id.share_event_button);
        share_button.setOnClickListener(this);
        venue_event = (TextView) findViewById(R.id.event_venue);
        location_button = (ImageButton) findViewById(R.id.location);
        location_button.setOnClickListener(this);
        time_event = (TextView) findViewById(R.id.event_time);
        clock_button = (ImageButton) findViewById(R.id.clock);
        clock_button.setOnClickListener(this);
        go_button = (Button) findViewById(R.id.going_button);
        go_button.setOnClickListener(this);
        interested_button = (Button) findViewById(R.id.interested_button);
        interested_button.setOnClickListener(this);
        going_count = (TextView) findViewById(R.id.going_count);
        interested_count = (TextView) findViewById(R.id.interested_count);
        view_count = (TextView) findViewById(R.id.view_count);

        title_event.setText(getIntent().getStringExtra("title"));
        date_event.setText(getIntent().getStringExtra("date"));
        image2 = getIntent().getIntExtra("image", 0);
        image_event.setImageResource(image2);

        final Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(image_event, "fullscreen");


        image_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Full_screen_imageActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Feedfragment_notifcation_Activity.this, pairs);
                intent.putExtra("image", image2);
                startActivity(intent, options.toBundle());
            }
        });

      /*

        description_event=findViewById(R.id.event_page_description);

        venue_event=findViewById(R.id.event_page_venue);
        time_event=findViewById(R.id.event_page_time);
        */


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clock:
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2012, 0, 19, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2012, 0, 19, 8, 30);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, "Yoga")
                        .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                        //invitees emails
                        .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
                startActivity(intent);
                break;

            case R.id.share_event_button:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case R.id.going_button:

                break;

            case R.id.interested_button:

                break;

            case R.id.location:
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode("1st & Pike, Seattle"));
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                break;

        }
    }}
