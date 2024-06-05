package com.example.weatherapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


final String APP_ID= "aa4c9b1bbbcafad0e337373a7485a342"
 final String WEATHER_URL= "https://home.openweathermap.org/data/2.5weather";

final long  MIN_TIME=5000;
final float MIN_DISTANCE=1000;
final int REQUEST_CODE=101;

String Location_Provider= LocationManager.GPS_PROVIDER;

TextView NameofCity,weatherState,Temperature;
ImageView mWeatherIcon;
RelativeLayout mCityFinder;

LocationManager locationManager;
LocationListener mLocationListner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        weatherState=findViewById(R.id.wheatherCondition);
        Temperature=findViewById(R.id.temperature);
        mWeatherIcon=findViewById(R.id.WheatherIcon);
        mCityFinder=findViewById(R.id.cityFinder);
        NameofCity=findViewById(R.id.cityName);

        mCityFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(packageContext:MainActivity.this.CityFinder.class);
                startActivity(intent);


            }
        });



    }
    @Override
    protected void onResume() {
        super.onResume();
        getweatherForCurrentLocation();
    }

    private void getweatherForCurrentLocation()
    {
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mLocationListner= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                String Latitude=String.valueOf(location.getLatitude());
                String Longitude=String.valueOf(location.getLongitude());


                RequestParams params =new RequestParams();
                params.put("lat",Latitude);
                params.put("lon",Longitude);
                params.put("appid",APP_ID);
                letsdoSomeNetworkin(params);



            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
            @Override
            public void onProviderEnabled(String provider) {

            }
            @Override
            public void onProviderDisabled(String provider) {
                  //not able to get location
            }
        };

        if(ActivityCompat.checkSelfPermission(context: this,Manifest.permission.ACCESS_FINE_LOCATION)
        // TODO: Consider calling
        // ActivityCompat#requestPermissions
        return;

       mlocationManager.requestLocationUpdates(Location_Provider,MIN_TIME,MIN_DISTANCE,mLocationListner);
    }

    @Override
    public void onRequestPermissionResult(int requestCode,@NonNull String [] permissions,@NonNull int[]grantResults){
          super.onRequestPermissionsResult(requestCode, permissions, grantResults);

          if(requestCode==REQUEST_CODE)
          {
              if(grantResults.length>0 && grantResults [0]==packagemanager.PERMISSION_GRANTED)
              {
                  Toast.makeText(context:MainActivity.this,text"Locationget Succesfully"),Toast.LENGTH_SHORT.show();
                  getweatherForCurrentLocation();
              }
          }
private void letsdoSomeNetworking(RequestParams params)
        {
            AsyncHttpClient client = new AsyncHttpClient();
            {


            }
        }
}
