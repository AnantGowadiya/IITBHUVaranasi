package com.example.anant.iitbhuvaranasi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter_CLubFeed extends RecyclerView.Adapter<Adapter_CLubFeed.MyViewHolder1> {

    ArrayList<SingleVerticalData> data = new ArrayList<>();
    private Context context1;

    public Adapter_CLubFeed(ArrayList<SingleVerticalData> data, Context context1) {
        this.data = data;
        this.context1 = context1;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_feed_layout_recyclerview, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, final int position) {
        Log.d("position209",Integer.toString(position));

       holder.title.setText(data.get(position).getTitle());
        holder.date.setText(data.get(position).getDate());

            Glide.with(context1)
                .load(data.get(position).getImage())
                .placeholder(R.drawable.sntc)
                .error(R.drawable.amc_workshop)
                .fitCenter() // scale to fit entire image within ImageView
                .into(holder.image);

        /*holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context1,Feedfragment_notifcation_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


             context1.startActivity(intent);
            }
        });*/

        final Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(holder.image, "fullscreen");
        pairs[1] = new Pair<View, String>(holder.title, "feedtitle");
        pairs[2] = new Pair<View, String>(holder.date, "feed_date");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context1, Full_screen_imageActivity.class);
               ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation((Activity) context1, pairs);
                intent.putExtra("image", data.get(position).getImage());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context1.startActivity(intent,options1.toBundle());
            }
        });

        final Pair<View, String> pair1 = Pair.create((View) holder.image, holder.image.getTransitionName());

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context1,Feedfragment_notifcation_Activity.class);
              // ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) context1, pairs);
                // ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, pair1);
                intent.putExtra("title",data.get(position).getTitle());
                intent.putExtra("date",data.get(position).getDate());
                intent.putExtra("image",data.get(position).getImage());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context1.startActivity(intent);
            }
        });

    /*    holder.setReminder.setOnClickListener(new View.OnClickListener() {
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
        });*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder{

        public ImageView image;
       public TextView title, date ;
        public ImageButton shareEvent, setReminder, mapLocation;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
               image =  itemView.findViewById(R.id.event_image);
            title =  itemView.findViewById(R.id.event_title);
            shareEvent =  itemView.findViewById(R.id.share_event_button2);
            date =  itemView.findViewById(R.id.event_dates);
            setReminder = itemView.findViewById(R.id.calendar_setevent);
             mapLocation =  itemView.findViewById(R.id.navigate_button);

        }
    }
}
