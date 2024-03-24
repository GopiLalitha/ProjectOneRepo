package com.leafground.elementpack;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownElement {
	
	public static String elementmenu="//*[@id='menuform']//ul[@class='layout-menu']//li[@id='menuform:j_idt40']/a";
	public static String dropdownitem="//*[@id='menuform']//ul[@role='menu']//li[@role='menuitem']//span[contains(text(),'Dropdown')]";
	public static String selecttool="//*[@class='card']//h5[text()='Which is your favorite UI Automation tool?']//following::select[@class='ui-selectonemenu']";
	public static String selectcountry="//*[@class='card']//h5[text()='Choose your preferred country.']//following::div[@id='j_idt87:country']";
	public static String countryoptions="//*[@class='card']//h5[text()='Choose your preferred country.']//following::div[@id='j_idt87:country_panel']//ul";
	public static String clickcityfield="//*[@class='card']//h5[text()='Confirm Cities belongs to Country is loaded']//following::div[@id='j_idt87:city']";
	public static String selectcity="//*[@class='card']//h5[text()='Confirm Cities belongs to Country is loaded']//following::div[@id='j_idt87:city_panel']//ul";
	public static String clickselectcourse="//*[@class='card']//h5[text()='Choose the Course']//following::div[contains(@id,'j_idt87:auto-complete')]/button";
	public static String couresdropdown="//*[@class='card']//h5[text()='Choose the Course']//following::span[@id='j_idt87:auto-complete_panel']";
	
	public static void loadUrl() {
		String countryname="India";
		String[] citylist={"Banglore","Chennai","Delhi"};
		String[] getcity=new String[10];
		
		System.out.println(citylist[2]);
		System.out.println(Arrays.toString(citylist));
		
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://leafground.com/");
		driver.findElement(By.xpath(elementmenu)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownitem))).click();
		
		//Drpdown-1
		WebElement dropdwn1=driver.findElement(By.xpath(selecttool));
		Select item1=new Select(dropdwn1);
		item1.selectByIndex(2);
		
		//Dropdown-2
		WebElement dropdown2=driver.findElement(By.xpath(selectcountry));
		dropdown2.click();
		WebElement drop=driver.findElement(By.xpath(countryoptions));
		List<WebElement> lst=drop.findElements(By.tagName("li"));
		for (WebElement a : lst) {
			String b=a.getText();
			System.out.println("country:"+b);
			if(b.contains(countryname)) {
				a.click();
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickcityfield)));
		WebElement drop2=driver.findElement(By.xpath(clickcityfield));
		drop2.click();
		 WebElement citydrop =driver.findElement(By.xpath(selectcity)); 
		  List<WebElement> citys=citydrop.findElements(By.tagName("li"));
		  for(WebElement names : citys) { 
			  String c=names.getText();
			  System.out.println("City:"+c);
			  
		  }
		
	}
	
	public static void main(String[] args) {
		loadUrl();
	}

}
