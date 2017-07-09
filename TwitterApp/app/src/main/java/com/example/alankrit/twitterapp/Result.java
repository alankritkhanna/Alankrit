package com.example.alankrit.twitterapp;

import java.util.ArrayList;

/**
 * Created by Alankrit on 07-Jul-17.
 */

public class Result {

    ArrayList<Statuses> statuses;

    public Result(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }
}
