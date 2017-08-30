package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.RestoranAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.RestoranModel;
import com.banyuwangi.wisatabanyuwangi.models.ListRestoranModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestoranActivity extends AppCompatActivity {

    private RecyclerView recyclerViewRestoran;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoran);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewRestoran = (RecyclerView) findViewById(R.id.rv_restoran);

        progressDialog = new ProgressDialog(this);

        getAllDataRestoran();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getAllDataRestoran(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListRestoranModel> call = apiService.getAllDataRestoran();
        call.enqueue(new Callback<ListRestoranModel>() {
            @Override
            public void onResponse(Call<ListRestoranModel> call, Response<ListRestoranModel> response) {
                ListRestoranModel listRestoranModel = response.body();
                if(listRestoranModel.getStatus()==1){
                    List<RestoranModel> listRestoran = listRestoranModel.getListRestoranM();
                    RestoranAdapter foodAdapter = new RestoranAdapter(listRestoran, RestoranActivity.this);

                    recyclerViewRestoran.setLayoutManager(new LinearLayoutManager(RestoranActivity.this));
                    recyclerViewRestoran.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewRestoran.setAdapter(foodAdapter);

                    progressDialog.dismiss();
                }else{
                    Toast.makeText(RestoranActivity.this, listRestoranModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListRestoranModel> call, Throwable t) {
                Toast.makeText(RestoranActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
