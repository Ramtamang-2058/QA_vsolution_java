<%-- 
    Document   : Register
    Created on : Aug 10, 2022, 10:39:18 PM
    Author     : ram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Register</title>

        <!-- Custom fonts for this template-->
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/sb-admin-2.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/vendor/fontawesome-free/css/all.min.css">


    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                                </div>
                                <form class="user" method="post" action="RegisterServlet" enctype="multipart/form-data">
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input name="first_name" type="text" class="form-control form-control-user" id="exampleFirstName"
                                                   placeholder="First Name">
                                        </div>
                                        <div name="last_name" class="col-sm-6">
                                            <input type="text" class="form-control form-control-user" id="exampleLastName"
                                                   placeholder="Last Name">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <select name="semester"  class="form-control form-control-user">
                                                    <option value="" disabled selected>Select your option</option>
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
                                            <option value="BICT">BICT</option>
                                            <option value="MBA">MBA</option>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input name="email" type="email" class="form-control form-control-user" id="exampleInputEmail"
                                               placeholder="Email Address">
                                    </div>
                                    <div class="form-group">
                                        <input name="username" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                               placeholder="username">
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input name="password1" type="password" class="form-control form-control-user"
                                                   id="exampleInputPassword" placeholder="Password">
                                        </div>
                                        <div class="col-sm-6">
                                            <input name="password2" type="password" class="form-control form-control-user"
                                                   id="exampleRepeatPassword" placeholder="Repeat Password">
                                        </div>
                                    </div>
                                    <p>${message}</p>
                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Account Register">
                                       
                                    <hr>
                                    <a href="index.html" class="btn btn-google btn-user btn-block">
                                        <i class="fab fa-google fa-fw"></i> Register with Google
                                    </a>
                                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                        <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                    </a>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="<%=request.getContextPath()%>/ResetPassword">Forgot Password?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="<%=request.getContextPath()%>/">Already have an account? Login!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="<%=request.getContextPath()%>/static/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>


    </body>

</html>