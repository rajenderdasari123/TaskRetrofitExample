package com.appbasic.taskretrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactsrecyclerview;
    static int width, height;
    Contact mcontact;
    private List<Contact> contactlist;
    ContactAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;

        contactlist = new ArrayList<>();
        contactsrecyclerview = (RecyclerView) findViewById(R.id.contactsrecyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        contactsrecyclerview.setLayoutManager(mLayoutManager);
        contactsrecyclerview.setItemAnimator(new DefaultItemAnimator());
      /*  mAdapter = new ContactAdapter(movieList);
        contactsrecyclerview.setAdapter(mAdapter);*/
        getContacts();
    }

    private void getContacts() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<Contact> call = api.doGetListResources();

        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {

                Contact resource = response.body();


                List<Contact.Datum> datumList = resource.data;
                for (Contact.Datum datum : datumList) {
                    mcontact = new Contact();
                    mcontact.setCuisine_id(datum.cuisine_id);
                    mcontact.setCuisine_name(datum.cuisine_name);
                    contactlist.add(mcontact);

                }

                cAdapter = new ContactAdapter(contactlist, MainActivity.this);
                contactsrecyclerview.setAdapter(cAdapter);
                Log.d("Result Data", " " + contactlist.size());
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.d("onFailure", " ");
            }
        });
    }

}
