package seleniumpack;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		String title;
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chromr.driver","C:\\Automation testing\\SeleniumJava\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.toolsqa.com/");
		title=driver.getTitle();
		System.out.println(title);
		String getbtn=driver.findElement(By.xpath("//*[@class='navbar__tutorial-menu']//span[@class='navbar__tutorial-menu--text']")).getText();
		boolean isbtn=driver.findElement(By.xpath("//*[@class='navbar__tutorial-menu']//span[@class='navbar__tutorial-menu--text']")).isDisplayed();
		if(isbtn) {
			System.out.println("Button displayed"+getbtn);
		}else {
			System.out.println("Button not displayed"+getbtn);
		}
		//menu
		List<WebElement> menulist=driver.findElements(By.xpath("//*[@class='col-auto']//ul//li"));
		int count=menulist.size();
		System.out.println(count);
		for(int i=1;i<=count;i++) {
			String tabs=driver.findElement(By.xpath("//*[@class='col-auto']//ul//li["+i+"]//a")).getText();
			System.out.println(tabs);
			if(tabs.contains("DEMO SITE")) {
				driver.findElement(By.xpath("//*[@class='col-auto']//ul//li["+i+"]//a")).click();
				//window handles
				String parentwindow=driver.getWindowHandle();
				System.out.println(parentwindow);
				Set<String> allwindows=driver.getWindowHandles();
				for(String childwindow:allwindows) {
					System.out.println(">>>"+childwindow);
					if(!parentwindow.equalsIgnoreCase(childwindow)) {
						driver.switchTo().window(childwindow);
						System.out.println("Child window:"+driver.getTitle());
						//driver.close();
					}
					
				}
			}
			driver.switchTo().defaultContent();

		}
		driver.close();
		//driver.quit();
	}

}
