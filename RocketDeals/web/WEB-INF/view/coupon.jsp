<%-- 
    Document   : coupon
    Created on : Apr 7, 2012, 1:36:37 PM
    Author     : BECoS --%>

<%String couponID = request.getQueryString();%>

<%
   String ID = session.getAttribute("ID").toString();
%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="coupon" dataSource="jdbc/rocketdeals">
    SELECT * FROM product WHERE id = <%= ID %>
</sql:query>
    
<sql:query var="vendor" dataSource="jdbc/rocketdeals">
    SELECT * FROM vendor WHERE id = ${coupon.rows[0].vendor_id}
</sql:query>        

<div id="couponLeftColumn">

    <form class="buyButton" method ="post" action="checkout">
        <p>
            $${coupon.rows[0].price}
            <input type ="image" src="img/blankCopy2.png" class="buyButton_submit" value="<%=ID %>">
        </p>
    </form>
    <table>
        <tr>
            <td>
               Value: <fmt:setLocale value="en_US"/>
                      <fmt:formatNumber value="${coupon.rows[0].reg_price}" type="currency"/>
            </td>
            <td>
                Discount: <fmt:formatNumber type="percent" maxIntegerDigits="2" value="${coupon.rows[0].price / coupon.rows[0].reg_price}" />
            </td>
            <td>
               You save: <fmt:formatNumber value="${(coupon.rows[0].reg_price - coupon.rows[0].price)}" type="currency"/>
            </td>            
        </tr>
        <tr>
            <td colspan="3">
                <font style="font-size: medium">Remaining Time:</font>
                <br />
                <strong id="countdown">Enable Javascript to see a Countdown to 2010!</strong>
                <br />
                <em id="label">days&nbsp;&nbsp;&nbsp;&nbsp; hours&nbsp;&nbsp;&nbsp; min&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; sec</em>
            </td>
        </tr>
    </table>
    <p style="float:left;font-size:medium;">
        ${coupon.rows[0].description}
    </p>
</div>
    
<div id="indexRightColumn">
    <DIV STYLE="position:absolute; margin-top: 1px; margin-left: -80px; width:500px; height:400px; color: grey; opacity: 0.9; font-size: x-large; font-family: Impact, Charcoal, sans-serif;">
        ${vendor.rows[0].name}
    </DIV>
    
    <img src ="${initParam.couponImagePath}${coupon.rows[0].image_url}" style="margin-top: 15px; width: 200px; height: 200px;"/>
    <p>
        ${vendor.rows[0].business_description}
    </p>
</div>    
        <%--<c:out value="${coupon.rows[0].quantity - 10}" />--%>