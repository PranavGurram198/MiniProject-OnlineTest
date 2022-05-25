package com.student.exam;

//package com.tourism;

import java.io.Serializable;

public class User implements Serializable{
String username;
String password;
String confirmpassword;
String role;
String mobilenumber;
double score;
public void User() {
	
}
public User(String username, String password, String confirmpassword, String role, String mobilenumber, double score) {
	super();
	this.username = username;
	this.password = password;
	this.confirmpassword = confirmpassword;
	this.role = role;
	this.mobilenumber = mobilenumber;
	this.score = score;
}
public User() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + ", confirmpassword=" + confirmpassword + ", role="
			+ role + ", mobilenumber=" + mobilenumber + ", score=" + score + "]";
}




}

