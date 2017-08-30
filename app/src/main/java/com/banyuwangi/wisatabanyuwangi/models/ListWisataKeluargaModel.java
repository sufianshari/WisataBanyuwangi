package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListWisataKeluargaModel {

    @SerializedName("wisata")
    private List<WisataKeluargaModel> listWisataKeluargaM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListWisataKeluargaModel(List<WisataKeluargaModel> listWisataKeluargaM, int status, String message) {
        this.listWisataKeluargaM = listWisataKeluargaM;
        this.status = status;
        this.message = message;
    }

    public ListWisataKeluargaModel() {
    }

    public List<WisataKeluargaModel> getListWisataKeluargaM() {
        return listWisataKeluargaM;
    }

    public void setListWisataKeluargaM(List<WisataKeluargaModel> listWisataKeluargaM) {
        this.listWisataKeluargaM = listWisataKeluargaM;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
