/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.UserDao;
import com.model.User;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ram
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2mb
        maxFileSize = 1024 * 1024 * 10, //10mb
        maxRequestSize = 1024 * 1024 * 50)
public class RegisterServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String faculty = request.getParameter("faculty");
        String semester = request.getParameter("semester");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
                System.out.println(password1 + "==" + password2);

        String email = request.getParameter("email");
        String role = "User";
        String fullname = first_name + last_name;
        if (password1.equals(password2)) {

            try {
                Part pic_part = null;
                pic_part = request.getPart("image");
                if (pic_part == null) {
                    String fileName = "static/user/profile/defult.png";
                    User newUser = new User(fullname, email, username, password1, role, fileName, semester, faculty);
                    userDao.insertUser(newUser);
                    response.sendRedirect("LoginServlet");

                } else {
                    String fileName = "static/user/profile/" + username + ".png";
                    String contextPath = new File("").getAbsolutePath();
                    String imageSavePath = "/home/ram/Downloads/javaproject/V2/web" + File.separator + fileName;
                    File fileSaveDir = new File(imageSavePath);
                    System.out.println(imageSavePath);
                    pic_part.write(imageSavePath + File.separator);
                    System.out.println("Hellow");
                    User newUser = new User(fullname, email, username, password1, role, fileName, semester, faculty);
                    userDao.insertUser(newUser);
                    response.sendRedirect("LoginServlet");

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            String message = "validation error ";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
            dispatcher.forward(request, response);
        }
    }

}
