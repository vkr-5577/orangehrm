package webdriver1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Orangehrm {

	WebDriver driver;


	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		//webdriver is an interface 
		//interface is a class which contains all browser implementation for  all browser
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String title= driver.getTitle();
		String url=driver.getCurrentUrl();

		System.out.println(title +"  " +url);
		Assert.assertEquals(title, "OrangeHRM");
		Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/");

	}

	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		String username =driver.findElement(By.id("txtUsername")).getAttribute("value");
		System.out.println("Print username:"+username);
		Assert.assertEquals(username, "Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		String password=driver.findElement(By.id("txtPassword")).getAttribute("value");
		System.out.println("Print password:"+password);
		Assert.assertEquals(password, "admin123");
		String login=driver.findElement(By.name("Submit")).getAttribute("value");
		System.out.println("Print Login:"+login);
		Assert.assertEquals(login, "LOGIN");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();



	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
