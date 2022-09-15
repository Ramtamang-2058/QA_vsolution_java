/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.CategoryDao;
import com.dao.UserDao;
import com.dao.MessageDao;
import com.model.Category;
import com.model.Message;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ram
 */
public class AdminUserServlet extends HttpServlet {
    private UserDao userDao;
    private CategoryDao categoryDao;
    private MessageDao messageDao;

    @Override
    public void init() {
        userDao = new UserDao();
        categoryDao = new CategoryDao();
        messageDao = new MessageDao();
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
                case "/user-new":
                    showNewForm(request, response);
                    break;
                case "/user-insert":
                    insertUser(request, response);
                    break;
                case "/user-delete":
                    deleteUser(request, response);
                    break;
                case "/user-edit":
                    showEditForm(request, response);
                    break;
                case "/user-update":
                    updateUser(request, response);
                    break;
                case "/userprofile":
                    userDetail(request, response);
                    break;
                case "/admin-user-list":
                    listUser(request, response);
                    break;
                case "/sendmessage":
                    insertMessage(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
        String userName=(String)session.getAttribute("User");  
        String password = (String)session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        List< User> listUser = userDao.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/users.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List< Category> listCategory = categoryDao.selectAllCategories();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-users.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }
    
    private void userDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
        String userName=(String)session.getAttribute("User");  
        String password = (String)session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.selectUser(id);
        request.setAttribute("userName", userName);
        request.setAttribute("user", user);
        request.setAttribute("usr", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/userprofile.jsp");
        dispatcher.forward(request, response);

    }
    
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String semester = request.getParameter("semester");
        String faculty = request.getParameter("faculty");
        try{
            Part pic_part = null;
            pic_part = request.getPart("profile");
            String fileName = "/static/user/profile/" + username + ".png";
            String contextPath = new File("").getAbsolutePath();
            System.out.println("Context Path: " + contextPath);
            String imageSavePath = "/home/ram/Downloads/javaproject/V2/web/static/user/profile" + File.separator + fileName;
            File fileSaveDir = new File(imageSavePath);
            pic_part.write(imageSavePath + File.separator);
            User newUser = new User(fullname, email, username, password, role, fileName, semester, faculty);
                        userDao.insertUser(newUser);
            response.sendRedirect("list");
        } catch (Exception e) {
            System.out.println(e);
        }
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
      response.sendRedirect("userprofile?id="+send_by_id);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String profile = request.getParameter("profile");
        String semester = request.getParameter("semester");
        String faculty = request.getParameter("faculty");

        User user = new User(id, fullname, email, username, password, role, profile, semester, faculty);
        userDao.updateUser(user);
        response.sendRedirect("user-list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("user-list");

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
