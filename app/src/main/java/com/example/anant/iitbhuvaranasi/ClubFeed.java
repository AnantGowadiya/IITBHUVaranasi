package com.example.anant.iitbhuvaranasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ClubFeed extends AppCompatActivity implements View.OnClickListener {
    TextView content;
    ImageButton expanddes, contractdes,clock, share ;


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

            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            default:
                break;
        }
    }
}