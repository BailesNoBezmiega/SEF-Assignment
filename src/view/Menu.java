package view;

public class Menu {
    // Dummy class, just needed to create a java class to push this directory to github
	
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
