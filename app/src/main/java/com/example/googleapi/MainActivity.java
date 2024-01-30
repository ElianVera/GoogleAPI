package com.example.googleapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity
        extends FragmentActivity
        implements OnMapReadyCallback {

        GoogleMap map;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
        @Override
        public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        map.getUiSettings().setZoomControlsEnabled(true);

            LatLng madrid = new LatLng(40.68920666153311, -74.04457014124193);

            CameraPosition camPos = new CameraPosition.Builder()
                    .target(madrid)
                    .zoom(25)
                    .bearing(10)      //noreste arriba
                    .tilt(25)         //punto de vista de la cámara 70 grados
                    .build();

            CameraUpdate camUpd3 =
                    CameraUpdateFactory.newCameraPosition(camPos);

            map.animateCamera(camUpd3);



        }

}