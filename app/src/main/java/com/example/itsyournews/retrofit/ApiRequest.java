package com.example.itsyournews.retrofit;

import com.example.itsyournews.constants.AppConstants;
import com.example.itsyournews.response.ArticleResponse;
import com.example.itsyournews.view.MainActivity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.itsyournews.constants.AppConstants.API_KEY;
//import static com.example.itsyournews.view.MainActivity.country;

public interface ApiRequest{
//    @GET("top-headlines?country=fr&category=business&apiKey="+API_KEY)
//    Call<ArticleResponse> getTopHeadLines();
//

//    passing country,category,apikey as a parameter
    @GET("top-headlines")
    Call<ArticleResponse> getTopHeadLines(@Query("country") String country,@Query("category") String category,@Query("apiKey")  String apiKey);




}
