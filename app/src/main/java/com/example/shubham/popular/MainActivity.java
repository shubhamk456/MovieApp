package com.example.shubham.popular;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movies = new ArrayList<>();
    RecyclerView recyclerView;
    PMRecyclerAdapter pmRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /* recyclerView=findViewById(R.id.recyclerview);
        pmRecyclerAdapter=new PMRecyclerAdapter(movies,this);

        recyclerView.setAdapter(pmRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/


        Tv_Shows tv_shows = new Tv_Shows();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
        transaction1.add(R.id.amainaaa, tv_shows).commit();


        //  fetchPmMovies();

    }

    public void fetchPmMovies() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetroApi retroApi = retrofit.create(RetroApi.class);
        // Call<ArrayList<Movie>> call = retroApi.getmovieslist();
        Call<Popular_Movie> call = retroApi.getmovieslist();
        call.enqueue(new Callback<Popular_Movie>() {
            @Override
            public void onResponse(Call<Popular_Movie> call, Response<Popular_Movie> response) {
                //ArrayList<Movie> pmmovies = response.body();
                Popular_Movie popular_movie = response.body();
                ArrayList<Movie> pmmovies = popular_movie.getResults();
                if (pmmovies != null) {
                    //userApis.clear();
                    movies.clear();
                    movies.addAll(pmmovies);
                    pmRecyclerAdapter.notifyDataSetChanged();
                    Log.e("abc", pmmovies.size() + "");

                }
            }

            @Override
            public void onFailure(Call<Popular_Movie> call, Throwable t) {

            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
