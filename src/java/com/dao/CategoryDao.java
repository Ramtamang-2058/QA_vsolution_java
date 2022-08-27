/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;
import java.util.List;

import com.config.DBConnection;
import com.model.Category;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ram
 */
public class CategoryDao {
    public List < Category > selectAllCategories(){
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        List <Category> categories = new ArrayList<>();
        try{
           con = DBConnection.createConnection();
           statement = con.createStatement();
           resultSet = statement.executeQuery("SELECT * FROM vsolution_category LIMIT 100;");

           while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            categories.add(new Category(id, name));
           }
        }catch(SQLException e){
            printSQLException(e);
        }
        return categories;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
