package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.anant.iitbhuvaranasi.FeedFragment.getHorizontalData;


public class HorizontalAdapter_Feedfragment extends RecyclerView.Adapter<HorizontalAdapter_Feedfragment.MyViewHolder> {

    ArrayList<SingleHorizontaldata> data = new ArrayList<>();
    private Context context;

    public HorizontalAdapter_Feedfragment(Context context,ArrayList<SingleHorizontaldata> data) {
        this.data = data;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_layout_feedfragment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.d("position",""+position);

        //holder.title.setText(data.get(position).getTitle());
        holder.image.setImageResource(data.get(position).getImage());
        if(data==getHorizontalData()){
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Clubs_group.class);
                intent.putExtra("image", data.get(position).getImage());
                context.startActivity(intent);
            }
        });
        }

        else{
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ClubFeed.class);
                    intent.putExtra("image", data.get(position).getImage());
                    context.startActivity(intent);
                }
            });
        }
        //holder.title.setText(data.get(position).getTitle());
        //Picasso.get().load(data.get(position).getImage()).into(holder.images);
        //Toast.makeText(FeedFragment.class, ""+position, Toast.LENGTH_SHORT).show();
        //Log.d("position",""+position);
        //Toast.makeText(context, ""+position, Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        Log.d("getitemcount",""+data.size());
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            //title = (TextView) itemView.findViewById(R.id.council_title);
            image = (ImageView) itemView.findViewById(R.id.council_image);
            linearLayout=itemView.findViewById(R.id.linearlayout_feedfragment);
        }
    }

}