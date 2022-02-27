package com.training.logical;
import java.util.*;
/**
 * 
 * @author harish.kumar
 *
 */
public class MoveZeroToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of elements in array");
//		int n=s.nextInt();
		int arr[]= { 1,9,8,4,0,0,2,7,0,6,0};
//		int arr[]=new int[n];
//		System.out.println("Enter elements in the array");
//		for(int i=0;i<n;i++)
//		{
//			arr[i]=s.nextInt();
//		}
		int lo=0;
		int hi=0;
		while(lo<arr.length)
		{
			if(arr[lo]==0) {
				lo++;
				continue;
			}
			arr[hi]=arr[lo];
			lo++;
			hi++;
		}
		while(hi<arr.length) {
			arr[hi]=0;
			hi++;
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		s.close();
	}

}
