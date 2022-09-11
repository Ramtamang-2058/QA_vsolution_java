/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.CategoryDao;
import com.dao.UserDao;
import com.model.Category;
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
import javax.servlet.http.Part;

/**
 *
 * @author ram
 */


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)

public class UserServlet extends HttpServlet {

    private UserDao userDao;
    private CategoryDao categoryDao;

    @Override
    public void init() {
        userDao = new UserDao();
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
                case "/user-list":
                    listUser(request, response);
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
        List< User> listUser = userDao.selectAllUsers();
        List< Category> listCategory = categoryDao.selectAllCategories();
        System.out.println("All category list from listUser: " + listCategory);
        request.setAttribute("listUser", listUser);
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/Home.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String faculty = request.getParameter("faculty");
        String semester = request.getParameter("semester");
        String password = request.getParameter("password");
        String role = "User";
        String fullname = first_name + last_name;
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-users.jsp");
        request.setAttribute("user", existingUser);
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
