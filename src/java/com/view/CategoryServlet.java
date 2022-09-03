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
                case "/new-category":
                    showNewForm(request, response);
                    break;
                case "/post-category":
                    insertCategory(request, response);
                    break;
                case "/delete-category":
                    deleteCategory(request, response);
                    break;
                case "/edit-category":
                    showEditForm(request, response);
                    break;
                case "/update-category":
                    updateCategory(request, response);
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
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("new-categorys.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = categoryDao.selectCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/new-categorys.jsp");
        request.setAttribute("category", existingCategory);
        dispatcher.forward(request, response);

    }
    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String text = request.getParameter("name");
        Category newCategory = new Category(text);
        categoryDao.insertCategory(newCategory);
        response.sendRedirect("list");
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
       
        Category category = new Category(id, name);
        categoryDao.updateCategory(category);
        response.sendRedirect("list");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDao.deleteCategory(id);
        response.sendRedirect("list");

    }
}
