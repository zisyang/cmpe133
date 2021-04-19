<%@page import="controller.UserBean"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : testDataSource
    Created on : Mar 28, 2012, 2:03:14 PM
    Author     : BECoS
--%>
<% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
<% String vendorID = Integer.toString(currentUser.getID());%>

<sql:query var="result" dataSource="jdbc/rocketdeals">
    SELECT id, name, price, reg_price, description, quantity, start_date, end_date, amount_bought FROM product WHERE product.vendor_id = <%=vendorID%>
</sql:query>
  
    <table width="850" border="1" style="font-size: small">
        <!-- column headers -->
        <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th width="8%" height="8%"><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
        <c:forEach var="column" items="${row}">
        <td><div class="Myclass"><c:out value="${column}"/></div></td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
<form name="deleteCoupon" method="post" action="deleteCoupon">
    <label>
        Enter coupon ID
    </label>
    <input type="text" name="delete" placeholder="seperate with a space">
    <input type="submit" value="Delete">  
    <input type="button" value="Cancel" onclick="javascript:window.location='vendorProfile'">
</form>

        
<%--<table border="1">
         column headers 
    <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
            </tr>
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
            <c:forEach var="column" items="${row}">
                <c:if test="${columnName =='id'}"> 
                    <td><a href="viewCouponHistory?<c:out value='${column}'/>"<c:out value="${column}"/></a></td>
                </c:if> 
                    <td><c:out value="${column}"/></td>
                </tr>
            </c:forEach>            
        </c:forEach>
    
     column data 

        
    </c:forEach>
</table>--%>
