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

    <title>Vsuluion | answer</title>

    <!-- Custom fonts for this template-->
    <%@ include file = "header.jsp" %>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
<c:if test="${user.role == 'Admin'}">
                <%@ include file = "adminSidebar.jsp" %>
            </c:if>
            <c:if test="${user.role == 'User'}">
                <%@ include file = "sidebar.jsp" %>
            </c:if>

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
                                <c:if test="${answer != null}">
                                    Edit Answer
                                </c:if>
                                <c:if test="${answer == null}">
                                    Add New Answer
                                </c:if>
                            </h2>
                        </caption>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content --><div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       
                        <fieldset class="form-group">
                            <label>Category</label>
                            <p> <c:forEach var="ans" items="${listAnswer}">
                                <p><c:out value="${ans.id}" /></p>
                                <p><c:out value="${ans.image}" /></p>
                                <!--<p><c:out value="${ans.answer}" /></p>-->
                                <hr>
                                <p><c:out value="${ans.user}" /></p>
                                <p><c:out value="${ans.created_by}" /></p>
                                 <p><c:out value="${ans.question}" /></p>
                                 <hr>
                                 <hr>
                            </c:forEach></p>
                  
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