package com.banyuwangi.wisatabanyuwangi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListWisataSejarahModel {

    @SerializedName("wisata")
    private List<WisataSejarahModel> listWisataSejarahM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListWisataSejarahModel(List<WisataSejarahModel> listWisataSejarahM, int status, String message) {
        this.listWisataSejarahM = listWisataSejarahM;
        this.status = status;
        this.message = message;
    }

    public ListWisataSejarahModel() {
    }

    public List<WisataSejarahModel> getListWisataSejarahM() {
        return listWisataSejarahM;
    }

    public void setListWisataSejarahM(List<WisataSejarahModel> listWisataSejarahM) {
        this.listWisataSejarahM = listWisataSejarahM;
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
