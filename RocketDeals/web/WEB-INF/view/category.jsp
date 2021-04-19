<%-- 
    Document   : category
    Created on : Mar 6, 2012, 12:26:33 PM
    Author     : BECoS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="categories" dataSource="jdbc/rocketdeals">
    SELECT * FROM category   
</sql:query>
    
<sql:query var="selectedCategory" dataSource="jdbc/rocketdeals">
    SELECT name FROM category WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>    

<div id="indexLeftColumn">
    <table style="width:100%; height:99.9%; background: whitesmoke" border = "1">
        <tr>  
        <c:forEach var="category" items="${categories.rows}" varStatus="rowCounter">  
            <c:choose>
                <c:when test="${category.id == pageContext.request.queryString}">
                    <td class="categoryButton" id="selectedCategory" style="background: url(img/stars.png)" align="center">
                        <span class="categoryText">
                            ${category.name}
                        </span>
                    </td>
                </c:when>
                <c:otherwise>
                    <td style="background: url(img/stars.png)" align="center">
                        <a href="category?${category.id}" class="categoryButton">
                            <span class="categoryText">
                                ${category.name}
                            </span>
                        </a>
                    </td>
                </c:otherwise>
            </c:choose>        
            <c:choose>  
                <c:when test="${(rowCounter.count % 2) == 0}">  
        </tr>  
                </c:when>  
            </c:choose>  
        </c:forEach>  
    </table>
</div>

<div id="indexRightColumn">
    <br />
    <%@include file= "slideShow.jsp"%>
    <p id="categoryTitle">
        ${selectedCategory.rows[0].name}
    </p>
    
        <%-- <%@ page import="java.sql.*,java.io.*,java.util.*" %> 
<table border="1">
 <tr><th>ID</th><th>Image</th></tr>
   <%
  try{      
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rocketdeals","root","ramir3z");
    Statement stmt=con.createStatement();
    String strQuery = "select * from save_image";
    ResultSet rs = stmt.executeQuery(strQuery);
    while(rs.next()){
       %>
      <tr>
      <td><%=rs.getInt("id")%></td>
      <td>
      <img src="image.jsp?imgid=<%=rs.getInt(1)%>" width="100" height="100">
</td>
      </tr>
      <%
    }
    rs.close();
    con.close();
    stmt.close();
  }
  catch(Exception e)
  {
    e.getMessage();
  }
  %>
 </table> <%--<%=session.getAttribute( "zipCode" )%>--%>

    </div>
