<%@ page import="java.sql.*,java.io.*,java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>rocketdeals generated by WOWSlider.com</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="rocketdeals, WOW Slider, Download Free jQuery Slideshow, jQuery Gallery" />
	<meta name="description" content="rocketdeals created with WOW Slider, a free wizard program that helps you easily generate beautiful web slideshow" />
	<!-- Start WOWSlider.com HEAD section -->
	<link rel="stylesheet" type="text/css" href="engine1/style.css" />
	<style type="text/css">a#vlb{display:none}</style>
	<script type="text/javascript" src="engine1/jquery.js"></script>
	<script type="text/javascript" src="engine1/wowslider.js"></script>
	<!-- End WOWSlider.com HEAD section -->
</head>
<body style="background-color:#ffffff">
	<!-- Start WOWSlider.com BODY section -->
	<div id="wowslider-container1">
	<div class="ws_images">
            <%try
                { 
                    String zipCode = session.getAttribute("zipCode").toString();
                    String category = session.getAttribute("category").toString();
                    String strQuery;
                    
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketdeals","root","admin");
                    Statement stmt=con.createStatement();
                    
                    if (Integer.parseInt(category) > 0)
                    {
                        strQuery = "select * from product JOIN vendor ON vendor.id = product.vendor_id WHERE vendor.zip = " + zipCode + " AND product.end_date >= CURRENT_DATE() AND product.start_date <= CURRENT_DATE() AND product.category_id = " + category; //select * from save_image                 
                    }
                    else
                    {
                        strQuery = "select * from product JOIN vendor ON vendor.id = product.vendor_id WHERE vendor.zip = " + zipCode + " AND product.end_date >= CURRENT_DATE() AND product.start_date <= CURRENT_DATE()";                  
                    }
                    
                    ResultSet rs = stmt.executeQuery(strQuery);
                    while(rs.next())                                    
                    {
                        %>            
                        <a href="coupon?<%=rs.getInt("id")%>">
                            <img src="${initParam.couponImagePath}<%=rs.getString("image_url")%>" title="<%=rs.getString("name")%>" alt="text" />
                        </a>                    
                        <% 
                    }
                    
                    rs.close();
                    con.close();
                    stmt.close();
                }
                catch(Exception e)
                {
                    e.getMessage();
                } %>
            
        </div>
	</div>
	<script type="text/javascript" src="engine1/script.js"></script>
	<!-- End WOWSlider.com BODY section -->
</body>
</html>