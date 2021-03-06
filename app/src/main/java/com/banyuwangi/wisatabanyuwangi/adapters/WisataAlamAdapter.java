package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.clients.ApiClient;
import com.banyuwangi.wisatabanyuwangi.models.WisataAlamModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WisataAlamAdapter extends RecyclerView.Adapter<WisataAlamAdapter.ViewHolder> {

    private List<WisataAlamModel> listWisataAlamModel;
    private Context context;

    public WisataAlamAdapter(List<WisataAlamModel> listWisataAlamModel, Context context) {
        this.listWisataAlamModel = listWisataAlamModel;
        this.context = context;
    }

    @Override
    public WisataAlamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_wisata,parent,false);
        return new WisataAlamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WisataAlamAdapter.ViewHolder holder, int position) {

        final WisataAlamModel model = listWisataAlamModel.get(position);

        try{
            //holder.txtIdWisata.setText(model.getIdWisata());
            holder.txtWisata.setText(model.getNmWisata());
            holder.txtLokasi.setText(model.getLokasi());

            Picasso.with(context)
                    .load(ApiClient.URL + "uploads/foto_wisata/" + model.getImgWisata())
                    .into(holder.imgWisata);

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listWisataAlamModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdWisata, txtWisata, txtLokasi;
        public ImageView imgWisata;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdWisata = (TextView) itemView.findViewById(R.id.txt_id_wisata);
            txtWisata = (TextView) itemView.findViewById(R.id.txt_nm_wisata);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi_wisata);
            imgWisata = (ImageView) itemView.findViewById(R.id.img_wisata);
        }

    }

}
