package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.anant.iitbhuvaranasi.FeedFragment.getHorizontalData;
import static com.example.anant.iitbhuvaranasi.FeedFragment.getVerticalData;


public class MainAdapterfeedfragment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context3;
    private ArrayList<Object> items;
    private final int HORIZONTAL = 0;
    private final int VERTICAL = 1;


    public MainAdapterfeedfragment(Context context3, ArrayList<Object> items) {
        this.context3 = context3;
        this.items = items;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            RecyclerView.ViewHolder holder;
           // Toast.makeText(context, "Hello" + viewType, Toast.LENGTH_LONG).show();

            switch (viewType) {

                case HORIZONTAL:
                    View view1 = inflater.inflate(R.layout.horizontal_recycler_feedfragment, parent, false);
                    holder = new HorizontalViewHolder(view1);
                    break;
                case VERTICAL:
                    View view2 = inflater.inflate(R.layout.vertical_recycler_feedfragment, parent, false);
                    holder = new VerticalViewHolder(view2);
                    break;

                default:
                    View view3 = inflater.inflate(R.layout.vertical_recycler_feedfragment, parent, false);
                    holder = new VerticalViewHolder(view3);
                    break;
            }



            return holder;
        }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       // Toast.makeText(context, "Hello"+position, Toast.LENGTH_LONG).show();
       if(position==0||position==1) {

           switch (holder.getItemViewType()) {
               case HORIZONTAL:
                   horizontalView((HorizontalViewHolder) holder);
                   break;
               case VERTICAL:
                   verticalView((VerticalViewHolder) holder);
                   break;
               default:
                   verticalView((VerticalViewHolder) holder);
                   break;
           }
       }


        /*if (holder.getItemViewType() == HORIZONTAL)
            horizontalView((HorizontalViewHolder) holder);
        else if (holder.getItemViewType() == VERTICAL)
            verticalView((VerticalViewHolder) holder);*/
    }



    private void horizontalView(HorizontalViewHolder holder) {
        //Toast.makeText(context, "Hello" + holder, Toast.LENGTH_LONG).show();
        Log.d("holder",""+holder);
        HorizontalAdapter_Feedfragment adapter = new HorizontalAdapter_Feedfragment(context3,getHorizontalData());
        //holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context3, 2, GridLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
        //holder.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, VERTICAL));
        //holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    private void verticalView(VerticalViewHolder holder) {

        VerticalAdapter_Feedfragment adapter1 = new VerticalAdapter_Feedfragment(context3,getVerticalData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context3));
        holder.recyclerView.setAdapter(adapter1);
    }



    @Override
    public int getItemCount() {
        return items.size();

    }

    @Override
    public int getItemViewType(int position) {
        Log.d("getitemviewtypr",""+position);
        if(position==0) {

            if (items.get(position) instanceof SingleHorizontaldata)
                return HORIZONTAL;
            if (items.get(position) instanceof SingleVerticalData)
                return VERTICAL;
        }
        return -1;

        /*switch(position) {

            case 0:
            if (items.get(position) instanceof SingleHorizontaldata) {
                return HORIZONTAL;

            }
            else
                return VERTICAL;

            *//*if (items.get(position) instanceof SingleVerticalData)
                return VERTICAL;*//*


           *//* case 1:
                if (items.get(position) instanceof SingleHorizontaldata)
                    return HORIZONTAL;
                if (items.get(position) instanceof SingleVerticalData)
                    return VERTICAL;

            break;*//*
        }
        return -1;*/
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
