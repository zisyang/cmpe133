
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="controller.UserBean"%>

<%
                UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));
                myname = currentUser.getName();
                //String mytype = currentUser.getUserType();
                String myemail = currentUser.getEmail();//(String) session.getAttribute("currentSessionEmail");
                String myaddress = currentUser.getAddress();//String) session.getAttribute("currentSessionAddress");
                String mystate = currentUser.getState();// session.getAttribute("currentSessionState");
                String myzip = currentUser.getZipCode();//(String) session.getAttribute("currentSessionZip");
                
                String mycity = currentUser.getCity();//(String) session.getAttribute("currentSessionCity");
                String payment = session.getAttribute("paymentMethod").toString();// + 
                 //       "xx" + session.getAttribute("lastTwoNumber");
         //       String exp = session.getAttribute("expMonth").toString() + "/" +
          //              session.getAttribute("expYear").toString();
                String ID = session.getAttribute("ID").toString();

 %>
<%-- <sql:query var="coupon" dataSource="jdbc/rocketdeals">
    SELECT * FROM product WHERE id = <%= ID %>
</sql:query>
    --%>
            <div id="singleColumn">

                <p id="confirmationText">
                    Thank You! Your order is placed!
                    <br><br>
                    Your confirmation reference number is #<%=session.getAttribute("confirmationNumber").toString()%>
                </p>

                <div class="summaryColumn" >

                    <table id="orderSummaryTable" class="detailsTable" >
                        <tr class="header">
                           <th style="padding:10px">
                               We'll email you the confirmation reference number <br>
                               and the purchase detail information. Thank you again! 
                              <%--[ order summary table ]
                                <br>${coupon.rows[0].name} <fmt:formatNumber value="${coupon.rows[0].price}" type="currency"/>
                                <br>Remaining Time: <strong id="countdown">Enable Javascript to see a Countdown to 2010!</strong>
                                <br>Discount: <fmt:formatNumber type="percent" maxIntegerDigits="2" value="${coupon.rows[0].price / coupon.rows[0].reg_price}" />
                                You save: <fmt:formatNumber value="${(coupon.rows[0].reg_price - coupon.rows[0].price)}" type="currency"/>
                           --%> </th>
                       </tr>
                    </table>

                </div>

                <div class="summaryColumn" >

                    <table id="deliveryAddressTable" class="detailsTable">
                        <tr class="header">
                            <th style="padding:10px">[ customer details ]
                                <br>Name: <%=myname%>
                                <br>E-mail: <%=myemail%>
                                <br>ZIP: <%=myzip%>
                                <br>Address: <%=myaddress%>
                                <br>City: <%=mycity%>
                                <br>State: <%=mystate%>
                                <br>Payment Method: <%=payment%>
                            </th>
                        </tr>
                    </table>
                </div>
            </div>

