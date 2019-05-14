package com.example.anant.iitbhuvaranasi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HorizontalAdapter_Feedfragment extends RecyclerView.Adapter<HorizontalAdapter_Feedfragment.MyViewHolder> {

    ArrayList<SingleHorizontaldata> data = new ArrayList<>();

    public HorizontalAdapter_Feedfragment(ArrayList<SingleHorizontaldata> data) {
        this.data = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_layout_feedfragment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText(data.get(position).getTitle());
        holder.image.setImageResource(data.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.council_title);
            image = (ImageView) itemView.findViewById(R.id.council_image);
        }
    }

}
