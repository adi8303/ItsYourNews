package com.example.itsyournews.response;

import androidx.annotation.NonNull;

import com.example.itsyournews.model.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ArticleResponse {

    //    List will get a list of Articles which means List of Modelclass Items
    @SerializedName("articles")
    @Expose
    private List<Article>articles;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    @NonNull
    @Override
    public String toString() {
        return "BashBoardNewsResponse{"+
               "articles" + articles+'}';
    }
}
