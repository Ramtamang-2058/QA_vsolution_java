///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.view;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author ram
// */
//public class Glogin extends HttpServlet {
//@Override
//    protected void doPost (HttpServletRequest req,
//                        HttpServletResponse resp)
//                        throws ServletException, IOException {
//
//        resp.setContentType("text/html");
//
//        try {
//            String idToken = req.getParameter("id_token");
//            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
//            String name = (String) payLoad.get("name");
//            String email = payLoad.getEmail();
//            System.out.println("User name: " + name);
//            System.out.println("User email: " + email);
//
//            HttpSession session = req.getSession(true);
//            session.setAttribute("userName", name);
//            req.getServletContext()
//               .getRequestDispatcher("/welcome-page.jsp").forward(req, resp);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
