package com.pluralsight.Persistance;

import com.pluralsight.Models.Category;
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

}
