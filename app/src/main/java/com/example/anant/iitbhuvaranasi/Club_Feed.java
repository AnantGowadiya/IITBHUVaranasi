package com.example.anant.iitbhuvaranasi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.anant.iitbhuvaranasi.MainActivity.getVerticalData1;

public class Club_Feed extends AppCompatActivity {

    private TextView club_name;
    private CircleImageView feed_clubimage;
    RecyclerView RecyclerView;
    private LinearLayout custombar;

    public static ArrayList<SingleVerticalData> getVerticalData3 ;

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
        final String title1= getIntent().getStringExtra("title");
        final String image1 = getIntent().getStringExtra("image");
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
                Intent i = new Intent(getApplicationContext(),Club_ProfilePage.class);

                i.putExtra("title1",title1);
                i.putExtra("image1",image1);
                startActivity(i);

            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        getVerticalData3 = new ArrayList<>();

        for(int a=getVerticalData1.size()-1;a>=0;a--) {

            if (getVerticalData1.get(a).getClub().equals(title1)){
                getVerticalData3.add(getVerticalData1.get(a));
                Log.d("567854", getVerticalData3.toString());
                Log.d("567853", getVerticalData1.get(a).getClub().toString());

            }

            Log.d("5678", getVerticalData1.get(a).getClub().toString());
        }

        RecyclerView = findViewById(R.id.cub_feed_recyclerview);
        RecyclerView.setHasFixedSize(true);
        RecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Adapter_CLubFeed adapter_cLubFeed = new Adapter_CLubFeed(getVerticalData3,getApplicationContext());
        RecyclerView.setAdapter(adapter_cLubFeed);
        Log.d("vetricalfer",getVerticalData1.toString());
    }

   /* public static ArrayList<SingleVerticalData> getVerticaldata() {
        ArrayList<SingleVerticalData> singleVerticalData = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.culturalcouncil, "Cultural Council"));
      singleHorizontals.add(new SingleHorizontaldata(R.drawable.saic, "Student Alumni Interaction Cell"));

          return singleVerticalData;
    }*/
}
