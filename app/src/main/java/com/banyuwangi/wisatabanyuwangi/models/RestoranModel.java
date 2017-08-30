package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

public class RestoranModel {

    @SerializedName("id_restoran")
    private int idRestoran;
    @SerializedName("nm_restoran")
    private String nmRestoran;
    @SerializedName("nm_kecamatan")
    private String nmKecamatan;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public RestoranModel() {
    }

    public RestoranModel(int idRestoran, String nmRestoran, String nmKecamatan, String lokasi, String latitude, String longitude) {
        this.idRestoran = idRestoran;
        this.nmRestoran = nmRestoran;
        this.nmKecamatan = nmKecamatan;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(int idRestoran){
        this.idRestoran = idRestoran;
    }

    public String getNmRestoran(){
        return nmRestoran;
    }

    public void setNmRestoran(String nmRestoran){
        this.nmRestoran = nmRestoran;
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
