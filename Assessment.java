package com.student.exam;
//package com.tourism;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Assessment {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		char option;
		Assessment loginmain = new Assessment();
		User user=new User();
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\AllNewProj\\User.txt");
		List<User> list = new ArrayList<User>();
		List<User> updatedlist = new ArrayList<User>();
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		ListIterator<User>iterator = null;
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("=====WELCOME=====");
			System.out.println("---1.SIGNUP----");
			System.out.println("---2.LOGIN----");
			int choice = scanner.nextInt();
			char opt;
			switch (choice) {
			case 1:
				do {
					System.out.println("----------signup------------");
					System.out.println("Enter the Details");
					System.out.println("Enter the role");
					String role = scanner.next();
					System.out.println("Enter the Mobile number");
			 		String mobilenumber = scanner.next();
					System.out.println("Enter the username");
					String username = scanner.next();
					if (UsernameValidator.userNameValidation(username)) {
						System.out.println("valid username");
						System.out.println("Enter the Password");
						String password = scanner.next();
						if (PasswordValidator.passWordValidation(password)) {
							System.out.println("valid password");
				 			System.out.println("Enter the confirmpassword");
							String confirmpassword = scanner.next();
							if (password.equals(confirmpassword)) {
	                            list.add(new User(username, password, confirmpassword, role, mobilenumber,0));
								out = new ObjectOutputStream(new FileOutputStream(file));
								out.writeObject(list);
								out.close();
								System.out.println("Access Granted!you can login and go ahead");
							} else
								System.out.println("password doesnot match");
						} else
	                           System.out.println("password should be strong");
					} else
						    System.out.println("enter the username again");
					break;
					//System.out.println("Do you want to signup again::");
					//opt= scanner.next().charAt(0);
				}while(opt == 'y');
				/*
				 * out = new ObjectOutputStream(new FileOutputStream(file,true));
				 * System.out.println(list.size()); out.writeObject(list); out.close();
				 */
				break;
			case 2:
				
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<User>)in.readObject();
				System.out.println(list.size());
				
				System.out.println("------Login---------");
				System.out.println("enter the username");
				String username1 = scanner.next();
				System.out.println("enter the password");
				String Password1 = scanner.next();
				
				in.close();
				iterator = list.listIterator();
				User tempUser = new User();
				while(iterator.hasNext())
				{
					user=(User)iterator.next();
					
					if (username1.equals(user.username) && Password1.equals(user.password))
					{
						if(user.role.equalsIgnoreCase("admin"))
						{
							System.out.println("Admin Login Success");
							new AdminManager().operations();
						}
						else if(user.role.equalsIgnoreCase("user"))
						{
							System.out.println("User Login Success");
							Scanner scanner1 = new Scanner(System.in);
							System.out.println("=====WELCOME=====");
							System.out.println("---1.Attempt Quiz----");
							System.out.println("---2.Show Result----");
							int choice1 = scanner1.nextInt();
							switch (choice1) {
							case 1:
								int score = new UserManager().attemptQuiz();
								user.score = score;
								tempUser = user;
								iterator.remove();
								break;
							case 2:
								new UserManager().showResult(user);
								break;
							}
							
							list.add(tempUser);
							out = new ObjectOutputStream(new FileOutputStream(file));
							out.writeObject(list);
							out.close();
						}
						break;
					}
				}
				
			}
			System.out.println("Do you want to continue press 'y',else press 'N'");
			option = scanner.next().charAt(0);// here charAt(0) returns the character at 0th index to variable "option"

		} while (option == 'y');
	}

}
