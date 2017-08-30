package com.banyuwangi.wisatabanyuwangi.models;

import com.google.gson.annotations.SerializedName;

public class IbadahModel {

    @SerializedName("id_ibadah")
    private int idIbadah;
    @SerializedName("nm_ibadah")
    private String nmIbadah;
    @SerializedName("nm_kecamatan")
    private String nmKecamatan;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public IbadahModel() {
    }

    public IbadahModel(int idIbadah, String nmIbadah, String nmKecamatan, String lokasi, String latitude, String longitude) {
        this.idIbadah = idIbadah;
        this.nmIbadah = nmIbadah;
        this.nmKecamatan = nmKecamatan;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdIbadah() {
        return idIbadah;
    }

    public void setIdIbadah(int idIbadah){
        this.idIbadah = idIbadah;
    }

    public String getNmIbadah(){
        return nmIbadah;
    }

    public void setNmIbadah(String nmIbadah){
        this.nmIbadah = nmIbadah;
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
