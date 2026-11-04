package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_007 {
	
	 WebDriver driver = new ChromeDriver();
	
    @AfterMethod
	public void closure() 
    {
		driver.quit();
    	
    	
	}
	
	@Test
	public void navigateResgisterAccountPage() 
	{
		
		  
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      driver.get("https://tutorialsninja.com/demo/");
	      
	      driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	      driver.findElement(By.linkText("Register")).click();
	      Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
	      
	      driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	      driver.findElement(By.linkText("Login")).click();
	      driver.findElement(By.linkText("Continue")).click();
	      Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
	      
	     driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	     driver.findElement(By.linkText("Login")).click(); 
	     driver.findElement(By.linkText("Register")).click();
	     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
	     
		
		
	}
	
	
	
	
	
	
}
