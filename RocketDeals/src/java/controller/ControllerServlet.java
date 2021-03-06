/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.*;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.VerhoeffCheckDigit;

/**
 *
 * @author BECoS
 */
@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns =
{
    "/category", "/checkout", "/purchase", "/login", "/coupon", "/register",
    "/index", "/addCoupon", "/purchaseHistory", "/about", "/contact",
    "/recoverPassword", "/updateProfile", "/changePassword", "/help",
    "/deleteCoupon", "/viewCouponHistory",
    "/logout","/selectedCoupon", "/selectCouponToEdit", "/processEditedCoupon", 
    "/customerUpdateProfile", "/vendorUpdateProfile",
    "/customerProfile", "/vendorProfile"
})
public class ControllerServlet extends HttpServlet
{

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String url = null;
        String userPath = request.getServletPath();

        if (userPath.equals("/logout"))
        {

            HttpSession session = request.getSession(true);
            session.removeAttribute("currentSessionUser");
            session.removeAttribute("currentSessionName");
            session.removeAttribute("currentSessionEmail");
            session.removeAttribute("currentSessionType");

            // use RequestDispatcher to forward request internally
            url = "/logout.jsp";
        } // if category page is requested
        else if (userPath.equals("/category"))
        {
            if (request.getQueryString() != null)
            {
                request.getSession().setAttribute("category", request.getQueryString());
            }
            // TODO: Implement category request
        } //        else if (userPath.equals("/viewCouponHistory"))
        //        {
        //            userPath = "viewCouponHistory";
        //            int success = 0;
        //            String couponID = request.getQueryString();
        //
        //            if (couponID != null) 
        //            {
        //                if (request.getQueryString() != null)
        //                    success = UserDAO.delete(couponID); 
        //            }            
        //        }
        else if (userPath.equals("/purchaseHistory"))
        {
            userPath = "/viewPurchaseHistory";
        } //        else if(userPath.equals("/deleteCoupon"))
        //        {
        //            
        //        }
        //       else if (userPath.equals("/searchcoupon"))
        //       {
        //           java.sql.Connection con = (Connection) ConnectionManager.getConnection();
        //           try
        //           {
        //                String zip=request.getParameter("zip");
        //                java.sql.PreparedStatement ps = con.prepareStatement("SELECT * "+
        //                 "FROM product p STRAIGHT_JOIN vendor v on p.vendor_id = v.id where v.city_region = \"" + zip + "\" "
        //                        + "and v.end_date =< curdate()");
        //                
        //            
        //                
        //                
        //                ResultSet rs = ps.executeQuery();
        //                ArrayList<coupon> CouponList = new ArrayList<coupon>();
        //               
        //                
        //                while (rs.next()){
        //                  
        //                    coupon coupons = new coupon(); 
        //                    coupons.setId(rs.getLong("id"));
        //                    coupons.setName(rs.getString("name"));
        //                    coupons.setPrice(rs.getDouble("price"));
        //                    coupons.setReg_price(rs.getDouble("reg_price"));
        //                    coupons.setDescription(rs.getString("description"));
        //                    coupons.setLast_update(rs.getTimestamp("last_update"));
        //                    coupons.setVendor_id(rs.getLong("vendor_id"));
        //                    coupons.setImage(rs.getBytes("image"));
        //                    coupons.setQuantity(rs.getLong("quantity"));
        //                    coupons.setStart_date(rs.getDate("start_date"));
        //                    coupons.setEnd_date(rs.getDate("end_date"));
        //                    coupons.setCategory_name(rs.getString("category_name"));
        //                    
        //                    CouponList.add(coupons);                                     
        //                }  
        //                ps.close();
        //                con.close();
        //            }
        //            catch(Exception e)
        //            {
        //                System.out.println("Fail!");
        //                e.toString();  
        //                e.printStackTrace();  
        //            }
        //        
        //           userPath = "/showcoupon";
        //       }
        //        else if (userPath.equals("/viewCart")) 
        //        {
        //            // TODO: Implement cart page request
        //
        //            userPath = "/cart";
        //
        //        // if checkout page is requested
        //        }
        else if (userPath.equals("/checkout"))
        {
            // TODO: Implement checkout page request
            // if user switches language
        } else if (userPath.equals("/coupon"))
        {
            String couponID = request.getQueryString();
            if (couponID != null)
            {
                request.getSession().setAttribute("ID", couponID);
//               UserBean user = (UserBean) request.getSession().getAttribute("currentSessionUser");
                ArrayList<String> dates = UserDAO.getDate(couponID);
                request.getSession().setAttribute("expYear", Integer.parseInt(dates.get(0)));
                request.getSession().setAttribute("expMonth", ((Integer.parseInt(dates.get(1))) - 1));
                request.getSession().setAttribute("expDay", Integer.parseInt(dates.get(2)));
                System.out.println("Year: " + request.getSession().getAttribute("expYear"));
                System.out.println(request.getSession().getAttribute("expMonth"));
                System.out.println(request.getSession().getAttribute("expDay"));
                System.out.println(new Date().toString());
            }
        }
//        else if (userPath.equals("/chooseLanguage"))
//        {
//            // TODO: Implement language request
//
//        }

