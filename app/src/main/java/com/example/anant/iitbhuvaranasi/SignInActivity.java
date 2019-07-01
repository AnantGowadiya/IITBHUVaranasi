package com.example.anant.iitbhuvaranasi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN =1 ;
    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;
    private  static final int REQ_CODE = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    private  GoogleSignInOptions gso;
    private String email,imageUri;
    private Uri personphoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("LOGIN");


        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        signInButton = (SignInButton) findViewById(R.id.siginbutton);
        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.siginbutton:
                signIn();
                break;



        }
    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }


    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            email = account.getEmail();
            personphoto = account.getPhotoUrl();
            if(personphoto == null)
            {
                imageUri =  "no value";
            }
            else
            {
                imageUri = personphoto.toString();
            }
            // Signed in successfully, show authenticated UI.
            if(isEmailValid2(email)==true || isEmailValid1(email)==true)
            {updateUI("true");}
            else
            {
                updateUI("invalid");
            }
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
            updateUI("false");
        }
    }

    private void updateUI(String result) {
        if(result == "true")
        {
            Intent intent= new Intent(SignInActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else if(result == "invalid")
        {
            Toast.makeText(SignInActivity.this,"Select Valid Institute Email-id",Toast.LENGTH_SHORT).show();
            signout();
        }
        else if(result == "false")
        {
            Toast.makeText(SignInActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
            signout();
        }
    }

    public static boolean isEmailValid1(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@itbhu.ac.in";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    public static boolean isEmailValid2(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@iitbhu.ac.in";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        UpdateUI(account);
    }

    private void UpdateUI(GoogleSignInAccount account) {
        if(account != null)
        {
            Intent intent= new Intent(SignInActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void signout() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
        SharedPreferences spreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor spreferencesEditor = spreferences.edit();
        spreferencesEditor.clear();
        spreferencesEditor.commit();
    }
}
