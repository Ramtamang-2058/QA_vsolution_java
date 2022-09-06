/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.config.DBConnection;
import com.model.Answer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ram
 */
public class AnswerDao {
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
    Answer answers = null;
    
    //SQL queries
    private static final String INSERT_ANSWERS_SQL = "INSERT INTO vsolution_answer" + "  (image, question, category_id, created_by_id) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_ANSWERS_BY_ID = "select id, code, image, answer, created_date, edited_date, category_id, created_by_id from vsolution_answer where id =?;";
    private static final String SELECT_ALL_ANSWERS = "select * from vsolution_answer";
    private static final String DELETE_ANSWERS_SQL = "delete from vsolution_answer where id = ?;";
    private static final String UPDATE_ANSWERS_SQL = "update vsolution_answer set image= ?, answer = ?, created_date=?, edited_date=?, category_id =?, created_by_id=? where id = ?;";
    private static final String SELECT_ANSWER= "SELECT * FROM vsolution_answer INNER JOIN users ON vsolution_answer.created_by_id=users.id;";
    
    PreparedStatement preparedStatement = null;
    public Answer selectAnswer(int id) {
        // Step 1: Establishing a Connection
        try {
           con = DBConnection.createConnection();
           preparedStatement = con.prepareStatement(SELECT_ANSWERS_BY_ID);
           preparedStatement.setInt(1, id);
           System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
           resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String image = resultSet.getString("image");
                String text = resultSet.getString("answer");
                String question = resultSet.getString("question");
                System.out.println(question);
                Date created_date = resultSet.getDate("created_date");
                Date edited_date = resultSet.getDate("edited_Date");
                int category_id = resultSet.getInt("category_id");
                int created_by_id = resultSet.getInt("created_by_id");
                answers = new Answer(id, code, image, text, created_date, edited_date, category_id, created_by_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return answers;
    }
    
    public void insertAnswer(Answer answer) throws SQLException{
        try{
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(INSERT_ANSWERS_SQL);
            preparedStatement.setString(1, answer.getAnswer());
            preparedStatement.setString(2, answer.getImage());
            preparedStatement.setInt(2, answer.getCreated_by());
            preparedStatement.setInt(4, answer.getQuestion());
            

        }catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    //LIST OF ANSWER
    public List < Answer > selectAllAnswers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Answer > answers = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try{
            con = DBConnection.createConnection();
            // Step 2:Create a statement using connection object
            preparedStatement = con.prepareStatement(SELECT_ANSWER);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String text = resultSet.getString("answer");
                String user = resultSet.getString("fullname");
                String image = resultSet.getString("image");
                Date created_date = resultSet.getDate("created_date");
                Date edited_date = resultSet.getDate("edited_Date");
                int question_id = resultSet.getInt("question_id");
                int created_by_id = resultSet.getInt("created_by_id");
                System.out.println(id + "  " + user+"   "+question_id);
                answers.add(new Answer(id, code, image, text, user, created_date, edited_date, question_id, created_by_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return answers;
    }

    public boolean deleteAnswer(int id) throws SQLException {
        boolean rowDeleted = false;
        try{
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(DELETE_ANSWERS_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted =preparedStatement.executeUpdate() > 0;
            
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateAnswer(Answer answer) throws SQLException {
        boolean rowUpdated = false;
        try{
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(UPDATE_ANSWERS_SQL);
            preparedStatement.setString(2, answer.getImage());
            preparedStatement.setString(1, answer.getAnswer());
            preparedStatement.setDate(3, answer.getCreatedDate());
            preparedStatement.setDate(4, answer.getEditedDate());
            preparedStatement.setInt(5, answer.getQuestion());
            preparedStatement.setInt(6, answer.getCreated_by());
            preparedStatement.setInt(7, answer.getId());


            rowUpdated = preparedStatement.executeUpdate() > 0;
        
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }
    
    //PRINT SQL EXCEPTION ERRORS
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
