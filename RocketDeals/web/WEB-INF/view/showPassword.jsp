<%-- 
    Document   : recoverResult
    Created on : Apr 30, 2012, 12:13:55 AM
    Author     : ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recover Password Result</title>
    </head>
    <body>
       <%-- <h1>Your Password</h1> --%>
        <% 
            String pass = (String) session.getAttribute("decryptedPassword");
            if (pass==null) {
                out.println("<h2 class=\"h2Main center\">Recover Password Failed!</h2>");
                out.println("<p> Can't find the password matching with your entered</p>");
            }
            else {
                out.println("<h2 class=\"h2Main center\">Successfully Recovered!</h2>");
                out.println("<p> Your Password will be send to your email account.</p>");
                out.println("<p> Please keep your password in safe! Thank you! </p");
                session.removeAttribute("decryptedPassword");
                pass=new String();
            }
        %>
       
    </body>
</html>