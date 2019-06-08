package com.example.anant.iitbhuvaranasi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

import static android.support.v4.content.ContextCompat.startActivity;

public class VerticalAdapter_Feedfragment extends RecyclerView.Adapter<VerticalAdapter_Feedfragment.MyViewHolder1> {
    private ArrayList<SingleVerticalData> data = new ArrayList<>();
    private Context mcontext;

    public VerticalAdapter_Feedfragment(Context context, ArrayList<SingleVerticalData> data) {
        this.data = data;
        this.mcontext = context;
    }

    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_layout_feedfragment, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder1 holder, final int position) {

        holder.image.setTransitionName("imageTransition");

        holder.image.setImageResource(data.get(position).getImage());
        holder.image_club.setImageResource(data.get(position).getEvent_image_club());
        holder.title.setText(data.get(position).getHeader());
        holder.council.setText(data.get(position).getCouncil());

        final Pair[] pairs=new Pair[3];
        pairs[0]=new Pair<View,String>(holder.image,"fullscreen");
        pairs[1]=new Pair<View,String>(holder.title,"feedtitle");
        pairs[2]=new Pair<View,String>(holder.date,"feed_date");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,Full_screen_imageActivity.class);
                ActivityOptions options1= ActivityOptions.makeSceneTransitionAnimation((Activity) mcontext, pairs);
                intent.putExtra("image",data.get(position).getImage());
                mcontext.startActivity(intent,options1.toBundle());
            }
        });

        //final Pair<View, String> pair1 = Pair.create((View) holder.image, holder.image.getTransitionName());

        holder.date.setText(data.get(position).getDate());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,Feedfragment_notifcation_Activity.class);
                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) mcontext, pairs);
                // ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, pair1);
                intent.putExtra("title",data.get(position).getHeader());
                intent.putExtra("date",data.get(position).getDate());
                intent.putExtra("image",data.get(position).getImage());
                        mcontext.startActivity(intent,options.toBundle());
            }
        });
        holder.shareEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                mcontext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        holder.setReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                mcontext.startActivity(intent);
            }
        });
        holder.mapLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 40.714728;
                double longitude = -73.998672;
                String label = "ABC Label";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent mapintent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                mcontext.startActivity(mapintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView image, image_club;
        TextView title, date, council, viewCount,goingCount, interestedCount;
        CardView cardView;
        ImageButton shareEvent, setReminder, mapLocation;
        Button goButton, interestedButton;

        public MyViewHolder1(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_events);
            title = (TextView) itemView.findViewById(R.id.titles);
            council = (TextView) itemView.findViewById(R.id.event_title_council);
            date = (TextView) itemView.findViewById(R.id.event_dates);
            image_club = (ImageView) itemView.findViewById(R.id.event_image_club);
            cardView=itemView.findViewById(R.id.cardview_feedfragment);
            viewCount=(TextView) itemView.findViewById(R.id.view_count);
            shareEvent = (ImageButton) itemView.findViewById(R.id.share_event_button);
            setReminder = (ImageButton) itemView.findViewById(R.id.calendar_setevent);
            mapLocation = (ImageButton) itemView.findViewById(R.id.navigate_button);
            goButton = (Button) itemView.findViewById(R.id.button_going);
            interestedButton = (Button) itemView.findViewById(R.id.button_interested);
            goingCount = (TextView) itemView.findViewById(R.id.count_going);
            interestedCount = (TextView) itemView.findViewById(R.id.count_interested);
        }
    }


}
