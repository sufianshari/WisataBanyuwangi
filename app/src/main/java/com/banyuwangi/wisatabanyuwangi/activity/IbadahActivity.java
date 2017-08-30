package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.IbadahAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.IbadahModel;
import com.banyuwangi.wisatabanyuwangi.models.ListIbadahModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IbadahActivity extends AppCompatActivity {

    private RecyclerView recyclerViewIbadah;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibadah);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewIbadah = (RecyclerView) findViewById(R.id.rv_ibadah);

        progressDialog = new ProgressDialog(this);

        getAllDataIbadah();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getAllDataIbadah(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListIbadahModel> call = apiService.getAllDataIbadah();
        call.enqueue(new Callback<ListIbadahModel>() {
            @Override
            public void onResponse(Call<ListIbadahModel> call, Response<ListIbadahModel> response) {
                ListIbadahModel listIbadahModel = response.body();
                if(listIbadahModel.getStatus()==1){
                    List<IbadahModel> listIbadah = listIbadahModel.getListIbadahM();
                    IbadahAdapter foodAdapter = new IbadahAdapter(listIbadah, IbadahActivity.this);

                    recyclerViewIbadah.setLayoutManager(new LinearLayoutManager(IbadahActivity.this));
                    recyclerViewIbadah.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewIbadah.setAdapter(foodAdapter);

                    progressDialog.dismiss();
                }else{
                    Toast.makeText(IbadahActivity.this, listIbadahModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListIbadahModel> call, Throwable t) {
                Toast.makeText(IbadahActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
