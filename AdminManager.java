package com.student.exam;
import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminManager {

	public static void operations() throws FileNotFoundException, ClassNotFoundException, IOException {
		String qno;
		String prompt;
		 String answer;
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<Question> list = new ArrayList<Question>();
		File file = new File("QuestionAnswer.txt");// initialising file object and passing filename as argument
		ObjectOutputStream out = null;// initially writing the object as null
		ObjectInputStream in = null;
		ListIterator<Question> iterator = null;
		File file1 = new File("User.txt");
		User user = new User();
		ArrayList<User> list1 = new ArrayList<User>();
		ObjectOutputStream out1 = null;
		ObjectInputStream in1 = null;
		ListIterator<User> iterator1 = null;
		char ch = 0;
		do {
			System.out.println("==================");
			System.out.println("== HELLO ADMIN ==");
			System.out.println("==================");
			System.out.println("1. Add Questions");
			System.out.println("2. View Questions ");
			System.out.println("3. Delete Question");
			System.out.println("4. View User Information");
			
			System.out.println("==================");
			System.out.println();
			System.out.println("Enter your choice ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Welcome Admin!");
	 	 		System.out.println("Please Enter the no of Questions that you want to add");
				int no_of_products = scanner.nextInt();
				for (int i = 0; i < no_of_products; i++) {
					System.out.println("Enter the Question Number");
					qno = scanner1.nextLine();
					System.out.println("Enter the Question");
					prompt = scanner1.nextLine();
					System.out.println("Enter Answer");
					answer = scanner1.nextLine();
					
					// adding place object to list
					list.add(new Question(qno,prompt,answer));
				}
				// fileoutputstream writes the file"Beautifulplaces.txt and it will be used by
				// objectoutputstream
				out = new ObjectOutputStream(new FileOutputStream(file));
            	out.writeObject(list);// writes the object available in list into the file.
				out.close();
				break;
			case 2:
				System.out.println("--- view all Questions--");
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Question>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;
			
			  case 3: 
				  System.out.println("-------DELETION--------"); 
			  boolean found1 = false; System.out.println("Enter the Question Number to be removed"); 
			  String Question_delete = scanner1.nextLine(); 
			  in = new ObjectInputStream(new FileInputStream(file)); 
			  list = (ArrayList<Question>) in.readObject();
			  in.close(); 
			  iterator = list.listIterator(); 
			  while (iterator.hasNext()) 
			  {
				  Question pl = (Question) iterator.next(); 
				  if(pl.qno.equals(Question_delete)) 
				  { 
					  iterator.remove(); found1 = true; 
					  } 
				  }
			  if (found1) 
			  { 
				  out = new ObjectOutputStream(new FileOutputStream(file));
			  out.writeObject(list); out.close(); 
			  System.out.println(Question_delete +" is removed sucessfully"); 
			  } else 
			  { 
				  System.out.println(Question_delete +" is not in a list"); 
				  } 
			  break;
			 
			case 4:
				System.out.println("-------view all users-------");
				in1 = new ObjectInputStream(new FileInputStream(file1));
				list1 = (ArrayList<User>) in1.readObject();
				in1.close();
				iterator1 = list1.listIterator();
				while (iterator1.hasNext()) {
					System.out.println(iterator1.next());
				}
				break;
			}
			System.out.println("Do u want to continue press y");
			ch = scanner.next().charAt(0);
		} while (ch == 'y');

	}
}