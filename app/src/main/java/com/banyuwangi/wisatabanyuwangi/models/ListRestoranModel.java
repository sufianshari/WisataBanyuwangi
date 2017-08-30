package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListRestoranModel {


    @SerializedName("restoran")
    private List<RestoranModel> listRestoranM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListRestoranModel(List<RestoranModel> listRestoranM, int status, String message) {
        this.listRestoranM = listRestoranM;
        this.status = status;
        this.message = message;
    }

    public ListRestoranModel() {
    }

    public List<RestoranModel> getListRestoranM() {
        return listRestoranM;
    }

    public void setListRestoranM(List<RestoranModel> listRestoranM) {
        this.listRestoranM = listRestoranM;
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
