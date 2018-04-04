package model;

public abstract class Staff
// This will be the abstract class that all of the actors will extend from
{
    protected String name;
    protected String userName;
    protected String emailAddress;
    protected String phoneNumber;
    protected String ID;

    abstract void menu();


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
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
