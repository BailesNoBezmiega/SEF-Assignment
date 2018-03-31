import java.util.*;
import java.io.*;

public abstract class Staff
// This will be the abstract class that all of the actors will extend from
{
    private String name;
    private String userName;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String ID;




    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setUserName(String uName)
    {
        this.userName = uName;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setPassword(String pWord)
    {
        this.password = pWord;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setEmailAddress(String email)
    {
        this.emailAddress = email;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public void setPhoneNumber(String phone)
    {
        this.phoneNumber = phone;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setID(String IDNum)
    {
        this.ID = IDNum;
    }

    public String getID()
    {
        return this.ID;
    }
}
