<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 06.10.2019
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
    <link href="/webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Category</th>
            <th>Creation Date</th>
            <th>Deadline</th>
            <th>Description</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:set var="i" value="1"/>
        <c:forEach items="${toDoList}" var="entity">

            <tr <c:if test="${entity.done}"> style="background-color: green;"</c:if>>
                <td>${i}</td>
                <td>${entity.name}</td>
                <td>${entity.category}</td>
                <td>${entity.creationDate}</td>
                <td>${entity.deadline}</td>
                <td>${entity.description}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/to-do/markAsDone" method="POST">
                    <button type="submit" class="btn btn-success" name="toDoId" value="${entity.id}">Done</button>
                    </form>
                </td>
                <td>
                    <button type="button" class="btn btn-info">Edit</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger">Remove</button>

                </td>
            </tr>
            <c:set var="i" value="${i+1}"/>
        </c:forEach>
    </table>
</div>
<script src="/webjars/jquery/3.4.1/jquery.min.js"/>
<script src="/webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
