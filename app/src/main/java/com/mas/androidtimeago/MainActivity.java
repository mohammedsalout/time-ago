package com.mas.androidtimeago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mas.gettime.GetTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // current time when test is :2020-12-09T21:03:32.000000Z

        String just_now = "2021-06-14T17:26:14.000000Z";
        String a_minute_ago = "2020-12-09T21:02:32.000000Z";
        String before_x_min = "2020-12-09T20:55:32.000000Z";
        String before_1_Hour = "2020-12-09T19:59:32.000000Z";
        String before_1_day = "2020-12-08T20:53:09.000000Z";
        String before_2_day = "2020-12-06T22:53:09.000000Z";
        String more_5_days = "2020-11-25T03:09:09.000000Z";


        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);


        // the server millis time zone is the server time zone it will be positive or negative
        // If server zone time is +2 then the he server millis time zone = 2h*60m*60s*10000 =  7200000
        //If server zone time is -2 then the he server millis time zone = -2h*60m*60s*10000 = -7200000




        // the time as text
        Log.e("MAS_TAG","just_now     : "+ GetTime.getTimeAgo(MainActivity.this, just_now, formatter,0));
        Log.e("MAS_TAG","a minute ago : "+ GetTime.getTimeAgo(MainActivity.this, a_minute_ago, formatter ,0));
        Log.e("MAS_TAG","before_x_min : "+ GetTime.getTimeAgo(MainActivity.this, before_x_min, formatter,0));
        Log.e("MAS_TAG","before_1_Hour: "+ GetTime.getTimeAgo(MainActivity.this, before_1_Hour, formatter,0));
        Log.e("MAS_TAG","before_1_day : "+ GetTime.getTimeAgo(MainActivity.this, before_1_day, formatter,0));
        Log.e("MAS_TAG","before_2_day : "+ GetTime.getTimeAgo(MainActivity.this, before_2_day, formatter,0));
        Log.e("MAS_TAG","more 5 days  : "+ GetTime.getTimeAgo(MainActivity.this, more_5_days, formatter,0));



        // if you want to use time in millis
        Log.e("MAS_TAG","just_now   ts  : "+ GetTime.getTimeAgo(MainActivity.this, 1607535180000L , 0));



        findViewById(R.id.btnCheck)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("MAS_TAG","just_now     : "+ GetTime.getTimeAgo(MainActivity.this, just_now, formatter,0));
                    }
                });


    }
}