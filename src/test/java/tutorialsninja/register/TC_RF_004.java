package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_RF_004 {
	
	
    @Test
	public void checkWarningMessages() {
		
		
		   WebDriver driver = new ChromeDriver();
		   driver.get("https://tutorialsninja.com/demo/");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   
		   driver.findElement(By.xpath("//span[text()='My Account']")).click();
		   driver.findElement(By.linkText("Register")).click();
		   
		   driver.findElement(By.xpath("//input[@value='Continue']")).click();
		   
		   
		   SoftAssert softAssert = new SoftAssert();
		   
		   softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),"Warning: You must agree to the Privacy Policy!");
		   
		   
		   WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"));
		   
		   softAssert.assertEquals(firstName.getText(), "First Name must be between 1 and 32 characters!");
		
		   
		   
           WebElement lastName = driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']"));
		   
		   softAssert.assertEquals(lastName.getText(), "Last Name must be between 1 and 32 characters!");
		   
		   
           WebElement email = driver.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']"));
		   
		   softAssert.assertEquals(email.getText(), "E-Mail Address does not appear to be valid!");
		   
		   
           WebElement telephn = driver.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']"));
		   
		   softAssert.assertEquals(telephn.getText(), "Telephone must be between 3 and 32 characters!");
		   
		   
		   
           WebElement password = driver.findElement(By.xpath("//div[text()='Password must be between 4 and 20 characters!']"));
		   
		   softAssert.assertEquals(password.getText(), "Password must be between 4 and 20 characters!");
		   		   
		   
		   
		   driver.quit();
		
		   softAssert.assertAll();
		
		
		
		
		
		
		
	}	
	
}
