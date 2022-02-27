package com.training.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String arr[] = { "John", "Marry" };
		List<Student> li = new ArrayList<>();
//				for (String i : arr) {
//					Student obj3 = new Student();
//					obj3.setName(i);
//					li.add(obj3);
//				}
		for (int i = 0; i < 2; i++) {
			String str = sc.next();
			Student obj3 = new Student();
			obj3.setName(str);
			li.add(obj3);
		}
		for (Student s : li) {

			System.out.println(s.getName());
		}
	}

}
