package model;

public class Staff {
	String id;
	String userName;
	String password;
	String name;
	String emailAddress;
	String phoneNumber;
	String role;
	String status;

	public Staff() {
	}

	public Staff(String id, String userName, String password, String name, String emailAddress, String phoneNumber,
			String role, String status) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return this.id+"\t"+this.userName+"\t"+this.password+"\t"+this.name+"\t"+this.emailAddress+"\t"+this.phoneNumber+"\t"+this.role+"\t"+(this.status.equals("1")?"activated":"Need to be activated");
	}
}
