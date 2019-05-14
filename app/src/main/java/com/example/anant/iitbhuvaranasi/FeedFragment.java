package com.example.anant.iitbhuvaranasi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.recyclerview.extensions.ListAdapter;
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
import com.example.anant.iitbhuvaranasi.MainAdapterfeedfragment;


public class FeedFragment extends Fragment {
    private ArrayList<Object> objects = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.feed_fragment,container,false);

        View view = inflater.inflate(R.layout.feed_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MainAdapterfeedfragment adapter = new MainAdapterfeedfragment(getActivity(), getObject());
        mRecyclerView.setAdapter(adapter);

        /*MainAdapterfeedfragment adapter = new MainAdapterfeedfragment(getActivity());
        mRecyclerView.setAdapter(adapter);*/



        return view;
    }

    private ArrayList<Object> getObject() {
        objects.add(getHorizontalData().get(0));
        objects.add(getVerticalData().get(0));
        return objects;
    }




        public static ArrayList<SingleHorizontaldata> getHorizontalData() {
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
        }

    public static ArrayList<SingleVerticalData> getVerticalData() {
        ArrayList<SingleVerticalData> singleVerticals = new ArrayList<>();
        singleVerticals.add(new SingleVerticalData("SAIC", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", R.drawable.saic));
        singleVerticals.add(new SingleVerticalData("E CELL", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", R.drawable.ecell));
        singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
        singleVerticals.add(new SingleVerticalData("AMC", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.drawable.sntc));
        return singleVerticals;
    }


}
