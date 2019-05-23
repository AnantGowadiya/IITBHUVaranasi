package com.example.anant.iitbhuvaranasi;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ClubFeed extends AppCompatActivity implements View.OnClickListener {
    TextView content;
    ImageButton expanddes, contractdes,clock, share, location ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_feed);
        Intent intent = getIntent();
        content = findViewById(R.id.content);
        expanddes = (ImageButton) findViewById(R.id.plus);
        expanddes.setOnClickListener(this);
        contractdes = (ImageButton) findViewById(R.id.minus);
        contractdes.setOnClickListener(this);
        clock=(ImageButton)findViewById(R.id.clock);
        clock.setOnClickListener(this);
        share=(ImageButton)findViewById(R.id.share);
        location=(ImageButton)findViewById(R.id.location);
        share.setOnClickListener(this);
        content.setMaxLines(0);

    }

    @Override
    public void onClick(View v) {
        //default method for handling onClick events
        switch (v.getId()) {

            case R.id.plus:
                expanddes.setVisibility(View.GONE);
                contractdes.setVisibility(View.VISIBLE);
                content.setMaxLines(Integer.MAX_VALUE);
                break;

            case R.id.minus:
                contractdes.setVisibility(View.GONE);
                expanddes.setVisibility(View.VISIBLE);
                content.setMaxLines(0);
                break;

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

            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case R.id.location:
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode("1st & Pike, Seattle"));
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager())!= null){
                    startActivity(mapIntent);
                }
                else {
                    Toast.makeText(this, "Maps Application Unsupported", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}