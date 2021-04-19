<%-- 
    Document   : welcome
    Created on : Apr 26, 2012, 6:28:57 PM
    Author     : ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Hello <% out.print((String) session.getAttribute("currentSessionUserType") ); %></h1>
    </body>
</html>
