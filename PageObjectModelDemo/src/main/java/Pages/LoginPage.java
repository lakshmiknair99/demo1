package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.UtilityClasss;

public class LoginPage {
	private static final String String = null;

	WebDriver driver;
	
	UtilityClasss utilityclasss=new UtilityClasss();
	
	@FindBy(xpath="//b[contains(text(),'7rmart supermarket')]")
	WebElement loginTitle;
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement usernameFld;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwrdFld;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement signInBtn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertBox;
	@FindBy(xpath="//span[contains(text(),'7rmart supermarket')]")
	WebElement dashboardHeader;
	
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginTitle()
	{
		return loginTitle.getText();
	}
	public void enterUsernameAndPw(String uname, String pw)
	{
		usernameFld.sendKeys(uname);
		passwrdFld.sendKeys(pw);
	}
	public void clickonSignInBtn()
	{
		signInBtn.click();
	}

	public String getAlertBoxText()
	{
		return alertBox.getText(); 
	}
	public boolean verifyValidLogin(String validUname, String validPw)
	{
		enterUsernameAndPw(validUname, validPw);
		clickonSignInBtn();
		//driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
		return dashboardHeader.isDisplayed();
		
	}
	public boolean verifyInvalidLogin(String invalidUname, String invalidPw)
	{
		enterUsernameAndPw(invalidUname, invalidPw);
		clickonSignInBtn();
		wait.until(ExpectedConditions.visibilityOf(alertBox));
		return alertBox.isDisplayed();
		
	}

}
