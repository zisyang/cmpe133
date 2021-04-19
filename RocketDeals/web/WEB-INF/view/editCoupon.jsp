<%-- 
    Document   : editCoupon
    Created on : May 9, 2012, 5:02:34 PM
    Author     : BECoS
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% String id = session.getAttribute("editID").toString(); 
System.out.println(id);%>

<sql:query var="result" dataSource="jdbc/rocketdeals">
    SELECT * FROM product WHERE product.id = <%= id %>
</sql:query>

<form action="processEditedCoupon" method="post" enctype="multipart/form-data">  
    <br/>
    <h2 class="h2Main center">Edit Coupon</h2>
    <label class="regLabel" style="padding-right: 165px">
        Category
    </label>
    <select name="categoryType">
        <option value="1" <c:if test="${result.rows[0].category_id == 1}"> <c:out value="Selected" /> </c:if> >Automotive & Home</option>
        <option value="2" <c:if test="${result.rows[0].category_id == 2}"> <c:out value="Selected" /> </c:if> >Beauty & Spa</option>
        <option value="3" <c:if test="${result.rows[0].category_id == 3}"> <c:out value="Selected" /> </c:if> >Books</option>
        <option value="4" <c:if test="${result.rows[0].category_id == 4}"> <c:out value="Selected" /> </c:if> >Food</option>
        <option value="5" <c:if test="${result.rows[0].category_id == 5}"> <c:out value="Selected" /> </c:if> >Toys</option>
        <option value="6" <c:if test="${result.rows[0].category_id == 6}"> <c:out value="Selected" /> </c:if> >Electronics</option>
        <option value="7" <c:if test="${result.rows[0].category_id == 7}"> <c:out value="Selected" /> </c:if> >Entertainment</option>
        <option value="8" <c:if test="${result.rows[0].category_id == 8}"> <c:out value="Selected" /> </c:if> >Health & Fitness</option>
        <option value="9" <c:if test="${result.rows[0].category_id == 9}"> <c:out value="Selected" /> </c:if> >Shopping</option>
        <option value="10" <c:if test="${result.rows[0].category_id == 10}"> <c:out value="Selected" /> </c:if> >Music</option>
    </select>
    <br>
    <br>
    <label class="regLabel" style="padding-right: 37px">
        Coupon Name
    </label>
    <input type="text" value="${result.rows[0].name}" name="couponName" class="inputTextMain" maxlength="40"> 
    <br>
    <br>	
    <label class="regLabel" style="padding-right: 5px">
        Number of Coupons
    </label>
    <input type="number" value="${result.rows[0].quantity}" name="quantity" class="inputTextMain" maxlength="6">
    <br>
    <br>
    <label class="regLabel" style="padding-right: 45px">
        Original Price
    </label>
    <input type="text" value="${result.rows[0].reg_price}" name="oriprice" class="inputTextMain" maxlength="5">
    <br>
    <br>
    <label class="regLabel" style="padding-right: 25px">
        Discounted Price
    </label>
    <input type="text" value="${result.rows[0].price}" name="disprice" class="inputTextMain" maxlength="5">
    <br>
    <br>
    <label class="regLabel" style="padding-right: 46px">
        Starting Date
    </label>
    <input type="text" value="${fn:substring(result.rows[0].start_date, 0, 4)}" name="startYear" class="inputTextMain" maxlength ="4" Style="display: inline; width: 45px; margin-right: 43px" placeholder="YYYY"><input type="text" name="startMonth" value="${fn:substring(result.rows[0].start_date, 6, 7)}" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 43px" placeholder="MM" maxlength="2"><input type="text" name="startDay" value="${fn:substring(result.rows[0].start_date, 9, 10)}" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 44px" placeholder="DD" maxlength="2">
    <br>
    <br>
    <label class="regLabel" style="padding-right: 56px">
        Expiry Date
    </label>
    <input type="text" name="expYear" value="${fn:substring(result.rows[0].end_date, 0, 4)}" class="inputTextMain" maxlength="4" Style="display: inline; width: 45px; margin-right: 43px" placeholder="YYYY"><input type="text" name="expMonth" value="${fn:substring(result.rows[0].end_date, 6, 7)}" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 43px" placeholder="MM" maxlength="2"><input type="text" name="expDay" value="${fn:substring(result.rows[0].end_date, 9, 10)}" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 44px" placeholder="DD" maxlength="2">
    <br>
    <br>
    <label class="regLabel" style="padding-right: 5px">
        Coupon Description
    </label>
    <textarea class="inputTextMain" style="vertical-align: middle;resize: none; height: 100px" name="couponDescription" onfocus="this.value=''; setbg('#e5fff3');" onblur="setbg('white')" maxlength="300">
${result.rows[0].description}"
    </textarea>
    <br>
    <br>
    <label class="regLabel" style="padding-right: 35px">
        Coupon Image
    </label>
    <input type="file" name="file" size="15" class="inputTextMain" required="required" />
    <br>
    <br>
    <input id="submit" style="float:none;" type="submit" value="Submit" class="inputTextMain">
    <input id="submit" style="float:none;" type="button" value="Cancel" onclick="javascript:window.location='selectCouponToEdit'"> 
<br>
</form>