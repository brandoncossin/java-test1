package com.ecommerce.models;

public class SignupForm {
    private String phone_number;
    private String first_name;
	private String last_name;
    private String password;

	public String getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
    public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
