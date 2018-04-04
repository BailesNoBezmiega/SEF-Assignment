package controller;

import model.Admin;
import model.Approval;
import model.CasualStaff;
import model.CourseCoordinator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver
{
    private static Scanner input = new Scanner(System.in);
    private static boolean loggedIn = false;

    // This function is used to login to the system
    private static void login(String user, String pass)
    {
        // Function will read loginDetails.txt and look for matching user and password
        File fileName = new File("loginDetails.txt");
        Scanner inputStream;

        try
        {
            inputStream = new Scanner(fileName);
            while(inputStream.hasNextLine())
            {
                /*  Read the text file line by line and for each line, split the string at every ':' character
                    so that the line is split into an array of three different strings.
                    loginComponents[0] = Username
                    loginComponents[1] = Password
                    loginComponents[2] = Account type
                */
                String nextLine = inputStream.nextLine();
                String[] loginComponents = nextLine.split(":");

                // If the input username and password matches any of the accounts in the txt file
                if(user.compareTo(loginComponents[0]) == 0 && pass.compareTo(loginComponents[1]) == 0)
                {
                    System.out.println("You have successfully logged in as "
                            + user + ", account type: " + loginComponents[2]);

                    loggedIn = true;    // Boolean that changes to true after successful login

                    /*  Check the type of account that the user logged into, switch that activates based
                        on the account type
                     */
                    switch(loginComponents[2])
                    {
                        case "Admin":
                            Admin a = new Admin(loginComponents[0]);
                            a.menu();
                            break;
                        case "Course Coordinator":
                            CourseCoordinator c = new CourseCoordinator(loginComponents[0]);
                            c.menu();
                            break;
                        case "Approval":
                            Approval ap = new Approval(loginComponents[0]);
                            ap.menu();
                            break;
                        case "Casual Staff":
                            // TO DO
                            CasualStaff cs = new CasualStaff(loginComponents[0]);
                            cs.menu();
                            break;
                    }
                }
            }
            if(!loggedIn)
            {
                System.out.println("Error: invalid username/password combination.");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("No file found: No login details loaded");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to RMIT HR System\n");
        // Keep asking user for username/password until they are able to log into an existing account
        do
        {
            System.out.println("Username: ");
            String inputUser = input.nextLine();
            System.out.println("Password: ");
            String inputPass = input.nextLine();
            login(inputUser, inputPass);
        }
        while(!loggedIn);


    }
}
