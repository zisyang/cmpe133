<%-- 
    Document   : vendorProfile
    Created on : Apr 28, 2012, 1:26:31 PM
    Author     : ty
--%>

<%@page import="controller.UserBean"%>
<% String user = session.getAttribute("currentSessionName").toString(); %>


<%-- <% String myName = (String) currentUser.getName(); <%=myName%>%>
    Document   : vendorProfile
    Created on : Apr 28, 2012, 1:26:31 PM
    Author     : ty
--%>

        <h2 class="h2Main center">My Page</h2>
        <p> Hi <%=user%> </p>
<!--        <p><a href="viewCouponHistory">
        View Coupons
    </a></p>-->
        <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='addCoupon'"
        value="Add Coupon">
    </a></p>
     <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='viewCouponHistory'"
        value="List/Delete Coupon">
    </a></p>
        <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='selectCouponToEdit'"
        value="Edit Coupon">
    </a></p> 
    <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='changePassword'"
        value="Change Password">
    </a></p>
    <p><input id="submit2" style="float:none;" type="button" onclick="javascript:window.location='vendorUpdateProfile'"
        value="Update Profile">
    </a></p>

        
