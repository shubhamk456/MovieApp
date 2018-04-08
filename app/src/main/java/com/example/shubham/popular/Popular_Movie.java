package com.example.shubham.popular;

import java.util.ArrayList;

/**
 * Created by shubham on 3/25/2018.
 */

public class Popular_Movie {
    int page;
    int total_results;
    int total_pages;
    ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
