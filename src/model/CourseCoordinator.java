package model;

public class CourseCoordinator extends Staff {
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
    System.out.println("1)\tView and edit course details");
        System.out.println("2)\tView timetable");
        System.out.println("3)\tRequest Activity");
        System.out.println("4)\tAdjust pay rate");
        System.out.println("5)\tRequest new staff member");

        System.out.println("Enter option: ");
        int option = userInput.nextInt();
        userInput.nextLine();

        if(option == 1)
        {
            System.out.println("1)\tView course details");
            System.out.println("2)\tEdit course details");
            

            System.out.println("Enter option 1 or 2: ");
            int firstOption = userInput.nextInt();
            userInput.nextLine();

            switch(firstOption)
            {
                
            }
        }

        else if (option == 2)
        {

        }

        else if (option == 3)
        {
            System.out.println("1)\tRequest activity");

            int thirdOption = userInput.nextInt();
            userInput.nextLine();

            switch(thirdOption)
            {
                case 1:
                    System.out.println("Activity type: ");
                    String activity = userInput.nextLine();
                    System.out.println("Pay rate: ");
                    int payRate = userInput.nextLine();
                    System.out.println("Duration: ");
                    int duration = userInput.nextLine();
                    requestActivity(activity,payRate,duration);
                    break;
            }

        }

        else if (option == 4)
        {
            
        }

        else if (option == 5)
        {
            System.out.println("1)\tRequest new staff member");

            int fifthOption = userInput.nextInt();
            userInput.nextLine();

            switch(fifthOption)
            {
                case 1:
                System.out.println("Enter new staff full name: ");
                String name = userInput.nextLine();
                System.out.println("Enter new staff ID: ");
                String ID = userInput.nextLine();
                System.out.println("Enter new staff email: ");
                String email = userInput.nextLine();
                requestNewStaffMember(name,ID,email);
                break;
        }
}
