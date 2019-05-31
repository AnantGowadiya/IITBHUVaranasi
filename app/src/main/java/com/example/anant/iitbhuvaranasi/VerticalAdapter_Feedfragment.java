package com.example.anant.iitbhuvaranasi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
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


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView image, image_club;
        TextView title, date, council;
        CardView cardView;

        public MyViewHolder1(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_events);
            title = (TextView) itemView.findViewById(R.id.titles);
            council = (TextView) itemView.findViewById(R.id.event_title_council);
            date = (TextView) itemView.findViewById(R.id.event_dates);
            image_club = (ImageView) itemView.findViewById(R.id.event_image_club);
            cardView=itemView.findViewById(R.id.cardview_feedfragment);
        }
    }


}
