/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author BECoS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager 
{ 
    static Connection con;
    static String url;
    public static Connection getConnection() 
    { 
        try 
        { 
            String dbUrl = "jdbc:mysql:///rocketdeals";
            try 
            {
                    Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            } 
            catch (InstantiationException ex) 
            {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) 
            {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try 
            { 
                con = DriverManager.getConnection(dbUrl,"root","admin");
            } 
            catch (SQLException ex)
            { 
                ex.printStackTrace(); 
            }
        } 
        catch(ClassNotFoundException e) 
        { 
            System.out.println(e); 
        }
        return con; 
    } 
}
