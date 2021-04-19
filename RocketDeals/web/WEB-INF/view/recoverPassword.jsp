<%-- 
    Document   : recoverpassword
    Created on : Apr 29, 2012, 4:52:01 PM
    Author     : ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recovery Password</title>
    </head>
    <body>
        <h2 class="h2Main center">Forgot Your Password?</h2>
        <script>
    function validateForm()
    {
        var email=document.forms["recoveryform"]["email"].value;
        var cemail=document.forms["recoveryform"]["cemail"].value;
        if ( email!=cemail ) {
            alert("Your email and confirmation email do not match.");
           // cpass.focus();
           // location.back(true);
            return false;
        }
        var zip=document.forms["recoveryform"]["zip"].value;
        if( ! /(^\d{5}$)/.test(zip) ) {
            alert("The zip code must be 5 numeric digits!");
           // zip.focus();
           // location.reload(true);
            return false;
        }
       
    }
</script>


        <form name="recoveryform" method="post" action="recoverPassword" id="formstyle" onsubmit="return validateForm();">
            <p> Enter your email address and zip code to recover your password,  or <a href="register">Register</a> </p><br><br>
            <label class="regLabel" style="padding-left: 45px">E-mail *</label><input type="password" name="email" maxlength="45" class="inputTextMain" required="required"><br><br>
            <label class="regLabel" style="padding-left: 0px">Confirm E-mail *</label><input type="password" name="cemail" maxlength="45" class="inputTextMain" required="required"><br><br>
            <label class="regLabel" style="padding-left: 60px">ZIP *</label><input type="text" maxlength="5" name="zip" class="inputTextMain" required="required"><br><br>
            <input id="submit" style="float:none;" type="submit" value="Submit" class="inputTextMain"><br>
        </form>
    </body>
</html>