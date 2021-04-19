<%-- 
    Document   : addCoupon
    Created on : Apr 26, 2012, 11:20:55 AM
    Author     : BECoS
--%>
<form action="addCoupon" method="post" enctype="multipart/form-data">
    
    <br/>
    
            <h2 class="h2Main center">Add Coupon</h2>
            <label class="regLabel" style="padding-right: 165px">Category</label>
            <select name="categoryType">
                <option value="1">Automotive & Home</option>
                <option value="2">Beauty & Spa</option>
                <option value="3">Books</option>
                <option value="4">Food</option>
                <option value="5">Toys</option>
                <option value="6">Electronics</option>
                <option value="7">Entertainment</option>
                <option value="8">Health & Fitness</option>
                <option value="9">Shopping</option>
                <option value="10">Music</option>
            </select><br><br>
            <label class="regLabel" style="padding-right: 37px">Coupon Name</label><input type="text" name="couponName" class="inputTextMain" required="required" maxlength="40"> <br> <br>	
            <label class="regLabel" style="padding-right: 5px">Number of Coupons</label><input type="number" name="quantity" class="inputTextMain" required="required" maxlength="6"><br><br>
            <label class="regLabel" style="padding-right: 45px">Original Price</label><input type="text" name="oriprice" class="inputTextMain" maxlength="5"><br><br>
            <label class="regLabel" style="padding-right: 25px">Discounted Price</label><input type="text" name="disprice" class="inputTextMain" maxlength="5"><br><br>
            <label class="regLabel" style="padding-right: 46px">Starting Date</label><input type="text" name="startYear" class="inputTextMain" maxlength ="4" Style="display: inline; width: 45px; margin-right: 43px" placeholder="YYYY"><input type="text" name="startMonth" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 43px" placeholder="MM" maxlength="2"><input type="text" name="startDay" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 44px" placeholder="DD" maxlength="2"><br><br>
            <label class="regLabel" style="padding-right: 56px">Expiry Date</label><input type="text" name="expYear" class="inputTextMain" maxlength="4" Style="display: inline; width: 45px; margin-right: 43px" placeholder="YYYY"><input type="text" name="expMonth" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 43px" placeholder="MM" maxlength="2"><input type="text" name="expDay" class="inputTextMain" Style="display: inline; width: 35px; margin-right: 44px" placeholder="DD" maxlength="2"><br><br>
            <label class="regLabel" style="padding-right: 5px">Coupon Description</label><textarea class="inputTextMain" style="vertical-align: middle;resize: none; height: 100px" name="couponDescription" onfocus="this.value=''; setbg('#e5fff3');" onblur="setbg('white')" maxlength="300">Enter your comment here...</textarea><br><br>
            <label class="regLabel" style="padding-right: 35px">Coupon Image</label><input type="file" name="file" size="15" class="inputTextMain" required="required" /><br><br>
            <input id="submit" style="float:none;" type="submit" value="Submit" class="inputTextMain">
            <input id="submit" style="float:none;" type="button" value="Cancel" onclick="javascript:window.location='vendorProfile'"> 
<br>
</form>
