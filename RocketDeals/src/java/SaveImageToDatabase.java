/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BECoS
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

class SaveImageToDatabase {
      public static void main(String[] args)  throws java.sql.SQLException {

            // declare a connection by using Connection interface 
            Connection connection = null;

            /* Create string of connection url within specified format with machine 
			name, port number and database name. Here machine name id localhost 
			and database name is mahendra. */

            String connectionURL = "jdbc:mysql://localhost:3306/rocketdeals";

            /*declare a resultSet that works as a table resulted by execute a specified 
			sql query. */
            ResultSet rs = null;

            // Declare statement.
            PreparedStatement psmnt = null;
           
		    // declare FileInputStream object to store binary stream of given image.
			FileInputStream fis;

            try {

                // Load JDBC driver "com.mysql.jdbc.Driver"
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                /* Create a connection by using getConnection() method that takes 
				parameters of string type connection url, user name and password to 
				connect to database. */
                connection = DriverManager.getConnection(connectionURL, "root", "admin");

                // create a file object for image by specifying full path of image as parameter.
	            File image = new File("web/images/crumb.png");

	           /* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */
               psmnt = connection.prepareStatement("insert into save_image(name, image) "+
				   "values(?,?)");
               psmnt.setString(1,"Bake Factory");

               fis = new FileInputStream(image);
	 
               psmnt.setBinaryStream(2, (InputStream)fis, (int)(image.length()));

	           /* executeUpdate() method execute specified sql query. Here this query 
	           insert data and image from specified address. */ 
               int s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload image.");
               }
           }

           // catch if found any exception during rum time.
           catch (Exception ex) {
	              System.out.println("Found some error : "+ex);
           }

           finally {
	            // close all the connections.
	            connection.close();
                psmnt.close();
           }
	  }
}

