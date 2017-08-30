package com.banyuwangi.wisatabanyuwangi.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banyuwangi.wisatabanyuwangi.R;
import com.banyuwangi.wisatabanyuwangi.models.HotelModel;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private List<HotelModel> listHotelModel;
    private Context context;

    public HotelAdapter(List<HotelModel> listHotelModel, Context context) {
        this.listHotelModel = listHotelModel;
        this.context = context;
    }

    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_hotel,parent,false);
        return new HotelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelAdapter.ViewHolder holder, int position) {

        final HotelModel model = listHotelModel.get(position);

        try{
            //holder.txtIdHotel.setText(model.getIdHotel());
            holder.txtHotel.setText(model.getNmHotel());
            holder.txtLokasi.setText(model.getLokasi());

            //Event Ketika di klik

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listHotelModel.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtIdHotel, txtHotel, txtLokasi;

        public ViewHolder(View itemView) {
            super(itemView);

            txtIdHotel = (TextView) itemView.findViewById(R.id.txt_id_hotel);
            txtHotel = (TextView) itemView.findViewById(R.id.txt_nm_hotel);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi_hotel);
        }

    }

}
