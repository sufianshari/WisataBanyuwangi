package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.models.WisataModel;

import java.util.List;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {

    private List<WisataModel> listWisataModel;
    private Context context;

    public WisataAdapter(List<WisataModel> listWisataModel, Context context) {
        this.listWisataModel = listWisataModel;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final WisataModel model = listWisataModel.get(position);

        try{
            //holder.txtIdWisata.setText(model.getIdWisata());
            holder.txtWisata.setText(model.getNmWisata());
            holder.txtKategori.setText(model.getNmKategori());

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listWisataModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdWisata, txtWisata, txtKategori;
        public ImageView imgWisata;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdWisata = (TextView) itemView.findViewById(R.id.txt_id_wisata);
            txtWisata = (TextView) itemView.findViewById(R.id.txt_wisata);
            txtKategori = (TextView) itemView.findViewById(R.id.txt_kategori);
            imgWisata = (ImageView) itemView.findViewById(R.id.img_wisata);
        }
    }

}
