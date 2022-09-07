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
                                <c:if test="${question != null}">
                                    Edit Question
                                </c:if>
                                <c:if test="${question == null}">
                                    Add your Question ?
                                </c:if>
                                </h2>
                        </caption>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content --><div class="container col-md-5">
                    <h1 class="heading" style="color: blue; font-size: 20px;">Ticket ID: <c:out value='${ticket}' /></h1>
                    <h1 class="heading">Opened Question Ticket</h1>
                    <div class="minihead">
                        <!-- <div>
                           <form class="left">
                                <label>Name</label>
                                <label class="email">Email</label><br><br>
                                <input type="text" size="50">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="email" size="50" height="50"><br><br>
                                <label>Department</label>
                                <label class="Prio">Priority</label><br><br>
                                <input type="text" size="50">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="email" size="50" height="50">
                            </form> -->
                        <!-- </div> -->
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

                        <div id="form" class="container  p-5">
                            <c:if test="${question != null}">
                                <form class="justify-content-md-cente" action="update" method="post" enctype="multipart/form-data">
                                </c:if>
                                <c:if test="${question == null}">
                                    <form class="justify-content-md-cente" action="insert" method="post" enctype="multipart/form-data">
                                    </c:if>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <input type="hidden" name="id" value="<c:out value='${question.id}' />" />
                                            <input name="code" type="hidden" value="<c:out value="${ticket}"/>">
                                            <input name="created_by" type="hidden" value="<c:out value="${user.id}"/>">
                                            <label class="font-weight-bold" for="this">Faculty</label>
                                            <select name="faculty" class="form-control-lg form-control bolder" id="this" aria-label=".form-select-lg example" value="<c:out value="${question.faculty}"/>">
                                                <option selected>Choose faculty</option>
                                                <option value="MBA">MBA</option>
                                                <option value="BICT">BICT</option>
                                            </select>   
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label class="font-weight-bold" for="this">Semester</label>
                                            <select name="semester" class="form-control-lg form-control bolder" id="this" aria-label=".form-select-lg example" value="<c:out value="${question.semester}"/>">
                                                <option selected>Choose semester</option>
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
                                        <div class="form-group col-md-6">
                                            <label class="font-weight-bold" for="inputCity">Subject</label>
                                            <select name="subject" class="form-control-lg form-control bolder" id="this" aria-label=".form-select-lg example" value="<c:out value="${question.subject}"/>">
                                                <option selected>Choose semester</option>
                                                <option value="RTS300">Real Time System</option>
                                                <option value="FSP202">Critical Thinking</option>
                                                <option value="SAD302">Agile Development</option>
                                                <option value="CST400">Software Testing</option>
                                                <option value="SQA400">Software Quality Assurance</option>
                                                <option value="SPC401">Software Integration and Improvement</option>
                                                <option value="CSP400">Knowledge management</option>
                                                <option value="CCP301">C-programming</option>
                                            </select>  
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label class="font-weight-bold" for="inputCity">Category</label>
                                            <select  class="form-control-lg form-control bolder" name="category" value="<c:out value="${question.category}"/>>
                                                     <c:forEach var="categry" items="${listCategory}">
                                                         <option value="${categry.id}">${categry.name}</option>
                                                     </c:forEach>
                                            </select>
                                            <input type="hidden" value="<c:out value='${question.created_date}' />" class="form-control" name="edited_date">
                                            <input type="hidden" value="<c:out value='${question.edited_date}' />" class="form-control" name="edited_date">
                                        </div>
                                    </div>
                                    </div>
                                    <div class="textarea">
                                        <div class="form-group col-md-15 form-row">
                                            <label class="font-weight-bold" for="inputCity">Images</label>
                                            <input type="file" name="photo" class="form-control-lg form-control bolder">
                                        </div>
                                        <h4 class="head1">Message</h4>
                                        <textarea name="question" id="default" class="textarea"  value="<c:out value='${question.question}' />">
                  
                                        </textarea>

                                    </div>
                                    <button type="submit" class="btn btn-primary">Save</button>
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