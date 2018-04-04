package model;
import java.io.*;
import java.util.*;

public class Admin extends Staff
{
    private File inputFile = new File("admin.txt");
    private String readUser = "";
    private String readID = "";
    private String readName = "";
    private String readPhoneNo = "";
    private String readEmail = "";

    private Scanner userInput = new Scanner(System.in);

    public Admin(String username) {
        readFile(username);

        this.ID = readID;
        this.name = readName;
        this.phoneNumber = readPhoneNo;
        this.emailAddress = readEmail;
    }

    private void readFile(String username)
    {
        Scanner readInput = null;
        try
        {
            readInput = new Scanner(inputFile);
            while(readInput.hasNextLine())
            {
                String nextLine = readInput.nextLine();
                String[] inputComponents = nextLine.split(":");
                // If the next line read in is NOT a blank line
                if (inputComponents[0].compareTo("Username") == 0)
                {
                    readUser = inputComponents[1];
                    switch (inputComponents[0])
                    {
                        case "ID":
                            readID = inputComponents[1];
                        case "Name":
                            readName = inputComponents[1];
                            break;
                        case "Phone number":
                            readPhoneNo = inputComponents[1];
                            break;
                        case "Email Address":
                            readEmail = inputComponents[1];
                            break;
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    // Function used to create new user by writing to the existing loginDetails.txt file
    private void addStaffMember(String newUser, String newPassword, String newAccountType)
    {
        try
        {
            FileWriter writer = new FileWriter("loginDetails.txt", true);
            writer.write("\n");
            writer.write(newUser);
            writer.write(":");
            writer.write(newPassword);
            writer.write(":");
            writer.write(newAccountType);
            writer.write("\n");

            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void menu()
    {
        System.out.println("1)\tMaintain and update casual staff list");
        System.out.println("2)\tManage payroll");
        System.out.println("Enter option 1 or 2: ");
        int option = userInput.nextInt();
        userInput.nextLine();

        if(option == 1)
        {
            System.out.println("1)\tAdd new staff member");
            System.out.println("2)\tRemove existing staff member");
            System.out.println("3)\tView staff member database");

            System.out.println("Enter option 1, 2 or 3: ");
            int secondOption = userInput.nextInt();
            userInput.nextLine();

            switch(secondOption)
            {
                case 1:
                    System.out.println("Enter new staff username: ");
                    String user = userInput.nextLine();
                    System.out.println("Enter new password: ");
                    String password = userInput.nextLine();
                    System.out.println("Enter new staff member account type: ");
                    String accountType = userInput.nextLine();
                    addStaffMember(user,password,accountType);
                    break;
                case 2:

            }
        }
    }
}
