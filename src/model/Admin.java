package model;
import java.io.*;
import java.util.*;

public class Admin extends Staff
{
    private File inputFile = new File("admin.txt");
    /*  Temporary variables which will be used to instantiate
        object after reading in from admin.txt file */
    private String readUser = "";
    private String readID = "";
    private String readName = "";
    private String readPhoneNo = "";
    private String readEmail = "";

    // Scanner used to ask for user input after opening admin.menu()
    private Scanner userInput = new Scanner(System.in);

    // Class constructor
    public Admin(String username) {
        readFile(username);
        this.userName = readUser;
        this.ID = readID;
        this.name = readName;
        this.phoneNumber = readPhoneNo;
        this.emailAddress = readEmail;
    }

    // Reads admin.txt file and then retrieves information such as name, email address and etc
    private void readFile(String username)
    {
        Scanner readInput;
        try
        {
            readInput = new Scanner(inputFile);
            while(readInput.hasNextLine())
            {
                String nextLine = readInput.nextLine();
                String[] inputComponents = nextLine.split(":");
                // If the next line read in is NOT a blank line
                if (inputComponents[0].compareTo("Username") == 0 && inputComponents[1].compareTo(username) == 0)
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
        System.out.println("2)\tManage payroll (currently unavailable)");

        System.out.println("Enter option 1 or 2: ");
        int option = userInput.nextInt();
        userInput.nextLine();

        if(option == 1)
        {
            System.out.println("1)\tAdd new staff member");
            System.out.println("2)\tRemove existing staff member (currently unavailable)");
            System.out.println("3)\tView staff member database (currently unavailable)");

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
                    System.out.println("Enter new staff member account type " +
                            "(Admin/Course Coordinator/Approval/Casual Staff) : ");
                    String accountType = userInput.nextLine();
                    addStaffMember(user,password,accountType);
                    break;
                case 2:

            }
        }
    }
}
