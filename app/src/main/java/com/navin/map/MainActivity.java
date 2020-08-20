package com.navin.map;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    GPSTracker gpsTracker;
    double longitude;
    double latitude;
    List<Address> addressList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gpsTracker = new GPSTracker(this);
        new GetLocation().execute();


    }


    class GetLocation extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            if (gpsTracker.canGetLocation) {
                latitude = gpsTracker.getLatitude();
                longitude = gpsTracker.getLongitude();
               final Geocoder geocoder = new Geocoder(getApplicationContext());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            addressList = geocoder.getFromLocation(35.87821333333333, 50.97706166666667, 1);
                            Log.e("", "");

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            } else
                gpsTracker.showSettingsAlert();
            return null;
        }
    }
}


