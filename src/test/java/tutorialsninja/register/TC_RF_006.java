package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_006 {

		
		WebDriver driver = new ChromeDriver();
		
		@AfterMethod
		public void closure() {
			
			driver.quit();
			
		}

		@Test
		public void verifyRegisterWithMandatoryFields() 
		
		{
			
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.manage().window().maximize();
			
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-firstname")).sendKeys("Rutuja");
	        driver.findElement(By.id("input-lastname")).sendKeys("Chachane");
	        driver.findElement(By.id("input-email")).sendKeys(generateEmail());
	        driver.findElement(By.id("input-telephone")).sendKeys("1234567891");
	        driver.findElement(By.id("input-password")).sendKeys("12345");
	        driver.findElement(By.id("input-confirm")).sendKeys("12345");
	        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
	        driver.findElement(By.name("agree")).click();
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	        
	        
	        
	        
	        driver.findElement(By.linkText("Continue")).click();
	        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
	        
	        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='radio' and @value='0']")).isSelected());
	        
	        
		}
		
		
		public String generateEmail() 
		{
			
			  Date date = new Date();
			  
			  String email = date.toString().replace(" ", "").replace(":", "")+"@gmail.com";			  
					  
			  return email;		
			
		}
		
		
		
		
		

	}


