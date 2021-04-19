<%-- 
    Document   : logout
    Created on : Apr 26, 2012, 6:55:30 PM
    Author     : ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Refresh" content="5,url=./index.jsp">
        <title>Logout</title>
    </head>
    <body>
        <p> Successfully logged out. </p>
        <p> You'll be redirected to the Home Page in 5 sec ... </p>
        <p> If took too long, please click <a href="./index.jsp">here</a> </p>
        
<%--

     String username=(String)session.getAttribute("currentSessionUser");
    if(username!=null)
        {
           out.println(username+" loged out, "
                   + "<p>You'll be redirected to the Home page in 5 sec ...</p>"
                   + "<p>If took too long, please click <a href=\"index.jsp\">Here</a></p>");
            session.removeAttribute("currentSessionUser");
            out.println("");
            username
        }
     else 
         {
         out.println("You are already not login <a href=\"index.jsp\">Back</a>");
     }



--%>  
    </body>
</html>
