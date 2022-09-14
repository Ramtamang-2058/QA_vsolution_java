<%-- 
    Document   : Messsage
    Created on : Sep 3, 2022, 8:21:07 AM
    Author     : ram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

    <meta charset="utf-8">
    <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
    <!--  All snippets are MIT license http://bootdey.com/license -->
    <title>Vsolution|chat</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/message.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.6.8-fix/jquery.nicescroll.min.js"></script>

    <div class="content container-fluid bootstrap snippets bootdey">
        <div class="row row-broken">
            <div class="col-sm-3 col-xs-12">
                <div class="col-inside-lg decor-default chat" style="overflow: hidden; outline: none;" tabindex="5000">
                    <div class="chat-users">
                        <h6>Message</h6>
                        <!--user profile starts here-->
                        <c:forEach var="usr" items="${listUser}">
                            <a href="<%=request.getContextPath()%>/message-list?id1=${usr.id}&id2=${user.id}"> <div class="user">
                                    <div class="avatar">
                                        <img src="<%=request.getContextPath()%>/<c:out value='${usr.profile}' />" alt="User name">
                                        <div class="status online"></div>
                                    </div>
                                    <div class="name"><c:out value="${usr.fullname}" /></div>
                                    <div class="mood"><c:out value="${usr.username}" /></div>
                                </div></a>
                            </c:forEach>
                    </div>
                </div>
            </div>
            <div id="scroll" class="col-sm-9 col-xs-12 chat" style="overflow: hidden; outline: none;" tabindex="5001">
                <div class="col-inside-lg decor-default">
                    <div class="chat-body">
                        <h6>Mini Chat</h6>
                        <c:forEach var="users" items="${listMessage}">
                            <c:if test="${users.send_by == sender.id}">
                            <div class="answer left">
                               
                                
                                <div class="avatar">
                                    <img src="<%=request.getContextPath()%>/<c:out value='${sender.profile}' />" alt="User name">
                                    <div class="status offline"></div>
                                </div>
                                <div class="name">${sender.fullname}</div>
                                <div class="text">
                                    ${users.message}                </div>
                                <div class="time">${users.created_date}</div>
                            </div>
                             </c:if>
                            <c:if test="${users.send_by != sender.id}">
                           
                             
                            <div class="answer right">
                                <div class="avatar">
                                    <img src="<%=request.getContextPath()%>/<c:out value="${user.profile}" />" alt="User name">
                                    <div class="status online"></div>
                                </div>
                                <div class="name">${user.fullname}</div>
                                <div class="text">
                                    ${users.message}
                                </div>
                                <div class="time">${users.created_date}</div>
                            </div>
                               </c:if>
                        </c:forEach>
                       
                        <div class="answer-add">
                        </div>
                    </div>
                </div>
            </div>
            <form method="post" action="new-message">
                <input type="hidden" name="sender" value="${user.id}">
                <input type="hidden" name="receiver" value="${sender.id}">
                <input class="rcorners1" type="submit" value="send" class="btn-outline-success">
                <input name="message" class="rcorners2" type="text" placeholder="Enter your message.">
            </form>

        </div>

    </div>
    <br><!-- line break -->   
    <br>
    <%@include file="../footer.jsp" %>
    <script type="text/javascript">
        document.getElementById('scroll').scrollTop = 9999999;
        $(function () {
            $(".chat").niceScroll();
        })
    </script>
</body>
</html>