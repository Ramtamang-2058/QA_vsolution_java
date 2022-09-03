/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Message;
import com.model.Question;
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
public class MessageDao {
    private String URL = "jdbc:mysql://localhost:3306/vsolution? useSSL=false";
    private String user = "root";
    private String password = "mynewpassword";

     private static final String INSERT_MESSAGES_SQL = "INSERT INTO vsolution_message" + "  (message, image, created_date, edited_date, category_id, created_by_id) VALUES " +
        " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_MESSAGES_BY_ID = "select id, message, created_date, edited_date, receive_by_id, send_by_id from vsolution_message where id =?;";
    private static final String SELECT_ALL_MESSAGES = "select * from vsolution_message INNER JOIN users ON vsolution_message.created_by_id=users.id INNER JOIN users ON vsolution_message.receive_by_id=users.id WHERE id=?;";
    private static final String DELETE_MESSAGES_SQL = "delete from vsolution_messages where id = ?;";
    private static final String UPDATE_MESSAGES_SQL = "update vsolution_message set message = ?, edited_date=?, category_id =?, created_by_id=? where id = ?;";
    private static final String SELECT_MESSAGES_BY_USER = "SELECT * FROM vsolution_message M INNER JOIN users U ON M.send_by_id=U.id WHERE M.send_by_id OR M.receive_by_id=?;";
    private static final String SELECT_USERS_BY_MESSAGE = "SELECT * FROM users U INNER JOIN vsolution_message M ON M.send_by_id=U.id WHERE M.send_by_id OR M.receive_by_id=?;";
//    SELECT * FROM users U INNER JOIN vsolution_message M ON M.send_by_id=U.id WHERE M.send_by_id=1 AND M.receive_by_id=2 OR M.receive_by_id=1 AND M.send_by_id=2;
    private static final String MESSAGE = "SELECT * FROM vsolution_message WHERE send_by_id=? AND receive_by_id=? OR receive_by_id=? AND send_by_id=?;";
    
    public MessageDao(){}

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
    public void insertMessage(Message message) throws SQLException{
        try(
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MESSAGES_SQL);
        ){
            preparedStatement.setString(1, message.getMessage());
            preparedStatement.setDate(2, message.getCreated_date());
            preparedStatement.setDate(3, message.getEdited_date());
            preparedStatement.setInt(4, message.getReceive_by());
            preparedStatement.setInt(5, message.getSend_by());
            preparedStatement.executeUpdate();
            

        }catch (SQLException e) {
            printSQLException(e);
        }
    }
    public Message selectMessage(int id) {
        Message message = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MESSAGES_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String text = rs.getString("message");
                Date created_date = rs.getDate("created_date");
                Date edited_date = rs.getDate("edited_date");
                int receive_by_id = rs.getInt("receive_by_id");
                int send_by_id = rs.getInt("send_by_id");
                message = new Message(id, text, created_date, edited_date, receive_by_id, send_by_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return message;
    }
    
    public Message selectMessageByUser(int id) {
        Message message = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MESSAGES_BY_USER);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String text = rs.getString("message");
                Date created_date = rs.getDate("created_date");
                Date edited_date = rs.getDate("edited_date");
                int receive_by_id = rs.getInt("receive_by_id");
                int send_by_id = rs.getInt("send_by_id");
                message = new Message(id, text, created_date, edited_date, receive_by_id, send_by_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return message;
    }

    public List < Message > selectAllMessages(int id) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Message > messages = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_MESSAGE);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String text = rs.getString("message");
                String username = rs.getString("fullname");
                String receiver = rs.getString("fullname");
                String profile = rs.getString("profile");
                Date created_date = rs.getDate("created_date");
                Date edited_date = rs.getDate("edited_Date");
                int receive_by_id = rs.getInt("receive_by_id");
                int send_by_id = rs.getInt("send_by_id");
                System.out.println(username);
                messages.add(new Message(id, text, username, receiver, profile, created_date, edited_date, receive_by_id, send_by_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return messages;
    }
    
    public List < Message > Messages(int id1, int id2) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Message > messages = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(MESSAGE);) {
            preparedStatement.setInt(1, id1);
            preparedStatement.setInt(2, id2);
            preparedStatement.setInt(3, id1);
            preparedStatement.setInt(4, id2);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String text = rs.getString("message");
                Date created_date = rs.getDate("created_date");
                Date edited_date = rs.getDate("edited_Date");
                int receive_by_id = rs.getInt("receive_by_id");
                int send_by_id = rs.getInt("send_by_id");
                messages.add(new Message(id, text, created_date, edited_date, receive_by_id, send_by_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return messages;
    }

    public boolean deleteMessage(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MESSAGES_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateMessage(Message message) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_MESSAGES_SQL);) {
            statement.setString(1, message.getMessage());
            statement.setDate(2, message.getCreated_date());
            statement.setDate(3, message.getEdited_date());
            statement.setInt(4, message.getReceive_by());
            statement.setInt(5, message.getSend_by());
            statement.setInt(6, message.getId());


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
