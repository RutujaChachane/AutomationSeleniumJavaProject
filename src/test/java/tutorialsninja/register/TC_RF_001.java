package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_RF_001 {
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
        driver.findElement(By.id("input-email")).sendKeys(generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567891");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),"Your Account Has Been Created!");
        
        String confirmationMessage = driver.findElement(By.xpath("//div[@id='content']")).getText();
        
        softAssert.assertEquals("confirmationMessage",confirmationMessage.contains("Congratulations! Your new account has been successfully created!"));
        softAssert.assertEquals("confirmationMessage",confirmationMessage.contains("You can now take advantage of member privileges to enhance your online shopping experience with us."));
        softAssert.assertEquals("confirmationMessage",confirmationMessage.contains("If you have ANY questions about the operation of this online shop, please e-mail the store owner.\n"
        		+ "\n"
        		+ ""));
        softAssert.assertEquals("confirmationMessage",confirmationMessage.contains("A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us."));
        
        driver.findElement(By.linkText("Continue")).click();
        
        softAssert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
	}
	
	
	public String generateEmail() 
	{
		
		  Date date = new Date();
		  
		  String email = date.toString().replace(" ", "").replace(":", "")+"@gmail.com";			  
				  
		  return email;		
		
	}
	
	
	
	
	

}
