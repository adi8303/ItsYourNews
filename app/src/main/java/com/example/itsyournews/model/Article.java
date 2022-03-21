package com.example.itsyournews.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    //what data to be tracked out from there is decided here
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("title")
    @Expose
    private String title;

    @NonNull
    @Override
//    convert the the JSON format data to string
    public String toString() {
//        filtering out our needed data
        return "BashBoardNews{"+
                "urlToImage='"+ urlToImage+'\''+
                "description='"+description+'\''+
                ",title='"+title+'\''+
                '}';
    }
    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
