package com.crm.vtiger.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.LoginPage;

public class BaseClass2 {
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility1 jutil = new JavaUtility1();
	public WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver;

	@BeforeSuite(groups = {"smoke","Regression"})
	public void bs_config() {
		System.out.println("Database Connection establised Sucessfully");
	}

	@BeforeClass(groups = {"smoke","Regression"})
	public void bc_config() throws Throwable {
		String Browser = putil.getPropertyFileData("Browser");
		String URL = putil.getPropertyFileData("URL");
//		Runtime Polymorphism or Method overriding
		if (Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		wutil.maximizeWebPage(driver);
		wutil.implicitWait(driver);
		driver.get(URL);
	}

	@BeforeMethod(groups = {"smoke","Regression"})
	public void bm_config() throws Throwable {
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
	}
	
	@AfterMethod(groups = {"smoke","Regression"})
	public void am_config() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterClass(groups = {"smoke","Regression"})
	public void ac_config() {
		driver.quit();
	}
	
	@AfterSuite(groups = {"smoke","Regression"})
	public void as_config() {
		System.out.println("Database Connection disattached Sucessfully");
	}
}
