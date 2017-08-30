package com.banyuwangi.wisatabanyuwangi.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.adapters.HotelAdapter;
import com.banyuwangi.wisatabanyuwangi.apiservices.ApiService;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.HotelModel;
import com.banyuwangi.wisatabanyuwangi.models.ListHotelModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHotel;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recyclerViewHotel = (RecyclerView) findViewById(R.id.rv_hotel);

        progressDialog = new ProgressDialog(this);

        getAllDataHotel();

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getAllDataHotel(){
        progressDialog.setTitle("Menampilkan Data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListHotelModel> call = apiService.getAllDataHotel();
        call.enqueue(new Callback<ListHotelModel>() {
            @Override
            public void onResponse(Call<ListHotelModel> call, Response<ListHotelModel> response) {
                ListHotelModel listHotelModel = response.body();
                if(listHotelModel.getStatus()==1){
                    List<HotelModel> listHotel = listHotelModel.getListHotelM();
                    HotelAdapter foodAdapter = new HotelAdapter(listHotel, HotelActivity.this);

                    recyclerViewHotel.setLayoutManager(new LinearLayoutManager(HotelActivity.this));
                    recyclerViewHotel.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewHotel.setAdapter(foodAdapter);

                    progressDialog.dismiss();
                }else{
                    Toast.makeText(HotelActivity.this, listHotelModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListHotelModel> call, Throwable t) {
                Toast.makeText(HotelActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
