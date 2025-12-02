package com.pluralsight.Models;

public class Actor {

    private int ID;
    private int filmID;
    private String firstName;
    private String lastName;

    public Actor(int ID, int filmID, String firstName, String lastName) {
        this.ID = ID;
        this.filmID = filmID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor( int filmID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "ID=" + ID +
                ", filmID=" + filmID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
