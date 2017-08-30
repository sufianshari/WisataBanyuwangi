package com.banyuwangi.wisatabanyuwangi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.activity.WisataAlamActivity;
import com.banyuwangi.wisatabanyuwangi.activity.WisataBudayaActivity;
import com.banyuwangi.wisatabanyuwangi.activity.WisataKeluargaActivity;
import com.banyuwangi.wisatabanyuwangi.activity.WisataSejarahActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {

    Button btnWisataAlam, btnWisataSejarah, btnWisataKeluarga, btnWisataBudaya;
    View view;

    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beranda, container, false);

        getActivity().setTitle("Selamat Datang");

        SetupView();

        btnWisataAlam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), WisataAlamActivity.class);
                startActivity(intent);
            }
        });
        btnWisataSejarah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), WisataSejarahActivity.class);
                startActivity(intent);
            }
        });
        btnWisataKeluarga.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), WisataKeluargaActivity.class);
                startActivity(intent);
            }
        });
        btnWisataBudaya.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), WisataBudayaActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    public void SetupView(){
        btnWisataAlam = (Button) view.findViewById(R.id.btnWisataAlam);
        btnWisataSejarah = (Button) view.findViewById(R.id.btnWisataSejarah);
        btnWisataKeluarga = (Button) view.findViewById(R.id.btnWisataKeluarga);
        btnWisataBudaya = (Button) view.findViewById(R.id.btnWisataBudaya);
    }

}
