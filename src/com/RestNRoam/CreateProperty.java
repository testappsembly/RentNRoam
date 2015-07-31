package com.RestNRoam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.RestNRoam.base.Page;

public class CreateProperty extends Page{
	
	public void CreateApartment() throws InterruptedException{
		ClickID("Apartment");
		ClickXpath("PrivateRoom");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement City = driver.findElement(By.id("citiesInput"));
		jse.executeScript("arguments[0].value = arguments[1];",City, CONFIG.getProperty("CityBanglore"));
		//InputXpath(OR.getProperty("city"), CONFIG.getProperty("CityBanglore"));
		Thread.sleep(5000);
		ValueFromDropdownValue(OR.getProperty("TotalGuest"), CONFIG.getProperty("TotalGuest"));
		ClickXpath("Continue");
	}
	
	public void CreateHouse() throws InterruptedException{
		ClickID("House");
		ClickXpath("SharedRoom");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement City = driver.findElement(By.id("citiesInput"));
		jse.executeScript("arguments[0].value = arguments[1];",City, CONFIG.getProperty("CityMumbai"));
		//InputXpath(OR.getProperty("city"), CONFIG.getProperty("CityMumbai"));
		Thread.sleep(5000);
		ValueFromDropdownValue(OR.getProperty("TotalGuest"), CONFIG.getProperty("TotalGuest"));
		ClickXpath("Continue");
	}

	public void VerifyApartment() {
		if(IsTextPresentXpath("ListingHeader","VerifyApartmentBanglore")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}
	
	public void VerifyHouse() {
		if(IsTextPresentXpath("ListingHeader","VerifyHouseMumbai")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
	}

	public void CreateBedBreakfast() throws InterruptedException {
		ClickID("BedBreakfast");
		ClickXpath("EntireApartment");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement City = driver.findElement(By.id("citiesInput"));
		jse.executeScript("arguments[0].value = arguments[1];",City, CONFIG.getProperty("CityKashmir"));
		Thread.sleep(5000);
		ValueFromDropdownValue(OR.getProperty("TotalGuest"), CONFIG.getProperty("TotalGuest"));
		ClickXpath("Continue");
		
	}

	public void VerifyBedBreakfast() {
		if(IsTextPresentXpath("ListingHeader","VerifyHouseMumbai")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
		
	}

	public void SetPricing() throws InterruptedException {
		ClickXpath("Pricing");
		Thread.sleep(5000);
		String DailyPrice=GetPlaceholderId(OR.getProperty("Season1Daily"));
		System.out.println(DailyPrice);
		String WeeklyPrice=GetPlaceholderId(OR.getProperty("Season1Weekly"));
		System.out.println(WeeklyPrice);
		String MonthlyPrice=GetPlaceholderId(OR.getProperty("Season1Monthly"));
		System.out.println(MonthlyPrice);
		String WeekendPrice=GetPlaceholderId(OR.getProperty("Season1Weekend"));
		System.out.println(WeekendPrice);
	}
}
