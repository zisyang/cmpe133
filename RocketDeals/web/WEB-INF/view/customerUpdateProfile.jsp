<%-- 
    Document   : updateprofile
    Created on : Apr 28, 2012, 5:28:34 PM
    Author     : brandonthai2003
--%>

<%@page import="controller.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>
    </head>
    <body>
        <h2 class="h2Main center">Update Profile</h2>

  <script>
    function validateForm()
    { 
        var pass=document.forms["customerupdateform"]["password"].value;
        var cpsas=document.forms["customerupdateform"]["cpass"].value;
        if ( pass!=cpass ) {
            alert("Your password and confirmation password do not match.");
           // cpass.focus();
           // location.back(true);
            return false;
        }
        var zip=document.forms["customerupdateform"]["zip"].value;
        if( ! /(^\d{5}$)/.test(zip) ) {
            alert("The zip code must be 5 numeric digits!");
           // zip.focus();
           // location.reload(true);
            return false;
        }
    }
</script>
            <%
                UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));
                myname = currentUser.getName();
                //String mytype = currentUser.getUserType();
                String myemail = currentUser.getEmail();//(String) session.getAttribute("currentSessionEmail");
                String myaddress = currentUser.getAddress();//String) session.getAttribute("currentSessionAddress");
                String mystate = currentUser.getState();// session.getAttribute("currentSessionState");
                String myzip = currentUser.getZipCode();//(String) session.getAttribute("currentSessionZip");
                
                String mycity = currentUser.getCity();//(String) session.getAttribute("currentSessionCity");
                if(myname!=null) {
            %>        
<form name="customerupdateform" method="post" action="customerUpdateProfile" id="formstyle" onsubmit="return validateForm();">
            <p> * indicated required field </p>
            <br><br>
            <label class="regLabel" style="padding-right: 87px">Name  </label><input value="<%=myname%>" type="text" name="name" disabled="disabled" class="inputTextMain"> <br> <br>	
            <label class="regLabel" style="padding-right: 85px">E-mail  </label><input value="<%=myemail%>" type="email" name="email" disabled="disabled" class="inputTextMain"><br><br>
            <label class="regLabel" style="padding-right: 61px">Password *</label><input type="password" name="password" maxlength="45" class="inputTextMain" required="required"><br><br>
            <label class="regLabel" style="padding-right: 15px">Confirm Password *</label><input type="password" name="cpass" maxlength="45" class="inputTextMain" required="required"><br><br>
            <label class="regLabel" style="padding-right: 100px">ZIP *</label><input value="<%=myzip%>" type="text" name="zip" maxlength="5" class="inputTextMain" required="required"><br><br>
            <label class="regLabel" style="padding-right: 73px">Address</label><input value="<%=myaddress%>" type="text" name="address" maxlength="45" class="inputTextMain"><br><br>
            <label class="regLabel" style="padding-right: 100px">City</label><input value="<%=mycity%>" type="text" name="city" maxlength="45" class="inputTextMain"><br><br>
            <label class="regLabel" style="padding-right: 92px">State</label><input value="<%=mystate%>" type="text" name="state" maxlength="2" class="inputTextMain"><br><br>            
            <input id="submit" style="float:none;" type="submit" value="Update" class="inputTextMain">&nbsp;&nbsp;&nbsp;
            <input id="submit2" style="float:none;" type="button" value="Back to My Page" class="inputTextMain" 
                   onclick="javascript:window.location='customerProfile'"><br>
        </form>
        
            <%
                }            
            %>
    </body>
</html>
