package com.crm.vtiger.GenericUtility;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;

public class BatchWE10_12 {

	public static void main(String[] args) {
		char ch='A';
		System.out.println(ch);
		boolean b=true;
		System.out.println(b);
		int[] ar= {5,6,4,8,9};
		System.out.println(Arrays.toString(ar));
		String s="hai hello";
		System.out.println(s);
		String s1="";
		System.out.println(s1);
//		int i=9+2;
		System.out.println("hai"+"2");
		int a=10, a1=200;
		//a=a+a1;
		a+=a1;
		System.out.println(a);
	}

}
