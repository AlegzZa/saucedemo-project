package test.data;

import config.Reader;

public class Users {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String postCode;

	public Users(String filename) {
		this.username=Reader.json(filename).get("username").toString();
		this.password=Reader.json(filename).get("password").toString();
		this.firstName=Reader.json(filename).get("firstName").toString();
		this.lastName=Reader.json(filename).get("lastName").toString();
		this.postCode=Reader.json(filename).get("zipCode").toString();

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}
