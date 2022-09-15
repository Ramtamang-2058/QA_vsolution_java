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
import java.io.IOException;
import java.util.Random;
import java.io.File;
import javax.servlet.annotation.MultipartConfig;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ram
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class QuestionServlet extends HttpServlet {

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
                case "/edit-question":
                    System.out.println("fafdasdfsadf");
                    showEditForm(request, response);
                    break;
                case "/update-question":
                    updateQuestion(request, response);
                    break;
                case "/question-list":
                    listQuestion(request, response);
                    break;
                case "/myquestions":
                    userlistQuestion(request, response);
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
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< Question> listQuestion = questionDao.selectAllQuestions();
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        System.out.println("user detail are:" + user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/Home.jsp");
        dispatcher.forward(request, response);
    }
    
    private void userlistQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< Question> listQuestion = questionDao.selectAllQuestions();
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        System.out.println("user detail are:" + user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/myquestion.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< Category> listCategory = categoryDao.selectAllCategories();
        String name = "#" + RandGeneratedStr();
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("ticket", name);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        request.setAttribute("message", "Question ticket was created successfully.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-questions.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("user:" + user);
        Question existingQuestion = questionDao.selectQuestion(id);
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-questions.jsp");
        request.setAttribute("question", existingQuestion);
        dispatcher.forward(request, response);

    }

    private void insertQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        Date created_date = new Date(System.currentTimeMillis());
        Date edited_date = new Date(System.currentTimeMillis());
        String text = request.getParameter("question");
        int category_id = Integer.parseInt(request.getParameter("category"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by"));
        String code = request.getParameter("code");
        String semester = request.getParameter("semester");
        String faculty = request.getParameter("faculty");
        String subject = request.getParameter("subject");
        try {
            Part pic_part = null;
            String name = code;
            pic_part = request.getPart("photo");
            String fileName = "/static/image/" + name + ".png";
            String contextPath = new File("").getAbsolutePath();
            String imageSavePath = "/home/ram/Downloads/javaproject/V2/web" + File.separator + fileName;
            File fileSaveDir = new File(imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            Question newQuestion = new Question(text, fileName, created_date, edited_date, category_id, created_by_id, code, semester, subject, faculty);
            questionDao.insertQuestion(newQuestion);
            response.sendRedirect("question-list");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        System.out.println("update servlet");
        int id = Integer.parseInt(request.getParameter("id"));
//        SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");  
        Date edited_date = new Date(System.currentTimeMillis());
//        Date created_date=(Date) formatter2.parse(created);
        String text = request.getParameter("question");
        int category_id = Integer.parseInt(request.getParameter("category"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by"));
        String code = request.getParameter("code");
        String semester = request.getParameter("semester");
        String faculty = request.getParameter("faculty");
        String subject = request.getParameter("subject");
        try {
            Part pic_part = null;
            String name = code;
            pic_part = request.getPart("photo");
            String fileName = "/static/image/" + name + ".png";
            String contextPath = new File("").getAbsolutePath();
            String imageSavePath = "/home/ram/Downloads/javaproject/V2/web" + File.separator + fileName;
            File fileSaveDir = new File(imageSavePath);
            System.out.println(imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            System.out.println("Hellow");
            System.out.println(imageSavePath);
            Question question = new Question(id, text, fileName, edited_date, category_id, created_by_id, code, semester, subject, faculty);
            questionDao.updateQuestion(question);
            response.sendRedirect("question-list");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void deleteQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        questionDao.deleteQuestion(id);
        response.sendRedirect("list");

    }

    static String RandGeneratedStr() {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABSDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        Random r = new Random(System.currentTimeMillis());
        char[] id = new char[8];
        for (int i = 0; i < 8; i++) {
            id[i] = chars[r.nextInt(chars.length)];
        }
        return new String(id);
    }
}
