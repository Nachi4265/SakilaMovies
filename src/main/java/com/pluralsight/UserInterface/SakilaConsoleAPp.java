package com.pluralsight.UserInterface;

import com.pluralsight.Models.Category;
import com.pluralsight.Persistance.DataManager;

import java.sql.SQLException;

public class SakilaConsoleAPp {

    private DataManager dataManager;

    public void start(){
        String prompt = """
                Please Select an option
                    1 - List all Categories
                    2 - List all Films
                    3 - List Filmas by Category
                    0 - Quit 
                Command: """;

        int choice = -1;

        while (choice ! = 0 ){
            choice = InputCollector.promptForInt(prompt);
            
            switch (choice){
                case 1 : listAllCategories();
                break;
            }
        }
    }

    private void listAllCategories() {
        try{List<Category> categories = dataManager.getAllCategories();
            InputCollector.displayList(categories);
        }catch(SQLException e){
            System.out.println("Error: " +  e.getMessage());
        }

    }
}
