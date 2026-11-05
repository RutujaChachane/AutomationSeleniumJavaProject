package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class TC_RF_008 {

WebDriver driver = new ChromeDriver();
	
	@AfterMethod
	public void closure() {
		
		driver.quit();
		
	}

	@Test
	public void verifyRegisterWithMandatoryFields() 
	
	{
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Rutuja");
        driver.findElement(By.id("input-lastname")).sendKeys("Chachane");
        driver.findElement(By.id("input-email")).sendKeys("kkmm@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567891");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("abcde");
        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        String p = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
        Assert.assertEquals(p, "Password confirmation does not match password!");
        
        
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
