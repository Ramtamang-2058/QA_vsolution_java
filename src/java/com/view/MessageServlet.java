/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import com.dao.CategoryDao;
import com.dao.MessageDao;
import com.dao.QuestionDao;
import com.model.Category;
import com.model.Question;
import com.model.Message;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ram
 */
public class MessageServlet extends HttpServlet {
    private QuestionDao questionDao;
    private MessageDao messageDao;
    private CategoryDao categoryDao;

    public void init() {
        messageDao = new MessageDao();
        questionDao = new QuestionDao();
        categoryDao = new CategoryDao();
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
                case "/message-list":
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
        int id1 = 1;
        int id2=2;
        List< Message > listMessage = messageDao.Messages(id1, id2);
        System.out.println("All category list from listQuestion: " + listMessage);
        request.setAttribute("listMessage", listMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Messsage.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Message existingMessage = messageDao.selectMessageByUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
        request.setAttribute("message", existingMessage);
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
            String fileName = "/static/image/#" + name + ".png";
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
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-questions.jsp");
        dispatcher.forward(request, response);
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
