package com.leafground.elementpack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.css.model.Value;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;

public class TextElement {
	
	public static String elementmenu="//*[@id='menuform']//ul[@class='layout-menu']//li[@id='menuform:j_idt40']/a";
	public static String textboxitem="//*[@id='menuform']//ul[@role='menu']//li[@role='menuitem']//span[contains(text(),'Text Box')]";
	public static String typetextlabel="//*[@id='j_idt88']//h5[text()='Type your name']";
	public static String typefield="//*[@id='j_idt88']//input[@id='j_idt88:name']";
	public static String appendfield="//*[@id='j_idt88']//input[@id='j_idt88:j_idt91']";
	public static String disablefield="//*[@id='j_idt88']//input[@id='j_idt88:j_idt93']";
	public static String clearfield="//*[@id='j_idt88']//input[@id='j_idt88:j_idt95']";
	public static String retrivefield="//*[@id='j_idt88']//input[@id='j_idt88:j_idt97']";
	public static String emailfield="//*[@id='j_idt88']//input[@id='j_idt88:j_idt99']";
	public static String textareafield="//*[@id='j_idt88']//textarea[@id='j_idt88:j_idt101']";
	public static String selectFont="//*[@id='j_idt88:j_idt103']//span[@class='ql-formats']//select[@class='ql-font']";
	public static String activefont="//*[@id='j_idt88:j_idt103']//span[@class='ql-picker-label ql-active']";
	public static String confirmMsg="//*[@id='j_idt106:thisform:age']";
	public static String errorMsg="//*[@id='j_idt106:thisform:j_idt110']/descendant::span[@class='ui-message-error-detail']";
	public static String hoverlabel="j_idt106:float-input";
	public static String typechoose="j_idt106:auto-complete_input";
	public static String chooseitem="//*[@id='j_idt106:auto-complete_panel']//ul";
	public static String pickerfield="//*[@id='j_idt106:j_idt116_input']";
	public static String pickertable="//*[@class='ui-datepicker-calendar']";
	
	//public static String field="//*[@id='j_idt88']//input[@id='j_idt88:']";

	
	public static void loadUrl() {
		
		
		try {
			
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://leafground.com/");
		String url=driver1.getCurrentUrl();
		String title=driver1.getTitle();
		System.out.println(">>>"+url+"***"+title);
		driver1.findElement(By.xpath(elementmenu)).click();
		
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver1,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textboxitem))).click();
		
		//typetext
		String label1=driver1.findElement(By.xpath(typetextlabel)).getText();
		if(label1.contains("Type your name")) {
			System.out.println("matched");
			boolean isenable=driver1.findElement(By.xpath(typefield)).isEnabled();
			if(isenable) {
				System.out.println(isenable);
				driver1.findElement(By.xpath(typefield)).sendKeys("Gopirajan");
			}
		}else {
			System.out.println("not matched");
		}
		
		driver1.findElement(By.xpath(appendfield)).sendKeys("tamilnadu");
		boolean isdisable=driver1.findElement(By.xpath(disablefield)).isEnabled();
		if(!isdisable) {
			System.out.println(isdisable);
		}
		
		
		driver1.findElement(By.xpath(clearfield)).clear();
		
		String retrivetext=driver1.findElement(By.xpath(retrivefield)).getAttribute("value");
		System.out.println("retrivetext:"+retrivetext);
		
		//TakesScreenshot ss=(TakesScreenshot)driver1;
		//File scrfile=ss.getScreenshotAs(OutputType.FILE);
		
			//take screenshot
			File scrFile = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile,new File("C:/Users/Lalitha Gopi/Documents/learning/Automation/SeleniumScreenshots/yad.png"));
		
		
		
		driver1.findElement(By.xpath(emailfield)).sendKeys("test@gmail.com");
		WebElement ele=driver1.findElement(By.xpath(emailfield));
		ele.sendKeys(Keys.TAB);
		
		driver1.findElement(By.xpath(textareafield)).sendKeys("Text area text 123 @#$#");
		
		/*
		 * WebElement selectfont=driver1.findElement(By.xpath(selectFont)); Select
		 * elem=new Select(selectfont); elem.selectByValue("monospace");
		 * 
		 * String getfontname1=driver1.findElement(By.xpath(activefont)).getAttribute(
		 * "data-value"); System.out.println("Ater select:"+getfontname1);
		 */
		
		WebElement msg=driver1.findElement(By.xpath(confirmMsg));
		msg.sendKeys(Keys.ENTER);
		String geterrmag=driver1.findElement(By.xpath(errorMsg)).getText();

		if(geterrmag.contains("Age is mandatory")) {
			System.out.println("Error mag displayed");
		}else {
			System.out.println("Error mag not displayed");
		}
		
		driver1.findElement(By.id(hoverlabel)).click();
		String gethoverlabel=driver1.findElement(By.id(hoverlabel)).getAttribute("class");
		if(gethoverlabel.contains("focus")) {
			System.out.println("Hover label verified");
		}else {
			System.out.println("hover label not verified");
		}
		
		/*
		 * driver1.findElement(By.name(typechoose)).sendKeys("Gopi"); WebElement
		 * wbe=driver1.findElement(By.xpath(chooseitem)); Select choosevalue=new
		 * Select(wbe); choosevalue.selectByIndex(5);
		 */
		//Select form dropdown
		  driver1.findElement(By.name(typechoose)).sendKeys("Gopi"); 
		//  WebDriverWait wait1=new WebDriverWait(driver1,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(chooseitem)));
		  WebElement ulist=driver1.findElement(By.xpath(chooseitem));
		  List<WebElement> li=ulist.findElements(By.tagName("li"));
		  for (WebElement getdata : li) {
			String aa=getdata.getAttribute("data-item-value");
			if(aa.contains("3")) {
				System.out.println(aa+" selected");
				getdata.click();
				//screen shot
				File sshot=((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(sshot,new File("C:/Users/Lalitha Gopi/Documents/learning/Automation/SeleniumScreenshots/choosefile.png"));
			}
		}

		//date picker
		driver1.findElement(By.xpath(pickerfield)).click();
		  WebElement table=driver1.findElement(By.xpath(pickertable));
		  List<WebElement> date=table.findElements(By.tagName("td")); 
		  for(WebElement add : date) { 
			  String d=add.findElement(By.tagName("a")).getText();
			  System.out.println(">>:"+d);
			  if(d.contains("4")) {
		  System.out.println(add+":date selected ");
		  add.click(); } 
		}
		 
		
		driver1.quit();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadUrl();
		
		

	}

}
