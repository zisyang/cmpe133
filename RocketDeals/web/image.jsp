<%-- 
    Document   : image
    Created on : Apr 2, 2012, 1:58:12 PM
    Author     : BECoS
--%>

<%@ page import="java.sql.*,java.io.*,java.util.*" %> 
<%
  int id =  Integer.parseInt(request.getParameter("imgid"));
  try{      
    //Class.forName("com.mysql.jdbc.Driver").newInstance();
    //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketdeals","root","admin");      
      Connection con=(Connection) controller.ConnectManager.gentConnection();
    Statement st=con.createStatement();
    String strQuery = "select image from save_image where id="+id;
    ResultSet rs = st.executeQuery(strQuery);

    String imgLen="";
    if(rs.next()){
      imgLen = rs.getString(1);
       }  
    rs = st.executeQuery(strQuery);
    if(rs.next()){
      int len = imgLen.length();
      byte [] rb = new byte[len];
      InputStream readImg = rs.getBinaryStream(1);
      int index = readImg.read(rb, 0, len);  
      st.close();
      response.reset();
      response.getOutputStream().write(rb,0,len); 
      response.getOutputStream().flush();        
    }
  }
  catch (Exception e){
    e.printStackTrace();
  }
%>