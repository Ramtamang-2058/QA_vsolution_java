<%-- 
    Document   : Login
    Created on : Aug 10, 2022, 9:55:11 PM
    Author     : ram
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/sb-admin-2.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/vendor/fontawesome-free/css/all.min.css">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="928543276217-chqj9oam8f18aiul3uva3630d6cd0jkn.apps.googleusercontent.com">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <img class="col-lg-5 d-none d-lg-block bg-register-image" src="static/img/bg2.webp">
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form class="user" name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="exampleInputEmail" aria-describedby="emailHelp"
                                                placeholder="Enter Your Username..." name="username">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                   id="exampleInputPassword" placeholder="Password" name="password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                                <span style="color: red"> <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
                                            </div>
                                        </div>
                                            <input class="btn btn-primary btn-user btn-block" type="submit" value="Login"></input>
                                        <hr>
                                        <a data-onsuccess="onSignIn" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="<%=request.getContextPath()%>/ResetPassword">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="<%=request.getContextPath()%>/RegisterServlet">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

  <script>
      //google callback. This function will redirect to our login servlet
      function onSignIn(googleUser) {
         var profile = googleUser.getBasicProfile();
         console.log('ID: ' + profile.getId());
         console.log('Name: ' + profile.getName());
         console.log('Image URL: ' + profile.getImageUrl());
         console.log('Email: ' + profile.getEmail());
         console.log('id_token: ' + googleUser.getAuthResponse().id_token);

         //do not post all above info to the server because that is not secure.
         //just send the id_token

         var redirectUrl = 'login';

         //using jquery to post data dynamically
         var form = $('<form action="' + redirectUrl + '" method="post">' +
                          '<input type="text" name="id_token" value="' +
                           googleUser.getAuthResponse().id_token + '" />' +
                                                                '</form>');
         $('body').append(form);
         form.submit();
      }

   </script>
    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/static/js/sb-admin-2.min.js"></script>

</body>

</html>