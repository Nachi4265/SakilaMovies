package com.pluralsight.Models;

public class film {

    private int ID;
    private String Title;
    private int length;
    private String rating ;

    public film(int ID, String title, int length, String rating) {
        this.ID = ID;
        Title = title;
        this.length = length;
        this.rating = rating;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "film{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", length=" + length +
                ", rating='" + rating + '\'' +
                '}';
    }
}
