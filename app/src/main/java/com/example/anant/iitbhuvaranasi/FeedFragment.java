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

      /* public static ArrayList<SingleVerticalData> getVerticalData1() {
       RequestQueue mRequestQueue;
        final ArrayList<SingleVerticalData> singleVerticals = new ArrayList<>();


      // mRequestQueue = Volley.newRequestQueue();
        JSONObject obj = new JSONObject();
       try {
           obj.put("roll", 18085061);
       } catch (JSONException e) {
           e.printStackTrace();
       }
       String url = "http://iitbhuapp.tk/feed";
       JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               Log.d("Response", response.toString());

               try {
                   int status = response.getInt("status");
                   Log.d("status", Integer.toString(status));
                   if (status == 1) {

                       Log.d("status1", "1");

                       JSONArray jsonArray = response.getJSONArray("notif");
                       JSONObject hit = jsonArray.getJSONObject(1);
                       String club=hit.getString("club");
                       String title=hit.getString("title");
                       String date=hit.getString("datetime");
                       String image_club="http://iitbhuapp.tk"+hit.getString("clubimage");
                       String image="http://iitbhuapp.tk"+hit.getString("image");
                       Integer viewcount=hit.getInt("viewedcount");
                       Integer interested=hit.getInt("interestedcount");
                       singleVerticals.add(new SingleVerticalData(club,title,date,image_club, image,viewcount,interested));
                        Log.d("singleverticalarray",singleVerticals.toString());
                   } else {
                       Log.d("status0", "0");
                   }


               } catch (JSONException e) {
                   e.printStackTrace();
               }

           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               VolleyLog.d("TAG", "Error: " + error.getMessage());

           }
       });
      // mRequestQueue.add(request);


        return singleVerticals;
    }*/
 /*public static ArrayList<SingleVerticalData> getVerticalData() {
      final ArrayList<SingleVerticalData> singleVerticals = new ArrayList<>();
       // String url = "http://iitbhuapp.tk/feed";

                singleVerticals.add(new SingleVerticalData("SNTC", "Introductory Workshop DFZ - Dance Club", "Saturday, 25 August 2018", "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg", "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg", "1", "2", "2"));
                i++;

         Log.d("singleverticaladd","hardcode");
        String url_clubs="http://iitbhuapp.tk/clubsandcouncils";
        JSONObject obj = new JSONObject();
        try {
            obj.put("roll", 18085016);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url_clubs,obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // Log.d("Response", response.toString());

                try {
                    int status = response.getInt("status");
                   // Log.d("status", Integer.toString(status));
                    if (status == 1) {

                        //Log.d("status1", "1");
                        Log.d("singleVerticalbeforech",singleVerticals.toString());


                        JSONArray jsonArray = response.getJSONArray("councils");
                        if(singleVerticals.toArray().length<=(jsonArray.length()+1)){



                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject hit = jsonArray.getJSONObject(i);

                            // String name = hit.getString("name");
                            String image_council = "http://iitbhuapp.tk" + hit.getString("image");
                            //  Log.d("clubname", name);
                            //Log.d("imageurl1313",image_council);

                            singleVerticals.add(new SingleVerticalData("SNTC", "Introductory Workshop DFZ - Dance Club", "Saturday, 25 August 2018", image_council, "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg", "1", "2", "2"));
                            String a = Integer.toString(singleVerticals.toArray().length);
                            Log.d("singleVerticalafterch",singleVerticals.toString());

                        }

                        }
                    } else {
                        //Log.d("status0", "0");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());

            }
        });
        mRequestQueue.add(request);
        Log.d("singleVerticalfinal",singleVerticals.toString());
        Log.d("beforereturnvertical", "singlehorizontal");
        return singleVerticals;

    }*/
     /* JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    int status = response.getInt("status");
                    Log.d("status", Integer.toString(status));
                    if (status == 1) {

                        Log.d("status1", "1");

                        JSONArray jsonArray = response.getJSONArray("notif");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject hit = jsonArray.getJSONObject(i);


                            String club=hit.getString("club");
                            String title=hit.getString("title");
                            String date=hit.getString("datetime");
                            Integer notification_id=hit.getInt("notifid");
                            Interestedbutton_class.notification_id=notification_id;
                            String image_club="http://iitbhuapp.tk"+hit.getString("clubimage");
                            String image="http://iitbhuapp.tk"+hit.getString("image");
                            Integer viewcount1=hit.getInt("viewedcount");
                            Integer interested1=hit.getInt("interestedcount");
                            Integer notif_id=hit.getInt("notifid");
                            String notifid=notif_id.toString();
                            String viewcount=viewcount1.toString();
                            String interested=interested1.toString();
                            singleVerticals.add(new SingleVerticalData(club,title,date,image_club, image,viewcount,interested,notifid));
                            Log.d("verticalse",singleVerticals.toArray().toString());

                            Log.d("imageurl", image);
                            Log.d("verticaldataori",singleVerticals.toString());

                        }
                        Log.d("getverticaldata1",singleVerticals.toString());

                    } else {
                        Log.d("status0", "0");
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());

            }
        });
        mRequestQueue.add(request);*/
    //Log.d("singleverticalfinal",singleVerticals.toString());

        /* public static ArrayList<SingleVerticalData> getVerticalData1(String club, String title, String date, String image_club, String image, int viewcount, int interested) {
        ArrayList<SingleVerticalData> singleVerticals = new ArrayList<>();
        singleVerticals.add(new SingleVerticalData(club,title,date,image_club, image,viewcount,interested));

        return singleVerticals;
    }
*/


    /* public static ArrayList<SingleHorizontaldata> getHorizontalData() {
        final ArrayList<SingleHorizontaldata> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontaldata("https://old.iitbhu.ac.in/imag/it2.png"));
        String url_clubs = "http://iitbhuapp.tk/clubsandcouncils";
        Log.d("singlehorizontaladd","hardcode");
        JSONObject object = new JSONObject();
        try {
            object.put("roll", 18085016);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.POST, url_clubs, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Log.d("Response", response.toString());

                try {
                    int status = response.getInt("status");
                    //Log.d("status", Integer.toString(status));
                    if (status == 1) {

                        // Log.d("status1", "1");

                        JSONArray jsonArray = response.getJSONArray("councils");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject hit = jsonArray.getJSONObject(i);

                            // String name = hit.getString("name");
                            String image_council = "http://iitbhuapp.tk" + hit.getString("image");
                            //  Log.d("clubname", name);
                            //Log.d("imageurl",image_council);

                            singleHorizontals.add(new SingleHorizontaldata(image_council));
                            Log.d("horizontaldata2345", singleHorizontals.toString());
                        }
                    } else {
                        // Log.d("status0", "0");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());

            }
        });
        mRequestQueue.add(request1);
        Log.d("singlehorizontalfinal", singleHorizontals.toString());
        // singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));
        // singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));
        Log.d("beforereturnhorizontal", "singlehorizontal");
        return singleHorizontals;
    }*/

    /*public static ArrayList<SingleHorizontaldata> getHorizontalData() {
        final ArrayList<SingleHorizontaldata> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));
        singleHorizontals.add(new SingleHorizontaldata("https://old.iitbhu.ac.in/imag/it2.png"));
        singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));



        Log.d("singlehorizontaladd","hardcode");
        Log.d("singlehorizontalfinal", singleHorizontals.toString());
         // singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));
        Log.d("beforereturnhorizontal", "singlehorizontal");
        Log.d("horizontalarray23",getHorizontalData.toString());

        return singleHorizontals;
    }*/







}
