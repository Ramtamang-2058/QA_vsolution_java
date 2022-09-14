<%-- 
    Document   : sidebar
    Created on : Aug 17, 2022, 10:29:25 PM
    Author     : ram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


 <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="QuestionServlet" action="QuestionServlet">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-question"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Vsoulution <sup>2</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Home
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/question-list">
                    <i class="fas fa-home"></i>
                    <span>Home</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/view-Answer">
                    <i class="fas fa-comment"></i>
                    <span>All Answers</span></a>
            </li>

           
               <li class="nav-item">
                <a class="nav-link" href="my-messages" action="/my-messages">
                    <i class="fas fa-comment-dots"></i>
                    <span>Message</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Questions
            </div>

           

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="new" action="/new">
                    <i class="fa fa-question"></i>
                    <span>New Questions</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fa fa-question-circle"></i>
                    <span>My questions</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fa fa-file-word"></i>
                    <span>My answer</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
             <div class="sidebar-heading">
                 <i class="fa fa-pencil"></i>
                My answers
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
