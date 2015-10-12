package com.example.ktr.weatherforecastes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


//import android.view.Menu;
//import android.view.MenuItem;


public class MainActivity extends Activity {


    private TextView textView;

    private class WeatherForecastTask extends WeatherForecastApiTask {


        public WeatherForecastTask(Context context) {
            super(context);
        }
    }




    @Override
    protected void onPostExeute(String date) {
        super.onPostExeute(date);
        if (date != null) {
            textView.setText(date);
        } else if (exception != null) {
            Toast.makeText(MainActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_main);


        new WeatherForecastTask(this).execute("400040");

    }

}


