<%-- 
    Document   : index
    Created on : Feb 28, 2012, 12:37:33 PM
    Author     : BECoS
--%>
</div>
                <div id="welcomeText">
                    <p style="font-size: larger">Welcome to Rocket Deals</p>
                    <p>We have the best deals for everyone. </p>
                    <p>Here we go<% if(myname == null) out.print("."); 
                                      else out.print(", "+myname+".");
                    %></p>
                    <p style="border-bottom: 1px solid #CCCCCC;"></p>  
                </div>
<%--
            <h2>The time is now <%= new java.util.Date() %></h2>
            <h3><%
                    out.println( "<BR>Your machine's address is " );
                    out.println( request.getRemoteHost());
                %>
            </h3>
                <br><br>
                <FORM METHOD=POST ACTION="category">
                <label class="regLabel" style="padding-right: 25px">What is Your Name?</label><input type="text" name="username" class="inputTextMain" required="required" size="20"> <br> <br>
                <P>
                    <input id="submit" style="float:none;" type="submit" value="Submit" class="inputTextMain">
                </FORM>
 --%>               
            </div>
