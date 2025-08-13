package pageObjects;


//BasePage==> It contains the Constructor to avoid the repeative use of  Constructor.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	
		WebDriver driver;
		
		public BasePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);//Initialize all @FindBy WebElements.
			
		}

	}


