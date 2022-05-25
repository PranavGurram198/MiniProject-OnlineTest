package com.student.exam;

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

public class UserManager {

	Scanner scanner = new Scanner(System.in);
	File file = new File("QuestionAnswer.txt");

	ArrayList<Question> list = new ArrayList<Question>();
	ArrayList<User> listUser = new ArrayList<User>();
	ListIterator<Question> iterator = null;
	int score = 0;

	public int attemptQuiz() throws FileNotFoundException, IOException, ClassNotFoundException {
		score = 0;
		Question q;
		ObjectInputStream in = null;
		in = new ObjectInputStream(new FileInputStream(file));
		list = (ArrayList<Question>) in.readObject();
		in.close();
		iterator = list.listIterator();
		while (iterator.hasNext()) {
			q = (Question) iterator.next();
			System.out.println(q.prompt);

			System.out.println("Enter the Answer::");
			String ans = scanner.next();

			if (q.answer.equalsIgnoreCase(ans)) {
				score++;
			}
		}
		return score * 100 / list.size();

	}

	public void showResult(User user) {
		System.out.println("Your score is ::" + user.score);

	}

}
