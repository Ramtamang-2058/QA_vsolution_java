/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.CategoryDao;
import com.dao.QuestionDao;
import com.dao.UserDao;
import com.model.Category;
import com.model.Question;
import com.model.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ram
 */


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class AdminQestionServlet extends HttpServlet {

     private QuestionDao questionDao;
    private CategoryDao categoryDao;
    private UserDao userDao;

    @Override
    public void init() {
        questionDao = new QuestionDao();
        categoryDao = new CategoryDao();
        userDao = new UserDao();
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
                case "/admin-question-list":
                    listQuestion(request, response);
                    break;
                default:
                    listQuestion(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException ex) {
            Logger.getLogger(QuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
        String userName=(String)session.getAttribute("User");  
        String password = (String)session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< Question> listQuestion = questionDao.selectAllQuestions();
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        System.out.println("user detail are:" + user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-questions.jsp");
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
    
    private void showDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Question existingQuestion = questionDao.selectQuestion(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/questionview.jsp");
        request.setAttribute("question", existingQuestion);
        dispatcher.forward(request, response);

    }
    
    private void insertQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Date created_date = new Date(System.currentTimeMillis());
        Date edited_date = new Date(System.currentTimeMillis());
        String text = request.getParameter("question");
        int category_id = Integer.parseInt(request.getParameter("categ"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));
        try{
            Part pic_part = null;
            String name = "#" + RandGeneratedStr();
            pic_part = request.getPart("photo");
            String fileName = "/static/image/" + name + ".png";
            String contextPath = new File("").getAbsolutePath();
            String imageSavePath = "/home/ram/Downloads/javaproject/V2/web/static/image" + File.separator + fileName;
            File fileSaveDir = new File(imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            Question newQuestion = new Question(name, text, fileName, created_date, edited_date, category_id, created_by_id);
                        questionDao.insertQuestion(newQuestion);
            response.sendRedirect("list");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String text = request.getParameter("question");
        String image = request.getParameter("image");
        Date edited_date = new Date(System.currentTimeMillis());
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));

        Question question = new Question(id, text, image, edited_date, category_id, created_by_id);
        questionDao.updateQuestion(question);
        response.sendRedirect("list");
    }

    private void deleteQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        questionDao.deleteQuestion(id);
        response.sendRedirect("list");

    }
    static String RandGeneratedStr(){
        char[] chars = "abcdefghijklmnopqrstuvwxyzABSDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        Random r = new Random(System.currentTimeMillis());
        char[]id = new char[8];
        for (int i = 0;  i < 8;  i++) {
            id[i] = chars[r.nextInt(chars.length)];
        }
        return new String(id);
    }
}
