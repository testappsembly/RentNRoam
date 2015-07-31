package com.RestNRoam.RestNRoam;

import org.testng.annotations.Test;

import com.RestNRoam.*;
import com.RestNRoam.base.Page;

public class RestNRoamTest extends Page{	 

	LoginPage lp = new LoginPage();
	CreateProperty CP = new CreateProperty();


	//Sign Up as a User	 
	@Test(priority=1) 
	public void Signup() throws InterruptedException{  
		System.out.println("Sign Up as a User");   		      
		lp.OpenWebsite();
		lp.SignUp();
		Thread.sleep(8000);
		lp.VerifySignUp(); 
	}

	//Login into application
	@Test(priority=2)
	public void Login() throws InterruptedException{
		System.out.println("Login into application");
		lp.OpenWebsite();
		lp.Login();
		lp.SuccessfulLogin();
	}

	//Create Property- Apartment
	@Test(priority=3)
	public void CreatePropertyApartment() throws InterruptedException{
		System.out.println("Create Property- Apartment");
		lp.OpenLoginWebsite();
		CP.CreateApartment();
		CP.VerifyApartment();
	}

	//Create Property- House
	@Test(priority=4)
	public void CreatePropertyHouse() throws InterruptedException{
		System.out.println("Create Property- House");
		lp.OpenLoginWebsite();
		CP.CreateHouse();
		CP.VerifyHouse();
	}
	
	//Save Prices
	@Test(priority=5)
	public void CreatePropertySavePrices() throws InterruptedException{
		System.out.println("Create Property- Bed Breakfast");
		lp.OpenLoginWebsite();
		CP.CreateBedBreakfast();
		CP.VerifyBedBreakfast();
		CP.SetPricing();
	}
	

} 