package com.example.anant.iitbhuvaranasi;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class FeedFragment extends Fragment {
    public static ArrayList<Object> objects = new ArrayList<>();

    private RecyclerView mRecyclerView;


    SwipeRefreshLayout swipeRefreshLayout;
    private ListAdapter mListadapter;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.feed_fragment, container, false);

        RecyclerView.RecycledViewPool sharedPool = new RecyclerView.RecycledViewPool();



        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
       mRecyclerView.setRecycledViewPool(sharedPool);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        //At this point the layout is complete and the
                        //dimensions of recyclerView and any child views are known.
                        //Remove listener after changed RecyclerView's height to prevent infinite loop
                        mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });


        MainAdapterfeedfragment adapter = new MainAdapterfeedfragment(getActivity(), getObject());
        adapter.notifyDataSetChanged();
        adapter.setHasStableIds(true);

        mRecyclerView.setAdapter(adapter);



/*


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       //mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        MainAdapterfeedfragment adapter = new MainAdapterfeedfragment(getActivity(), objects);
        adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(adapter);*/

        return view;
    }



    private ArrayList<Object> getObject() {

        objects.add(getHorizontalData().get(0));
        objects.add(getVerticalData().get(0));
        return objects;
    }
    //String url= "https://firebasestorage....."
     //Glide.with(getApplicationContext()).load(url).into(imageView);

   /* public static ArrayList<SingleHorizontaldata> getHorizontalData() {
        ArrayList<SingleHorizontaldata> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.culturalcouncil, "Cultural Council"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.fmc, "Film and Media Council"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.ssc, "Social Service Council"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.gamesnsportscouncil, "Games and Sports Council"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.ecell, "E Cell"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.sntc, "Science and Technology Council"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.saic, "Student Alumni Interaction Cell"));
        //singleHorizontals.add(new SingleHorizontaldata(R.drawable.E Cell, "Student's Parliament"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.tpc, "Training and Placement Cell"));
        return singleHorizontals;
    }*/

   public static ArrayList<SingleHorizontaldata> getHorizontalData() {
        ArrayList<SingleHorizontaldata> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.culturalcouncil));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.fmc));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.ssc));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.gamesnsportscouncil ));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.ecell ));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.sntc));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.saic));
        //singleHorizontals.add(new SingleHorizontaldata(R.drawable.E Cell, "Student's Parliament"));
        singleHorizontals.add(new SingleHorizontaldata(R.drawable.tpc ));
        return singleHorizontals;
    }

    public static ArrayList<SingleVerticalData> getVerticalData() {
        ArrayList<SingleVerticalData> singleVerticals = new ArrayList<>();
       // singleVerticals.add(new SingleVerticalData("SAIC", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", R.drawable.saic));
        singleVerticals.add(new SingleVerticalData("SNTC","Introductory Workshop DFZ - Dance Club", "Saturday, 25 August 2018",R.drawable.dfz_workshop, R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("SAIC","Quadcopter Workshop","Thursday, 1 November 2018",R.drawable.amc_workshop, R.drawable.sntc));

        singleVerticals.add(new SingleVerticalData("FMC","Water Rocket Pro", "2 Sep 2017 ",R.drawable.amc_waterrocket1, R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("CULTURAL","Quadcopter Workshop","Thursday, 1 November 2018",R.drawable.amc_workshop, R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("CULTURAL","Water Rocket Pro", "2 Sep 2017 ",R.drawable.amc_waterrocket1, R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("SNTC","Introductory Workshop DFZ - Dance Club", "Saturday, 25 August 2018",R.drawable.dfz_workshop, R.drawable.sntc));

        //singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
       // singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
       // singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
        return singleVerticals;
    }


}
