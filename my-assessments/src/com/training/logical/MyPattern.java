package com.training.logical;
import java.util.Scanner;

public class MyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int n=s.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("0");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print("1");
			}
			System.out.print(" ");
		}
		s.close();
	}

}
