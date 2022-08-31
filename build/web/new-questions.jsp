<%-- 
    Document   : new-questions
    Created on : Aug 16, 2022, 10:55:26 PM
    Author     : ram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Blank</title>

    <!-- Custom fonts for this template-->
    <%@ include file = "header.jsp" %>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@ include file = "sidebar.jsp" %>


        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
              
                    <!-- Topbar Navbar -->
                    <%@ include file = "navbar.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <caption>
                        <h1 class="h3 mb-4 text-gray-800">
                                <c:if test="${question != null}">
                                    Edit Question
                                </c:if>
                                <c:if test="${question == null}">
                                    Add New Question
                                </c:if>
                            </h2>
                        </caption>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content --><div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${question != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${question == null}">
                            <form action="insert" method="post" enctype="multipart/form-data">
                        </c:if>
                        <c:if test="${quesiton != null}">
                            
                        </c:if>
                            <input type="hidden" name="id" value="<c:out value='${question.id}' />" />
                        <fieldset class="form-group">
                            <label>Your Question</label> <input type="text" value="<c:out value='${question.question}' />" class="form-control" name="question" placeholder="Write your question.." required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Image</label><input name="photo" id="dropzone-file" type="file"/>
                        </fieldset>
                        <c:if test="${question != null}">
                        <fieldset class="form-group">
                            <label>Created Date</label> <input type="text" value="<c:out value='et>${question.created_date}' />" class="form-control" name="created_date">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Modified Date</label> <input type="text" value="<c:out value='${question.edited_date}' />" class="form-control" name="edited_date">
                        </fieldset>
                         </c:if>
                        <fieldset class="form-group">
                            <label>Created by</label> <input type="text" value="<c:out value='${question.created_by}' />" class="form-control" name="created_by_id">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Category</label>
                            <select name="categ">
                            <c:forEach var="categry" items="${listCategory}">
                                <option name ="categ" value="${categry.id}">${categry.name}</option>
                            </c:forEach>
                          </select>
                        </fieldset>
                        <button type="submit" class="btn btn-primary">Save</button>
                        </form>
                    </div>
                </div>
            <!-- Footer -->
            <%@ include file = "footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Logout Modal-->
    <%@ include file = "logout.jsp" %>

    <!-- Bootstrap core JavaScript-->
   <%@ include file = "scripts.jsp" %>

</body>

</html>