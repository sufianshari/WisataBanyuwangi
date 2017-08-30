package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.adapters.WisataAlamAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataAlamModel;
import com.banyuwangi.wisatabanyuwangi.models.WisataAlamModel;

import com.banyuwangi.wisatabanyuwangi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataAlamActivity extends AppCompatActivity {


    private RecyclerView recyclerViewWisata;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_alam);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewWisata = (RecyclerView) findViewById(R.id.rv_wisata_alam);

        progressDialog = new ProgressDialog(this);

        getAllDataWisataAlam();

    }

    private void getAllDataWisataAlam(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListWisataAlamModel> call = apiService.getAllDataWisataAlam();
        call.enqueue(new Callback<ListWisataAlamModel>() {
            @Override
            public void onResponse(Call<ListWisataAlamModel> call, Response<ListWisataAlamModel> response) {
                ListWisataAlamModel listWisataAlamModel = response.body();
                if(listWisataAlamModel.getStatus()==1){
                    List<WisataAlamModel> listWisataAlam = listWisataAlamModel.getListWisataAlamM();
                    WisataAlamAdapter foodAdapter = new WisataAlamAdapter(listWisataAlam, WisataAlamActivity.this);

                    recyclerViewWisata.setLayoutManager(new LinearLayoutManager(WisataAlamActivity.this));
                    recyclerViewWisata.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewWisata.setAdapter(foodAdapter);

                    progressDialog.dismiss();
                }else{
                    Toast.makeText(WisataAlamActivity.this, listWisataAlamModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListWisataAlamModel> call, Throwable t) {
                Toast.makeText(WisataAlamActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
