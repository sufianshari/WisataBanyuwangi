package com.banyuwangi.wisatabanyuwangi.models;

import com.google.gson.annotations.SerializedName;

public class AtmModel {

    @SerializedName("id_atm")
    private int idAtm;
    @SerializedName("nm_atm")
    private String nmAtm;
    @SerializedName("nm_kecamatan")
    private String nmKecamatan;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public AtmModel() {
    }

    public AtmModel(int idAtm, String nmAtm, String nmKecamatan, String lokasi, String latitude, String longitude) {
        this.idAtm = idAtm;
        this.nmAtm = nmAtm;
        this.nmKecamatan = nmKecamatan;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdAtm() {
        return idAtm;
    }

    public void setIdAtm(int idAtm){
        this.idAtm = idAtm;
    }

    public String getNmAtm(){
        return nmAtm;
    }

    public void setNmAtm(String nmAtm){
        this.nmAtm = nmAtm;
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
