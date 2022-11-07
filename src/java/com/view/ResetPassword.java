/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.view;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
public class ResetPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();

        if (email != null || !email.equals("")) {
            // sending otp
            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("mausambhandari74@gmail.com", "jvmdrozhtuhktkbt");// Put your email
                    // id and
                    // password here
                }
            });
            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Hello");
                message.setText("your reset one time password for the vsolution is: " + otpvalue);
                // send message
                Transport.send(message);
                System.out.println("message sent successfully");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
            request.setAttribute("message", "OTP is sent to your email id");
            //request.setAttribute("connection", con);
            mySession.setAttribute("otp", otpvalue);
            mySession.setAttribute("email", email);
            dispatcher.forward(request, response);
            //request.setAttribute("status", "success");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("forgot-password.jsp");
        dispatcher.forward(request, response);
    }
}
