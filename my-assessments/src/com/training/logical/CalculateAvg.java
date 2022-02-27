package com.training.logical;
import java.util.Scanner;

public class CalculateAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner s =new Scanner(System.in);
	        System.out.println("Enter the number of elements in array");
			int n=s.nextInt();
			int a[]=new int[n];
			System.out.println("Enter the array elements");
			int sum=0;	
			for(int i=0;i<n;i++)
				{
				a[i]=s.nextInt();
				sum+=a[i];
				}
			double avg;
			avg=(double)sum/n;
			System.out.println(avg);
			s.close();
			
	}

}
