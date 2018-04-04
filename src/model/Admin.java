package model;
import java.io.*;
import java.util.*;

public class Admin extends Staff
{


    /*  Temporary variables which will be used to instantiate
        object after reading in from Admin.txt file */


    // Scanner used to ask for user input after opening admin.menu()
    private Scanner userInput = new Scanner(System.in);

    // Class constructor
    public Admin(String username)
    {
        this.inputFile = new File("Admin.txt");
        readFile(username);
        this.userName = readUser;
        this.ID = readID;
        this.name = readName;
        this.phoneNumber = readPhoneNo;
        this.emailAddress = readEmail;

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
