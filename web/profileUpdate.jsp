<%-- 
    Document   : new-answers
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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/text.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/messagelist.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.tiny.cloud/1/kuhw6714mg0yfaluqlt0sqwy30y4w54fbmacma45ipgfhbfg/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <title>Home | updprofile</title>

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

                    <div class="container">

                        <div class="card o-hidden border-0 shadow-lg my-5">
                            <div class="card-body p-0">
                                <!-- Nested Row within Card Body -->
                                <div class="row">
                                    <img class="col-lg-5 d-none d-lg-block" src="<%=request.getContextPath()%>/${usr.profile}">
                                    <!--                        <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>-->
                                    <div class="col-lg-7">
                                        <div class="p-5">
                                            <div class="text-center">
                                                <h1 class="h4 text-gray-900 mb-4">Update your profile !</h1>
                                            </div>
                                            <form class="user" method="post" action="user-update" enctype="multipart/form-data">
                                                <div class="form-group row">
                                                    <div class="col-sm-8 mb-3 mb-sm-0">
                                                        <input type="hidden" value="${usr.id}">
                                                        <input name="name" type="text" class="form-control form-control-user" id="exampleFirstName"
                                                               placeholder="Name" value="${usr.fullname}">
                                                    </div>

                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                                        <select name="semester"  class="form-control form-control-user">
                                                            <option value="${usr.semester}" selected>${usr.semester}</option>
                                                            <option value="1-semester">1-semester</option>
                                                            <option value="2-semester">2-semester</option>
                                                            <option value="3-semester">3-semester</option>
                                                            <option value="4-semester">4-semester</option>
                                                            <option value="5-semester">5-semester</option>
                                                            <option value="6-semester">6-semester</option>
                                                            <option value="7-semester">7-semester</option>
                                                            <option value="8-semester">8-semester</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <select name="faculty" class="form-control form-control-user">
                                                            <option value="${usr.faculty}" selected>${usr.faculty}</option>
                                                            <option value="BICT">BICT</option>
                                                            <option value="MBA">MBA</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <input name="email" type="email" class="form-control form-control-user" id="exampleInputEmail"
                                                           placeholder="Email Address" value="${usr.email}">
                                                </div>
                                                <div class="form-group">
                                                    <input name="username" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                                           name="${usr.username}"    placeholder="username">
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                                        <input name="password" type="password" class="form-control form-control-user"
                                                               id="exampleInputPassword" placeholder="Password" value="${usr.password}">
                                                    </div>
                                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                                        <input name="image" type="file" class="form-control form-control-user" value="${usr.profile}">
                                                    </div>

                                                </div>
                                                <p>${message}</p>
                                                <input type="submit" class="btn btn-primary btn-user btn-block" value="Update Profile">

                                                <hr>

                                            </form>
                                            <hr>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>




                    <!-- Footer -->
                    <%@ include file = "../footer.jsp" %>

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Logout Modal-->
            <%@ include file = "../logout.jsp" %>

            <!-- Bootstrap core JavaScript-->
            <%@ include file = "scripts.jsp" %>

    </body>

    <script>
        tinymce.init({
            selector: 'textarea',
            plugins: 'advlist autolink lists link image charmap preview anchor pagebreak',
            toolbar_mode: 'floating',
        });
    </script>
    <script>
        window.setTimeout(function () {
            $(".alert").fadeTo(500, 0).slideUp(500, function () {
                $(this).remove();
            });
        }, 2000);
    </script>

</html>