package com.training.logical;
import java.util.Scanner;

public class Compare {

	public static void  main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		System.out.println("Enter two numbers");
		int a=s.nextInt();
		int b=s.nextInt();
		
		System.out.println(compare(a,b));
		s.close();
		
	}
	public static boolean compare(int a,int b)
	{
		int tenb=(b*10)/100;
//		System.out.println(tenb);
		if(a==b)
		return true;	
		if(a>=(b-tenb) && a<=(b+tenb))
		{
				return true;
		}
		else
			return false;
	}

}
