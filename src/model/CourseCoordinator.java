package model;

import java.io.*;

public class CourseCoordinator extends Staff
{
    public CourseCoordinator(String username)
    {
        this.inputFile = new File("CourseCoordinator.txt");
        loadUserInformation(username);
        this.userName = readUser;
        this.ID = readID;
        this.name = readName;
        this.phoneNumber = readPhoneNo;
        this.emailAddress = readEmail;
    }

    public void menu()
    {
        // ** TO DO **
    }
}
