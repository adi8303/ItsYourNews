package com.example.itsyournews.retrofit;

import com.example.itsyournews.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.itsyournews.constants.AppConstants.API_KEY;

public interface ApiRequest {

    @GET("top-headlines?country=fr&category=business&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadLines();
}
