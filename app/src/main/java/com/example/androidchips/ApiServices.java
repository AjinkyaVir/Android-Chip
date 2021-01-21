package com.example.androidchips;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {

    @Headers({"Accept: application/json"})
    @GET("interests")
    Call<InterestResponse> getActiveInterest();


}
