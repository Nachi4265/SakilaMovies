package com.pluralsight.Models;

import java.util.ArrayList;
import java.util.List;

public class Film {

    private int ID;
    private String Title;
    private String rating ;
    private List<Actor> actors;

    public Film(int ID, String title, String rating) {
        this.ID = ID;
        this.Title = title;
        this.rating = rating;
        this.actors = new ArrayList<>();
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("------------------------\n ID: %-10d \n Movie Title: %-5s \n  Rating: %-40s \n " , ID , Title, rating);
    }





}
