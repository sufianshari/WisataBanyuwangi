package com.banyuwangi.wisatabanyuwangi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListAtmModel {

    @SerializedName("atm")
    private List<AtmModel> listAtmM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListAtmModel(List<AtmModel> listAtmM, int status, String message) {
        this.listAtmM = listAtmM;
        this.status = status;
        this.message = message;
    }

    public ListAtmModel() {
    }

    public List<AtmModel> getListAtmM() {
        return listAtmM;
    }

    public void setListAtmM(List<AtmModel> listAtmM) {
        this.listAtmM = listAtmM;
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
