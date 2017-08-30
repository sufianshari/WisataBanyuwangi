package com.banyuwangi.wisatabanyuwangi.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.banyuwangi.wisatabanyuwangi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PanggilanFragment extends Fragment {

    Button btnCallPolisi, btnCallAmbulan1, btnCallAmbulan2, btnCallDamkar, btnCallSar, btnCallPln, btnCallPosko;
    View v;

    public PanggilanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_panggilan, container, false);

        getActivity().setTitle("Panggilan Darurat");


        SetupView();


        btnCallPolisi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("110");
            }
        });
        btnCallAmbulan1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("118");
            }
        });
        btnCallAmbulan2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("119");
            }
        });
        btnCallDamkar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("113");
            }
        });
        btnCallSar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("115");
            }
        });
        btnCallPln.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("123");
            }
        });
        btnCallPosko.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialContactPhone("129");
            }
        });


        return v;
    }

    public void SetupView(){
        btnCallPolisi = (Button) v.findViewById(R.id.btnCallPolisi);
        btnCallAmbulan1 = (Button) v.findViewById(R.id.btnCallAmbulan1);
        btnCallAmbulan2 = (Button) v.findViewById(R.id.btnCallAmbulan2);
        btnCallDamkar = (Button) v.findViewById(R.id.btnCallDamkar);
        btnCallSar = (Button) v.findViewById(R.id.btnCallSar);
        btnCallPln = (Button) v.findViewById(R.id.btnCallPln);
        btnCallPosko = (Button) v.findViewById(R.id.btnCallPosko);
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
        /*String number = "0218581162";
        Intent telephon = new Intent(Intent.ACTION_DIAL);
        telephon.setData(Uri.parse("tel:"+number));
        startActivity(telephon);*/
    }

}
