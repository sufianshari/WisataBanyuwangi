package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListSpbuModel {

    @SerializedName("spbu")
    private List<SpbuModel> listSpbuM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListSpbuModel(List<SpbuModel> listSpbuM, int status, String message) {
        this.listSpbuM = listSpbuM;
        this.status = status;
        this.message = message;
    }

    public ListSpbuModel() {
    }

    public List<SpbuModel> getListSpbuM() {
        return listSpbuM;
    }

    public void setListSpbuM(List<SpbuModel> listSpbuM) {
        this.listSpbuM = listSpbuM;
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
