package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

public class HotelModel {

    @SerializedName("id_hotel")
    private int idHotel;
    @SerializedName("nm_hotel")
    private String nmHotel;
    @SerializedName("nm_kecamatan")
    private String nmKecamatan;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public HotelModel() {
    }

    public HotelModel(int idHotel, String nmHotel, String nmKecamatan, String lokasi, String latitude, String longitude) {
        this.idHotel = idHotel;
        this.nmHotel = nmHotel;
        this.nmKecamatan = nmKecamatan;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel){
        this.idHotel = idHotel;
    }

    public String getNmHotel(){
        return nmHotel;
    }

    public void setNmHotel(String nmHotel){
        this.nmHotel = nmHotel;
    }

    public String getNmKecamatan(){
        return nmKecamatan;
    }

    public void setNmKecamatan(String nmKecamatan){
        this.nmKecamatan = nmKecamatan;
    }

    public String getLokasi(){
        return lokasi;
    }

    public void setLokasi(String lokasi){
        this.lokasi = lokasi;
    }

    public String getLatitude(){
        return latitude;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLongitude(){
        return longitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }
}
