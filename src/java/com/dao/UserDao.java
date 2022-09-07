/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ram
 */
public class UserDao {
    private String URL = "jdbc:mysql://localhost:3306/vsolution? useSSL=false";
    private String user = "root";
    private String password = "mynewpassword";

     private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (fullname, email, username, password, role, profile, faculty) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USERS_BY_ID = "select id, fullname, email, username, password, role, profile, semester, faculty from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set fullname=?, email=?, username=?, password=?, role=?, profile=?, semester=?, faculty=? where id = ?;";
    private static final String SELECT_USERS_BY_USERNAME_AND_PASSWORD = "select id, fullname, email, username, password, role, profile, semester, faculty from users where username=? AND password=?;";

    
    public UserDao(){}

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, user, password);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
    public void insertUser(User user) throws SQLException{
        try(
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        ){
            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getProfile());
            preparedStatement.setString(6, user.getSemester());
            preparedStatement.setString(6, user.getFaculty());
            preparedStatement.executeUpdate();
            

        }catch (SQLException e) {
            printSQLException(e);
        }
    }
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String profile = rs.getString("profile");
                String semester = rs.getString("semester");
                String faculty = rs.getString("faculty");
                user = new User(id, fullname, email, username, password, role, profile, semester, faculty);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    
    public User getUser(String username, String password) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_USERNAME_AND_PASSWORD);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String usr = rs.getString("username");
                String psw = rs.getString("password");
                String role = rs.getString("role");
                String profile = rs.getString("profile");
                String semester = rs.getString("semester");
                String faculty = rs.getString("faculty");
                user = new User(id, fullname, email, usr, psw, role, profile, semester, faculty);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < User > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < User > users = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String profile = rs.getString("profile");
                String semester = rs.getString("semester");
                String faculty = rs.getString("faculty");
                users.add(new User(id, fullname, email, username, password, role, profile, semester, faculty));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            statement.setString(6, user.getProfile());
            statement.setString(6, user.getSemester());
            statement.setString(6, user.getFaculty());
            statement.setInt(7, user.getId());


            rowUpdated = statement.executeUpdate() > 0;
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
