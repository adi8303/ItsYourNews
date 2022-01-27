package com.example.itsyournews.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.itsyournews.constants.AppConstants.BASE_URL;

public class RetrofitRequest {

    private  static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

//            The converter depend0ency provides a GsonConverterFactory class.
//            Call the created instance of that class (done via create()) to your Retrofit instance
//            with the method addConverterFactory(). After you’ve added the converter to Retrofit,
//            it’ll automatically take care of mapping the JSON data to your Java objects, as you’ve seen
//            in the previous blog post. Of course, this works for both directions: sending and receiving data.

        }
        return retrofit;
    }
}
