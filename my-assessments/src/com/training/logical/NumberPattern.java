package com.training.logical;
import java.util.Scanner;

public class NumberPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of rows");
		int n=s.nextInt();
		for(int i=n;i>0;i--)
		{
			for(int j=i;j>0;j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		s.close();
	}

}
