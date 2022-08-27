package com.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.model.Category;

public class CategoryServlet extends HttpServlet {

    private CategoryDao categoryDao;

    @Override
    public void init() {
        categoryDao = new CategoryDao();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/newCategory":
                    break;

                case "/list":
                    listCategory(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List< Category> listCategory = categoryDao.selectAllCategories();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-questions.jsp");
        request.setAttribute("listCategory", listCategory);
        dispatcher.forward(request, response);
    }
}
