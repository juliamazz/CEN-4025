package org.example.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class TodoItemServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private TodoItemDAO todoItemDao;

    public void init() {
        todoItemDao = new TodoItemDAO();
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
                case "/insert":
                    insertItem(request, response);
                    break;
                case "/delete":
                    deleteItem(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateItem(request, response);
                    break;
                default:
                    listItems(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listItems(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List < TodoItem > listItems = todoItemDao.getAllItems();
        System.out.println(listItems);
        request.setAttribute("listItems", listItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-list.jsp");
        dispatcher.forward(request, response);

    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-item-form.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TodoItem existingItem = TodoItemDAO.getItem(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-item-form.jsp");
        request.setAttribute("item", existingItem);
        dispatcher.forward(request, response);

    }
    private void insertItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String description = request.getParameter("description");
        String dueDate = request.getParameter("duedate");
        Boolean status = Boolean.valueOf(request.getParameter("status"));
        TodoItem newItem = new TodoItem(description, dueDate, status);
        todoItemDao.addItem(newItem);
        response.sendRedirect("list");
    }
    private void updateItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String dueDate = request.getParameter("duedate");
        Boolean status = Boolean.valueOf(request.getParameter("status"));
        TodoItem item = new TodoItem(id, description, dueDate, status);
        todoItemDao.updateItem(item);
        response.sendRedirect("list");
    }
    private void deleteItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoItemDao.deleteItem(id);
        response.sendRedirect("list");

    }
}
