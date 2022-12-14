/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.sql.Connection;
import com.model.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
/**
 *
 * @author ram
 */
public class QuestionDao {
    private String URL = "jdbc:mysql://localhost:3306/vsolution? useSSL=false";
    private String user = "root";
    private String password = "mynewpassword";

     private static final String INSERT_QUESTIONS_SQL = "INSERT INTO vsolution_question" + "  (question, image, created_date, edited_date, category_id, created_by_id, code, semester, subject, faculty) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_QUESTIONS_BY_ID = "select Q.id, code, question, image, fullname, profile, created_date, edited_date, category_id, created_by_id, code, Q.semester, subject, Q.faculty from vsolution_question  Q INNER JOIN users U ON Q.created_by_id=U.id where Q.id =?;";
    private static final String SELECT_ALL_QUESTIONS = "select * from vsolution_question INNER JOIN users ON vsolution_question.created_by_id=users.id order by created_date desc;";
    private static final String DELETE_QUESTIONS_SQL = "delete from questions where id = ?;";
    private static final String UPDATE_QUESTIONS_SQL = "update vsolution_question set question=?, image=?, edited_date=?, category_id=?, created_by_id=?, code=?, semester=?, subject=?, faculty=? where id = ?;";

    public QuestionDao(){}

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
    public void insertQuestion(Question question) throws SQLException{
        try(
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUESTIONS_SQL);
        ){
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getImage());
            preparedStatement.setDate(3, question.getCreated_date());
            preparedStatement.setDate(4, question.getEdited_date());
            preparedStatement.setInt(5, question.getCategory());
            preparedStatement.setInt(6, question.getCreated_by());
            preparedStatement.setString(7, question.getCode());
            preparedStatement.setString(8, question.getSemester());
            preparedStatement.setString(9, question.getSubject());
            preparedStatement.setString(10, question.getFaculty());
            preparedStatement.executeUpdate();
            

        }catch (SQLException e) {
            printSQLException(e);
        }
    }
    public Question selectQuestion(int id) {
        Question question = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTIONS_BY_ID);) {
            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String code = rs.getString("code");
                String text = rs.getString("question");
                String image = rs.getString("image");
                String fullname = rs.getString("fullname");
                String profile = rs.getString("profile");
                Date created_date = rs.getDate("created_date");
                Date edited_date = rs.getDate("edited_Date");
                int category_id = rs.getInt("category_id");
                int created_by_id = rs.getInt("created_by_id");
                String semester = rs.getString("semester");
                String subject = rs.getString("subject");
                String faculty = rs.getString("faculty");
                question = new Question(id, code, text, image, fullname, profile, created_date, edited_date, category_id, created_by_id, semester, subject, faculty);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return question;
    }

    public List < Question > selectAllQuestions() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Question > questions = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTIONS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String text = rs.getString("question");
                String image = rs.getString("image");
                String username = rs.getString("fullname");
                String profile = rs.getString("profile");
                Date created_date = rs.getDate("created_date");
                Date edited_date = rs.getDate("edited_Date");
                int category_id = rs.getInt("category_id");
                int created_by_id = rs.getInt("created_by_id");
                String semester = rs.getString("semester");
                String subject = rs.getString("subject");
                String faculty = rs.getString("faculty");
                questions.add(new Question(id, code, text, image, username, profile, created_date, edited_date, category_id, created_by_id, semester, subject, faculty));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return questions;
    }

    public boolean deleteQuestion(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_QUESTIONS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateQuestion(Question question) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUESTIONS_SQL);) {
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getImage());
            preparedStatement.setDate(3, question.getEdited_date());
            preparedStatement.setInt(4, question.getCategory());
            preparedStatement.setInt(5, question.getCreated_by());
            preparedStatement.setString(6, question.getCode());
            preparedStatement.setString(7, question.getSemester());
            preparedStatement.setString(8, question.getSubject());
            preparedStatement.setString(9, question.getFaculty());
            preparedStatement.setInt(10, question.getId());
            preparedStatement.executeUpdate();


            rowUpdated = preparedStatement.executeUpdate() > 0;
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
