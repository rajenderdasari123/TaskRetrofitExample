package com.appbasic.taskretrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL="http://testingmadesimple.org/foody/api/services/";

    @GET("getcuisines")
    Call<Contact> doGetListResources();
}
