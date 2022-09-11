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

                    <div class="container">
                        <div class="row">
                            <div class="chat_container">
                                <div class="job-box">
                                                                                                            <c:forEach var="usr" items="${listUser}"> 

                                    <div class="inbox-message">
                                        <ul>
                                            <li style="width: 800px;">
                                                <a href="<%=request.getContextPath()%>/message-list?id1=${usr.id}&id2=${user.id}">
                                                    <div class="message-avatar">
                                                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                                                    </div>
                                                    <div class="message-body">
                                                        <div class="message-body-heading">
                                                            <h5>${usr.fullname} <span class="unread">messages</span></h5>
                                                            <span>${usr.username}</span>
                                                        </div>
                                                        <p>${usr.faculty}, ${usr.semester}.</p>
                                                        <p> view your message....</p>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                                                          </c:forEach>

                                </div>
                            </div>
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