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

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.tiny.cloud/1/kuhw6714mg0yfaluqlt0sqwy30y4w54fbmacma45ipgfhbfg/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
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
                                <c:if test="${answer != null}">
                                    Edit Answer
                                </c:if>
                                <c:if test="${answer == null}">
                                    Add your Answer ?
                                </c:if>
                                </h2>
                        </caption>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content --><div class="container col-md-5">
                    <c:if test="${answer == null}">
                        <h1 class="heading" style="color: blue; font-size: 20px;">Ticket ID: <c:out value='${ticket}' /></h1>
                        <h1 class="heading">Opened Question Ticket</h1>addanswer
                    </c:if>
                          
                        <c:if test="${answer == null}">
                            <c:if test="${message != null}">
                                <div classs="container p-5">
                                    <div class="row no-gutters">
                                        <div class="col-lg-6 col-md-12 m-auto">
                                            <div class="alert alert-success fade show" role="alert">
                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                    <span aria-hidden="True">&times;</span>
                                                </button>
                                                <h4 class="alert-heading">Well done!</h4>
                                                <p>Ticket was created successfully !</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:if>
                        <div id="form" class="container  p-5">
                            <c:if test="${answer != null}">
                                <form class="justify-content-md-cente" action="update-answer" method="post" enctype="multipart/form-data">
                                    <input name="code" type="hidden" value="<c:out value="${answer.code}"/>"/>
                                </c:if>
                                <c:if test="${answer == null}">
                                   <p>Hello  ma here in insert form</p>
                                    <form class="justify-content-md-cente" action="post-Answer" method="post" enctype="multipart/form-data">
                                        <input name="code" type="hidden" value="<c:out value="${ticket}"/>"/>
                                    </c:if>
                                    <div class="form-group col-md-6">
                                        <input type="hidden" name="id" value="{answer.id}"/>
                                        <input name="created_by" type="hidden" value="${user.id}" required/>
                                    <div class="textarea">
                                        <div class="form-group col-md-15 form-row">
                                            <label class="font-weight-bold" for="inputCity">Images: <%=request.getContextPath()%>${answer.image}</label>
                                            <input type="file" name="image" class="form-control-lg form-control bolder"/>
                                        </div>
                                        <h4 class="head1">Answer</h4>

                                        <textarea name="answer" id="default" class="textarea">
                                            ${answer.answer}
                                        </textarea>
                                        <button type="submit" class="btn btn-primary">Save</button>

                                    </div>
                                </form>
                        </div>

                        <input type="text">
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