package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.ViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterWisata(Context context, ArrayList<HashMap<String, String>> list_data) {
        this.context = context;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Glide.with(context)
                .load("http://banyuwangi.tugas-akhir.com/uploads/foto_wisata/" + list_data.get(position).get("gambar"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgWisata);*/
        holder.txtWisata.setText(list_data.get(position).get("nm_wisata"));
        holder.txtKategori.setText(list_data.get(position).get("nm_kategori"));

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtWisata, txtKategori;
        ImageView imgWisata;

        public ViewHolder(View itemView) {
            super(itemView);

            txtWisata = (TextView) itemView.findViewById(R.id.txt_wisata);
            txtKategori = (TextView) itemView.findViewById(R.id.txt_kategori);
            imgWisata = (ImageView) itemView.findViewById(R.id.img_wisata);
        }
    }
}
