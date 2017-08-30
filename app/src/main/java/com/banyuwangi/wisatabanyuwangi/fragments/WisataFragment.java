package com.banyuwangi.wisatabanyuwangi.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.WisataAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataModel;
import com.banyuwangi.wisatabanyuwangi.models.WisataModel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WisataFragment extends Fragment {

    View view;

    private RecyclerView recyclerViewWisata;
    private ProgressDialog progressDialog;

    public WisataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wisata, container, false);

        getActivity().setTitle("Wisata Banyuwangi");

        recyclerViewWisata = (RecyclerView) view.findViewById(R.id.recyclerview_wisata);

        progressDialog = new ProgressDialog(getActivity());

        getAllDataWisata();

        return view;
    }

    private void getAllDataWisata(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListWisataModel> call = apiService.getAllDataWisata();
        call.enqueue(new Callback<ListWisataModel>() {
            @Override
            public void onResponse(Call<ListWisataModel> call, Response<ListWisataModel> response) {
                ListWisataModel listWisataModel = response.body();
                if(listWisataModel.getStatus()==1){
                    List<WisataModel> listWisata = listWisataModel.getListWisataM();
                    WisataAdapter foodAdapter = new WisataAdapter(listWisata, getActivity());
                    recyclerViewWisata.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerViewWisata.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewWisata.setAdapter(foodAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(getActivity(), listWisataModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListWisataModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }


}
