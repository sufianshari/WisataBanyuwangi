package com.banyuwangi.wisatabanyuwangi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.activity.AtmActivity;
import com.banyuwangi.wisatabanyuwangi.activity.HotelActivity;
import com.banyuwangi.wisatabanyuwangi.activity.IbadahActivity;
import com.banyuwangi.wisatabanyuwangi.activity.RestoranActivity;
import com.banyuwangi.wisatabanyuwangi.activity.SpbuActivity;
import com.banyuwangi.wisatabanyuwangi.activity.WisataAlamActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class JelajahFragment extends Fragment {

    Button btnListAtm;
    Button btnListHotel;
    Button btnListRestoran;
    Button btnListSpbu;
    Button btnListIbadah;

    View view;

    public JelajahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jelajah, container, false);

        getActivity().setTitle("Jelajah Banyuwangi");

        SetupView();

        btnListAtm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), AtmActivity.class);
                startActivity(intent);
            }
        });
        btnListHotel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), HotelActivity.class);
                startActivity(intent);
            }
        });
        btnListRestoran.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), RestoranActivity.class);
                startActivity(intent);
            }
        });
        btnListSpbu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), SpbuActivity.class);
                startActivity(intent);
            }
        });
        btnListIbadah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), IbadahActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void SetupView(){
        btnListAtm = (Button) view.findViewById(R.id.btnListAtm);
        btnListHotel = (Button) view.findViewById(R.id.btnListHotel);
        btnListRestoran = (Button) view.findViewById(R.id.btnListRestoran);
        btnListSpbu = (Button) view.findViewById(R.id.btnListSpbu);
        btnListIbadah = (Button) view.findViewById(R.id.btnListIbadah);
    }
}
