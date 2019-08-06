package com.example.anant.iitbhuvaranasi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.anant.iitbhuvaranasi.MainActivity.getHorizontalData1;
import static com.example.anant.iitbhuvaranasi.MainActivity.getVerticalData1;

//import android.util.Log;
//import android.util.Log;
//import android.util.Log;


public class FeedFragment extends Fragment {
    private ArrayList<Object> objects = new ArrayList<>();
   // public static Integer i=0;

    private RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.feed_fragment, container, false);

        RecyclerView.RecycledViewPool sharedPool = new RecyclerView.RecycledViewPool();




        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
       // mRecyclerView.setRecycledViewPool(sharedPool);

        Log.d("fe",getVerticalData1.toString());
        Log.d("fe",getHorizontalData1.toString());

        mRecyclerView.setHasFixedSize(true);

        Log.d("beforemainadapter","009");
        MainAdapterfeedfragment adapter = new MainAdapterfeedfragment(getActivity(), getObject());
        Log.d("aftermainadapter","009");
        //Log.d("getobjectstart",getObject().toString());
        adapter.notifyDataSetChanged();
       // adapter.setHasStableIds(true);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


    private ArrayList<Object> getObject() {
        objects.add(getHorizontalData1);
        objects.add(getVerticalData1);

       // Log.d("horizontalarray234",getHorizontalData1.toString());
        return objects;
    }







}
