package com.qsp.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qsp.objectrepository.HomePage;
import com.qsp.objectrepository.LoginPage;
import com.qsp.objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	
	public FileUtility fileLib;
	public ExcelUtility excelLib;
	public JavaUtility javaLib;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		fileLib=new FileUtility();
		String url = fileLib.getDataFromProperty("url");
		driver.get(url);
	}
	@BeforeMethod
	public void login() throws IOException {
		wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		lp=new LoginPage(driver);
		String email = fileLib.getDataFromProperty("email");
		String password = fileLib.getDataFromProperty("password");
		lp.getEmailTextField().sendKeys(email);
		lp.getPasswordTextField().sendKeys(password);
		lp.getLoginButton().click();
	}
	@AfterMethod
	public void logout() {
		hp=new HomePage(driver);
		hp.getLogoutLink().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
