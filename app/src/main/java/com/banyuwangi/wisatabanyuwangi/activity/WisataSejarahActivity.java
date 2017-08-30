package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.WisataSejarahAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataSejarahModel;
import com.banyuwangi.wisatabanyuwangi.models.WisataSejarahModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataSejarahActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWisata;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_sejarah);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewWisata = (RecyclerView) findViewById(R.id.rv_wisata_sejarah);

        progressDialog = new ProgressDialog(this);

        getAllDataWisataSejarah();

    }

    private void getAllDataWisataSejarah(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListWisataSejarahModel> call = apiService.getAllDataWisataSejarah();
        call.enqueue(new Callback<ListWisataSejarahModel>() {
            @Override
            public void onResponse(Call<ListWisataSejarahModel> call, Response<ListWisataSejarahModel> response) {
                ListWisataSejarahModel listWisataSejarahModel = response.body();
                if(listWisataSejarahModel.getStatus()==1){
                    List<WisataSejarahModel> listWisataSejarah = listWisataSejarahModel.getListWisataSejarahM();
                    WisataSejarahAdapter foodAdapter = new WisataSejarahAdapter(listWisataSejarah, WisataSejarahActivity.this);
                    recyclerViewWisata.setLayoutManager(new LinearLayoutManager(WisataSejarahActivity.this));
                    recyclerViewWisata.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewWisata.setAdapter(foodAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(WisataSejarahActivity.this, listWisataSejarahModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListWisataSejarahModel> call, Throwable t) {
                Toast.makeText(WisataSejarahActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
