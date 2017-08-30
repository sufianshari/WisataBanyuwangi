package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.models.IbadahModel;

import java.util.List;

public class IbadahAdapter extends RecyclerView.Adapter<IbadahAdapter.ViewHolder> {

    private List<IbadahModel> listIbadahModel;
    private Context context;

    public IbadahAdapter(List<IbadahModel> listIbadahModel, Context context) {
        this.listIbadahModel = listIbadahModel;
        this.context = context;
    }

    @Override
    public IbadahAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_ibadah,parent,false);
        return new IbadahAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IbadahAdapter.ViewHolder holder, int position) {

        final IbadahModel model = listIbadahModel.get(position);

        try{
            //holder.txtIdIbadah.setText(model.getIdIbadah());
            holder.txtIbadah.setText(model.getNmIbadah());
            holder.txtLokasi.setText(model.getLokasi());

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listIbadahModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdIbadah, txtIbadah, txtLokasi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdIbadah = (TextView) itemView.findViewById(R.id.txt_id_ibadah);
            txtIbadah = (TextView) itemView.findViewById(R.id.txt_nm_ibadah);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi_ibadah);
        }

    }

}
