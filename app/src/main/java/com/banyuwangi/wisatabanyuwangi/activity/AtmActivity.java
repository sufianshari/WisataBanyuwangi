package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.AtmAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.ListAtmModel;
import com.banyuwangi.wisatabanyuwangi.models.AtmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtmActivity extends AppCompatActivity {

    private RecyclerView recyclerViewAtm;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewAtm = (RecyclerView) findViewById(R.id.rv_atm);

        progressDialog = new ProgressDialog(this);

        getAllDataAtm();

    }

    @Override
    public void onBackPressed() {
        finish();
    }


    private void getAllDataAtm(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListAtmModel> call = apiService.getAllDataAtm();
        call.enqueue(new Callback<ListAtmModel>() {
            @Override
            public void onResponse(Call<ListAtmModel> call, Response<ListAtmModel> response) {
                ListAtmModel listAtmModel = response.body();
                if(listAtmModel.getStatus()==1){
                    List<AtmModel> listAtm = listAtmModel.getListAtmM();
                    AtmAdapter foodAdapter = new AtmAdapter(listAtm, AtmActivity.this);

                    recyclerViewAtm.setLayoutManager(new LinearLayoutManager(AtmActivity.this));
                    recyclerViewAtm.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewAtm.setAdapter(foodAdapter);

                    progressDialog.dismiss();
                }else{
                    Toast.makeText(AtmActivity.this, listAtmModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListAtmModel> call, Throwable t) {
                Toast.makeText(AtmActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
