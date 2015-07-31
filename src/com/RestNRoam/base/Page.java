package com.RestNRoam.base;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page {

	public static WebDriver driver = null;
	public static Properties CONFIG = null;
	public static Properties OR =null;

	int i=0; int j=0; int k=0; int l=0;
	String CDT2 = null;	
	String CDT4 = null;
	String CDT6 = null;
	String CT2 = null;
	WebElement checkBox;

	public Page(){
		if(driver==null){
			//initialize the properties file
			CONFIG= new Properties();
			OR = new Properties();

			try{
				//config file path
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//com//RestNRoam//config//config.properties");
				CONFIG.load(fs);

				//OR file path
				fs = new FileInputStream(System.getProperty("user.dir")+"//src//com//RestNRoam//config//OR.properties");
				OR.load(fs);				
			}catch (Exception e){
				//error
				return;
			}

			if(CONFIG.getProperty("browser").equals("Mozilla")){
				this.driver=new FirefoxDriver();
				driver.manage().window().maximize();
			} 
			else if(CONFIG.getProperty("browser").equals("IE"))
				this.driver = new InternetExplorerDriver();
			else if(CONFIG.getProperty("browser").equals("HTML")){
				this.driver=new HtmlUnitDriver(true);
				//((HtmlUnitDriver) driver).setJavascriptEnabled(true);
				//driver.manage().window().maximize();
			}
		}
		//implicit wait for the whole application
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}			

	//----------------------------------------Click Functions----------------------------------------------

	//click function definition for element with ID as an attribute
	public void ClickID(String idKey){
		try{
			driver.findElement(By.id(OR.getProperty(idKey))).click();
		}catch(Exception e){
			// report error
		}
	}
	//click function definition for element with ID as an attribute
	public void DynamicClickID(String idKey){
		try{
			driver.findElement(By.id(idKey)).click();
		}catch(Exception e){
			// report error
		}
	}
	//click function definition for element with ID as an attribute having Dynamic ID
	public void ClickIDDynamic(String idKey){
		try{
			driver.findElement(By.id(idKey)).click();
		}catch(Exception e){
			// report error
		}
	}

	//click function definition for element with link as an attribute
	public void ClickLink(String linkKey){
		try{
			driver.findElement(By.linkText((OR.getProperty(linkKey)))).click();
		}catch(Exception e){
			// report error
		}
	}	

	//click function definition for element with link as an attribute
	public void DynamicClickLink(String linkKey){
		try{
			driver.findElement(By.linkText(linkKey)).click();
		}catch(Exception e){
			// report error
		}
	}	

	//click function definition for element with xpath as an attribute
	public void ClickXpath(String xpathKey){
		try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//click function definition for element with CSS as an attribute
	public void ClickCss(String cssKey){
		try{
			driver.findElement(By.cssSelector(OR.getProperty(cssKey))).click();
		}catch(Exception e){
			// report error
		}
	}

	//click function definition for element with name as an attribute
	public void ClickName(String nameKey){
		try{
			driver.findElement(By.name(OR.getProperty(nameKey))).click();
		}catch(Exception e){
			// report error
		}
	}

	//-------------------------------------Function to input text in text fields-------------------

	//input function definition -- By ID
	public void Input(String idkey, String text){
		try{
			driver.findElement(By.id(idkey)).sendKeys(text);
		}catch(Exception e){
			//report error
		}
	}
	//input function definition -- By Name
	public void InputName(String idkey, String text){
		try{
			driver.findElement(By.name(idkey)).sendKeys(text);
		}catch(Exception e){
			//report error
		}
	}
	
	//input function definition -- By Name
		public void InputCss(String Csskey, String text){
			try{
				driver.findElement(By.cssSelector(Csskey)).sendKeys(text);
			}catch(Exception e){
				//report error
			}
		}
		
		//input function definition -- By Name
		public void InputXpath(String Xpathkey, String text){
			try{
				driver.findElement(By.xpath(Xpathkey)).sendKeys(text);
			}catch(Exception e){
				//report error
			}
		}



	//------------------------------------Functions to clear text from text boxes----------------------------------------

	//Function to clear text from text box
	public void ClearField(String idkey){
		try{
			driver.findElement(By.id(idkey)).clear();
		}catch(Exception e){
			//report error
		}
	}

	//Function to clear text from text box by name
	public void ClearFieldName(String idkey){
		try{
			driver.findElement(By.name(idkey)).clear();
		}catch(Exception e){
			//report error
		}
	}
	
	//Function to clear text from text box by Xpath
	public void ClearFieldXpath(String Xpathkey){
		try{
			driver.findElement(By.xpath(Xpathkey)).clear();
		}catch(Exception e){
			//report error
		}
	}
	
	//Function to clear text from text box by CSS
	public void ClearFieldCSS(String Xpathkey){
		try{
			driver.findElement(By.cssSelector(Xpathkey)).clear();
		}catch(Exception e){
			//report error
		}
	}


	//--------------------------------------Functions to retrieve text from text boxes-------------------------------

	//Function to retrieve text from read-only field-- By ID
	public String GetText(String idKey){
		String text1 = null;
		try{
			text1 =driver.findElement(By.id(OR.getProperty(idKey))).getText();
		}catch(Exception e){
			//report error
		}
		return text1;
	}

	//Function to retrieve text from read-only field-- By ID
	public String GetTextDynamicID(String idKey){
		String text1 = null;
		try{
			text1 =driver.findElement(By.id(idKey)).getText();
		}catch(Exception e){
			//report error
		}
		return text1;
	}
	
	//Function to retrieve text from read-only field-- By Xpath
	public String GetTextDynamicXpath(String idKey){
		String text1 = null;
		try{
			text1 =driver.findElement(By.xpath(idKey)).getText();
		}catch(Exception e){
			//report error
		}
		return text1;
	}


	//Function to retrieve text from read-only field -- By Css
	public String GetTextCss(String cssKey){
		String text1 = null;
		try{
			text1 =driver.findElement(By.cssSelector(OR.getProperty(cssKey))).getText();
		}catch(Exception e){
			//report error
		}
		return text1;
	}

	//Function to get text from an editable field	
	public String GetEditableText(String IdKey){
		String Value=driver.findElement(By.id(OR.getProperty(IdKey))).getAttribute("value");
		return Value;
	}
	
	//Function to get text from an editable field using name	
	public String GetTextDynamicName(String NameKey){
		String Value=driver.findElement(By.name(NameKey)).getAttribute("value");
		return Value;
	}
	
	public String GetPlaceholderId(String IdKey){
		String Value = driver.findElement(By.id(IdKey)).getAttribute("placeholder");
		return Value;
	}





	//-------------------------------------Functions related to table operations-----------------------------------
	//Return the name from Xpath
	public String ReturnNameXpath(String Xpath){
		String Id=driver.findElement(By.xpath(Xpath)).getAttribute("id");
	//System.out.println(Id);
		//String Name=Id.substring(17, Id.length());
		//System.out.println(Name);
		return Id;
	}


	//-------------------------------------------Verify functions--------------------------------------------

	//Function to verify if text is present
	public boolean IsTextPresent(String text){
		try{
			boolean b = driver.getPageSource().contains(text);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	//Function to verify text
	public boolean IsTextPresentXpath(String xpathkey, String text){
		try{
			String b = driver.findElement(By.xpath(OR.getProperty(xpathkey))).getText();
			if(b.equals(CONFIG.getProperty(text))){
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			return false;
		}
	}

	//Function to verify if element is present  -- By xpath
	public boolean IsElementPresentXpath(String xpathKey){
		try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		}catch(Exception e){
			return false;			
		}
		return true;
	}	

	//Function to verify if element is present  -- By ID
	public boolean IsElementPresentId(String idKey){
		try{
			driver.findElement(By.id(idKey));
		}catch(Exception e){
			return false;

		}
		return true;
	}

	//Function to verify if element is present  -- By Link Text
	public boolean IsElementPresentLink(String linkKey){
		try{
			driver.findElement(By.linkText(OR.getProperty(linkKey)));
		}catch(Exception e){
			return false;

		}
		return true;
	}
	
	//Function to verify if element is present  -- By Link Text
	public boolean IsElementPresentLinkText(String linkKey){
		try{
			driver.findElement(By.linkText(linkKey));
		}catch(Exception e){
			return false;

		}
		return true;
	}


	//Function to verify if element is present  -- By Css Selector
	public boolean IsElementPresentCss(String cssKey){
		try{
			driver.findElement(By.cssSelector(OR.getProperty(cssKey)));
		}catch(Exception e){
			return false;

		}
		return true;
	}	

	//Function to verify Checkbox is selected   -- By ID
	public boolean VerifyCheckboxSelected(String CheckboxID){
		WebElement checkBox1 = driver.findElement(By.id(OR.getProperty(CheckboxID)));
		if(checkBox1.isSelected()){
			return true;
		}
		else
			return false;
	}
	
	//1st function to return current date and time

	public String CurrentDate1(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMMddHHmmss");   
		Date now = new Date();
		String CDT1 = sdfDate.format(now);
		if(i==0){
			CDT2=CDT1;
			i=i+1;
			return CDT2;
		}
		else
			return CDT2;	
	}

	//2nd function to return current date and time

	public String CurrentDate2(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMMddHHmmss");   
		Date now = new Date();
		String CDT3 = sdfDate.format(now);
		if(j==0){
			CDT4=CDT3;
			j=j+1;
			return CDT4;
		}
		else
			return CDT4;	
	}
	
	//-------------------------------------------------DropDown---------------------------------------------------------------------
	//Choose value from dropdown based on value
	public void ValueFromDropdownValue(String DDSource, String Value){
		Select select = new Select(driver.findElement(By.xpath(DDSource)));
		select.selectByValue(Value);
	}  
}

