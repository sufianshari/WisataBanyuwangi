package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListIbadahModel {

    @SerializedName("ibadah")
    private List<IbadahModel> listIbadahM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListIbadahModel(List<IbadahModel> listIbadahM, int status, String message) {
        this.listIbadahM = listIbadahM;
        this.status = status;
        this.message = message;
    }

    public ListIbadahModel() {
    }

    public List<IbadahModel> getListIbadahM() {
        return listIbadahM;
    }

    public void setListIbadahM(List<IbadahModel> listIbadahM) {
        this.listIbadahM = listIbadahM;
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
