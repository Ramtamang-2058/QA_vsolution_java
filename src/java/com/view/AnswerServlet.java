/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.AnswerDao;
import com.dao.QuestionDao;
import com.dao.UserDao;
import com.model.Answer;
import com.model.Category;
import com.model.Question;
import com.model.User;
import static com.view.QuestionServlet.RandGeneratedStr;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
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
public class AnswerServlet extends HttpServlet {

    private AnswerDao answerDao;
    private UserDao userDao;
    private QuestionDao questionDao;

    @Override
    public void init() {
        answerDao = new AnswerDao();
        userDao = new UserDao();
        questionDao = new QuestionDao();
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
                case "/new-answer":
                    showNewForm(request, response);
                    break;
                case "/post-Answer":
                    System.out.println("I am here");
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

                case "/view-Answer":
                    listAnswer(request, response);
                    break;
                case "/myanswer":
                    userlistAnswer(request, response);
                    break;
                case "/listAnswerByQuestion":
                    listAnswerByQuestion(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< Answer> listAnswer = answerDao.selectAllAnswers();
        request.setAttribute("listAnswer", listAnswer);
        
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewAllAnswer.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private void listAnswerByQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        int id = Integer.parseInt(request.getParameter("id"));
        List< Answer> listAnswer = answerDao.selectAllAnswersByQuestion(id);
        Question existingQuestion = questionDao.selectQuestion(id);
        request.setAttribute("listAnswer", listAnswer);
        request.setAttribute("question", existingQuestion);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewAllAnswerByQuestion.jsp");
        dispatcher.forward(request, response);
    }
    
    private void userlistAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< Answer> listAnswer = answerDao.selectAllAnswers();
        request.setAttribute("listAnswer", listAnswer);
        
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/myasnwer.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        String name = "#" + RandGeneratedStr();
        request.setAttribute("ticket", name);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        System.out.println("Hellow: "+ userName);
        request.setAttribute("message", "Question ticket was created successfully.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addanswer.jsp");
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
        Answer existingAnswer = answerDao.selectAnswer(id);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addanswer.jsp");
        request.setAttribute("answer", existingAnswer);
        dispatcher.forward(request, response);


    }

    private void insertAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Date created_date = new Date(System.currentTimeMillis());
        Date edited_date = new Date(System.currentTimeMillis());
        String code = request.getParameter("code");
        int question_id = 2;
        String text = request.getParameter("answer");
        int created_by_id= Integer.parseInt(request.getParameter("created_by"));
        System.out.println(created_by_id);
        try {
            Part pic_part = null;
            String name = code;
            pic_part = request.getPart("image");
            String fileName = "static/answer/" + name + ".png";
            String contextPath = new File("").getAbsolutePath();
            String imageSavePath = "/home/ram/Downloads/javaproject/V2/web" + File.separator + fileName;
            File fileSaveDir = new File(imageSavePath);
            System.out.println(imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            System.out.println("Hellow");
            System.out.println(imageSavePath);
            Answer  newAnswer= new Answer(code, fileName, text, created_date, edited_date, created_by_id, question_id);
            answerDao.insertAnswer(newAnswer);
            response.sendRedirect("view-Answer");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    

    private void updateAnswer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String text = request.getParameter("answer");
        String question = "sdf";
        String image = request.getParameter("image");
        Date created_date = new Date(System.currentTimeMillis());
        Date edited_date = new Date(System.currentTimeMillis());
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
