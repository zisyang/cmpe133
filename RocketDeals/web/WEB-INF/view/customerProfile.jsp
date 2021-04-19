<%-- 
    Document   : userProfile
    Created on : Apr 28, 2012, 12:58:18 PM
    Author     : ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
     <body>
    </a>
        <h2 class="h2Main center">My Page</h2>
        <p>Hello <% out.print( (String) session.getAttribute("currentSessionName") ); %> !</p>
        <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='purchaseHistory'"
        value="Purchase History">
    </a></p>
    <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='changePassword'"
        value="Change Password">
    </a></p>
    <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='customerUpdateProfile'"
        value="Update Profile">
    </a></p>
    </body>
</html>
