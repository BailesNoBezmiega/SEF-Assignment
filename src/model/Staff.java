package model;

import java.io.*;
import java.util.Scanner;

public abstract class Staff
// This will be the abstract class that all of the actors will extend from
{
    String name;
    String userName;
    String emailAddress;
    String phoneNumber;
    String ID;

    abstract void menu();
    //abstract void printDetails();

    //  The following variables are just temporary variables which the function readFile will use
    private Scanner readInput;
    String readUser = "";
    String readID = "";
    String readName = "";
    String readPhoneNo = "";
    String readEmail = "";
    File inputFile;
    /*  This function will read either Admin.txt, Approval.text, CourseCoordinator.txt or CasualStaff.txt,
        then it will search for the corresponding username in those text files and then
        the constructor will call this function so that the corresponding user's details (name,address etc)
        will be set when the object is created
     */
    void readFile(String username)
    {
        try
        {
            // Loop that will read over the text file line by line
            readInput = new Scanner(inputFile);
            while(readInput.hasNextLine())
            {
                // Split line at each ':' character
                String nextLine = readInput.nextLine();
                String[] inputComponents = nextLine.split(":");
                /*  If the current line that is being read is a different username to the one passed as an
                    argument in this function, skip over the text file until a blank line is reached
                 */
                if(inputComponents[0].equals("Username") && inputComponents[1].compareTo(username) != 0)
                {
                    do
                    {
                        nextLine = readInput.nextLine();
                    }
                    while(nextLine.compareTo("") != 0);
                }
                else    // If the username passed as an argument in the function matches one in the text file
                {
                    switch(inputComponents[0])
                    {
                        case "Username":
                            readUser = inputComponents[1];
                            break;
                        case "ID":
                            readID = inputComponents[1];
                            break;
                        case "Name":
                            readName = inputComponents[1];
                            break;
                        case "Phone number":
                            readPhoneNo = inputComponents[1];
                            break;
                        case "Email Address":
                            readEmail = inputComponents[1];
                            return;
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}
