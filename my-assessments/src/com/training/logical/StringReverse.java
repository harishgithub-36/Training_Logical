package com.training.logical;

import java.util.Scanner;

public class StringReverse {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter length of array");
		int n=s.nextInt();
		System.out.println("Please enter characters");
		char ch[]=new char[n];
//		['a','b']
		for(int i=0;i<n;i++)
		{
			ch[i]=s.next().charAt(0);
		}
		System.out.println(stringReverseUsingIterative(ch,""));
		System.out.println(stringReverseUsingRecursion(ch,"",ch.length-1));
		s.close();
	}
	public static String stringReverseUsingIterative(char ch[],String result)
	{
		for(int i=ch.length-1;i>=0;i--)
		{
			result+=ch[i];
		}
		return result;
	}
	public static String stringReverseUsingRecursion(char ch[],String result,int l)
	{
		if(l<0)
		{
			return result;
		}
		result+=ch[l];
		l=l-1;
		return stringReverseUsingRecursion(ch,result,l);
	}
}
