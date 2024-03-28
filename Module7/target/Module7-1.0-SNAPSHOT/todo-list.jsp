<%--
  Created by IntelliJ IDEA.
  User: Julianne
  Date: 3/27/2024
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Todo List</h1>
<table border="1">
    <tr>
        <th>Description</th>
        <th>Due Date</th>
        <th>Priority</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="todoitem" items="${todoitem}">
        <tr>
            <td>${todoitem.description}</td>
            <td>${todoitem.dueDate}</td>
            <td>${todoitem.priority}</td>
            <td>${todoitem.status ? 'Completed' : 'Pending'}</td>
            <td>
                <a href="edit?id=${todoitem.id}">Update</a> |
                <a href="delete?id=${todoitem.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="new">Add Item</a>
</body>
</html>

