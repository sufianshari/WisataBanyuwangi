package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.SpbuAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.SpbuModel;
import com.banyuwangi.wisatabanyuwangi.models.ListSpbuModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpbuActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSpbu;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spbu);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewSpbu = (RecyclerView) findViewById(R.id.rv_spbu);

        progressDialog = new ProgressDialog(this);

        getAllDataSpbu();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getAllDataSpbu(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListSpbuModel> call = apiService.getAllDataSpbu();
        call.enqueue(new Callback<ListSpbuModel>() {
            @Override
            public void onResponse(Call<ListSpbuModel> call, Response<ListSpbuModel> response) {
                ListSpbuModel listSpbuModel = response.body();
                if(listSpbuModel.getStatus()==1){
                    List<SpbuModel> listSpbu = listSpbuModel.getListSpbuM();
                    SpbuAdapter foodAdapter = new SpbuAdapter(listSpbu, SpbuActivity.this);

                    recyclerViewSpbu.setLayoutManager(new LinearLayoutManager(SpbuActivity.this));
                    recyclerViewSpbu.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewSpbu.setAdapter(foodAdapter);

                    progressDialog.dismiss();
                }else{
                    Toast.makeText(SpbuActivity.this, listSpbuModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListSpbuModel> call, Throwable t) {
                Toast.makeText(SpbuActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
