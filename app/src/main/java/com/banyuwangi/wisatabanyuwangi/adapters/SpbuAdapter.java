package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.models.SpbuModel;

import java.util.List;

public class SpbuAdapter extends RecyclerView.Adapter<SpbuAdapter.ViewHolder> {

    private List<SpbuModel> listSpbuModel;
    private Context context;

    public SpbuAdapter(List<SpbuModel> listSpbuModel, Context context) {
        this.listSpbuModel = listSpbuModel;
        this.context = context;
    }

    @Override
    public SpbuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_spbu,parent,false);
        return new SpbuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpbuAdapter.ViewHolder holder, int position) {

        final SpbuModel model = listSpbuModel.get(position);

        try{
            //holder.txtIdSpbu.setText(model.getIdSpbu());
            holder.txtSpbu.setText(model.getNmSpbu());
            holder.txtLokasi.setText(model.getLokasi());

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listSpbuModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdSpbu, txtSpbu, txtLokasi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdSpbu = (TextView) itemView.findViewById(R.id.txt_id_spbu);
            txtSpbu = (TextView) itemView.findViewById(R.id.txt_nm_spbu);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi_spbu);
        }

    }

}
