/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import com.dao.AdminDao;
import com.dao.UserDao;
import com.model.Chart;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AdminHome extends HttpServlet {
 private AdminDao adminDao;
 private UserDao userDao;

    @Override
    public void init() {
        adminDao = new AdminDao();
        userDao = new UserDao();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        String userName = (String) session.getAttribute("User");
        String password = (String) session.getAttribute("password");
        User user = userDao.getUser(userName, password);
        Chart chart;
        chart = adminDao.chartQuestion();
        Chart ans = adminDao.chartAnswer();
        Chart msg = adminDao.chartMessage();
        Chart cqn = adminDao.answeredQestion();
        int tq = chart.getQn(); //total question
        int ncq = chart.getQn() - cqn.getQn(); //number of unanswerd quesion
        int qp = (ncq*100)/tq; //calculating percetage of unanswerd question
        request.setAttribute("q_total", chart.getQn());
        request.setAttribute("a_total", ans.getQn());
        request.setAttribute("msg_total", msg.getQn());
        request.setAttribute("ncq", ncq);
        request.setAttribute("qp", qp);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }
    
}
