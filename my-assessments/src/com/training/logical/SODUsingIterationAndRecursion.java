package com.training.logical;
import java.util.Scanner;

public class SODUsingIterationAndRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("Please enter a number");
		int n=s.nextInt();
		System.out.println("Sum of Digits Using Iteration");
		System.out.println(sumDigitsIteration(n));
		System.out.println("Sum of Digits Using Recursion");
		System.out.println(sumDigitsRecursion(n,0));
		s.close();
	}
	public static int sumDigitsIteration(int n)
	{
		int sum=0;
		while(n>0)
		{
			sum=sum+(n%10);
			n=n/10;
		}
		return sum;
	}
	public static int sumDigitsRecursion(int n,int sum)
	{
		if(n<=0)
			return sum;
		sum=sum+n%10;
		return sumDigitsRecursion(n/10,sum);
	}

}
