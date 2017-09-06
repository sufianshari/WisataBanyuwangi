package com.banyuwangi.wisatabanyuwangi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.banyuwangi.wisatabanyuwangi.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class PetaFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment sMapFragment;
    View view;
    public GoogleMap mMap;
    public PetaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_peta, container, false);

        getActivity().setTitle("Peta");

       // sMapFragment = SupportMapFragment.newInstance();
        sMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        sMapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng marker = new LatLng(-33.565, 151.343);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 13));

        mMap.addMarker(new MarkerOptions().title("Hello Google Maps").position(marker));
    }

    @Override
    public void onResume() {
        sMapFragment.onResume();
        super.onResume();
    }
}