        // use RequestDispatcher to forward request internally
        if (url == null)
        {
            url = "/WEB-INF/view" + userPath + ".jsp";
        }

        try
        {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String url;
        String userPath = request.getServletPath();

        // if addToCart action is called
       /*
         * if (userPath.equals("/addToCart")) { // TODO: Implement add product
         * to cart action
         *
         * // if updateCart action is called }
         */

        if (userPath.equals("/changePassword"))
        {
            HttpSession session = request.getSession(true);
            UserBean user = (UserBean) session.getAttribute("currentSessionUser");

            DesEncrypter encrypt = new DesEncrypter();
            String oldpass = request.getParameter("oldpassword");
            String newpass = request.getParameter("password");
            String cpass = request.getParameter("cpass");

            if (cpass.equals(newpass) && validatePassword(newpass) && validatePassword(oldpass))
            {
                user.setPassword(encrypt.encrypt(oldpass));
                user = UserDAO.login(user);
                if (user.isValid())
                {
                    Connection con = (Connection) ConnectionManager.getConnection();
                    try
                    {
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                                "UPDATE "
                                + user.getUserType().toLowerCase() //customer or vendor
                                + " SET password=\"" + encrypt.encrypt(newpass) + "\""
                                + " WHERE id = \"" + user.getID() + "\"");

                        int i = ps.executeUpdate();

                        //email notice
                        String from = "brandonthai2003@yahoo.com";
                        String subject = "Password Changed";
                        String body = "Dear " + user.getName() + ",\n\n"
                                + "your passwrod is changed.\n"
                                + "Have a great day.\n\n"
                                + "Brandon Thai\n"
                                + "RocketDeals Support Team";
                        boolean isBodyHTML = false;

                        try
                        {
                            MailUtilYahoo.sendMail(user.getEmail(), from, subject, body, isBodyHTML);


                        } catch (MessagingException ex)
                        {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        userPath = "/" + user.getUserType().toLowerCase() + "Profile";
                        System.out.println(userPath);
                    } catch (SQLException ex)
                    {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else
                {
                    userPath = "/changePasswordFail";
                }
            } else
            {
                userPath = "/changePasswordFail";
            }

        } else if (userPath.equals("/recoverPassword"))
        {
            String email = request.getParameter("email");
            String cemail = request.getParameter("cemail");
            String zip = request.getParameter("zip");
            boolean emailExist = false;
            if (email.equals(cemail) && isDigit(zip))
            {
                Connection con = (Connection) ConnectionManager.getConnection();

                try
                {
                    PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(
                            "SELECT * FROM customer WHERE email = \"" + email
                            + "\"AND zip =\"" + zip + "\"");
                    PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(
                            "SELECT * FROM vendor WHERE email = \"" + email
                            + "\" AND zip = \"" + zip + "\"");

                    ResultSet rs = ps1.executeQuery();

                    if (!rs.last())
                    {
                        rs = ps2.executeQuery();
                    }

                    emailExist = rs.last();
                    if (emailExist)
                    {
                        String password = rs.getString("password");
                        DesEncrypter encryt = new DesEncrypter();

                        HttpSession session = request.getSession(true);
                        session.setAttribute("decryptedPassword", encryt.decrypt(password));// encryt.decrypt(password) );                   
                    }
                    ps1.close();
                    ps2.close();
                    con.close();
                } catch (Exception e)
                {
                    e.toString();
                }
            }
            userPath = "/showPassword";

        } else if (userPath.equals("/category"))
        {
            String zipCode = request.getParameter("zipCode");
            if (zipCode != null)
            {
                request.getSession().setAttribute("zipCode", zipCode);
                request.getSession().setAttribute("category", 0);
            }

        } else if (userPath.equals("/register"))
        {
            String email = request.getParameter("email");
            boolean emailExist = false;
            UserBean user = new UserBean();
            user.setEmail(request.getParameter("email"));
            Connection con = (Connection) ConnectionManager.getConnection();

            try
            {
                PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(
                        "SELECT * FROM customer WHERE email = \"" + email + "\"");
                PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(
                        "SELECT * FROM vendor WHERE email = \"" + email + "\"");

                ResultSet rs1 = ps1.executeQuery();
                ResultSet rs2 = ps2.executeQuery();
                emailExist = rs1.last() || rs2.last();
                ps1.close();
                ps2.close();
                //con.close();

            } catch (Exception e)
            {
                e.toString();
                userPath = "/registrationFail";
            }

            if (!emailExist)
            {

                String accounttype = request.getParameter("AccountType");
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                String password = request.getParameter("password");
                String cpass = request.getParameter("cpass");

                if (password.equals(cpass) && validatePassword(password) && zip.length() == 5 && state.length() == 2 && isLetter(name) && isLetter(city) && isLetter(state) && isDigit(zip))
                {

                    DesEncrypter encrypter = new DesEncrypter();

                    String passw = encrypter.encrypt(password);
                    user.setPassword(passw);
                    if (accounttype.equalsIgnoreCase("Customer"))
                    {
                        try
                        {
                            PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                                    "INSERT INTO "
                                    + "customer(name, email, address, city, state, zip, password) "
                                    + "VALUES(?,?,?,?,?,?,?)");
                            ps.setString(1, name);
                            ps.setString(2, email);
                            ps.setString(3, address);
                            ps.setString(4, city);
                            ps.setString(5, state);
                            ps.setString(6, zip);
                            ps.setString(7, passw);
                            int i = ps.executeUpdate();

                            user = UserDAO.login(user);
                            user.setUserType(accounttype);

                            HttpSession session = request.getSession(true);
                            session.setAttribute("currentSessionUser", user); //name
                            session.setAttribute("currentSessionName", name);
                            session.setAttribute("currentSessionEmail", email);
                            session.setAttribute("currentSessionType", accounttype);

                            userPath = "/../../index";

                            ps.close();
                            con.close();
                        } catch (Exception e)
                        {
                            e.toString();
                            userPath = "/registrationFail";
                        }
                    } else if (accounttype.equalsIgnoreCase("Vendor"))
                    {

                        //String phone = new String("000-000-0000");

                        try
                        {
                            PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                                    "INSERT INTO "
                                    + "vendor(name, email, address, city, state, zip, password) "
                                    + "VALUES(?,?,?,?,?,?,?)");
                            // + ", phone) VALUES(?,?,?,?,?,?)");
                            ps.setString(1, name);
                            ps.setString(2, email);
                            ps.setString(3, address);
                            ps.setString(4, city);
                            ps.setString(5, state);
                            ps.setString(6, zip);
                            ps.setString(7, passw);
                            //ps.setString(6, phone);
                            int i = ps.executeUpdate();

                            user = UserDAO.login(user);
                            user.setUserType(accounttype);

                            HttpSession session = request.getSession(true);
                            session.setAttribute("currentSessionUser", user); //name
                            session.setAttribute("currentSessionName", name);
                            session.setAttribute("currentSessionEmail", email);
                            session.setAttribute("currentSessionType", accounttype);

                            userPath = "/../../index";

                            ps.close();
                            con.close();

                        } catch (Exception e)
                        {
                            e.toString();
                            userPath = "/registrationFail";
                        }
                    } else
                    {
                        //other kind of user, but not in this project
                    }
                } else
                {
                    userPath = "/registrationFail";
                }
            } else
            { // Email alread exist in the data base
                userPath = "/registrationFail";
            }
        } /*
         * else if (userPath.equals("/updateCart")) { // TODO: Implement update
         * cart action
         *
         * // if purchase action is called }
         */ //        else if (userPath.equals("/index"))
        //        {
        //            try 
        //            { 
        //                UserBean user = new UserBean();
        //                user.setEmail(request.getParameter("emailLogin"));
        //                
        //                byte[] unencodedPassword = request.getParameter("passwordLogin").getBytes();
        //                MessageDigest md = null;
        //                try 
        //                {
        //                    md = MessageDigest.getInstance("MD5");
        //                } 
        //                catch (Exception e) 
        //                {
        //                    //Good practise for error handling by printing the Exception
        //                    e.toString();
        //                }
        //
        //                //encoding the password
        //                md.reset();
        //                md.update(unencodedPassword);
        //                byte[] encodedPassword = md.digest();
        //                StringBuilder buf = new StringBuilder();
        //
        //                for (int i = 0; i < encodedPassword.length; i++) 
        //                {
        //                    if (((int) encodedPassword[i] & 0xff) < 0x10) 
        //                    {
        //                        buf.append("0");
        //                    }   
        //                    buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
        //                }
        //                String passw=buf.toString();                
        //                
        //                user.setPassword(passw); 
        //                user = UserDAO.login(user); 
        //                if (user.isValid()) 
        //                {
        //                    HttpSession session = request.getSession(true); 
        //                    session.setAttribute("currentSessionUser",user);
        //                    //response.sendRedirect("userLogged.jsp"); //logged-in page 
        //                    userPath = "index";
        //                }      
        //                else 
        //                    //response.sendRedirect("invalidLogin.jsp"); //error page 
        //                    userPath ="/category";
        //                }
        //                catch (Throwable theException) 
        //                { 
        //                    System.out.println(theException);
        //                }
        //        }
        else if (userPath.equals("/login"))
        {
            System.out.println("at login");
            try
            {
                UserBean user = new UserBean();
                user.setEmail(request.getParameter("emailLogin"));

                DesEncrypter encrypter = new DesEncrypter();

                String passw = encrypter.encrypt(request.getParameter("passwordLogin"));

                user.setPassword(passw);
                user = UserDAO.login(user);
                if (user.isValid())
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser", user);//user.getName()
                    session.setAttribute("currentSessionEmail", user.getEmail());
                    session.setAttribute("currentSessionType", user.getUserType());
                    session.setAttribute("currentSessionName", user.getName());

                    userPath = "/../../index";
                } else
                {
                    //response.sendRedirect("invalidLogin.jsp"); //error page 
                    userPath = "/loginFail";
                }
            } catch (Throwable theException)
            {
                System.out.println(theException);
                userPath = "/loginFail";
            }
        } else if (userPath.equals("/addCoupon"))
        {
            String categoryID = null;
            String couponName = null;
            String quantity = null;
            String originalPrice = null;
            String discountPrice = null;
            String startDate = null;
            String expDate = null;
            String couponDescription = null;
            String fileName = null;

//            DiskFileUpload fu = new DiskFileUpload();  
//            // maximum size before a FileUploadException will be thrown  
//            fu.setSizeMax(10000000);  
//            // maximum size that will be stored in memory  
//            fu.setSizeThreshold(4096);  
//            // the location for saving data that is larger than getSizeThreshold()  
//            fu.setRepositoryPath("web/img/coupons/temp");  

            List fileItemsList = null;
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try
            {
                fileItemsList = servletFileUpload.parseRequest(request);
            } catch (FileUploadException ex)
            {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

//            List fileItems = null;  
//            try 
//            {
//                fileItems = fu.parseRequest(request);
//            } 
//            catch (FileUploadException ex) 
//            {
//                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
            Iterator it = fileItemsList.iterator();
            while (it.hasNext())
            {
                FileItem item = (FileItem) it.next();
                if (item.isFormField())
                {
                    //Plain request parameters will come here.  
                    String name = item.getFieldName();
                    String value = item.getString();

                    if (name.equalsIgnoreCase("categorytype"))
                    {
//                        if(value.equals("Automotive & Home"))
//                            categoryID = "1";
//                        else if(value.equals("Health & Fitness"))
//                            categoryID = "2";
//                        else if(value.equals("Food"))
//                            categoryID = "3";   
//                        else if(value.equals("Shopping"))
//                            categoryID = "4";
//                        else if(value.equals("Entertainment"))
//                            categoryID = "5";     
//                        else if(value.equals("Beauty & Spay"))
//                            categoryID = "6";  
//                        else if(value.equals("Electronics"))
//                            categoryID = "7"; 
//                        else if(value.equals("Toys"))
//                            categoryID = "8";
//                        else if(value.equals("Music"))
//                            categoryID = "9";
//                        else 
                        categoryID = value;
                    } else if (name.equalsIgnoreCase("couponname"))
                    {
                        couponName = value;
                        System.out.println("couponName");
                    } else if (name.equalsIgnoreCase("quantity"))
                    {
                        System.out.println("quantity");
                        quantity = value;
                        if (!isDigit(quantity))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }

                    } else if (name.equalsIgnoreCase("oriprice"))
                    {
                        System.out.println("1");
                        originalPrice = value;
                        if (!isDigit(originalPrice))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }
                    } else if (name.equalsIgnoreCase("disprice"))
                    {
                        System.out.println("1");
                        discountPrice = value;
                        if (!isDigit(discountPrice))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }
                    } else if (name.equalsIgnoreCase("startyear"))
                    {
                        //System.out.println("1");
                        startDate = value;
                        if (!isDigit(startDate))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }
                    } else if (name.equalsIgnoreCase("startmonth"))
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            startDate = startDate + "-" + value;
                        }
                    } else if (name.equalsIgnoreCase("startday"))
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            startDate = startDate + "-" + value;
                        }
                    } else if (name.equalsIgnoreCase("expyear"))
                    {
                        expDate = value;
                        if (!isDigit(expDate))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }
                    } else if (name.equalsIgnoreCase("expmonth"))
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            expDate = expDate + "-" + value;
                        }
                    } else if (name.equalsIgnoreCase("expday"))
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            expDate = expDate + "-" + value;
                            System.out.println(expDate);
                        }
                    } else if (name.equalsIgnoreCase("coupondescription"))
                    {
                        couponDescription = value;
                    }

                } else
                {
                    //upload file comes here
                    String contentType = request.getContentType();
                    System.out.println("content=" + contentType);
                    if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
                    {
                        fileName = item.getName();
//                        DataInputStream in = new DataInputStream(request.getInputStream());
//                        int formDataLength = request.getContentLength();
//                        byte dataBytes[] = new byte[formDataLength];
//                        int byteRead = 0;
//                        int totalBytesRead = 0;
//                        while(totalBytesRead < formDataLength)
//                        {
//                            byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
//                            totalBytesRead += byteRead;
//                        }
//                        
//                        System.out.println(fileName);
//                        String file = new String(dataBytes);
//                        saveFile = file.substring(file.indexOf("filename=\"") + 10);
//                        saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
//                        saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
//                        int lastIndex = contentType.lastIndexOf("=");
//                        String boundary = contentType.substring(lastIndex + 1,contentType.length());
//                        int pos;
//                        pos = file.indexOf("filename=\"");
//                        pos = file.indexOf("\n", pos) + 1;
//                        pos = file.indexOf("\n", pos) + 1;
//                        pos = file.indexOf("\n", pos) + 1;
//                        int boundaryLocation = file.indexOf(boundary, pos) - 4;
//                        int startPos = ((file.substring(0, pos)).getBytes()).length;
//                        int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
//                        File ff = new File("img/coupons/"+saveFile);
//                        FileOutputStream fileOut = new FileOutputStream(ff);
//                        fileOut.write(dataBytes, startPos, (endPos - startPos));
//                        fileOut.flush();
//                        fileOut.close();   
                        System.out.println("filename=:" + fileName);
                        File saveTo = new File("/home/ty/Desktop/Dropbox/RocketDeals/web/img/coupons/" + fileName);
                        try
                        {
                            item.write(saveTo);
                        } catch (Exception ex)
                        {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
//            Connection con=null;
//        
//            try
//            {
//                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//                con = (Connection) DriverManager.getConnection("jdbc:mysql:///rocketdeals","root","admin");
//            }
//            catch(Exception e)
//            {
//                e.toString();
//            }

            //try
            //{
            UserBean user = (UserBean) request.getSession().getAttribute("currentSessionUser");
            //call userDAO to store the coupon in DB
            int ok = UserDAO.storeCoupon(couponName, Double.parseDouble(originalPrice), Double.parseDouble(discountPrice), couponDescription, Integer.parseInt(categoryID), user.getID(), fileName, Integer.parseInt(quantity), java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(expDate));
            if (ok > 0)
            {
                //success
                userPath = "/viewCouponHistory";
            } else
            {
                //fail 
                userPath = "/addCouponFail";
            }
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            //Date sDate = sdf.parse(startDate); 
            //Date eDate = sdf.parse(expDate);
            // UserBean user = (UserBean) request.getSession().getAttribute("currentSessionUser");
//                System.out.println(user.getName());
//                PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO product(name, price, reg_price, description, category_id, vendor_id, image_url, quantity, start_date, end_date) VALUES(?,?,?,?,?,?,?,?,?,?)");
//                ps.setString(1,couponName);
//                ps.setDouble(2,Double.parseDouble(originalPrice));
//                ps.setDouble(3,Double.parseDouble(discountPrice));
//                ps.setString(4,couponDescription);
//                ps.setInt(5,Integer.parseInt(categoryID));
//                ps.setInt(6, user.getID());
//                ps.setString(7, fileName);
//                ps.setInt(8, Integer.parseInt(quantity));
//                ps.setDate(9, java.sql.Date.valueOf(startDate));
//                ps.setDate(10, java.sql.Date.valueOf(expDate));
//                int i = ps.executeUpdate();
            //ps.s

//                System.out.println(i);
//
//                ps.close();
//                con.close();
            //            }
//            catch(Exception e)
//            {
//                e.toString();    
//            }      
        } else if (userPath.equals("/purchase"))
        {
            String sqlUpdateRecord = null;
            // create confirmation number if it does not already exist

                Random random = new Random();
                int i = random.nextInt(999999999);
                request.getSession().setAttribute("confirmationNumber", i);

            userPath = "/confirmation";

            UserBean user = (UserBean) request.getSession().getAttribute("currentSessionUser");
            String cardType = request.getParameter("cardtype");
            String cardNumber = request.getParameter("cardNumber");
            String secureCode = request.getParameter("secureCode");
            String nameCard = request.getParameter("nameCard");
            String cardExpMonth = request.getParameter("cardExpMonth");
            String cardExpYear = request.getParameter("cardExpYear");

            request.getSession().setAttribute("paymentMethod", cardType);
        //    request.getSession().setAttribute("lastTwoNumber", cardNumber.substring(cardNumber.length() - 2));
        //    request.getSession().setAttribute("expMonth", cardExpMonth);
         //   request.getSession().setAttribute("expTwoYear", cardExpYear.substring(cardExpYear.length() - 2));

            System.out.println("This is my name: " + nameCard);
            String checkDigit = null;

            //Check for a valid credit number using the VerhoerrCheckDigit class
//            VerhoeffCheckDigit creditChecker = new VerhoeffCheckDigit();
//            try
//            {
//                checkDigit = creditChecker.calculate(cardNumber);
//            } catch (CheckDigitException ex)
//            {
//                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }

            //assume the credit card is valid
            boolean valid = true; //creditChecker.isValid(checkDigit);

            if (!valid)
            {
                System.out.println("The credit card is not valid");
                userPath = "/checkoutFail";
            } else
            {
                //credit card is valid
                user.setCardName(nameCard);
                user.setCardNumber(cardNumber);
                user.setCardType(cardType);
                user.setExpYear(cardExpYear);
                user.setExpMonth(cardExpMonth);
                user.setSecureCode(secureCode);
                //System.out.print(request.getSession().getAttribute("ID"));
                //store credit info in database  //skipped
                int returnValue = 1;//UserDAO.storeCard(user);
                if (returnValue > 0)
                {
               //     sqlUpdateRecord = "UPDATE product SET quantity = (quantity - 1), amount_bought = (amount_bought + 1) WHERE id=" + request.getAttribute("ID").toString();
                    //update the database of the coupon purchased
                    int success = 1; ///skipped update datbase -->UserDAO.update(sqlUpdateRecord, request.getParameter("ID").toString());
                    if (success > 0)
                    {
                        //save the order in the database
                        //Skipped -->UserDAO.storePurchase(user, request.getSession().getAttribute("ID").toString(), (Integer) request.getAttribute("confirmationNumber"));
                        userPath="/confirmation";
                    }
                } else
                {
                    //card not stored in database
                    userPath = "/checkoutFail";
                }

            }

        } else if (userPath.equals("/customerUpdateProfile"))
        {
            String sqlUpdateRecord = "UPDATE customer SET ";
            String password = request.getParameter("password");
            String cpass = request.getParameter("cpass");

            if (!password.equals(cpass) && validatePassword(password))
            {
                userPath = "/updateProfileFail";
            } else
            {
                UserBean user = (UserBean) (request.getSession().getAttribute("currentSessionUser"));
                user.setPassword(new DesEncrypter().encrypt(password));
                user = UserDAO.login(user);
                System.out.println("HYE" + user.getZipCode());

                if (user.isValid() && user.getUserType().equalsIgnoreCase("customer"))
                {
                    if (request.getParameter("address") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + "address=\"" + request.getParameter("address") + "\",";
                    }
                    if (request.getParameter("state") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " state=\"" + request.getParameter("state") + "\",";
                    }
                    if (request.getParameter("zip") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " zip=\"" + request.getParameter("zip") + "\",";
                    }
                    if (request.getParameter("city") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " city=\"" + request.getParameter("city") + "\"";
                    }
                    sqlUpdateRecord = sqlUpdateRecord + " WHERE customer.id = " + Integer.toString(user.getID());

                    System.out.println(sqlUpdateRecord);
                    Connection con = (Connection) ConnectionManager.getConnection();
                    try
                    {
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlUpdateRecord);

                        int i = ps.executeUpdate();
                        //sent email 
                        String from = "brandonthai2003@yahoo.com";
                        String subject = "Information Changed";
                        String body = "Dear " + user.getName() + ",\n\n"
                                + "your information is changed.\n"
                                + "Have a great day.\n\n"
                                + "Brandon Thai\n"
                                + "RocketDeals Support Team";
                        boolean isBodyHTML = false;

                        try
                        {
                            MailUtilYahoo.sendMail(user.getEmail(), from, subject, body, isBodyHTML);
                        } catch (MessagingException ex)
                        {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        user = UserDAO.login(user); // login again to refresh
                    } catch (SQLException ex)
                    {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else
                {
                    userPath = "/updateProfileFail";
                }
            }
        } else if (userPath.equals("/vendorUpdateProfile"))
        {
            String sqlUpdateRecord = "UPDATE vendor SET ";
            String password = request.getParameter("password");
            String cpass = request.getParameter("cpass");

            if (!password.equals(cpass) && validatePassword(password))
            {
                userPath = "/updateProfileFail";
            } else
            {
                UserBean user = (UserBean) (request.getSession().getAttribute("currentSessionUser"));
                user.setPassword(new DesEncrypter().encrypt(password));
                user = UserDAO.login(user);
                System.out.println("HYE" + user.getZipCode());

                if (user.isValid() && user.getUserType().equalsIgnoreCase("vendor"))
                {
                    if (request.getParameter("address") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + "address=\"" + request.getParameter("address") + "\",";
                    }
                    if (request.getParameter("state") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " state=\"" + request.getParameter("state") + "\",";
                    }
                    if (request.getParameter("zip") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " zip=\"" + request.getParameter("zip") + "\",";
                    }
                    if (request.getParameter("city") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " city=\"" + request.getParameter("city") + "\",";
                    }
                    if (request.getParameter("phone") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " phone=\"" + request.getParameter("phone") + "\",";
                    }
                    if (request.getParameter("description") != null)
                    {
                        sqlUpdateRecord = sqlUpdateRecord + " business_description=\"" + request.getParameter("description") + "\"";
                    }
                    sqlUpdateRecord = sqlUpdateRecord + " WHERE vendor.id = " + Integer.toString(user.getID());

                    System.out.println(sqlUpdateRecord);
                    Connection con = (Connection) ConnectionManager.getConnection();
                    try
                    {
                        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sqlUpdateRecord);

                        int i = ps.executeUpdate();
                        //sent email 
                        String from = "brandonthai2003@yahoo.com";
                        String subject = "Information Changed";
                        String body = "Dear " + user.getName() + ",\n\n"
                                + "your information is changed.\n"
                                + "Have a great day.\n\n"
                                + "Brandon Thai\n"
                                + "RocketDeals Support Team";
                        boolean isBodyHTML = false;

                        try
                        {
                            MailUtilYahoo.sendMail(user.getEmail(), from, subject, body, isBodyHTML);
                        } catch (MessagingException ex)
                        {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        user = UserDAO.login(user); // login again to refresh
                    } catch (SQLException ex)
                    {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else
                {
                    userPath = "/updateProfileFail";
                }
            }
        } else if (userPath.equals("/deleteCoupon"))
        {
            //System.out.println("in here");
            String toDelete = request.getParameter("delete");
            StringTokenizer st1 = new StringTokenizer(toDelete, " ");
            //iterate through tokens
            while (st1.hasMoreTokens())
            {
                UserDAO.delete(st1.nextToken());
            }
            userPath = "/viewCouponHistory";
        } else if (userPath.equals("/selectedCoupon"))
        {
            System.out.println("in here");
            String toEdit = request.getParameter("select");
            request.getSession().setAttribute("editID", toEdit);
            userPath = "/editCoupon";
        } else if (userPath.equals("/processEditedCoupon"))
        {
            String categoryID = null;
            String couponName = null;
            String quantity = null;
            String originalPrice = null;
            String discountPrice = null;
            String startDate = null;
            String expDate = null;
            String couponDescription = null;
            String fileName = null;
            String sqlUpdateRecord = "UPDATE product SET ";


            List fileItemsList = null;
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try
            {
                fileItemsList = servletFileUpload.parseRequest(request);
            } catch (FileUploadException ex)
            {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            Iterator it = fileItemsList.iterator();
            while (it.hasNext())
            {
                FileItem item = (FileItem) it.next();
                if (item.isFormField())
                {
                    //Plain request parameters will come here.  
                    String name = item.getFieldName();
                    String value = item.getString();

                    if (name.equalsIgnoreCase("categorytype"))
                    {
                        categoryID = value;
                        sqlUpdateRecord = sqlUpdateRecord + "category_id='" + categoryID + "', ";
                    } else if (name.equalsIgnoreCase("couponname") && value != null)
                    {
                        couponName = value;
                        sqlUpdateRecord = sqlUpdateRecord + "name='" + couponName + "', ";
                    } else if (name.equalsIgnoreCase("quantity") && value != null)
                    {
                        quantity = value;
                        if (!isDigit(quantity))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            sqlUpdateRecord = sqlUpdateRecord + "quantity='" + quantity + "', ";
                        }
                    } else if (name.equalsIgnoreCase("oriprice") && value != null)
                    {
                        originalPrice = value;
                        if (!isDigit(originalPrice))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            sqlUpdateRecord = sqlUpdateRecord + "reg_price='" + originalPrice + "', ";
                        }
                    } else if (name.equalsIgnoreCase("disprice") && value != null)
                    {
                        discountPrice = value;
                        if (!isDigit(discountPrice))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            sqlUpdateRecord = sqlUpdateRecord + "price='" + discountPrice + "', ";
                        }
                    } else if (name.equalsIgnoreCase("startyear") && value != null)
                    {
                        startDate = value;
                        if (!isDigit(startDate))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }
                    } else if (name.equalsIgnoreCase("startmonth") && value != null)
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            startDate = startDate + "-" + value;
                        }
                    } else if (name.equalsIgnoreCase("startday") && value != null)
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            startDate = startDate + "-" + value;
                            sqlUpdateRecord = sqlUpdateRecord + "start_date='" + startDate + "', ";
                        }
                    } else if (name.equalsIgnoreCase("expyear") && value != null)
                    {
                        expDate = value;
                        if (!isDigit(expDate))
                        {
                            userPath = "/addCouponFail";
                            break;
                        }
                    } else if (name.equalsIgnoreCase("expmonth") && value != null)
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            expDate = expDate + "-" + value;
                        }
                    } else if (name.equalsIgnoreCase("expday") && value != null)
                    {
                        if (!isDigit(value))
                        {
                            userPath = "/addCouponFail";
                            break;
                        } else
                        {
                            expDate = expDate + "-" + value;
                            sqlUpdateRecord = sqlUpdateRecord + "end_date='" + expDate + "', ";
                        }
                    } else if (name.equalsIgnoreCase("coupondescription") && value != null)
                    {
                        couponDescription = value;
                        sqlUpdateRecord = sqlUpdateRecord + "description='" + couponDescription + "', ";
                    }

                } else
                {
                    //upload file comes here
                    String contentType = request.getContentType();
                    if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
                    {
                        fileName = item.getName();

                        File saveTo = new File("/home/ty/Desktop/Dropbox/RocketDeals/web/img/coupons/" + fileName);
                        try
                        {
                            item.write(saveTo);
                        } catch (Exception ex)
                        {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        sqlUpdateRecord = sqlUpdateRecord + "image_url='" + fileName + "'";
                        //sqlUpdateRecord = sqlUpdateRecord + " WHERE product.id ='" + request.getSession().getAttribute("editID").toString() +"'";
                    }
                    while (sqlUpdateRecord.charAt(sqlUpdateRecord.length() - 1) == ',' || Character.isWhitespace(sqlUpdateRecord.charAt(sqlUpdateRecord.length() - 1)))
                    {
                        sqlUpdateRecord = sqlUpdateRecord.substring(0, sqlUpdateRecord.length() - 1);
                    }
                    sqlUpdateRecord = sqlUpdateRecord + " WHERE product.id ='" + request.getSession().getAttribute("editID").toString() + "'";
                    System.out.println(sqlUpdateRecord);

                }
            }
            UserDAO.update(sqlUpdateRecord, request.getSession().getAttribute("editID").toString());
            userPath = "/vendorProfile";
        }



        // use RequestDispatcher to forward request internally
        if (userPath.equalsIgnoreCase("index"))
        {
            url = "index.jsp";
        } else
        {
            url = "/WEB-INF/view" + userPath + ".jsp";
        }

        try
        {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /*
     * This method is used to verify a password @param password the password to
     * verify @return true if the password is valid, false otherwise
     */
    public boolean validatePassword(String password)
    {
        int i = 0;
        int digits = 0;
        boolean valid = true;

        if (password.length() < 6)
        {
            valid = false;
        } else
        {
            while (i < password.length())
            {
                if (Character.isSpaceChar(password.charAt(i)))
                {
                    valid = false;
                    break;
                } else if (Character.isLetterOrDigit(password.charAt(i)))
                {
                    if (Character.isDigit(password.charAt(i)))
                    {
                        digits++;
                    }
                } else
                {
                    valid = false;
                    break;
                }
                i++;
            }
            if (digits < 2)
            {
                valid = false;
            }
        }

        return valid;
    }

    /*
     * This method is used to verify that a string is composed of only digits
     * @param aString the string to check @return true if the string is only
     * digits, false otherwise
     */
    public boolean isDigit(String aString)
    {
        int i = 0;
        boolean valid = true;
        while (i < aString.length())
        {
            if (aString.charAt(i) == '.')
            {
            } else if (!Character.isDigit(aString.charAt(i)))
            {
                valid = false;
                break;
            }
            i++;
        }
        return valid;
    }

    /*
     * This method is used to verify that a string is composed of only letters
     * @param aString the string to check @return true if the string is only
     * letters, false otherwise
     */
    public boolean isLetter(String aString)
    {
        int i = 0;
        boolean valid = true;
        while (i < aString.length())
        {
            if (Character.isWhitespace(aString.charAt(i)))
            {
            } else if (!Character.isLetter(aString.charAt(i)))
            {
                valid = false;
                break;
            }
            i++;
        }
        return valid;
    }
}

