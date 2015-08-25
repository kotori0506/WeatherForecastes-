package com.example.ktr.weatherforecastes;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by ktr on 15/08/25.
 */
public class GetWeatgerForecastApiTask extends AsyncTask<String,Void,String>{

    private final Context context;
    Exception exception;

    public GetWeatgerForecastApiTask(Context context){
        this.context=context;
    }

    @Override
    protected String doInBackground(String...params) {
        try {
            return WeatherApi.getWeather(context, params[0]);
        } catch (IOException e) {
            exception = e;
        }
        return null;
    }
}
