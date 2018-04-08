package com.example.shubham.popular;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shubham on 3/25/2018.
 */

public interface RetroApi {
    @GET("popular?api_key=783e35773dc7d9948ab9c7672956017e&language=en-US&page=1")
    Call<Popular_Movie> getmovieslist();
    // Call<ArrayList<Movie>> getmovieslist();

    @GET("popular?api_key=783e35773dc7d9948ab9c7672956017e&language=en-US&page=1")
    Call<Popular_Show> getshowslist();

}
