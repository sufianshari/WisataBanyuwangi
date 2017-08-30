package com.banyuwangi.wisatabanyuwangi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListWisataAlamModel {

    @SerializedName("wisata")
    private List<WisataAlamModel> listWisataAlamM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListWisataAlamModel(List<WisataAlamModel> listWisataAlamM, int status, String message) {
        this.listWisataAlamM = listWisataAlamM;
        this.status = status;
        this.message = message;
    }

    public ListWisataAlamModel() {
    }

    public List<WisataAlamModel> getListWisataAlamM() {
        return listWisataAlamM;
    }

    public void setListWisataAlamM(List<WisataAlamModel> listWisataAlamM) {
        this.listWisataAlamM = listWisataAlamM;
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
