package model;

import java.io.*;

public class CasualStaff extends Staff
{
    // ** TO DO **
    public CasualStaff(String username)
    {
        this.inputFile = new File("CasualStaff.txt");
        readFile(username);
        this.userName = readUser;
        this.ID = readID;
        this.name = readName;
        this.phoneNumber = readPhoneNo;
        this.emailAddress = readEmail;

    }

    public void menu()
    {

    }
}
