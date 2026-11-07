package tutorialsninja.register;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_012{
	WebDriver driver = new ChromeDriver();
	
	@AfterMethod
	public void closure() {
		
		 driver.quit();
		
	}

	@Test
	public void fillFormWithTabSpaceEnterEvent() throws InterruptedException 
	
	{
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		Actions actions = new Actions(driver);
		
		
		for(int i=0;i<23;i++) {
		     actions.sendKeys(Keys.TAB).perform();

		}

		     actions.sendKeys("Varun").perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys("Dhawan").perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys(new CommonUtils().generateBrandNewEmail());
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys("12345678911").perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys("1234").perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys("1234").perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys(Keys.ARROW_LEFT).perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys(Keys.TAB).perform();
		     actions.sendKeys(Keys.SPACE).perform();
		     actions.sendKeys(Keys.RETURN).perform();
		     
		     
		     Thread.sleep(5000);
		     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),"Your Account Has Been Created!");
		           
        
	}
	
	
}
	
	
	
	
	


