package com.banyuwangi.wisatabanyuwangi.apiservices;

import com.banyuwangi.wisatabanyuwangi.models.ListAtmModel;
import com.banyuwangi.wisatabanyuwangi.models.ListHotelModel;
import com.banyuwangi.wisatabanyuwangi.models.ListIbadahModel;
import com.banyuwangi.wisatabanyuwangi.models.ListRestoranModel;
import com.banyuwangi.wisatabanyuwangi.models.ListSpbuModel;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataAlamModel;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataBudayaModel;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataKeluargaModel;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataModel;
import com.banyuwangi.wisatabanyuwangi.models.ListWisataSejarahModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //Menampilkan Seluruh Data Wisata
    @GET("api_services/api.php?type=all-wisata")
    Call<ListWisataModel> getAllDataWisata();

    //Menampilkan Wisata Alam
    @GET("api_services/api.php?type=all-wisata-alam")
    Call<ListWisataAlamModel> getAllDataWisataAlam();
    //Menampilkan Wisata Sejarah
    @GET("api_services/api.php?type=all-wisata-sejarah")
    Call<ListWisataSejarahModel> getAllDataWisataSejarah();
    //Menampilkan Wisata Keluarga
    @GET("api_services/api.php?type=all-wisata-keluarga")
    Call<ListWisataKeluargaModel> getAllDataWisataKeluarga();
    //Menampilkan Wisata Budaya
    @GET("api_services/api.php?type=all-wisata-budaya")
    Call<ListWisataBudayaModel> getAllDataWisataBudaya();

    //Menampilkan Detail Wisata


    //JELAJAH
    @GET("api_services/api.php?type=all-atm")
    Call<ListAtmModel> getAllDataAtm();
    @GET("api_services/api.php?type=all-hotel")
    Call<ListHotelModel> getAllDataHotel();
    @GET("api_services/api.php?type=all-ibadah")
    Call<ListIbadahModel> getAllDataIbadah();
    @GET("api_services/api.php?type=all-restoran")
    Call<ListRestoranModel> getAllDataRestoran();
    @GET("api_services/api.php?type=all-spbu")
    Call<ListSpbuModel> getAllDataSpbu();
}
