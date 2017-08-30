package com.banyuwangi.wisatabanyuwangi.models;

import com.google.gson.annotations.SerializedName;

public class WisataKeluargaModel {

    @SerializedName("id_wisata")
    private int idWisata;
    @SerializedName("nm_wisata")
    private String nmWisata;
    @SerializedName("nm_kategori")
    private String nmKategori;
    @SerializedName("nm_kecamatan")
    private String nmKecamatan;
    @SerializedName("lokasi")
    private String lokasi;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("gambar")
    private String imgWisata;

    public WisataKeluargaModel() {
    }

    public WisataKeluargaModel(int idWisata, String nmWisata, String nmKategori, String nmKecamatan, String lokasi, String deskripsi, String latitude, String longitude, String imgWisata) {
        this.idWisata = idWisata;
        this.nmWisata = nmWisata;
        this.nmKategori = nmKategori;
        this.nmKecamatan = nmKecamatan;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imgWisata = imgWisata;
    }

    public int getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(int idWisata){
        this.idWisata = idWisata;
    }

    public String getNmWisata(){
        return nmWisata;
    }

    public void setNmWisata(String nmWisata){
        this.nmWisata = nmWisata;
    }

    public String getNmKategori(){
        return nmKategori;
    }

    public void setNmKategori(String nmKategori){
        this.nmKategori = nmKategori;
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

    public String getDeskripsi(){
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
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

    public String getImgWisata(){
        return imgWisata;
    }

    public void setImgWisata(String imgWisata){
        this.imgWisata = imgWisata;
    }
}
