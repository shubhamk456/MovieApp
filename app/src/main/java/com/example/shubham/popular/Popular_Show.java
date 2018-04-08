package com.example.shubham.popular;

import java.util.ArrayList;

/**
 * Created by shubham on 4/7/2018.
 */

public class Popular_Show{
        int page;
        int total_results;
        int total_pages;
        ArrayList<Show> results;

        public ArrayList<Show> getResults() {
            return results;
        }

        public void setResults(ArrayList<Show> results) {
            this.results = results;
        }
}
