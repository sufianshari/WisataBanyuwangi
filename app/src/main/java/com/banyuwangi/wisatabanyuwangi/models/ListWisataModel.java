package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListWisataModel {

    @SerializedName("wisata")
    private List<WisataModel> listWisataM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListWisataModel(List<WisataModel> listWisataM, int status, String message) {
        this.listWisataM = listWisataM;
        this.status = status;
        this.message = message;
    }

    public ListWisataModel() {
    }

    public List<WisataModel> getListWisataM() {
        return listWisataM;
    }

    public void setListWisataM(List<WisataModel> listWisataM) {
        this.listWisataM = listWisataM;
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
