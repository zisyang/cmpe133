/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author BECoS
 */
public class UserBean 
{
    private String usertype;
    private String email; 
    private String password; 
    private String name; 
    private int ID;
    public boolean valid;
    private String cardType;
    private String cardNumber;
    private String cardName;
    private String secureCode;
    private String expYear;
    private String expMonth;
    private String city;
    private String address;
    private String zip;
    private String state;
    private String description;
    private String phone;
    
    /*This method is used to return the variable 'name'
     *@return the value of 'name'
     */
    public String getName() 
    { 
        return name; 
    }
    
    /*This method is used to set the value of the variable 'name'
     *@param newName the value which the variable will be set to 
     */
    public void setName(String newName) 
    { 
        name = newName; 
    } 

    /*This method is used to return the variable 'password'
     *@return the value of 'password'
     */    
    public String getPassword() 
    {
        return password; 
    } 

    /*This method is used to set the value of the variable 'password'
     *@param newPassword the value which the variable will be set to 
     */    
    public void setPassword(String newPassword) 
    { 
        password = newPassword; 
    }

    /*This method is used to return the variable 'email'
     *@return the value of 'email'
     */     
    public String getEmail() 
    { 
        return email; 
    }

    /*This method is used to set the value of the variable 'email'
     *@param newEmail the value which the variable will be set to 
     */     
    public void setEmail(String newEmail)
    {
        email = newEmail;
    }

    /*This method is used to set the value of the variable 'ID'
     *@param newID the value which the variable will be set to 
     */     
    public void setID(int newID)
    {
        ID = newID;
    }

    /*This method is used to return the variable 'ID'
     *@return the value of 'ID'
     */     
    public int getID()
    {
        return ID;
    }
 
    /*This method is used to return the variable 'valid'
     *@return the value of 'valid'
     */     
    public boolean isValid() 
    {
        return valid; 
    }

    /*This method is used to set the value of the variable 'valid'
     *@param newValid the value which the variable will be set to 
     */     
    public void setValid(boolean newValid) 
    {
        valid = newValid; 
    }

    /*This method is used to set the value of the variable 'usertype'
     *@param newType the value which the variable will be set to 
     */     
    public void setUserType(String newType) 
    {
        usertype = newType;
    }
 
    /*This method is used to return the variable 'usertype'
     *@return the value of 'usertype'
     */     
    public String getUserType()
    {
        return usertype;
    }
   
    /*This method is used to return the variable 'cardNumber'
     *@return the value of 'cardNumber'
     */     
    public String getCardNumber()
    {
        return cardNumber;
    }

    /*This method is used to set the value of the variable 'cardNumber'
     *@param cardNumber the value which the variable will be set to 
     */     
    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }
 
    /*This method is used to return the variable 'cardName'
     *@return the value of 'cardName'
     */     
    public String getCardName()
    {
        return cardName;
    }

    /*This method is used to set the value of the variable 'cardName'
     *@param cardName the value which the variable will be set to 
     */     
    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    /*This method is used to return the variable 'secureCode'
     *@return the value of 'secureCode'
     */     
    public String getSecureCode()
    {
        return secureCode;
    }

    /*This method is used to set the value of the variable 'secureCode'
     *@param secureCode the value which the variable will be set to 
     */     
    public void setSecureCode(String secureCode)
    {
        this.secureCode = secureCode;
    }   

    /*This method is used to return the variable 'cardType'
     *@return the value of 'cardType'
     */     
    public String getCardType()
    {
        return cardType;
    }
 
    /*This method is used to set the value of the variable 'cardType'
     *@param cardType the value which the variable will be set to 
     */     
    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }
 
    /*This method is used to return the variable 'expYear'
     *@return the value of 'expYear'
     */     
    public String getExpYear()
    {
        return expYear;
    }

    /*This method is used to set the value of the variable 'expYear'
     *@param expYear the value which the variable will be set to 
     */     
    public void setExpYear(String expYear)
    {
        this.expYear = expYear;
    }    
 
    /*This method is used to return the variable 'expMonth'
     *@return the value of 'expMonth'
     */     
    public String getExpMonth()
    {
        return expMonth;
    }

    /*This method is used to set the value of the variable 'expMonth'
     *@param expMonth the value which the variable will be set to 
     */     
    public void setExpMonth(String expMonth)
    {
        this.expMonth = expMonth;
    }
    
    /*This method is used to return the variable 'city'
     *@return the value of 'city'
     */     
    public String getCity()
    {
        return city;
    }

    /*This method is used to set the value of the variable 'city'
     *@param city the value which the variable will be set to 
     */     
    public void setCity(String city)
    {
        this.city = city;
    } 
    
    /*This method is used to return the variable 'address'
     *@return the value of 'address'
     */     
    public String getAddress()
    {
        return address;
    }

    /*This method is used to set the value of the variable 'address'
     *@param address the value which the variable will be set to 
     */     
    public void setAddress(String address)
    {
        this.address = address;
    } 
    
    /*This method is used to return the variable 'zip'
     *@return the value of 'zip'
     */     
    public String getZipCode()
    {
        return zip;
    }

    /*This method is used to set the value of the variable 'zip'
     *@param zip the value which the variable will be set to 
     */     
    public void setZipCode(String zip)
    {
        this.zip = zip;
    }
    
    /*This method is used to return the variable 'state'
     *@return the value of 'state'
     */     
    public String getState()
    {
        return state;
    }

    /*This method is used to set the value of the variable 'state'
     *@param state the value which the variable will be set to 
     */     
    public void setState(String state)
    {
        this.state = state;
    }
    
    /*This method is used to return the variable 'state'
     *@return the value of 'state'
     */     
    public String getPhone()
    {
        return phone;
    }

    /*This method is used to set the value of the variable 'state'
     *@param state the value which the variable will be set to 
     */     
    public void setPhone(String phone)
    {
        this.phone = phone;
    } 
    
    /*This method is used to return the variable 'state'
     *@return the value of 'state'
     */     
    public String getDescription()
    {
        return description;
    }

    /*This method is used to set the value of the variable 'state'
     *@param state the value which the variable will be set to 
     */     
    public void setDescription(String description)
    {
        this.description = description;
    }      
    
}
