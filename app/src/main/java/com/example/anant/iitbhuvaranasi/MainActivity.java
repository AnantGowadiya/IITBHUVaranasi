package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    SharedPreferences sharedpreferences;
    private static RequestQueue mRequestQueue;
    public static ArrayList<SingleVerticalData> getVerticalData1 = new ArrayList<>();
    public static ArrayList<SingleHorizontaldata>getHorizontalData1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Splash Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        /**
         * Volley
         */
        sharedpreferences = getSharedPreferences("dataourTeam", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_main);
        mRequestQueue = Volley.newRequestQueue(this);
        String url = "http://iitbhuapp.tk/feedandclubs";
        JSONObject obj = new JSONObject();
        try {
            obj.put("roll", 18085016);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                SharedPreferences.Editor editor = sharedpreferences.edit();

                String response1 = response.toString();
                editor.putString("response", response1);
                editor.commit();



                Log.d("Response00", response.toString());

                try {
                    int status = response.getInt("status");
                    Log.d("status00", Integer.toString(status));
                    if (status == 1) {

                        Log.d("status100", "1");

                        JSONArray jsonArray = response.getJSONArray("notif");
                        JSONArray array = response.getJSONArray("councils");

                        for (int j = 0; j < array.length(); j++){
                            JSONObject hit1 = array.getJSONObject(j);
                            String image_council = "http://iitbhuapp.tk" + hit1.getString("image");
                            //  Log.d("clubname", name);
                            //Log.d("imageurl",image_council);

                            getHorizontalData1.add(new SingleHorizontaldata(image_council));
                        }
                        Log.d("horizontaldata234500", getHorizontalData1.toString());




                        for (int i = jsonArray.length() - 1; i >= 0; i--) {
                            JSONObject hit = jsonArray.getJSONObject(i);

                            // store in share opref hit.toString()
                            // update last post number
                            // read shared pref and add vertical ddata section

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
                            getVerticalData1.add(new SingleVerticalData(club,title,date,image_club, image,viewcount,interested,notifid));
                            Log.d("verticalse00",getVerticalData1.toArray().toString());

                            Log.d("imageurl00", image);
                            Log.d("verticaldataori00",getVerticalData1.toString());

                        }
                        Log.d("getverticaldata100",getVerticalData1.toString());



                    } else {
                        Log.d("status000", "0");
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
       // Log.d("getverticaldata1000",getVerticalData2.toString());

        getSupportActionBar().hide();

        videoView = (VideoView)findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.animated_logo);
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startActivity(new Intent(MainActivity.this,SignInActivity.class));
                finish();
            }
        });

        videoView.start();
    }

    /*public static ArrayList<SingleHorizontaldata> getHorizontalData() {
        final ArrayList<SingleHorizontaldata> singleHorizontals = new ArrayList<>();
        //singleHorizontals.add(new SingleHorizontaldata("https://old.iitbhu.ac.in/imag/it2.png"));
        String url = "http://iitbhuapp.tk/feedandclubs";
        Log.d("singlehorizontaladd","hardcode");
        JSONObject object = new JSONObject();
        try {
            object.put("roll", 18085016);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

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
        mRequestQueue.add(request);
        Log.d("singlehorizontalfinal", singleHorizontals.toString());
        // singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));
        // singleHorizontals.add(new SingleHorizontaldata("https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg"));
        Log.d("beforereturnhorizontal", "singlehorizontal");
        return singleHorizontals;
    }*/
}
