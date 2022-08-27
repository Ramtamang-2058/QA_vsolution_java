/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.CategoryDao;
import com.dao.QuestionDao;
import com.model.Category;
import com.model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
public class QuestionServlet extends HttpServlet {

    private QuestionDao questionDao;
    private CategoryDao categoryDao;

    @Override
    public void init() {
        questionDao = new QuestionDao();
        categoryDao = new CategoryDao();
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
        List< Question> listQuestion = questionDao.selectAllQuestions();
        List< Category> listCategory = categoryDao.selectAllCategories();
        System.out.println("All category list from listQuestion: " + listCategory);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/Home.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("new-questions.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Question existingQuestion = questionDao.selectQuestion(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-questions.jsp");
        request.setAttribute("question", existingQuestion);
        dispatcher.forward(request, response);

    }
    private void insertQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String text = request.getParameter("name");
        String image = request.getParameter("image");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));
        try {
                    Part pic_part = null;
                    pic_part = request.getPart("cover_photo");
                    //String fileName = validateVendor.extractFileName(pic_part);
                    String fileName = bookname + "-vendor" + vendor_id + ".png";
                    //String contextPath = request.getContextPath();
                    String contextPath = new File("").getAbsolutePath();
                    System.out.println("Context Path: " + contextPath);
                    String imageSavePath = "\\web\\images\\book_cover_photos" + File.separator + fileName;
                    File fileSaveDir = new File(imageSavePath);
                    pic_part.write(imageSavePath + File.separator);
        }catch (Exception e) {
                    System.out.println(e);
        }
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
