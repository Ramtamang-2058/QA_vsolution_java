package com.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.QuestionDao;
import com.model.Question;


@WebServlet("/")
public class views extends HttpServlet {
    private QuestionDao questionDao;

    public void init() {
        questionDao = new QuestionDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertQuestion(request, response);
                    break;
                case "/delete":
                    deleteQuestion(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateQuestion(request, response);
                    break;
               
                default:
                    listQuestion(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listQuestion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Question > listQuestion = questionDao.selectAllQuestions();
        request.setAttribute("listQuestion", listQuestion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("question-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("question-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Question existingQuestion = questionDao.selectQuestion(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("question-form.jsp");
        request.setAttribute("question", existingQuestion);
        dispatcher.forward(request, response);

    }

    private void insertQuestion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String text = request.getParameter("name");
        String image = request.getParameter("image");  
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));
        Question newQuestion = new Question(text, image, category_id, created_by_id);
        questionDao.insertQuestion(newQuestion);
        response.sendRedirect("list");
    }

    private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String text = request.getParameter("question");
        String image = request.getParameter("image");
        String created_date = request.getParameter("created_date");
        String edited_date = request.getParameter("edited_date");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));

        Question question = new Question(id, text, image, created_date, edited_date, category_id, created_by_id);
        questionDao.updateQuestion(question);
        response.sendRedirect("list");
    }

    private void deleteQuestion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        questionDao.deleteQuestion(id);
        response.sendRedirect("list");

    }
}