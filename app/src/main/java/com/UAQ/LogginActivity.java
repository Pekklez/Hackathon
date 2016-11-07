package com.UAQ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LogginActivity extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_loggin);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);

        profile = Profile.getCurrentProfile();
        if(profile != null){
            Intent intent = new Intent(LogginActivity.this, MainActivity.class);
            intent.putExtra("idFacebook", profile.getId());
            intent.putExtra("userFb", profile.getName());
            startActivity(intent);
        }

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String idFacebook = loginResult.getAccessToken().getUserId();

                Profile profile = Profile.getCurrentProfile();
                Intent intent = new Intent(LogginActivity.this, MainActivity.class);
                intent.putExtra("idFacebook", idFacebook);
                intent.putExtra("userFb", profile.getName());
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

