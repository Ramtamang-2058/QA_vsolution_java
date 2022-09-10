/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.view;

import com.dao.CategoryDao;
import com.dao.MessageDao;
import com.dao.MessageDao;
import com.dao.UserDao;
import com.model.Category;
import com.model.Message;
import com.model.Message;
import com.model.User;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ram
 */
public class MessageServlet extends HttpServlet {
    private MessageDao messageDao;
    private CategoryDao categoryDao;
    private UserDao userDao;

    public void init() {
        messageDao = new MessageDao();
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
                case "/new-message":
                    insertMessage(request, response);
                    break;
                case "/delete":
                    deleteMessage(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMessage(request, response);
                    break;
                case "/message-list":
                    listMessage(request, response);
                    break;
                case "/my-messages":
                    userMessages(request, response);
                    break;
                default:
                    listMessage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException ex) {
            Logger.getLogger(MessageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listMessage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
         HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        int id1 = Integer.parseInt(request.getParameter("id1"));
        int id2= Integer.parseInt(request.getParameter("id2"));
        List< Message > listMessage = messageDao.Messages(id1, id2);
        User existingUser = userDao.selectUser(id1);
        List< User> listUser = userDao.selectAllUsers();
        System.out.println("All category list from listMessage: " + listMessage);
        request.setAttribute("listMessage", listMessage);
        request.setAttribute("listUser", listUser);
        request.setAttribute("user", user);
        request.setAttribute("sender", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Messsage.jsp");
        dispatcher.forward(request, response);
    }
    
    private void userMessages(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
         HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< User> listUser = userDao.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Message.jsp");
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
    private void insertMessage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Date created_date = new Date(System.currentTimeMillis());
        Date edited_date = new Date(System.currentTimeMillis());
        String text = request.getParameter("message");
        int send_by_id = Integer.parseInt(request.getParameter("sender"));
        int receive_by_id = Integer.parseInt(request.getParameter("receiver"));
        Message newMessage = new Message(text, created_date, edited_date, receive_by_id, send_by_id);
        messageDao.insertMessage(newMessage);
      response.sendRedirect("message-list?id1=1&id2=2");
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List< Category> listCategory = categoryDao.selectAllCategories();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-messages.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateMessage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String text = request.getParameter("message");
        String image = request.getParameter("image");
        Date edited_date = new Date(System.currentTimeMillis());
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int created_by_id = Integer.parseInt(request.getParameter("created_by_id"));

//        Message message = new Message(id, text, image, edited_date, category_id, created_by_id);
//        messageDao.updateMessage(message);
        response.sendRedirect("list");
    }

    private void deleteMessage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        messageDao.deleteMessage(id);
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
