package com.appbasic.taskretrofitexample;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;

public class Contact {
    String cuisine_name;
    String cuisine_id;

    public String getCuisine_name() {
        return cuisine_name;
    }

    public void setCuisine_name(String cuisine_name) {
        this.cuisine_name = cuisine_name;
    }

    public String getCuisine_id() {
        return cuisine_id;
    }

    public void setCuisine_id(String cuisine_id) {
        this.cuisine_id = cuisine_id;
    }

    @SerializedName("result")
    public String result;

    @SerializedName("status")
    public Integer status;

    @SerializedName("cuisines")
    public List<Datum> data = null;

    public Contact() {
        this.result = result;
        this.status = status;
    }

    public class Datum {


        @SerializedName("cuisine_id")
        public String cuisine_id;


        @SerializedName("cuisine_name")
        public String cuisine_name;

    }
}
