/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.AnswerDao;
import com.model.Answer;
import com.model.Question;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ram
 */
public class AnswerServlet extends HttpServlet {

    private AnswerDao answerDao;

    @Override
    public void init() {
        answerDao = new AnswerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new_answer":
                    showNewForm(request, response);
                    break;
                case "/post_answer":
                    insertAnswer(request, response);
                    break;
                case "/delete_answer":
                    deleteAnswer(request, response);
                    break;
                case "/edit_answer":
                    showEditForm(request, response);
                    break;
                case "/update_answer":
                    updateAnswer(request, response);
                    break;

                case "/viewAnswer":
                    listAnswer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Answer> listAnswer = answerDao.selectAllAnswers();
        request.setAttribute("listAnswer", listAnswer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Answers.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("new-answers.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Answer existingAnswer = answerDao.selectAnswer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-answers.jsp");
        request.setAttribute("answer", existingAnswer);
        dispatcher.forward(request, response);

    }
    private void insertAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String text = request.getParameter("name");
        String image = request.getParameter("image");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));
        Answer newAnswer = new Answer(text, image, category_id, created_by_id);
        answerDao.insertAnswer(newAnswer);
        response.sendRedirect("list");
    }

    private void updateAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String text = request.getParameter("answer");
        String question ="sdf";
        String image = request.getParameter("image");
        String created_date = request.getParameter("created_date");
        String edited_date = request.getParameter("edited_date");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));

        Answer answer = new Answer(id, image, question, text, created_date, edited_date, category_id, created_by_id);
        answerDao.updateAnswer(answer);
        response.sendRedirect("list");
    }

    private void deleteAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        answerDao.deleteAnswer(id);
        response.sendRedirect("list");

    }
}
