package com.pluralsight.Persistance;

import com.pluralsight.Models.Actor;
import com.pluralsight.Models.Category;
import com.pluralsight.Models.Film;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private BasicDataSource dataSource1;

    public DataManager(BasicDataSource dataSource1){
        this.dataSource1 = dataSource1;
    }

    public List<Category> getAllCategories() throws SQLException {

        List<Category> categories = new ArrayList<>();

        String query = """
                    SELECT
                    category_id,
                    name
                    from category""";
        try(
                Connection connection = this.dataSource1.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet results = statement.executeQuery();
        ){
            while(results.next()){
                int id = results.getInt("category_id");
                String name = results.getString("name");
                Category c = new Category(id, name);
                categories.add(c);
            }
        }
        return categories;
    }

    public List<Actor> getActorByName(String actorLastName)throws SQLException{
        List<Actor> actors = new ArrayList<>();

        try(Connection connection = dataSource1.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT actor_id, first_name, last_name FROM actor where last_name like ? ")
        ){
            preparedStatement.setString(1,actorLastName);

            try(ResultSet result = preparedStatement.executeQuery()){

                while (result.next()) {

                    int ActorID = result.getInt("actor_id");
                    String firstName = result.getString("first_name");
                    String lastName = result.getString("last_name");

                    //making the actor
                    Actor actor = new Actor(ActorID ,firstName,lastName);
                    actors.add(actor);
                }
            }
        }
        return actors;

    }


    public List<Film> getFilmByActorID(int actorID) throws SQLException {
        List<Film> films = new ArrayList<>();

        try(Connection connection = dataSource1.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    //todo fix SQL statment
                    "SELECT film.film_id, title, length, rating FROM film join film_actor on film.film_id = film_actor.film_id where film_actor.actor_id = ? ")
        ){
            preparedStatement.setInt(1,actorID);


            try(ResultSet result = preparedStatement.executeQuery()){

                while (result.next()) {

                    int filmID = result.getInt("film_id");
                    String title = result.getString("title");
                    String rating = result.getString("rating");

                    //making the actor
                    Film film = new Film(filmID,title,rating);
                    films.add(film);
                }
            }
        }
        return films;
    }

}
