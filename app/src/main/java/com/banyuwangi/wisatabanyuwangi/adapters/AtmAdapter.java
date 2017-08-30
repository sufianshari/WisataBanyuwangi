package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.models.AtmModel;

import java.util.List;

public class AtmAdapter extends RecyclerView.Adapter<AtmAdapter.ViewHolder> {

    private List<AtmModel> listAtmModel;
    private Context context;

    public AtmAdapter(List<AtmModel> listAtmModel, Context context) {
        this.listAtmModel = listAtmModel;
        this.context = context;
    }

    @Override
    public AtmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_atm,parent,false);
        return new AtmAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AtmAdapter.ViewHolder holder, int position) {

        final AtmModel model = listAtmModel.get(position);

        try{
            //holder.txtIdAtm.setText(model.getIdAtm());
            holder.txtAtm.setText(model.getNmAtm());
            holder.txtLokasi.setText(model.getLokasi());

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listAtmModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdAtm, txtAtm, txtLokasi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdAtm = (TextView) itemView.findViewById(R.id.txt_id_atm);
            txtAtm = (TextView) itemView.findViewById(R.id.txt_nm_atm);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi_atm);
        }

    }

}
