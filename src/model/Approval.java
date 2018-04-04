package model;
import java.io.*;

public class Approval extends Staff
{
    // ** TO DO **
    public Approval(String username)
    {
        this.inputFile = new File("Approval.txt");
        loadUserInformation(username);
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
