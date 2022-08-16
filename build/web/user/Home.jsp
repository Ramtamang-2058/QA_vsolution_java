<%-- 
    Document   : Home
    Created on : Aug 10, 2022, 11:08:06 PM
    Author     : ram
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <!-- Custom fonts for this template-->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <!-- Custom styles for this template-->
    

        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/sb-admin-2.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/satic/css/user-style.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/vendor/fontawesome-free/css/all.min.css">


</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Vsoulution <sup>2</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Home
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Topics</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Components:</h6>
                        <a class="collapse-item" href="buttons.html">Buttons</a>
                        <a class="collapse-item" href="cards.html">Cards</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>All Categories</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html">Colors</a>
                        <a class="collapse-item" href="utilities-border.html">Borders</a>
                        <a class="collapse-item" href="utilities-animation.html">Animations</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>FAQs</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#collapsePages">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html">Colors</a>
                        <a class="collapse-item" href="utilities-border.html">Borders</a>
                        <a class="collapse-item" href="utilities-animation.html">Animations</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Questions
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="#" >
                    <i class="fas fa-fw fa-folder"></i>
                    <span>un answered</span>
                </a>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>New Questions</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Most Answered Question</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
             <div class="sidebar-heading">
                Contact us
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
           
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>+9841542244</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>01512458</span></a>
            </li><!-- comment -->
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>vsolution.edu.np</span></a>
            </li>

           
            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="<%=request.getContextPath()%>/static/img/undraw_profile_1.svg"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="<%=request.getContextPath()%>/static/img/undraw_profile_2.svg"
                                            alt="...">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="<%=request.getContextPath()%>/static/img/undraw_profile_3.svg"
                                            alt="...">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=request.getAttribute("userName") %></span>
                                <img class="img-profile rounded-circle"
                                    src="<%=request.getContextPath()%>/static/img/undraw_profile.svg"
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

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

/* story
.story {
  position: relative;
  background-repeat: no-repeat;
  background-size: cover;
  width: 120px;
  height: 200px;
  box-shadow: 0px 5px 17px -7px rgba(0, 0, 0, 0.75);
  border-radius: 10px;
  margin-right: 10px;
  transition: transform 100ms ease-in;
  cursor: pointer;
}

.story:hover {
  transform: scale(1.07);
}

.story__avatar {
  margin: 10px;
  color: blue;
}

.story h4 {
  position: absolute;
  bottom: 20px;
  left: 20px;
  color: white;
}

.storyReel {
  padding: 10px 0;
  display: flex;
} */

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
                <div class="container-fluid">
<div class="header">
      <div class="header__left">
        <img
          src="MOT.png"
          alt=""
        />
        <div class="header__input">
          <span class="material-icons"> search </span>
          <input type="text" placeholder="Search..." />
        </div>
      </div>

      <div class="header__middle">
        
        <div class="header__option active header_2">Recent Question
        </div>
        <div class="header__option header_2">No answered
        </div>
        <div class="header__option header_2">Most answered
        </div>
        <div class="header__option header_2">Most Visted
        </div>
        <div class="header__option header_2"> Most Liked
        </div>
      </div>

      <div class="header__right">
        <span class="material-icons"> add </span>
        <span class="material-icons"> expand_more </span>
      </div>
    </div>
    <!-- header ends -->

    <!-- main body starts -->
    <div class="main__body">

      <!-- feed starts -->
      <div class="feed">
        <div class="storyReel">
        </div>

        <!-- message sender starts -->
        <div class="messageSender">
          <!-- <a class="ask">Ask Here</a> -->
          <div class="messageSender__top">
            <img
              class="user__avatar"
              src="<%=request.getContextPath()%>/static/img/user/profile.png"
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

        <!-- post starts -->
        <div class="post">
          <div class="post__top">
            <img
              class="user__avatar post__avatar"
              src="<%=request.getContextPath()%>/static/img/user/profile.png"
              alt=""
            />
            <div class="post__topInfo">
              <h3>subash sigdel</h3>
              <p>25 April at 20:30</p>
            </div>
          </div>

          <div class="post__bottom">
            <p>What is Mission oxygen Team ?</p>
          </div>

          <div class="post__image">
            <img
              src="<%=request.getContextPath()%>/static/img/user/ldc.jpg"
              alt=""
            />
          </div>

          <div class="post__options">
            <div class="post__option">
                <div style="padding-bottom:10px" >
                    <span class="material-icons"> thumb_up </span></div>
                    <div><p>Like</p></div>
            </div>

            <div class="post__option">
              <span class="material-icons"> chat_bubble_outline </span>
              <p>Comment</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> near_me </span>
              <p>Share</p>
            </div>
          </div>
        </div>
        <!-- post ends -->

        <!-- post starts -->
        <div class="post">
          <div class="post__top">
            <img
              class="user__avatar post__avatar"
              src="<%=request.getContextPath()%>/static/img/user/profile.png"
              alt=""
            />
            <div class="post__topInfo">
              <h3>Ram hari</h3>
              <p>25 April at 20:30</p>
            </div>
          </div>

          <div class="post__bottom">
            <p>Mission Oxygen Team [MOT] for you, is the team to reach out for any technical help to install, operate, repair any medical equipment including oxygen concentrators and plants. We are already working with the COVID Alliance team, Nepal Ventilators Bank, FNCCI Covid Crisis Support team. We are already a team of 150+ members who are trained ...</p>
          </div>

          <div class="post__options">
            <div class="post__option">
              <span class="material-icons"> thumb_up </span>
              <p>Like</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> chat_bubble_outline </span>
              <p>Comment</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> near_me </span>
              <p>Share</p>
            </div>
          </div>
        </div>
        <!-- post ends -->

        <!-- post starts -->
        <div class="post">
          <div class="post__top">
            <img
              class="user__avatar post__avatar"
              src="<%=request.getContextPath()%>/static/img/user/profile.png"
              alt=""
            />
            <div class="post__topInfo">
              <h3>Somanath Goudar</h3>
              <p>25 April at 20:30</p>
            </div>
          </div>

          <div class="post__bottom">
            <p>How to join missdion oxygen Team </p>
          </div>

          <div class="post__image">
            <img src="<%=request.getContextPath()%>/static/img/user/edc.jpeg" alt="" />
          </div>

          <div class="post__options">
            <div class="post__option">
              <span class="material-icons"> thumb_up </span>
              <p>Like</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> chat_bubble_outline </span>
              <p>Comment</p>
            </div>

            <div class="post__option">
              <span class="material-icons"> near_me </span>
              <p>Share</p>
            </div>
          </div>
        </div>
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
 <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
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