<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Question</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${question != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${question == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${question != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${question == null}">
                                    Add New User
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${quesiton != null}">
                            
                        </c:if>
                            <input type="text" name="id" value="<c:out value='${question.id}' />" />
                        <fieldset class="form-group">
                            <label>User Name</label> <input type="text" value="<c:out value='${question.question}' />" class="form-control" name="question" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Email</label> <input type="text" value="<c:out value='${question.image}' />" class="form-control" name="image">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>User Email</label> <input type="text" value="<c:out value='${question.created_date}' />" class="form-control" name="created_date">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Country</label> <input type="text" value="<c:out value='${question.edited_date}' />" class="form-control" name="edited_date">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Country</label> <input type="text" value="<c:out value='${question.category}' />" class="form-control" name="category_id">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Created by</label> <input type="text" value="<c:out value='${question.created_by}' />" class="form-control" name="created_by_id">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>