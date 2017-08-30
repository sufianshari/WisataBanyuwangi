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
import com.banyuwangi.wisatabanyuwangi.adapters.WisataKeluargaAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataKeluargaModel;
import com.banyuwangi.wisatabanyuwangi.models.WisataKeluargaModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataKeluargaActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWisata;
    private ProgressDialog progressDialog;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_keluarga);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewWisata = (RecyclerView) findViewById(R.id.rv_wisata_keluarga);

        progressDialog = new ProgressDialog(this);

        getAllDataWisataKeluarga();

    }

    private void getAllDataWisataKeluarga(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListWisataKeluargaModel> call = apiService.getAllDataWisataKeluarga();
        call.enqueue(new Callback<ListWisataKeluargaModel>() {
            @Override
            public void onResponse(Call<ListWisataKeluargaModel> call, Response<ListWisataKeluargaModel> response) {
                ListWisataKeluargaModel listWisataKeluargaModel = response.body();
                if(listWisataKeluargaModel.getStatus()==1){
                    List<WisataKeluargaModel> listWisataKeluarga = listWisataKeluargaModel.getListWisataKeluargaM();
                    WisataKeluargaAdapter foodAdapter = new WisataKeluargaAdapter(listWisataKeluarga, WisataKeluargaActivity.this);
                    recyclerViewWisata.setLayoutManager(new LinearLayoutManager(WisataKeluargaActivity.this));
                    recyclerViewWisata.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewWisata.setAdapter(foodAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(WisataKeluargaActivity.this, listWisataKeluargaModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListWisataKeluargaModel> call, Throwable t) {
                Toast.makeText(WisataKeluargaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
