package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.Staff;
import view.Menu;

public class Driver {
	private static String ACCOUNT_FILE = "src/files/account.txt";
	public static Map<String, Staff> userMap = null;
	private static int countUser = 0;

	private static boolean IS_VALIDATE = false;
	private static Scanner LOGIN_INPUT = new Scanner(System.in);
	private static Scanner FILE_STREAM = null;

	public static Map<String, Staff> initialStaffDetails2Map() {
		userMap = new HashMap<String, Staff>();
		try {
			Scanner fileStream = new Scanner(new File(ACCOUNT_FILE), "UTF-8");

			while (fileStream.hasNextLine()) {
				Staff staff = new Staff();
				String[] accountComponents = fileStream.nextLine().split(":");
				staff.setId(accountComponents[0]);
				staff.setUserName(accountComponents[1]);
				staff.setPassword(accountComponents[2]);
				staff.setName(accountComponents[3]);
				staff.setEmailAddress(accountComponents[4]);
				staff.setPhoneNumber(accountComponents[5]);
				staff.setRole(accountComponents[6]);
				staff.setStatus(accountComponents[7]);
				if (userMap.containsKey(staff.getUserName()) == false) {
					userMap.put(staff.getUserName(), staff);
					countUser++;
				}
			}
			System.out.println("Count User: " + countUser);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			return userMap;
		}
	}

	public static boolean validUser(String userName, String password) {
		if (userName != null && !userName.equals("")) {
			if (userMap.containsKey(userName) == true) {
				Staff staff = userMap.get(userName);
				if (staff.getPassword().equals(password) && password != null)
					IS_VALIDATE = true;
			}
		}
		return IS_VALIDATE;
	}

	private static void login(String userName, String password) {
		boolean loginResult = validUser(userName, password);
		if (loginResult == true) {
			System.out.println("You have successfully logged in as " + userName);
			Menu.displayMainMenuByRole(userMap.get(userName).getRole());

		} else {
			System.out.println("Error: invalid username/password combination.");
		}
	}

	public static void addUser(String userName, String password, String name, String emailAddress, String phoneNumber,
			String userRole, String status) {
		FileWriter writer;
		try {
			writer = new FileWriter(ACCOUNT_FILE, true);
			writer.write("\n");
			countUser = countUser + 1;
			writer.write(String.valueOf(countUser));
			writer.write(":");
			writer.write(userName);
			writer.write(":");
			writer.write(password);
			writer.write(":");
			writer.write(name);
			writer.write(":");
			writer.write(emailAddress);
			writer.write(":");
			writer.write(phoneNumber);
			writer.write(":");
			writer.write(userRole);
			writer.write(":");
			writer.write(status);

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addUser(Staff staff) {
		FileWriter writer;
		try {
			writer = new FileWriter(ACCOUNT_FILE, true);
			writer.write("\n");
			writer.write(countUser++);
			writer.write(":");
			writer.write(staff.getUserName());
			writer.write(":");
			writer.write(staff.getPassword());
			writer.write(":");
			writer.write(staff.getName());
			writer.write(":");
			writer.write(staff.getEmailAddress());
			writer.write(":");
			writer.write(staff.getPhoneNumber());
			writer.write(":");
			writer.write(staff.getRole());
			writer.write(":");
			writer.write(staff.getStatus());

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void displayAllUsers() {
		Set<String> keys = Driver.userMap.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Staff value = Driver.userMap.get(key);
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		userMap = Driver.initialStaffDetails2Map();
		System.out.println("Welcome to RMIT HR System\n");
		do {
			System.out.println("Username: ");
			String inputUserName = LOGIN_INPUT.nextLine();
			System.out.println("Password: ");
			String inputPassword = LOGIN_INPUT.nextLine();
			login(inputUserName, inputPassword);

		} while (!IS_VALIDATE);

	}
}
