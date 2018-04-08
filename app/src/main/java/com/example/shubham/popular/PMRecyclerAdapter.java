package com.example.shubham.popular;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shubham on 3/25/2018.
 */

public class PMRecyclerAdapter extends RecyclerView.Adapter<PMRecyclerAdapter.MovieViewHolder>{
    ArrayList<Movie> movies;
    Context context;

    public PMRecyclerAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view= inflater.inflate(R.layout.pm_rows,parent,false);
MovieViewHolder holder=new MovieViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
Movie movie=movies.get(position);
holder.titletextview.setText(movie.getTitle());
holder.avergageRatingTextview.setText(movie.getVote_average()+"");
        Picasso.get().load("http://image.tmdb.org/t/p/w342"+movie.getPoster_path()).into(holder.posterimageview);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    class MovieViewHolder extends RecyclerView.ViewHolder{
ImageView posterimageview;
TextView titletextview;
TextView avergageRatingTextview;
View itemview;
        public MovieViewHolder(View itemView) {
            super(itemView);
            this.itemview=itemView;
            posterimageview=itemView.findViewById(R.id.imageView);
            titletextview=itemView.findViewById(R.id.title);
            avergageRatingTextview=itemView.findViewById(R.id.vote_average);
        }
    }
}
