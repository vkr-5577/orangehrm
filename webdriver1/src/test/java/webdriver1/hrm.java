package webdriver1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class hrm {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void f() throws InterruptedException {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		//		List<WebElement> link=driver.findElements(By.tagName("a"));
		//		//for(int i=0;i<link.size();i++)
		//		//{
		//		////	System.out.println(link.get(i).getText());
		//		//}
		//		//For enhanced loop
		//		for(WebElement e:link)
		//		{
		//			String alllink=e.getText();
		//			System.out.println(alllink);
		//		}
		//		Thread.sleep(5000);
		driver.findElement(By.linkText("PIM")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().to("https://www.google.com");
		//Thread.sleep(5000);
		//driver.findElement(By.partialLinkText("Welcome")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
