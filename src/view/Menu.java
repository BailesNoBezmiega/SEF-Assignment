package view;

import java.util.Map;
import java.util.Scanner;

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
			System.out.println("1)\tViewassigned activities  (currently unavailable)");
			System.out.println("2)\tSee offer and application  (currently unavailable)");
		} else if (userRole.equals("Approval")) {
			System.out.println("1)\tView assignment requests  (currently unavailable)");
		} else if (userRole.equals("CourseCoordinator")) {
			System.out.println("1)\tView assigned courses  (currently unavailable)");
			System.out.println(
					"2)\tRequest onboarding for new casual staff member then notify admin  (currently unavailable)");
		} else if (userRole.equals("Admin")) {
			System.out.println("1)\tMaintain and update casual staff list");
			System.out.println("2)\tManage payroll  (currently unavailable)");
		}
		System.out.println("3)\tLogout");
		int option = LOGIN_INPUT.nextInt();
		LOGIN_INPUT.nextLine();
		if (option > 0 && option <= 3) {
			if (option == 3) {

			} else {
				displaySubMenuByRole(userRole, 1, option);
			}
		}
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
				subMenuByAdmin();

				int newOption = LOGIN_INPUT.nextInt();
				LOGIN_INPUT.nextLine();
				if (newOption >= 1 && newOption <= 4) {
					if (newOption == 4) {
						Menu.displayMainMenuByRole(ADMIN);
					} else {
						displaySubMenuByRole(ADMIN, 2, newOption);
					}
				} else {
					System.out.println("Wrong number, input again: ");
					displaySubMenuByAdmin(level, option);
				}
			} else if (option == 2) {
				System.out.println("Manage payroll:  (currently unavailable) ");
				System.out.println("Need to do..........");
				// TODO
			}
		} else if (level == 2) {
			if (option == 1) {
				System.out.println("Add new staff member======================");

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
				System.out.println("Remove existing staff member======================");
				Driver.displayAllUsers();
				System.out.print("Enter userName that you want to delete: ");
				String delUserName = LOGIN_INPUT.nextLine();
				if (delUserName != null && !delUserName.equals("")) {
					Map<String, Staff> userMap = Driver.userMap;
					if (userMap.containsKey(delUserName) == true) {
						userMap.remove(delUserName);
						System.out.println("User has been deleted.");
					}
				}
				Driver.displayAllUsers();
			} else if (option == 3) {
				System.out.println("View staff member database: ");
				Driver.displayAllUsers();
			} else if (option == 4) {
				System.out.println("back to main menu: ");
				System.out.println("Need to do..........");
				// TODO
			}

		}
	}

	private static void subMenuByAdmin() {
		System.out.println("Maintain and update casual staff list======================");
		System.out.println("1)\tAdd new staff member");
		System.out.println("2)\tRemove existing staff member");
		System.out.println("3)\tView staff member database");
		System.out.println("4)\tback to main menu");
		System.out.println("Enter option 1, 2, 3 or 4: ");
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
