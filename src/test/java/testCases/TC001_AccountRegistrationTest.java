package testCases;

//Implementation for the =--->TC001_AccountRegistrationPage.

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
//import testBase.BaseClass;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on MyAccount ****");
		hp.clickRegister();
		logger.info("***** Clicked on Register Link ****");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		
		logger.info("Providing customer details..........");
		
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		
//		regpage.setEmail("xyyzz@gmail.com");
		regpage.setEmail(randomString()+"@gmail.com");
		
		regpage.setTelephone(randomString());
		
		String password = randomAlphaNUmeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		logger.info("=========Validating Expected message-------");
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
		
		
	}
	
	
	
}
