<%
   String ID = session.getAttribute("ID").toString();
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="coupon" dataSource="jdbc/rocketdeals">
    SELECT * FROM product WHERE id = <%= ID %>
</sql:query>

<div id="centerColumn">
    <h2>
        checkout
    </h2>
    <p>
        In order to purchase the items in your shopping cart, please provide us with the following information:
    </p>
    <form action="purchase" method="post">
        <table id ="checkoutTable">
            <tr>
                <th>
                    card details
                </th>
            </tr>
            <tr>
                <td>
                    <label for=visa>
                        VISA
                    </label> 
                  <%--  <input name="ID" hidden="hidden" value="<%= ID %>">--%>
                    <input id=visa name=cardtype type=radio value="Visa" />
                    
                    <label for=amex>
                        American Express
                    </label>
                    <input id=amex name=cardtype type=radio value ="American Express" />
                    
                    <label for=mastercard>
                        Mastercard
                    </label> 
                    <input id=mastercard name=cardtype type=radio value="Mastercard"/>                          
                </td>
            </tr>
            <tr>
                <td>
                    <label for=cardnumber>
                        Card Number
                    </label>
                    <input id=cardnumber maxlength="16" name=cardNumber type=number required />
                </td>              
            </tr>
            <tr>
                <td>
                    <label for=secure>
                        Security Code
                    </label>
                    <input id=secure maxlength="4" name=secureCode type=number required />
                </td>              
            </tr>    
            <tr>
                <td>
                    <label for=namecard>
                        Cardholder Name
                    </label>
                    <input id=namecard maxlength="45" name=nameCard type=text placeholder="Exact name on the card" required />
                </td>              
            </tr>             
            <tr>
                <td>
                    <label for=cardexp>
                        Expiration date
                    </label>
                    <input id=cardexp maxlength="2" name=cardExpMonth type=text placeholder="MM" style="display:inline; width: 35px;" required />
                    <input id=cardexp maxlength="4" name=cardExpYear type=text placeholder="YYYY" style="display:inline; width: 45px;" required />
                </td>
            </tr>
            <tr>
                <td>
                    <input id="submit" style="float:none;" type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form>
    
    <div id="infoBox">
        <div style="border: black solid 1px; height:100px; padding: 10px">
            [ purchase conditions ]<br>
            All order(s) are final.
        </div>
        <div id="priceBox">
            [ purchase calculations:<br>Your card will be charged ${coupon.rows[0].price}]
        </div>
    </div>
</div>