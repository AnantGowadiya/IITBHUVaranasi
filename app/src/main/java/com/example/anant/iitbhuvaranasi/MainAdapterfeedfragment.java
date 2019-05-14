package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import com.example.anant.iitbhuvaranasi.SingleVerticalData;
import com.example.anant.iitbhuvaranasi.SingleHorizontaldata;
import com.example.anant.iitbhuvaranasi.HorizontalAdapter_Feedfragment;
import com.example.anant.iitbhuvaranasi.VerticalAdapter_Feedfragment;
import com.example.anant.iitbhuvaranasi.R;

import static com.example.anant.iitbhuvaranasi.FeedFragment.getHorizontalData;
import static com.example.anant.iitbhuvaranasi.FeedFragment.getVerticalData;

public class MainAdapterfeedfragment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> items;
    private final int HORIZONTAL = 1;
    private final int VERTICAL = 2;


    public MainAdapterfeedfragment(Context context, ArrayList<Object> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {

            case HORIZONTAL:
                view = inflater.inflate(R.layout.horizontal_recycler_feedfragment, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
            case VERTICAL:
                view = inflater.inflate(R.layout.vertical_recycler_feedfragment, parent, false);
                holder = new VerticalViewHolder(view);
                break;

            default:
                view = inflater.inflate(R.layout.horizontal_recycler_feedfragment, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == HORIZONTAL)
            horizontalView((HorizontalViewHolder) holder);
        else if (holder.getItemViewType() == VERTICAL)
            verticalView((VerticalViewHolder) holder);
    }

    private void horizontalView(HorizontalViewHolder holder) {
        HorizontalAdapter_Feedfragment adapter = new HorizontalAdapter_Feedfragment(getHorizontalData());
        //holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void verticalView(VerticalViewHolder holder) {

        VerticalAdapter_Feedfragment adapter1 = new VerticalAdapter_Feedfragment(getVerticalData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter1);
    }




    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SingleHorizontaldata)
            return HORIZONTAL;
        if (items.get(position) instanceof SingleVerticalData)
            return VERTICAL;
        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }

}
