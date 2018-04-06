package view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import controller.Driver;
import model.Staff;

public class Menu {
	private static String ADMIN = "Admin";
	private static String COURSE_COORDINATOR = "CourseCoordinator";
	private static String CASUAL_STAFF = "CasualStaff";
	private static String APPROVAL = "Approval";
	private static Scanner LOGIN_INPUT = new Scanner(System.in);

	public static void displayMainMenuByRole(String userRole) {
		if (userRole.equals("CasualStaff")) {
			System.out.println("1)\tViewassigned activities");
			System.out.println("2)\tSee offer and application");
		} else if (userRole.equals("Approval")) {
			System.out.println("1)\tView assignment requests");
		} else if (userRole.equals("CourseCoordinator")) {
			System.out.println("1)\tView assigned courses");
			System.out.println("2)\tRequest onboarding for new casual staff member then notify admin");
		} else if (userRole.equals("Admin")) {
			System.out.println("1)\tMaintain and update casual staff list");
			System.out.println("2)\tManage payroll");
		}
		System.out.println("3)\tLogout");
	}

	public static void displaySubMenuByRole(String userRole, int level, int option) {
		if (userRole != null && !userRole.equals("")) {
			if (level >= 1 && level <= 2) {
				if (userRole.equals(ADMIN)) {
					displaySubMenuByAdmin(level, option);
				} else if (userRole.equals(COURSE_COORDINATOR)) {
					displaySubMenuByCoordinator(level, option);
				} else if (userRole.equals(CASUAL_STAFF)) {
					displaySubMenuByCasual(level, option);
				} else if (userRole.equals(APPROVAL)) {
					displaySubMenuByApproval(level, option);
				}
			} else {
				System.out.println("Wrong Sub Menu");
			}
		}
	}

	public static void displaySubMenuByAdmin(int level, int option) {
		if (level == 1) {
			if (option == 1) {
				System.out.println("Maintain and update casual staff list: ");
				System.out.println("1)\tAdd new staff member");
				System.out.println("2)\tRemove existing staff member (currently unavailable)");
				System.out.println("3)\tView staff member database (currently unavailable)");
				System.out.println("4)\tback to main menu (currently unavailable)");
				System.out.println("Enter option 1, 2, 3 or 4: ");

				int newOption = LOGIN_INPUT.nextInt();
				LOGIN_INPUT.nextLine();
				if (newOption >= 1 && newOption <= 4) {
					if (newOption == 4) {
						displayMainMenuByRole(ADMIN);
					} else {
						displaySubMenuByRole(ADMIN, 2, newOption);
					}
				} else {
					System.out.println("Input number is wrong");
				}
			} else if (option == 2) {
				System.out.println("Manage payroll: ");
				System.out.println("Need to do..........");
				// TODO
			}
		} else if (level == 2) {
			if (option == 1) {
				System.out.println("Add new staff member: ");

				System.out.println("Enter new staff username: ");
				String userName = LOGIN_INPUT.nextLine();
				System.out.println("Enter new password: ");
				String password = LOGIN_INPUT.nextLine();

				System.out.println("Enter name: ");
				String name = LOGIN_INPUT.nextLine();
				System.out.println("Enter Email Address: ");
				String emailAddress = LOGIN_INPUT.nextLine();

				System.out.println("Enter Phone Number: ");
				String phoneNumber = LOGIN_INPUT.nextLine();
				System.out.println("Enter new staff member role (" + ADMIN + "/" + COURSE_COORDINATOR + "/"
						+ CASUAL_STAFF + "/" + APPROVAL + ") : ");
				String userRole = LOGIN_INPUT.nextLine();
				if (userRole != null && !userRole.equals("")) {
					if (!userRole.equals(ADMIN) && !userRole.equals(COURSE_COORDINATOR)
							&& !userRole.equals(CASUAL_STAFF) && !userRole.equals(APPROVAL)) {
						System.out.println("Input wrong role");
					}
				}

				String status = "1";
				Driver.addUser(userName, password, name, emailAddress, phoneNumber, userRole, status);

			} else if (option == 2) {
				System.out.println("Remove existing staff member: ");
				System.out.println("Need to do..........");
				// TODO
			} else if (option == 3) {
				System.out.println("View staff member database: ");
				Set<String> keys = Driver.userMap.keySet();
				Iterator<String> it = keys.iterator();
				while (it.hasNext()) {
					String key = it.next();
					Staff value = Driver.userMap.get(key);
					System.out.println(value);
				}
			} else if (option == 4) {
				System.out.println("back to main menu: ");
				System.out.println("Need to do..........");
				// TODO
			}

		}
	}

	public static void displaySubMenuByCoordinator(int level, int option) {
		if (level == 1) {
			System.out.println("1)\tAdd new staff member");
			System.out.println("2)\tRemove existing staff member (currently unavailable)");
			System.out.println("3)\tView staff member database (currently unavailable)");
			System.out.println("4)\tback to main menu (currently unavailable)");
			System.out.println("Enter option 1, 2, 3 or 4: ");

		} else if (level == 2) {

		}
	}

	public static void displaySubMenuByCasual(int level, int option) {
		if (level == 1) {
			System.out.println("1)\tAdd new staff member");
			System.out.println("2)\tRemove existing staff member (currently unavailable)");
			System.out.println("3)\tView staff member database (currently unavailable)");
			System.out.println("4)\tback to main menu (currently unavailable)");
			System.out.println("Enter option 1, 2, 3 or 4: ");

		} else if (level == 2) {

		}
	}

	public static void displaySubMenuByApproval(int level, int option) {
		if (level == 1) {
			System.out.println("1)\tAdd new staff member");
			System.out.println("2)\tRemove existing staff member (currently unavailable)");
			System.out.println("3)\tView staff member database (currently unavailable)");
			System.out.println("4)\tback to main menu (currently unavailable)");
			System.out.println("Enter option 1, 2, 3 or 4: ");

		} else if (level == 2) {

		}
	}

}
