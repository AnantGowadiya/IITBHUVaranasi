package com.example.anant.iitbhuvaranasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ClubFeed extends AppCompatActivity {
    TextView content;
    ImageButton plus, minus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_feed);
        Intent intent=getIntent();
        content = (TextView) findViewById(R.id.content);
        plus = (ImageButton) findViewById(R.id.plus);
        minus = (ImageButton) findViewById(R.id.minus);
        content.setMaxLines(0);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus.setVisibility(View.GONE);
                minus.setVisibility(View.VISIBLE);
                content.setMaxLines(Integer.MAX_VALUE);
            }

        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus.setVisibility(View.GONE);
                plus.setVisibility(View.VISIBLE);
                content.setMaxLines(0);
            }
        }
        );}}