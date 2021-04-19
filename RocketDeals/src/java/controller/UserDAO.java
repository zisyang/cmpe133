/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author BECoS
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class UserDAO
{

    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    /*
     * This method is used to login a registered user @param bean the Userbean
     * containing information about the user trying to login @return Userbean is
     * returned after validating the user
     */
    public static UserBean login(UserBean bean)
    { //preparing some objects for connection Statement 
        ResultSet rs2 = null;
        Statement stmt = null;
        Statement stmt2 = null;
        String email = bean.getEmail();
        String password = bean.getPassword();
        String searchQuery = "SELECT * FROM vendor WHERE email='" + email + "' AND password='" + password + "'";// + " AND password = " + password;// + " OR customer.email=" + email + " AND customer.password=" + password;
        String searchQuery2 = "SELECT * FROM customer WHERE email='" + email + "' AND password='" + password + "'";
        // "System.out.println" prints in the console; Normally used to trace the process 
        System.out.println("Your e-mail is " + email);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);
        boolean more = true;
        boolean more2 = true;
        try
        { //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt2 = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            System.out.println(rs);
            more = rs.next();
            rs2 = stmt2.executeQuery(searchQuery2);
            System.out.println(rs2);
            more2 = rs2.next();
            //     if (rs != null)
            {
                // more = rs.next();
                // if user does not exist set the isValid variable to false  window.location.reload();
                if (!more && !more2)
                {
                    System.out.println("Sorry, you are not a registered user! Please sign up first");
                    bean.setValid(false);
                } //if user exists set the isValid variable to true 
                else if (more)
                {  // in vendor table
                    bean.setAddress(rs.getString("address"));
                    bean.setCity(rs.getString("city"));
                    bean.setState(rs.getString("state"));
                    bean.setZipCode(rs.getString("zip"));
                    String DBemail = rs.getString("email");
                    bean.setEmail(DBemail);
                    System.out.println("Welcome " + DBemail);
                    bean.setName(rs.getString("name"));
                    bean.setID(rs.getInt(1));
                    System.out.println(bean.getID());
                    bean.setValid(true);
                    bean.setUserType("vendor");
                    bean.setPhone(rs.getString("phone"));
                    bean.setDescription(rs.getString("business_description"));

                } //     } else if (rs2 != null)
                //    {
                //   more2 = rs2.next();
                //    if ((!more2))
                //  {
                //   System.out.println("Sorry, you are not a registered user! Please sign up first");
                //   bean.setValid(false);
                //   } //if user exists set the isValid variable to true 
                else if (more2)
                {
                    bean.setAddress(rs2.getString("address"));
                    bean.setCity(rs2.getString("city"));
                    bean.setState(rs2.getString("state"));
                    bean.setZipCode(rs2.getString("zip"));
                    String DBemail = rs2.getString("email");
                    bean.setEmail(DBemail);
                    System.out.println("Welcome " + DBemail);
                    bean.setName(rs2.getString("name"));
                    bean.setID(rs2.getInt(1));
                    System.out.println(bean.getID());
                    bean.setValid(true);
                    bean.setUserType("customer");
                }
            }

        } catch (Exception ex)
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling 
        finally
        {
            if (rs != null || rs2 != null)
            {
                try
                {
                    rs.close();
                    rs2.close();
                } catch (Exception e)
                {
                }
                rs = null;
                rs2 = null;
            }

            if (stmt != null || stmt2 != null)
            {
                try
                {
                    stmt.close();
                    stmt2.close();
                } catch (Exception e)
                {
                }
                stmt = null;
                stmt2 = null;
            }

            if (currentCon != null)
            {
                try
                {
                    currentCon.close();
                } catch (Exception e)
                {
                }
                currentCon = null;
            }
        }
        return bean;
    }

    /*
     * This method is used to get the expiration date of a coupon @param id the
     * unique id value of a coupon @return an ArrayList with the expiration date
     * of the specified coupon
     */
    public static ArrayList<String> getDate(String id)
    {
        Statement stmt = null;
        ArrayList<String> myList = new ArrayList<String>();
        String searchQuery = "SELECT end_date FROM product WHERE id= " + id;
        try
        { //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            // if user does not exist set the isValid variable to false 
            if (!more)
            {
                System.out.println("Sorry, cannot find the coupon");
            } //if user exists set the isValid variable to true 
            else if (more)
            {

                StringTokenizer st1 = new StringTokenizer(rs.getString("end_date"), "-");
                //iterate through tokens
                while (st1.hasMoreTokens())
                {
                    myList.add(st1.nextToken());
                    System.out.println(myList.get(0));
                }

            }
        } catch (Exception ex)
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling 
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                } catch (Exception e)
                {
                }
                rs = null;
            }

            if (stmt != null)
            {
                try
                {
                    stmt.close();
                } catch (Exception e)
                {
                }
                stmt = null;
            }

            if (currentCon != null)
            {
                try
                {
                    currentCon.close();
                } catch (Exception e)
                {
                }
                currentCon = null;
            }
        }
        return myList;
    }

    /*
     * This method is used to store payment information @param bean the current
     * users bean @return an int value representing successful/unsuccessful
     * operation
     */
    public static int storeCard(UserBean bean)
    {
        int i = 0;
        try
        { //connect to DB 
            currentCon = ConnectionManager.getConnection();
            ps = (PreparedStatement) currentCon.prepareStatement("INSERT INTO " + "creditCard(card_type, card_number, security_number, exp_date, card_name) " + "VALUES(?,?,?,?,?)");
            ps.setString(1, bean.getCardType());
            ps.setString(2, bean.getCardNumber());
            ps.setString(3, bean.getSecureCode());
            ps.setString(4, bean.getExpYear() + "-" + bean.getExpMonth() + "-" + "01");
            ps.setString(5, bean.getCardName());
           // ps.setInt(6, bean.getID());

            i = ps.executeUpdate();

            ps.close();
            currentCon.close();
        } catch (Exception ex)
        {
            System.out.println("Unable to process card into database" + ex);
        } //some exception handling 
        return i;
    }

    /*
     * This method is used to update data in the database @param id the unique
     * id of the coupon whose data will be updated @return an int value
     * representing a successful/unsuccessful operation
     */
    public static int update(String sqlUpdateRecord, String id)
    {
        PreparedStatement psUpdateRecord = null;

        int i = 0;
        currentCon = ConnectionManager.getConnection();
        try
        {

            psUpdateRecord = (PreparedStatement) currentCon.prepareStatement(sqlUpdateRecord);
//              psUpdateRecord.setString(1,staffName);
//              psUpdateRecord.setInt(2,staffPhone);
//              psUpdateRecord.setInt(3,empID);
            i = psUpdateRecord.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("EERR0r");
            //response.sendRedirect("updateRecord.jsp");
            // On error it will send back to addRecord.jsp page
        }
        try
        {
            if (psUpdateRecord != null)
            {
                psUpdateRecord.close();
            }
            if (currentCon != null)
            {
                currentCon.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public static int delete(String id)
    {
        int delete = 0;
        currentCon = ConnectionManager.getConnection();
        try
        {
            Statement st = currentCon.createStatement();
            String sql = "DELETE FROM product WHERE product.id = " + id;
            delete = st.executeUpdate(sql);
            if (delete == 1)
            {
                System.out.println("Row is deleted.");
            } else
            {
                System.out.println("Row is not deleted.");
            }
        } catch (SQLException s)
        {
            System.out.println("SQL statement is not executed!");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return delete;
    }

    public static int storePurchase(UserBean bean, String ID, int confirmationNumber)
    {
        Statement stmt = null;
        int i = 0;
        String searchQuery = "SELECT price FROM product WHERE id= " + ID;
        try
        { //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            ps = (PreparedStatement) currentCon.prepareStatement("INSERT INTO " + "customer_order(amount, date_created, confirmation_number, customer_id) " + "VALUES(?,?,?,?)");
            ps.setString(1, rs.getString("price"));
            ps.setString(2, new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
            ps.setString(3, Integer.toString(confirmationNumber));
            ps.setString(4, Integer.toString(bean.getID()));

            i = ps.executeUpdate();

            ps.close();
            currentCon.close();
        } catch (Exception ex)
        {
            System.out.println("Unable to process card into database" + ex);
        } //some exception handling 
        return i;
    }

    public static int storeCoupon(String name, double originalPrice, double discountPrice, String description, int categoryID, int vendorID, String fileName, int quantity, java.sql.Date sDate, java.sql.Date eDate)
    {
        int i = 0;
        try
        {
            currentCon = ConnectionManager.getConnection();
        } catch (Exception e)
        {
            e.toString();
        }

        try
        {
            //java.sql.Date aDate = new java.sql.Date(0000-00-00);
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            //Date sDate = sdf.parse(startDate); 
            //Date eDate = sdf.parse(expDate);
            //UserBean user = (UserBean) request.getSession().getAttribute("currentSessionUser");
            //System.out.println(user.getName());
            ps = (PreparedStatement) currentCon.prepareStatement("INSERT INTO product(name, price, reg_price, description, category_id, vendor_id, image_url, quantity, start_date, end_date) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setDouble(2, originalPrice);
            ps.setDouble(3, discountPrice);
            ps.setString(4, description);
            ps.setInt(5, categoryID);
            ps.setInt(6, vendorID);
            ps.setString(7, fileName);
            ps.setInt(8, quantity);
            ps.setDate(9, sDate);
            ps.setDate(10, eDate);
            i = ps.executeUpdate();
            //ps.s

            System.out.println(i);

            ps.close();
            currentCon.close();
        } catch (Exception e)
        {
            e.toString();
        }
        return i;
    }
}
