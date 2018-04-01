import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver
{
    static Scanner input = new Scanner(System.in);


    private static void login(String user, String pass)
    {
        File fileName = new File("loginDetails.txt");
        Scanner inputStream = null;

        try
        {
            inputStream = new Scanner(fileName);
            while(inputStream.hasNextLine())
            {
                // Convert the line read by scanner into an array that holds two strings
                String nextLine = inputStream.nextLine();
                /* loginComponents[0] = Username
                   loginComponents[1] = Password
                   loginComponents[2] = Access Level
                 */
                String[] loginComponents = nextLine.split(":");

                if(user.compareTo(loginComponents[0]) == 0 && pass.compareTo(loginComponents[1]) == 0)
                {
                    System.out.println("You have successfully logged in as " + user + ", access level: " + loginComponents[2]);
                    /*
                    if loginComponents[2] == "admin"
                        call adminMenu()
                    else if loginComponents[2] = "CourseCoordinator"
                        call CourseCoordinatorMenu()
                    ETC
                     */
                }

            }
        } catch (FileNotFoundException e)
        {
            System.out.println("No file found: No login details loaded");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to RMIT HR System");
        System.out.println("Please enter your Username: ");
        String inputUser = input.nextLine();
        System.out.println("Please enter your Password: ");
        String inputPass = input.nextLine();

        login(inputUser, inputPass);
    }
    
    public static void displayMenu(String userType) //prints menu after login(), menu differs based on userType
    {
    	if(userType == "CasualStaff")
    	{
    		System.out.println("1)\tViewassigned activities");
    		System.out.println("2)\tSee offer and application");
    	}
    	else if(userType == "Approval")
    	{
    		System.out.println("1)\tView assignment requests");
    	}
    	else if(userType == "CourseCoordinator")
    	{
    		System.out.println("1)\tView assigned courses");
    		System.out.println("2)\tRequest onboarding for new casual staff member then notify admin");
    	}
    	else if(userType == "Admin")
    	{
    		System.out.println("1)\tMaintain and update casual staff list");
    		System.out.println("2)\tManage payroll");
    	}
    }
}
