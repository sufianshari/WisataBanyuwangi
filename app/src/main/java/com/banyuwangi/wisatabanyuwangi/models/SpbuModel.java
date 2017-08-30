package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

public class SpbuModel {


    @SerializedName("id_spbu")
    private int idSpbu;
    @SerializedName("nm_spbu")
    private String nmSpbu;
    @SerializedName("nm_kecamatan")
    private String nmKecamatan;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public SpbuModel() {
    }

    public SpbuModel(int idSpbu, String nmSpbu, String nmKecamatan, String lokasi, String latitude, String longitude) {
        this.idSpbu = idSpbu;
        this.nmSpbu = nmSpbu;
        this.nmKecamatan = nmKecamatan;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdSpbu() {
        return idSpbu;
    }

    public void setIdSpbu(int idSpbu){
        this.idSpbu = idSpbu;
    }

    public String getNmSpbu(){
        return nmSpbu;
    }

    public void setNmSpbu(String nmSpbu){
        this.nmSpbu = nmSpbu;
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
