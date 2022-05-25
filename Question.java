package com.student.exam;

import java.io.Serializable;

public class Question implements Serializable {
	String qno;
	String prompt;
	 String answer;
	 
	 public Question(String qno,String prompt,String answer) {
		 this.qno = qno;
		 this.prompt = prompt;
		 this.answer = answer;
	 }

	@Override
	public String toString() {
		return "Question [qno=" + qno + ", prompt=" + prompt + ", answer=" + answer + "]";
	}

	
}