/*
 * This works for uploading to folder
 *
 *
 *
 * File file ; int maxFileSize = 5000 * 1024; int maxMemSize = 5000 * 1024;
 * ServletContext context = request.getServletContext(); String filePath =
 * context.getInitParameter("uploadImagePath"); }
 *
 * // Verify the content type String contentType = request.getContentType(); if
 * ((contentType.indexOf("multipart/form-data") >= 0)) {
 *
 * DiskFileItemFactory factory = new DiskFileItemFactory(); // maximum size that
 * will be stored in memory factory.setSizeThreshold(maxMemSize); // Location to
 * save data that is larger than maxMemSize. factory.setRepository(new
 * File("C:\\Users\\BECoS\\cmpe133\\RocketDeals\\web\\img\\temp\\"));
 *
 * // Create a new file upload handler ServletFileUpload upload = new
 * ServletFileUpload(factory); // maximum file size to be uploaded.
 * upload.setSizeMax( maxFileSize ); try{ // Parse the request to get file
 * items. List fileItems = upload.parseRequest(request);
 *
 * // Process the uploaded file items Iterator i = fileItems.iterator();
 *
 * System.out.println("<html>"); System.out.println("<head>");
 * System.out.println("<title>JSP File upload</title>");
 * System.out.println("</head>"); System.out.println("<body>"); while (
 * i.hasNext () ) { FileItem fi = (FileItem)i.next(); if ( !fi.isFormField () )
 * { // Get the uploaded file parameters String fieldName = fi.getFieldName();
 * String fileName = fi.getName(); boolean isInMemory = fi.isInMemory(); long
 * sizeInBytes = fi.getSize(); // Write the file if( fileName.lastIndexOf("\\")
 * >= 0 ){ file = new File( filePath + fileName.substring(
 * fileName.lastIndexOf("\\"))) ; }else{ file = new File( filePath +
 * fileName.substring(fileName.lastIndexOf("\\")+1)) ; } fi.write( file ) ;
 * System.out.println("Uploaded Filename: " + filePath + fileName + "<br>"); } }
 * System.out.println("</body>"); System.out.println("</html>");
 * }catch(Exception ex) { System.out.println(ex); } }else{
 * System.out.println("<html>"); System.out.println("<head>");
 * System.out.println("<title>Servlet upload</title>");
 * System.out.println("</head>"); System.out.println("<body>");
 * System.out.println("<p>No file uploaded</p>"); System.out.println("</body>");
 * System.out.println("</html>"); }
 *
 *
 * }
 */
