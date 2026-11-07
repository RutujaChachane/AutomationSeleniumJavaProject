package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_011 {
	WebDriver driver = new ChromeDriver();
	
	@AfterMethod
	public void closure() {
		
		driver.quit();
		
	}

	@Test
	public void verifyValidPhoneNumberField() throws InterruptedException 
	
	{
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Rutuja");
        driver.findElement(By.id("input-lastname")).sendKeys("Chachane");
        driver.findElement(By.id("input-email")).sendKeys(generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("abcd");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),"Your Account Has Been Created!");
        System.out.println("It is a Bug");
        
	}
	
	
	public String generateEmail() 
	{
		
		  Date date = new Date();
		  
		  String email = date.toString().replace(" ", "").replace(":", "")+"@gmail.com";			  
				  
		  return email;		
		
	}
	
	
	
	
	

}
