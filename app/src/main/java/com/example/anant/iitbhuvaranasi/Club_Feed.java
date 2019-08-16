package com.example.anant.iitbhuvaranasi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Club_Feed extends AppCompatActivity {

    private TextView club_name;
    private CircleImageView feed_clubimage;
    private LinearLayout custombar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club__feed);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.club_bar_layout, null);


        club_name = mCustomView.findViewById(R.id.feed_clubname);
        feed_clubimage = mCustomView.findViewById(R.id.feed_clubimage);
        custombar=mCustomView.findViewById(R.id.linear_club1);
        String title1= getIntent().getStringExtra("title");
        String image1 = getIntent().getStringExtra("image");
        Log.d("title123",title1);
        Log.d("image123",image1);
       club_name.setText(title1);
        Picasso.get()
                .load(image1)
                .placeholder(R.drawable.ic_eye_view)
                .error(R.drawable.amc_workshop)
                .into(feed_clubimage);



        custombar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
                        Toast.LENGTH_LONG).show();

            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }
}
