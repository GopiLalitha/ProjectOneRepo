package com.leafground.elementpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class irctc {
	
	
	public static void main(String[] args) {
	 String fromaddress="//*[@class='level_1_1 col-xs-12 remove-padding jp-form']//child::span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']";
	 String toaddress="//*[@class='level_1_1 col-xs-12 remove-padding jp-form']//child::span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']";
	 String dropdown="//*[@class='level_1_1 col-xs-12 remove-padding jp-form']//child::div[@class='ui-dropdown-label-container ng-tns-c65-11']";
	 String ullist="//*[@class='level_1_1 col-xs-12 remove-padding jp-form']//child::ul[contains(@class,'ui-dropdown-items ui-dropdown-list')]";
	 
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		
		WebElement from=driver.findElement(By.xpath(fromaddress));
		wait.until(ExpectedConditions.visibilityOf(from));
		driver.findElement(By.xpath(fromaddress)).sendKeys("Erode");

		WebElement to=driver.findElement(By.xpath(toaddress));
		driver.findElement(By.xpath(toaddress)).sendKeys("chennai");

		driver.close();
	}

}
