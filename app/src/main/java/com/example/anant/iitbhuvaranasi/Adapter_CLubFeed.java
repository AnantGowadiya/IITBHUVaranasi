package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter_CLubFeed extends RecyclerView.Adapter<Adapter_CLubFeed.MyViewHolder1> {

    ArrayList<SingleVerticalData> data = new ArrayList<>();
    private Context mcontext;

    public Adapter_CLubFeed(ArrayList<SingleVerticalData> data, Context mcontext) {
        this.data = data;
        this.mcontext = mcontext;
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

        // holder.image.setTransitionName("imageTransition");

        // holder.image.setImageResource(data.get(position).getImage());
        //holder.image_club.setImageResource(data.get(position).getEvent_image_club());
        // Log.d("imageurlvertical",data.get(position).getImage());
        // Log.d("imageurlvertical2",data.get(position).getImage_club());
        holder.title.setText(data.get(position).getTitle());
       //  holder.club.setText(data.get(position).getClub());
        holder.date.setText(data.get(position).getDate());
        // Log.d("date",data.get(position).getDate());
        // Log.d("holderimage2",holder.image.toString());

        // holder.viewcount.setText(data.get(position).getViewcount());
       // holder.interestedcount.setText(data.get(position).getInterested());
        Glide.with(mcontext)
                .load(data.get(position).getImage())
                .placeholder(R.drawable.sntc)
                .error(R.drawable.amc_workshop)
                .fitCenter() // scale to fit entire image within ImageView
                .into(holder.image);
        /*Glide.with(mcontext)
                .load(data.get(position).getImage_club())
                .placeholder(R.drawable.sntc)
                .error(R.drawable.amc_workshop)
                .fitCenter() // scale to fit entire image within ImageView
                .into(holder.image_club);*/


        //  Picasso.with(mcontext).load(data.get(position).getImage()).fit().centerInside().into(holder.image);
        //Picasso.with(mcontext).load(data.get(position).getImage_club()).fit().centerInside().into(holder.image_club);

      /*  final Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(holder.image, "fullscreen");
        pairs[1] = new Pair<View, String>(holder.title, "feedtitle");
        pairs[2] = new Pair<View, String>(holder.date, "feed_date");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, Full_screen_imageActivity.class);
                ActivityOptions options1 = ActivityOptions.makeSceneTransitionAnimation((Activity) mcontext, pairs);
                intent.putExtra("image", data.get(position).getImage());
                mcontext.startActivity(intent, options1.toBundle());
            }
        });*/

        //final Pair<View, String> pair1 = Pair.create((View) holder.image, holder.image.getTransitionName());

      /*  holder.interestedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRequestQueue = Volley.newRequestQueue(mcontext);
                Integer notif_id = Integer.valueOf(data.get(position).getNotifid());
                String url = "http://iitbhuapp.tk/interested";
                Log.d("notifid_push",notif_id.toString());
                JSONObject obj = new JSONObject();
                try {
                    obj.put("roll", 18085016);
                    obj.put("notifid",notif_id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("push_info",obj.toString());

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("TAG", "Error: " + error.getMessage());
                    }
                });
                mRequestQueue.add(jsonObjectRequest);
            }
        });*/
   /*     holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,Feedfragment_notifcation_Activity.class);
                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity) mcontext, pairs);
                // ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, pair1);
                intent.putExtra("title",data.get(position).getTitle());
                intent.putExtra("date",data.get(position).getDate());
                intent.putExtra("image",data.get(position).getImage());
                mcontext.startActivity(intent,options.toBundle());
            }
        });*/
      /*  holder.shareEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                mcontext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });*/
      /*  holder.setReminder.setOnClickListener(new View.OnClickListener() {
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

        public ImageView image,image_club;
       public TextView title, date ,club, viewcount,goingCount;
        public ImageButton shareEvent, setReminder, mapLocation;
          public Button goButton, interestedButton;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            //image_club =  itemView.findViewById(R.id.event_image_club);
          //  club =  itemView.findViewById(R.id.event_title_club);
          //  viewcount= itemView.findViewById(R.id.event_viewcount);
            image =  itemView.findViewById(R.id.event_image);
            title =  itemView.findViewById(R.id.event_title);
            shareEvent =  itemView.findViewById(R.id.share_event_button2);
            date =  itemView.findViewById(R.id.event_dates);
            setReminder = itemView.findViewById(R.id.calendar_setevent);
             mapLocation =  itemView.findViewById(R.id.navigate_button);
          //  goButton =  itemView.findViewById(R.id.button_going);
         //   interestedButton =  itemView.findViewById(R.id.button_interested);
         //   goingCount =  itemView.findViewById(R.id.count_going);

        }
    }
}
