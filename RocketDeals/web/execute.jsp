<%-- 
    Document   : execute
    Created on : Apr 17, 2012, 2:23:15 PM
    Author     : BECoS
--%>

<%@page import="java.sql.*"%>
<%@page import=" java.security.MessageDigest"%>

<html>
    <body>

    <%
    
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String address=request.getParameter("address");
    String zip=request.getParameter("zip");
    String password=request.getParameter("password");
    
    byte[] unencodedPassword = password.getBytes();
    MessageDigest md = null;

    try {
        md = MessageDigest.getInstance("MD5");
    } catch (Exception e) {

        //Good practise for error handling by printing the Exception
        %>
        <%=e%>
        <%
    }

    //encoding the password

    md.reset();
    md.update(unencodedPassword);
    byte[] encodedPassword = md.digest();
    StringBuffer buf = new StringBuffer();

    for (int i = 0; i < encodedPassword.length; i++) {
        if (((int) encodedPassword[i] & 0xff) < 0x10) {
            buf.append("0");
        }
        buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
    }

    String passw=buf.toString();
    Connection con=null;

    try{

    Class.forName("org.gjt.mm.mysql.Driver").newInstance();
    con =DriverManager.getConnection("jdbc:mysql:///rocketdeals","root","admin");
    }
    catch(Exception e){
        %>
        <%=e.toString()%>
        <%
    }

    try{
        PreparedStatement ps = con.prepareStatement("INSERT INTO customer(name, email, address, city_region, password) VALUES(?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,address);
        ps.setString(4,zip);
        ps.setString(5,passw);
        int i = ps.executeUpdate();

        ps.close();
        con.close();
    }
    catch(Exception e){

        %>
        <%=e.toString()%>
        <%
    }

        %>   
    </body>
</html>
