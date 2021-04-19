<%-- 
    Document   : changepassword
    Created on : Apr 28, 2012, 5:28:49 PM
    Author     : brandonthai2003
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
            <h2 class="h2Main center">Change Password</h2>
        <script>
    function validateForm()
    { 
        var pass=document.forms["changepasswordform"]["password"].value;
        var cpass=document.forms["changepasswordform"]["cpass"].value;
        if ( pass!=cpass ) {
            alert("Your new password and confirmation password do not match.");
           // cpass.focus();
           // location.back(true);
            return false;
        }
       
    }
</script>


        <form name="changepasswordform" method="post" action="changePassword" id="formstyle" onsubmit="return validateForm();">
                    <label class="regLabel" style="padding-right: 61px">Old Password *</label><input type="password" name="oldpassword" maxlength="45" class="inputTextMain" required="required"><br><br>
                    <label class="regLabel" style="padding-right: 61px">New Password *</label><input type="password" name="password" maxlength="45" class="inputTextMain" required="required"><br><br>
            <label class="regLabel" style="padding-right: 15px">Confirm New Password *</label><input type="password" name="cpass" maxlength="45" class="inputTextMain" required="required"><br><br>
                    <input id="submit" style="float:none;" type="submit" value="Submit" class="inputTextMain"><br>
</form>

    </body>
</html>
