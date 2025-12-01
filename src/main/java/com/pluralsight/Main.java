package com.pluralsight;

import com.pluralsight.Models.Category;
import com.pluralsight.UserInterface.InputCollector;
import com.pluralsight.UserInterface.SakilaConsoleAPp;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {


        if(!ensureArgs){
            return;
        }

        try{



        }catch (Exception e ){
            System.out.println("There was a SQL exception: " + e.getMessage());
        }

        BasicDataSource dataSource =getDataSource(args);

        SakilaConsoleAPp app = new SakilaConsoleAPp();
        app.start();



        try{ List<Category> categories = getAllCategories(basicDataSource);
             InputCollector.displayList(categories);

        }catch (SQLException e ){
            System.out.println("There was a SQL Error: " + e.getMessage());
        }

    }

    private boolean ensureArgs(String[] args){


    }

    private static BasicDataSource getDataSource(String userName , String password , String URL) throws SQLException {

        try(BasicDataSource basicDataSource = new BasicDataSource()){
            basicDataSource.setUrl(URL);
            basicDataSource.setUsername(userName);
            basicDataSource.setPassword(password);
            return basicDataSource;
        }


    }

    private static BasicDataSource getDataSource(String[]args) throws SQLException {
            String username = args[0];
            String password = args[1];
            String URL = args[2];
            return getDataSource(username,password,URL);
    }

}