package com.UAQ;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LogginActivity.class);
        startActivity(intent);
        finish();
    }

}