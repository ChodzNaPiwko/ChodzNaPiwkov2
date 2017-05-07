package com.example.lorenc.p1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.net.URL;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Lokalizacje
        LatLng spiz = new LatLng(51.110116, 17.031189);
        LatLng remontbar = new LatLng(51.111487, 17.058608);
        LatLng schody = new LatLng(51.109123,17.028743);
        //lokalizacja uzytkownika
        mMap.setMyLocationEnabled(true);
        //markery
        mMap.addMarker(new MarkerOptions()
                .position(spiz)
                .title("Spiż")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .snippet("Opis baru"));
        mMap.addMarker(new MarkerOptions().position(remontbar).title("Remont Bar")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .snippet("Opis baru"));
        mMap.addMarker(new MarkerOptions().position(schody).title("Schody do nikąd")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .snippet("Opis baru"));


        //greanice
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(spiz)
                .include(remontbar)
                .include(schody)
                .build();

        //mMap.setLatLngBoundsForCameraTarget(bounds);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(bounds.getCenter()));
        mMap.setMinZoomPreference(12);

    }
}

