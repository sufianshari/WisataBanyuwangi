package com.banyuwangi.wisatabanyuwangi.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListHotelModel {


    @SerializedName("hotel")
    private List<HotelModel> listHotelM;
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;

    public ListHotelModel(List<HotelModel> listHotelM, int status, String message) {
        this.listHotelM = listHotelM;
        this.status = status;
        this.message = message;
    }

    public ListHotelModel() {
    }

    public List<HotelModel> getListHotelM() {
        return listHotelM;
    }

    public void setListHotelM(List<HotelModel> listHotelM) {
        this.listHotelM = listHotelM;
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
