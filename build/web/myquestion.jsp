<%-- 
    Document   : Home
    Created on : Aug 10, 2022, 11:08:06 PM
    Author     : ram
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<% //In case, if User session is not set, redirect to Login page.
if((request.getSession(false).getAttribute("User")== null) )
{
%>
<jsp:forward page="/Login.jsp"></jsp:forward>
<%} %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>
    <%@include file="../header.jsp" %>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
      <c:if test="${user.role == 'Admin'}">
                <%@ include file = "../adminSidebar.jsp" %>
            </c:if>
            <c:if test="${user.role == 'User'}">
                <%@ include file = "../sidebar.jsp" %>
            </c:if>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
                <%@ include file="../navbar.jsp" %>
                <!-- Begin Page Content -->
                <style>
                    * {
  margin: 0;
  box-sizing: border-box;
}

.header__left img {
  height: 40px;
}

.user__avatar {
  border-radius: 50%;
  width: 45px;
}

.header {
  padding: 15px 20px;
  display: flex;
  justify-content: space-between;
  position: sticky;
  background-color: white;
  z-index: 100;
  top: 0;
  box-shadow: 0 5px 8px -9px rgba(0, 0, 0, 0.75);
}

.header__left {
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}

.header__input {
  display: flex;
  align-items: center;
  background-color: #eff2f5;
  padding: 10px;
  margin-left: 10px;
  border-radius: 999px;
}

.header__input input {
  border: none;
  background-color: transparent;
  outline-width: 0;
}

.header__middle {
  display: flex;
  flex: 1;
  justify-content: center;
}

.header__option .material-icons {
  font-size: xx-large;
  color: gray;
}

.header__option:hover .material-icons {
  color: #2e81f4;
}

.header__option {
  display: flex;
  align-items: center;
  padding: 0 30px;
  cursor: pointer;
}

.header__option.active .material-icons {
  color: #2e81f4;
}

.header__option.active {
  border-bottom: 4px solid #2e81f4;
}

.header__option:hover {
  background-color: #eff2f5;
  border-radius: 10px;
  align-items: center;
  padding: 0 30px;
  border-bottom: none;
}

.header__info {
  display: flex;
  align-items: center;
}

.header__info h4 {
  margin-left: 10px;
}

.header__right {
  display: flex;
  align-items: center;
}

.header__right .material-icons {
  color: gray;
  margin: 0 10px;
}

.header__right .material-icons:hover {
  cursor: pointer;
}

/* sidebar  */

.sidebarRow {
  display: flex;
  align-items: center;
  padding: 10px;
  cursor: pointer;
}

.sidebarRow:hover {
  background-color: lightgray;
  border-radius: 10px;
}

.sidebarRow h4 {
  margin-left: 20px;
  font-weight: 600;
}

.sidebarRow .material-icons {
  font-size: xx-large;
  color: #2e81f4;
}

.main__body {
  display: flex;
}

body {
  background-color: #f1f2f5;
}

.feed {
  flex: 1;
  padding: 30px 100px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  overflow: auto;
}

.sidebar {
  padding: 25px 10px;
  flex: 0.33;
}

/* message sender */

.messageSender {
  display: flex;
  margin-top: 30px;
  flex-direction: column;
  background-color: white;
  border-radius: 15px;
  box-shadow: 0px 5px 7px -7px rgba(0, 0, 0, 0.75);
  width: 100%;
}

.messageSender__top {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #eff2f5;
  padding: 15px;
}

.messageSender__top form {
  flex: 1;
  display: flex;
}

.messageSender__top form input {
  flex: 1;
  outline-width: 0;
  border: none;
  padding: 15px 20px;
  margin: 0 10px;
  border-radius: 999px;
  background-color: #eff2f5;
}

.messageSender__bottom {
  display: flex;
  justify-content: space-evenly;
}

.messageSender__option {
  padding: 8px;
  display: flex;
  align-items: center;
  color: gray;
  margin: 5px;
}

.messageSender__option h3 {
  font-size: medium;
  margin-left: 10px;
}

.messageSender__option:hover {
  cursor: pointer;
  background-color: #eff2f5;
  border-radius: 20px;
}

/* post */

.post {
  width: 100%;
  margin-top: 15px;
  border-radius: 15px;
  background-color: white;
  box-shadow: 0px 5px 7px -7px rgba(0, 0, 0, 0.75);
}

.post__image img {
  width: 100%;
}

.post__top {
  display: flex;
  position: relative;
  align-items: center;
  padding: 15px;
}

.post__avatar {
  margin-right: 10px;
}

.post__topInfo h3 {
  font-size: medium;
  color: black;
}

