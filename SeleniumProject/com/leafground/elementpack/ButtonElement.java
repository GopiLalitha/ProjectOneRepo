package com.leafground.elementpack;

import java.awt.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonElement {
	
	public static String elementmenu="//*[@id='menuform']//ul[@class='layout-menu']//li[@id='menuform:j_idt40']/a";
	public static String buttonitem="//*[@id='menuform']//ul[@role='menu']//li[@role='menuitem']//span[contains(text(),'Button')]";
	public static String button="//*[@id='j_idt88:j_idt90']";
	public static String disablebutton="//*[@id='j_idt88:j_idt92']";
	public static String submitbtn="//*[@id='j_idt88:j_idt94']";
	
	//public static String ="//*[@id='j_idt88:j_idt90']";
	
	public static void loadUrl() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://leafground.com/");
		driver.findElement(By.xpath(elementmenu)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonitem))).click();
		
		driver.findElement(By.xpath(button)).click();
		String title=driver.getTitle();
		System.out.println(title);
		driver.navigate().back();
		
		boolean isdisable=driver.findElement(By.xpath(disablebutton)).isEnabled();
		System.out.println(isdisable);
		
		WebElement submit=driver.findElement(By.xpath(submitbtn));
		System.out.println("Position:"+submit.getLocation());
		
		driver.close();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadUrl();

	}

}
