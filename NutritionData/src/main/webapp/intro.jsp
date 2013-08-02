<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="stylesheets/intro.css"/>
    <link href="resources/dist/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="resources/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <title>Explorer</title>
    <script>
        $(function () {
            $("#lefttabs").tabs();
        });
        $(function () {
            $("#toptabs").tabs();
        });
    </script>
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();

%>
<div id="toptabs">
    <div id="topcontent">
        <ul>
            <li><a class="glidebutton" href="#tt-1"><span data-text="Home">Home</span></a></li>
            <li><a class="glidebutton" href="#tt-2"><span data-text="Post">Post</span></a></li>

        </ul>
    </div>
    <div id="topleftcontent">
        <div class="btn-group">
            <button type="button" class="btn btn-success" data-toggle="dropdown" style="float:right;margin:5px;"><%=user.getNickname()%> <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="<%=userService.createLogoutURL(request.getRequestURI())%>">Sign Out</a></li>
            </ul>
        </div>
    </div>
    <div id="maincontent">
        <div class="innertube">
            <div id="tt-1">Get material</div>
            <div id="tt-2">
                <% if(userService.isUserAdmin()){%>
                Post material
                <%}else{%>
                You must be an admin to post data.
                <%}%>
            </div>
        </div>
    </div>
</div>
</body>
</html>