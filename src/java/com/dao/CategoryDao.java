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
    
    Connection con = null;
    ResultSet resultSet = null;
    Category category = null;
    
    //SQL queries
    private static final String INSERT_CATEGORYS_SQL = "INSERT INTO vsolution_category" + "  (name) VALUES " +
        " (?);";

    private static final String SELECT_CATEGORYS_BY_ID = "select id, name from vsolution_category where id =?;";
    private static final String DELETE_CATEGORYS_SQL = "delete from vsolution_category where id = ?;";
    private static final String UPDATE_CATEGORYS_SQL = "update vsolution_category set name= ? where id = ?;";
    
    
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
    
    PreparedStatement preparedStatement = null;
    public Category selectCategory(int id) {
        // Step 1: Establishing a Connection
        try {
           con = DBConnection.createConnection();
           preparedStatement = con.prepareStatement(SELECT_CATEGORYS_BY_ID);
           preparedStatement.setInt(1, id);
           System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
           resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }
    
    public void insertCategory(Category category) throws SQLException{
        try{
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(INSERT_CATEGORYS_SQL);
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
            

        }catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public boolean deleteCategory(int id) throws SQLException {
        boolean rowDeleted = false;
        try{
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(DELETE_CATEGORYS_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted =preparedStatement.executeUpdate() > 0;
            
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateCategory(Category answer) throws SQLException {
        boolean rowUpdated = false;
        try{
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(UPDATE_CATEGORYS_SQL);
            preparedStatement.setString(1, answer.getName());
            preparedStatement.setInt(2, answer.getId());


            rowUpdated = preparedStatement.executeUpdate() > 0;
        
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
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
