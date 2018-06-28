package com.example.cesargardellim.dm_final;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by cesargardellim on 27/06/18.
 */

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    //Localização de start
    double lat = -23.161863;
    double longi = -45.795248;
    LatLng ll = new LatLng(lat, longi);




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_maps,container,false);
    }//onCreate


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);
        mMap.addMarker(new MarkerOptions().position(ll).title("FATEC SJC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        mMap.animateCamera(zoom, 8000, null);

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

}
