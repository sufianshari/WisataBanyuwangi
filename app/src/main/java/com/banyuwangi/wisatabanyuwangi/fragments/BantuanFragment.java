package com.banyuwangi.wisatabanyuwangi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.banyuwangi.wisatabanyuwangi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BantuanFragment extends Fragment {


    public BantuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bantuan, container, false);

        getActivity().setTitle("Bantuan");

        return v;
    }

}
