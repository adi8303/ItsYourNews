package com.example.itsyournews.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.itsyournews.constants.AppConstants;
import com.example.itsyournews.response.ArticleResponse;
import com.example.itsyournews.retrofit.ApiRequest;
import com.example.itsyournews.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {

    private static final  String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);

    }
public LiveData<ArticleResponse>getDashBoardNews(String CCode) {  // CCode means CountryCode

    final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
    apiRequest.getTopHeadLines(CCode,"business", AppConstants.API_KEY)  //changes done to send country as a parameter
            .enqueue(new Callback<ArticleResponse>() {
                @Override
                public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                    if(response.body()!=null){
                        data.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        data.setValue(null);    
                }
            });
    return data;
}

}
//