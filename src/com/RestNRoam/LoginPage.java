package com.RestNRoam;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.RestNRoam.base.Page;

public class LoginPage extends Page {

	//passing the website url in the browser
	public void OpenWebsite(){	  
		driver.get(CONFIG.getProperty("Website_URL")); 		
	}	

	//Basic Login Function
	public void Login() throws InterruptedException{
		WebElement LoginButton = driver.findElement(By.cssSelector(".login>a"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", LoginButton);
		WebElement Email = driver.findElement(By.id("email_id"));
		jse.executeScript("arguments[0].value = arguments[1];",Email, CONFIG.getProperty("LoginUsername"));
		WebElement Password = driver.findElement(By.id("password"));
		jse.executeScript("arguments[0].value = arguments[1];",Password, CONFIG.getProperty("LoginPassword"));
		ClickCss("loginButton");	   
		
	} 	

	//Verifying Successful Login
	public void SuccessfulLogin(){
		if(!IsElementPresentCss("signUpButton")){
			Assert.assertTrue(true);
		}
		else{			
			Assert.fail();				
		}
	}


	//Close Browser
	public void CloseBrowser(){
		driver.quit();
	}

	public void SignUp() {
		ClickCss("signUpButton");
		Input(OR.getProperty("firstName"), CONFIG.getProperty("FirstName"));
		Input(OR.getProperty("lastName"), CONFIG.getProperty("LastName"));
		Input(OR.getProperty("emailAddress"), CurrentDate1()+"@Tester.com");
		Input(OR.getProperty("mobileNumber"), CONFIG.getProperty("MobileNo"));
		Input(OR.getProperty("password"), CONFIG.getProperty("Password"));
		Input(OR.getProperty("confirmPassword"), CONFIG.getProperty("Password"));
		ClickCss("signupButton");
	}

	public void VerifySignUp() {
		if(IsElementPresentCss("signUpButton")){
			Assert.fail();
						
		}
		else{			
			Assert.assertTrue(true);				
		}
	}

	public void OpenLoginWebsite() {
		driver.get(CONFIG.getProperty("Login_Website_URL"));		
	}

}
