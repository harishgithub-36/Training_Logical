package com.training.logical;

public class TwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[]={'1','2','*','#','7','8','$','5','&','9'};
		char output1[]=new char[arr.length];
		char output2[]=new char[arr.length];
		int l=0;
		int k=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>='0' && arr[i]<='9')
			{
				output1[l++]=arr[i];
			}
			else if(!(arr[i]>64 && arr[i]<=122))
				output2[k++]=arr[i];
		}
		
		for(int i=0;i<l;i++)
			System.out.print(output1[i]+" ");
		System.out.println();
		for(int i=0;i<k;i++)
			System.out.print(output2[i]+" ");
	
		
	}

}
