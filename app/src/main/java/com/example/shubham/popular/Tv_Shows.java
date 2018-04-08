package com.example.shubham.popular;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tv_Shows extends Fragment {
    ArrayList<Show> shows = new ArrayList<>();
    RecyclerView recyclerView;
    PSRecyclerAdapter psRecyclerAdapter;


    public Tv_Shows() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv__shows, container, false);
        recyclerView = view.findViewById(R.id.psrecyclerview);
        psRecyclerAdapter = new PSRecyclerAdapter(shows, getContext());
        recyclerView.setAdapter(psRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Fetchshows();
        return view;


    }

    public void Fetchshows() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/tv/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetroApi retroApi = retrofit.create(RetroApi.class);
        Call<Popular_Show> call = retroApi.getshowslist();
        call.enqueue(new Callback<Popular_Show>() {
            @Override
            public void onResponse(Call<Popular_Show> call, Response<Popular_Show> response) {
                Popular_Show popular_show = response.body();

                ArrayList<Show> psshows = popular_show.getResults();
                Log.e("amam",psshows.get(5)+"");
                if (psshows != null) {
                    //userApis.clear();
                    shows.clear();
                    shows.addAll(psshows);
                    psRecyclerAdapter.notifyDataSetChanged();
                    Log.e("abc", psshows.size() + "");

                }
            }

            @Override
            public void onFailure(Call<Popular_Show> call, Throwable t) {

            }

        });

    }
}