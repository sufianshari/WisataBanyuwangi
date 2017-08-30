package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.models.RestoranModel;

import java.util.List;

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.ViewHolder> {

    private List<RestoranModel> listRestoranModel;
    private Context context;

    public RestoranAdapter(List<RestoranModel> listRestoranModel, Context context) {
        this.listRestoranModel = listRestoranModel;
        this.context = context;
    }

    @Override
    public RestoranAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_restoran,parent,false);
        return new RestoranAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestoranAdapter.ViewHolder holder, int position) {

        final RestoranModel model = listRestoranModel.get(position);

        try{
            //holder.txtIdRestoran.setText(model.getIdRestoran());
            holder.txtRestoran.setText(model.getNmRestoran());
            holder.txtLokasi.setText(model.getLokasi());

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listRestoranModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdRestoran, txtRestoran, txtLokasi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdRestoran = (TextView) itemView.findViewById(R.id.txt_id_restoran);
            txtRestoran = (TextView) itemView.findViewById(R.id.txt_nm_restoran);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi_restoran);
        }

    }

}
