package webdriver1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class gurudemo {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}
	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("vishal");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("vishal@123");
		driver.findElement(By.xpath("//*[@name='submit']")).click();
		Thread.sleep(3000);
		String hd=driver.findElement(By.xpath("//tbody/tr/td/h3")).getText();
		Assert.assertEquals(hd,"Login Successfully");
		//System.out.println(hd);
		driver.findElement(By.linkText("Flights")).click();
		//driver.findElement(By.partialLinkText("Car")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();
		WebElement dd=driver.findElement(By.name("passCount"));
		Select sel1=new Select(dd);
		sel1.selectByVisibleText("1");
		Thread.sleep(3000);
		sel1.selectByIndex(2);
		Thread.sleep(3000);
		sel1.selectByValue("3");
		
		WebElement dd1 = driver.findElement(By.name("fromPort"));
		Select sel2= new Select(dd1);
		List<WebElement> values=sel2.getOptions();
		System.out.println(values.size());
		for(int i=0;i<values.size(); i++)
		{
			System.out.println(values.get(i).getText());
			
		}
		sel2.selectByValue("London");
		WebElement First = sel2.getFirstSelectedOption();
		System.out.println(First.getAttribute("value"));
	
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
