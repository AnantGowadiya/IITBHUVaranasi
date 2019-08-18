package com.example.anant.iitbhuvaranasi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Feedfragment_notifcation_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView image_event;
    String image,time;
    String event_title,event_description,event_date,event_venue,event_time;
    TextView title_event, description_event, date_event, venue_event, time_event, going_count, view_count, interested_count;
    Button go_button, interested_button;
    ImageButton share_button, location_button, clock_button;
    SingleVerticalData obj;
    int image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedfragment_notifcation_);

        time=getIntent().getStringExtra("time");

        String json=getIntent().getStringExtra("all");
        Gson gson = new Gson();
        obj = gson.fromJson(json, SingleVerticalData.class);
        Log.d("poiuy",obj.getClub_name());

        title_event = findViewById(R.id.event_page_title);
        date_event = findViewById(R.id.event_page_date);
        image_event = findViewById(R.id.event_picture_2);
        share_button = (ImageButton) findViewById(R.id.share_event_button);
        share_button.setOnClickListener(this);
        venue_event = (TextView) findViewById(R.id.event_venue);
        location_button = (ImageButton) findViewById(R.id.location);
        description_event=findViewById(R.id.event_page_description);
        location_button.setOnClickListener(this);
        time_event = (TextView) findViewById(R.id.event_time);
        clock_button = (ImageButton) findViewById(R.id.clock);
        clock_button.setOnClickListener(this);
        go_button = (Button) findViewById(R.id.going_button);
        go_button.setOnClickListener(this);
        interested_button = (Button) findViewById(R.id.interested_button);
        interested_button.setOnClickListener(this);
        going_count = (TextView) findViewById(R.id.going_count);
        interested_count = (TextView) findViewById(R.id.interested_count);
        view_count = (TextView) findViewById(R.id.view_count);
       // title_event.setText(getIntent().getStringExtra("title"));
      //  date_event.setText(getIntent().getStringExtra("date"));
      //  image=getIntent().getStringExtra("image");

        title_event.setText(obj.getTitle_event());
        description_event.setText(obj.getDescription_event());
        Glide.with(this)
                .load(obj.getImage_event())
                .fitCenter() // scale to fit entire image within ImageView
                .into(image_event);
        date_event.setText(time);
        venue_event.setText(obj.getLocation());
        view_count.setText(obj.getViewcount());
        interested_count.setText(obj.getInterestedcount());






        final Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(image_event, "fullscreen");

        final LayoutInflater inflater = LayoutInflater.from(this);
        image_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(Feedfragment_notifcation_Activity.this);
                View View =inflater.inflate(R.layout.dialog_custom_layout_image1, null);
                PhotoView photoView1 = View.findViewById(R.id.imageView2);
                Glide.with(Feedfragment_notifcation_Activity.this)
                        .load(image)
                        .error(R.drawable.amc_workshop)
                        .fitCenter() // scale to fit entire image within ImageView
                        .into(photoView1);
                mBuilder1.setView(View);
                AlertDialog mDialog = mBuilder1.create();
                mDialog.show();
            }
        });




 }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clock:
                addEventToCalender(obj.getTitle_event(),obj.getDescription_event(),
                        obj.getLocation(),time);
            /*    Calendar beginTime = Calendar.getInstance();
                beginTime.set(2012, 0, 19, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2012, 0, 19, 8, 30);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE,"hke" )
                        .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                        //invitees emails
                        .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
                startActivity(intent);*/
                break;

            case R.id.share_event_button:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "#IIT BHU App\n"+ obj.getTitle_event().toString() + "\n"
                        + obj.getDescription_event().toString()
                        + "\n\n" + "Date & Time : " + time + "\nVenue : " +
                        obj.getLocation().toString() ;
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, obj.getTitle_event().toString());
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case R.id.going_button:

                break;

            case R.id.interested_button:

                break;

            case R.id.location:
                Intent intent1 = new Intent(this,Full_screen_imageActivity.class);
              startActivity(intent1);
               /* Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode("1st & Pike, Seattle"));
                Intent mapIntent= new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);*/
                break;

        }
    }

    public void addEventToCalender(String title,String description,String location,String time) {
        SharedPreferences sharedPref = getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
        String savedOption = sharedPref.getString(Constants.CALENDAR_DIALOG, Constants.CALENDAR_DIALOG_ALWAYS_ASK);
        if (savedOption.equals(Constants.CALENDAR_DIALOG_YES)) {
            createAddToCalendarIntent(title,description,location,time);
        } else if (savedOption.equals(Constants.CALENDAR_DIALOG_ALWAYS_ASK)) {
            showAddEventToCalendarDialog(title,description,location,time);
        }
    }

    public void showAddEventToCalendarDialog(final String title, final String description, final String location,final String time) {
        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(this);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View layout = layoutInflater.inflate(R.layout.calendar_dialog_checkbox, null);
        dialogBuilder.setView(layout);
        final CheckBox dontShowAgain = layout.findViewById(R.id.skip);

        dialogBuilder.setTitle("Add to Calendar")
                .setMessage("You will be notified about this event by InstiApp. Do you also want to add this event to your calendar?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Feedfragment_notifcation_Activity.this.createAddToCalendarIntent(title, description, location, time);
                        Feedfragment_notifcation_Activity.this.saveCalendarDialogPreference(dontShowAgain.isChecked(), true);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Feedfragment_notifcation_Activity.this.saveCalendarDialogPreference(dontShowAgain.isChecked(), false);
                    }
                })
                .create()
                .show();
    }

    public void createAddToCalendarIntent(String title,String description,String location,String time) {

        DateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy hh:mm a");
        long lnsTime = 0, lneTime = 0;
        Date dateObject = null;
        try {
            dateObject = formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lnsTime = dateObject.getTime();
        Calendar cal = Calendar.getInstance();

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", lnsTime);
        Log.d("34567", String.valueOf(cal.getTimeInMillis()));
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,0);
        intent.putExtra("endTime", lnsTime+60*60*1000*2);
        intent.putExtra(CalendarContract.Events.TITLE, title);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, description);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location);
        intent.putExtra("eventTimezone", "UTC/GMT +5:30");
         /*   startActivity(intent);
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType("vnd.android.cursor.item/event");

            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, starttime);
            intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,"6789");
            intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,1);

            intent.putExtra(CalendarContract.Events.TITLE, title);
            intent.putExtra(CalendarContract.Events.DESCRIPTION, description);
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location);*/

        startActivity(intent);
    }

    private void saveCalendarDialogPreference(boolean dontAskAgain, boolean yes) {
        SharedPreferences sharedPref = getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (!dontAskAgain) {
            editor.putString(Constants.CALENDAR_DIALOG, Constants.CALENDAR_DIALOG_ALWAYS_ASK);
            editor.commit();
        } else {
            if (yes) {
                editor.putString(Constants.CALENDAR_DIALOG, Constants.CALENDAR_DIALOG_YES);
                editor.commit();
            } else {
                editor.putString(Constants.CALENDAR_DIALOG, Constants.CALENDAR_DIALOG_NO);
                editor.commit();
            }
        }
    }
}
