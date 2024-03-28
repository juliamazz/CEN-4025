<%--
  Created by IntelliJ IDEA.
  User: Julianne
  Date: 3/27/2024
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo Item Form</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Todo Item Form</h1>
<form action="insert" method="post">
    <input type="hidden" name="id" value="${todoitem != null ? todoitem.id : ''}">
    <label for="description">Description:</label><br>

    <input type="text" id="description" name="description" value= "<{todoitem != null ? todoitem.description : ''}" required><br>
    <label for="due_date">Due Date:</label><br>

    <input type="date" id="due_date" name="due_date" value= "<{todoitem != null ? todoitem.dueDate : ''}" required><br>
    <label for="status">Status:</label><br>

    <input type="checkbox" id="status" name="status" ${todoitem != null && todoitem.status ? "checked" : ""}><br>
    <button type="submit">Submit</button>
</form>
<a href="list">Back to Todo List</a>
</body>
</html>

