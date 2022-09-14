/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import com.model.Login;
import com.dao.LoginDao;
import com.dao.UserDao;
import com.model.User;
import javax.servlet.annotation.WebServlet;
 

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {
    }
    @Override
     
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
System.out.println("Inside servlet");    
    Login login = new Login();
 
    login.setUserName(userName);
    login.setPassword(password);
 
    LoginDao loginDao = new LoginDao();
 
    try
    {
        String userValidate = loginDao.authenticateUser(login);
 
        if(userValidate.equals("Admin_Role"))
        {
            System.out.println("Admin's Home");
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("User", userName);
            session.setAttribute("password", password);
            request.setAttribute("userName", userName);
            response.sendRedirect("AdminHome");
        }
        else if(userValidate.equals("Editor_Role"))
        {
            System.out.println("Editor's Home");
 
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("User", userName);
            session.setAttribute("password", password);
            request.setAttribute("userName", userName);
            response.sendRedirect("question-list");
 
            request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
        }
        else if(userValidate.equals("User_Role"))
        {
            System.out.println("User's Home"); 
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("User", userName);
            session.setAttribute("password", password);
            request.setAttribute("userName", userName);
            response.sendRedirect("question-list");
//            request.getRequestDispatcher("/user/Home.jsp").forward(request, response);
        }
        else
        {
            System.out.println("Error message = "+userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }
    catch (IOException e1)
    {
        e1.printStackTrace();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
} //End of doPost()
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }
}