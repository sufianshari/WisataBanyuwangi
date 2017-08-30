package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.WisataBudayaAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataBudayaModel;
import com.banyuwangi.wisatabanyuwangi.models.WisataBudayaModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataBudayaActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWisata;
    private ProgressDialog progressDialog;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_budaya);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewWisata = (RecyclerView) findViewById(R.id.rv_wisata_budaya);

        progressDialog = new ProgressDialog(this);

        getAllDataWisataBudaya();

    }

    private void getAllDataWisataBudaya(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListWisataBudayaModel> call = apiService.getAllDataWisataBudaya();
        call.enqueue(new Callback<ListWisataBudayaModel>() {
            @Override
            public void onResponse(Call<ListWisataBudayaModel> call, Response<ListWisataBudayaModel> response) {
                ListWisataBudayaModel listWisataBudayaModel = response.body();
                if(listWisataBudayaModel.getStatus()==1){
                    List<WisataBudayaModel> listWisataBudaya = listWisataBudayaModel.getListWisataBudayaM();
                    WisataBudayaAdapter foodAdapter = new WisataBudayaAdapter(listWisataBudaya, WisataBudayaActivity.this);
                    recyclerViewWisata.setLayoutManager(new LinearLayoutManager(WisataBudayaActivity.this));
                    recyclerViewWisata.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewWisata.setAdapter(foodAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(WisataBudayaActivity.this, listWisataBudayaModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListWisataBudayaModel> call, Throwable t) {
                Toast.makeText(WisataBudayaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
