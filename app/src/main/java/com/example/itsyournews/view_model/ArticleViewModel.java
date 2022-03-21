package com.example.itsyournews.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.itsyournews.repository.ArticleRepository;
import com.example.itsyournews.response.ArticleResponse;
import com.example.itsyournews.view.MainActivity;

public class ArticleViewModel extends AndroidViewModel {

    private String CountryCode = "in";
//
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse>articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashBoardNews(CountryCode);
    }



    public LiveData<ArticleResponse> getBashboardNewsResponseLiveData(){
        return articleResponseLiveData;
    }
}
