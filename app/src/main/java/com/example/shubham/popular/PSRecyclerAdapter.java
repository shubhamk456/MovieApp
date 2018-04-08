package com.example.shubham.popular;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shubham on 4/7/2018.
 */

public class PSRecyclerAdapter extends RecyclerView.Adapter<PSRecyclerAdapter.ShowViewHolder> {
    ArrayList<Show> shows;
    Context context;
    int width,height;

    public PSRecyclerAdapter(ArrayList<Show> shows, Context context) {
        this.shows = shows;
        this.context = context;
    }

    void getScreenSize(){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
    }

    @Override
    public PSRecyclerAdapter.ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.ps_rows,parent,false);
        PSRecyclerAdapter.ShowViewHolder holder=new PSRecyclerAdapter.ShowViewHolder(view);
        getScreenSize();
        return holder;
    }

    @Override
    public void onBindViewHolder(ShowViewHolder holder, int position) {
        Show show=shows.get(position);
        Picasso.get().load("http://image.tmdb.org/t/p/w342"+show.getBackdrop_path()).resize(width,0).into(holder.posterback);
        Picasso.get().load("http://image.tmdb.org/t/p/w342"+show.getPoster_path()).into(holder.posterfront);
        holder.showname.setText(show.getName());
        holder.year.setText(show.Air_Year()+"");

    }


    @Override
    public int getItemCount() {
        return shows.size();
    }
    class ShowViewHolder extends RecyclerView.ViewHolder{
        ImageView posterback;
        ImageView posterfront;
        TextView showname;
        TextView year;
        View itemview;
        public ShowViewHolder(View itemView) {
            super(itemView);
            this.itemview=itemView;
            posterback=itemView.findViewById(R.id.posterback);
            posterfront=itemView.findViewById(R.id.posterfront);
            showname=itemView.findViewById(R.id.showname);
            year=itemView.findViewById(R.id.year);
        }
    }

}
