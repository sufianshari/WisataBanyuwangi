package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListWisataBudayaModel {

    @SerializedName("wisata")
    private List<WisataBudayaModel> listWisataBudayaM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListWisataBudayaModel(List<WisataBudayaModel> listWisataBudayaM, int status, String message) {
        this.listWisataBudayaM = listWisataBudayaM;
        this.status = status;
        this.message = message;
    }

    public ListWisataBudayaModel() {
    }

    public List<WisataBudayaModel> getListWisataBudayaM() {
        return listWisataBudayaM;
    }

    public void setListWisataBudayaM(List<WisataBudayaModel> listWisataBudayaM) {
        this.listWisataBudayaM = listWisataBudayaM;
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
