package com.example.complaintbox;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
   Spinner spinner;
   CheckBox checkBox;
   EditText editText;
   TextView textView;
   Button button;
   ArrayList<String> problems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText2);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView2);
        spinner=findViewById(R.id.spinner3);
        autoCompleteTextView1=findViewById(R.id.autoCompleteTextView3);
        checkBox=findViewById(R.id.checkBox);
        textView=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        problems.add("Academics");
        problems.add("Hostel Facilities");
        problems.add("Mess Facilities");
        problems.add("others");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,problems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,problems);
        autoCompleteTextView.setAdapter(adapter);
        spinner.setAdapter(adapter1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("I am aware that if will misuse this facility by any way I would be deregistered from this app")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendmail();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Alert!");
                alert.show();
            }
        });
    }
    private void  sendmail() {

    String recipientlist ="piyushsingh.eee18@itbhu.ac.in";
    String[] recipients = recipientlist.split(",");
    String subject = editText.getText().toString();
    String message = autoCompleteTextView1.getText().toString();

        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT ,subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose an email client"));






    }
}
