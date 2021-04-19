<%@page import="controller.UserBean"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : viewPurchaseHistory
    Created on : May 5, 2012, 11:12:32 PM
    Author     : BECoS
--%>
<% 
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");
            
            %>
    <sql:query var="result" dataSource="jdbc/rocketdeals">
        SELECT customer_order.id, customer_order.amount,customer_order.date_created,
        customer_order.confirmation_number, product.name, product.description,
        product.price, product.end_date
        FROM customer_order,product WHERE customer_order.customer_id = <%=user.getID()%>
        AND customer_order.id = product.id
    </sql:query>
    
    <table border="1">
        <!-- column headers -->
        <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
        <c:forEach var="column" items="${row}">
            <td><c:out value="${column}"/></td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>