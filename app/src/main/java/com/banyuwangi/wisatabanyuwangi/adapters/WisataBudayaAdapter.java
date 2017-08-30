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
import com.banyuwangi.wisatabanyuwangi.models.WisataBudayaModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class WisataBudayaAdapter extends RecyclerView.Adapter<WisataBudayaAdapter.ViewHolder> {

    private List<WisataBudayaModel> listWisataBudayaModel;
    private Context context;

    public WisataBudayaAdapter(List<WisataBudayaModel> listWisataBudayaModel, Context context) {
        this.listWisataBudayaModel = listWisataBudayaModel;
        this.context = context;
    }

    @Override
    public WisataBudayaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_wisata,parent,false);
        return new WisataBudayaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WisataBudayaAdapter.ViewHolder holder, int position) {

        final WisataBudayaModel model = listWisataBudayaModel.get(position);

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
        return listWisataBudayaModel.size();
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
