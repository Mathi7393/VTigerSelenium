package com.crm.vtiger.practice;

import com.crm.vtiger.GenericUtility.JavaUtility1;
import com.crm.vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		PropertyFileUtility putil=new PropertyFileUtility();
		String Browser = putil.getPropertyFileData("Browser");
		System.out.println(Browser);
		JavaUtility1 JU=new JavaUtility1();
		int random=JU.getRandom();
		System.out.println(random);
		String DateTime=JU.getSysDate();
		System.out.println(DateTime);
		String CurrentDate=JU.getModifiedDate();
		System.out.println(CurrentDate);
	}

}
