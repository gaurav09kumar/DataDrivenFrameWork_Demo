package testData;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleSheets1 {
	WebDriver driver;

	@Test(dataProvider = "getdata1")
	public void f(String username, String password, String adminName) throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Application is loaded sucessfully");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtUsername']/following::input[1]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='txtUsername']/following::input[2]")).click();
		Thread.sleep(3000);
		String y = driver.getCurrentUrl();
		if (y == "https://opensource-demo.orangehrmlive.com/index.php/dashboard") {
			driver.findElement(By.xpath("//input[@id='3searchSystemUser_userName']")).sendKeys(adminName);
			driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		}
		Thread.sleep(2000);
	}

	@DataProvider(name = "getdata1")
	public Object passData() throws IOException {
MultipleSheets2 obj = new MultipleSheets2();

		return obj.getData("C:\\Users\\VSPICT\\DataDrivenFramework\\src\\testData\\TestData.xlsx");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VSPICT\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
