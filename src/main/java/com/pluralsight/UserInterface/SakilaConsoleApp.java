package com.pluralsight.UserInterface;

import com.pluralsight.Models.Actor;
import com.pluralsight.Models.Category;
import com.pluralsight.Persistance.DataManager;

import java.sql.SQLException;
import java.util.List;

public class SakilaConsoleApp {

    private DataManager dataManager;

    public SakilaConsoleApp(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public void start(){
        String prompt = """
                Please Select an option
                    1 - List all Categories
                    2 - List all Films
                    3 - List Films by Category
                    4 - List Actors by Name
                    0 - Quit 
                Command """;

        int choice = -1;

        while (choice != 0 ){
            choice = InputCollector.promptForInt(prompt);
            
            switch (choice){
                case 1 : listAllCategories();
                break;
                case 2 : listAllFilms();
                    break;
                case 3 : listAllFilmsByCategory();
                    break;
                case 4 : listActorsByName();
                    break;
                case 0:
                    return;
                default:
            }
        }
    }

    private void listActorsByName() {
        try{

           String lastName = InputCollector.promptForString("What is the last name of the actor");
            List<Actor> actors = dataManager.getActorByName(lastName);
            InputCollector.displayList(actors);

        }catch(SQLException e){
            System.out.println("Error: " +  e.getMessage());
        }
    }

    private void listAllFilmsByCategory() {
    }

    private void listAllFilms() {
    }


    private void listAllCategories() {
        try{

            List<Category> categories = dataManager.getAllCategories();
            InputCollector.displayList(categories);

        }catch(SQLException e){
            System.out.println("Error: " +  e.getMessage());
        }

    }
}
