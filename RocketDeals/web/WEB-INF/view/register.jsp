<%-- 
    Document   : testForm
    Created on : Apr 19, 2012, 3:56:41 PM
    Author     : BECoS
--%>



        <form name="userform" method="post" action="register" id="formstyle">
            <h2 class="h2Main center">Register</h2>
            <label class="regLabel" style="padding-right: 203px">Account Type</label>
            <select name="AccountType">
                <option value="customer">Customer</option>
                <option value="vendor">Vendor</option>
            </select><br><br>
            <label class="regLabel" style="padding-right: 87px">Name</label><input type="text" name="name" class="inputTextMain" required="required" maxlength="50"> <br> <br>	
            <label class="regLabel" style="padding-right: 85px">E-mail</label><input type="email" name="email" class="inputTextMain" required="required" maxlength ="36"><br><br>
            <label class="regLabel" style="padding-right: 73px">Address</label><input type="text" name="address" class="inputTextMain" maxlength="95"><br><br>
            <label class="regLabel" style="padding-right: 100px">City</label><input type="text" name="city" class="inputTextMain" maxlength="35"><br><br>
            <label class="regLabel" style="padding-right: 92px">State</label><input type="text" name="state" class="inputTextMain" maxlength="2"><br><br>            
            <label class="regLabel" style="padding-right: 100px">ZIP</label><input type="text" name="zip" class="inputTextMain" maxlength="5"><br><br>
            <label class="regLabel" style="padding-right: 61px">Password</label><input type="password" name="password" class="inputTextMain" required="required" maxlength="10"><br><br>
            <label class="regLabel" style="padding-right: 15px">Confirm Password</label><input type="password" name="cpass" class="inputTextMain" required="required" maxlength="10"><br><br>
            <input id="submit" style="float:none;" type="submit" value="Submit" class="inputTextMain"><br>
        </form>

<!--<select name="AccountType" ONCHANGE="location = this.options[this.selectedIndex].value;">

<option>Customer</option>

<option value="about">Vendor</option>

</select><br><br>
have that for select	9:47 PM
just change the value = "about"	9:47 PM
to value = "vendorReg"	9:47 PM
or something	9:47 PM
don't forget to add the path in controller servlet. it should work. 

-->