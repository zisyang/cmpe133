<%-- 
    Document   : editCoupon
    Created on : May 9, 2012, 3:50:50 PM
    Author     : BECoS
--%>
<%@page import="controller.UserBean"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
<% String vendorID = Integer.toString(currentUser.getID());%>

<sql:query var="result" dataSource="jdbc/rocketdeals">
    SELECT id, name, price, reg_price, description, quantity, start_date, end_date, amount_bought FROM product WHERE product.vendor_id = <%=vendorID%>
</sql:query>

<table width="850" border="1" style="font-size: small">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th width="8%" height="8%">
                <c:out value="${columnName}"/>
            </th>
        </c:forEach>
    </tr>
   <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
            <td>
                <div class="Myclass">
                    <c:out value="${column}"/>
                </div>
            </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
                
<form name="selectToEditCoupon" method="post" action="selectedCoupon">
    <label>
        Enter coupon ID
    </label>
    <input type="text" name="select" placeholder="seperate with a space">
    <input type="submit" value="Edit"> 
    <input type="button" value="Cancel" onclick="javascript:window.location='vendorProfile'"> 
</form>