.post__topInfo p {
  font-size: small;
  color: gray;
}

.post__bottom {
  margin-top: 10px;
  margin-bottom: 10px;
  padding: 15px 25px;
  color: black;
}

.post__options {
  padding-top: 10px;
  border-top: 1px solid lightgray;
  display: flex;
  justify-content: space-evenly;
  font-size: medium;
  color: gray;
  cursor: pointer;
  padding: 15px;
}

.post__option {
    
  align-items: center;
  display: flex;
  flex-direction: row;
}

.post__option p {
  margin-left: 10px;
}

.post__option:hover {
  background-color: #eff2f5;
  border-radius: 10px;
}
.MOT{
  border-radius: 100%;
  height: 100px;
}
.sidebarRow2{
  font-weight: 0px;
  font-size: 12px;
}
.header_2{
  font-size: 14px;
  font-weight: bolder;
}
/* .ask{
  font-weight:lighter;
  margin-left:400px;
  font-style:italic;
} */

@media (max-width: 768px) {
  .sidebar {
    display: none;
  }

  .header__input input {
    display: none;
  }

  .header__middle {
    display: none;
  }

  .header__info {
    display: none;
  }

  .widgets {
    display: none;
  }

  .feed {
    margin-top: 20px;
    width: 100%;
    padding: 0;
  }

  .story h4 {
    font-size: 10px;
  }

  .story img {
    width: 40px;
  }
}

@media (min-width: 320px) {
  .storyReel {
    width: 100%;
    overflow-x: scroll;
  }
}

@media (min-width: 769px) and (max-width: 1440px) {
  /* CSS To Target 767 px width of screen */

  .feed {
    width: 50%;
    padding: 10px 50px;
  }
}

                </style>
<div class="container-fluid" >


    <!-- main body starts -->
    <div class="main__body">

      <!-- feed starts -->
      <div class="feed">

        <!-- message sender starts -->
        <div class="messageSender">
          <!-- <a class="ask">Ask Here</a> -->
          <div class="messageSender__top">
            <img
              class="user__avatar"
              src="<%=request.getContextPath()%>/<c:out value="${user.profile}" />"
              alt=""
            />
            <form>
              <input class="messageSender__input" placeholder="What's on your mind?" type="text" />
            </form>
          </div>

          <div class="messageSender__bottom">
            <div class="messageSender__option">
              <h3>photo</h3>
              <span style="color: green" class="material-icons">camera</span>
            </div>
            <div class="messageSender__option">
              <h3>Post</h3>
              <span style="color: green" class="material-icons"> send</span>
            </div>
          </div>
        </div>
        <!-- message sender ends -->

         
        <c:forEach var="question" items="${listQuestion}">  
                           <c:if test="${question.created_by == user.id}">

            <!-- post starts -->
        <div class="post">
          <div class="post__top">
            <img
              class="user__avatar post__avatar"
              src="<%=request.getContextPath()%>/<c:out value="${question.profile}" />"
              alt=""
            />
            <div class="post__topInfo">
              <h3><c:out value="${question.user}" /></h3>
               <a href="edit-question?id=<c:out value='${question.id}' />" class='btn btn-success btn-sm btn-flat' ><i class='fa fa-edit'></i> Update</a>
               <p><c:out value="${question.created_date}" /></p>
            </div>
          </div>

          <div class="post__bottom">
               ${question.question}
          </div>
          
           <div class="post__image">
            <img src="<%=request.getContextPath()%>/<c:out value="${question.image}" />" alt="" />
          </div>

          <div class="post__options">
            <div class="post__option">
              <span class="material-icons"> thumb_up </span>
              <p>Like</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> chat_bubble_outline </span>
              <p>Answers</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> near_me </span>
              <p>Share</p>
            </div>
          </div>
        </div>
                         </c:if>

                  </c:forEach>
        <!-- post ends -->

      </div>
      <!-- feed ends -->


     </div>



     </div>
          </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

           

        </div>
        <!-- End of Content Wrapper -->
        
<script>
function myFunction() {
  var input = document.getElementById("Search");
  var filter = input.value.toLowerCase();
  var nodes = document.getElementsByClassName('post');

  for (i = 0; i < nodes.length; i++) {
    if (nodes[i].innerText.toLowerCase().includes(filter)) {
      nodes[i].style.display = "block";
    } else {
      nodes[i].style.display = "none";
    }
  }
}
</script>
<%@include file="../footer.jsp" %>
</div>

<%@include file="../logout.jsp" %>
    <!-- Bootstrap core JavaScript-->
    <%@include file="../scripts.jsp" %>

</body>

</html>