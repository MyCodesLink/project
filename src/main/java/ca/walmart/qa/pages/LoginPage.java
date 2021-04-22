package ca.walmart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.walmart.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Page Factory or Object Repository
	@FindBy(id="firstName")WebElement firstName;
	@FindBy(id="lastName")WebElement lastName;
	@FindBy(id="phoneNumber")WebElement phonenumber;
	@FindBy(id="email")WebElement email;
	@FindBy(id="password")WebElement password;
	@FindBy(xpath="//span[text()='Please enter your first name.']")WebElement fnameMsg;
	@FindBy(xpath="//span[text()='Please enter a valid first name.']")WebElement fnameValid;
	@FindBy(xpath="//span[text()='Please enter your last name.']")WebElement lnameMsg;
	@FindBy(xpath="//span[text()='Please enter a valid last name.']")WebElement lnameValid;
	@FindBy(xpath="//span[text()='Please enter a valid email address.']")WebElement emailMsg;
	@FindBy(xpath="//span[text()='Please enter a valid phone number.']")WebElement phoneMsg;
	@FindBy(xpath="//span[text()='Your password must be at least 6 characters long.']")WebElement passwordLengthMsg;
	@FindBy(xpath="//div[@class='password-strength-label']/span")WebElement passwordStrength;
	@FindBy(css="#create-account-form > div > div:nth-child(6) > div > button > span")WebElement showBtn;
	@FindBy(xpath="//label[contains(text(),'Optional: Email me about weekly flyers,')]")WebElement Flyer;
	
	//Initializing Page Object
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	//Actions for Objects
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterFirstAndLastname(String fName,String lName) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
	}
	
	public boolean selectFlyerCheckbox() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//label[contains(text(),'Optional: Email me about weekly flyers,')]")) );
		//driver.findElement(By.xpath("//label[contains(text(),'Optional: Email me about weekly flyers,')]")).click();
		Flyer.click();
		Thread.sleep(2000);
		return Flyer.isSelected();
	}
		
	public String getValueOfPassword() {
		return password.getAttribute("value");
	}
	
	public void enterPhone(String pn) {
		phonenumber.sendKeys(pn);
	}
	public void enterEmail(String em) {
		email.sendKeys(em);
	}
	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	public boolean blankFirstnameMsg() {
		return fnameMsg.isDisplayed();
		}
	public boolean invalidFirstnameMsg() {
		return fnameValid.isDisplayed();
		}
	public boolean blankLastnameMsg() {
		return lnameMsg.isDisplayed();
		}
	public boolean invalidLastnameMsg() {
		return lnameValid.isDisplayed();
		}
	public boolean invalidEmailMsg() {
		return  emailMsg.isDisplayed();
		}
	public boolean phoneMsg() {
		return phoneMsg.isDisplayed();
		}
	public boolean passwordLength() {
		return passwordLengthMsg.isDisplayed();
		}
	public String strengthOfPassword() {
		return passwordStrength.getText();
		}
	public String textOfBlankFnameMsg() {
		return fnameMsg.getText();
	}
	public String textOfBlankLnameMsg() {
		return lnameMsg.getText();
	}
	public String textOfPhoneMsg() {
		return phoneMsg.getText();
	}
	public String textOfInvalidFnameMsg() {
				return fnameValid.getText();
	}
	public String textOfInvalidLnameMsg() {
		return lnameValid.getText();
	}
	public boolean ClickOnShow() {
		showBtn.click();
		return showBtn.isEnabled();
	}
	public boolean checkFnameErrorMessage() {
		 try {
			    driver.findElement(By.xpath("//span[text()='Please enter your first name.']"));
		        System.out.println("Element Present");
		        return false;

		    } catch (NoSuchElementException e) {
		        System.out.println("Error message was not displayed");
		        return true;
		    }
	}
	public boolean checkLnameErrorMessage() {
		 try {
			    driver.findElement(By.xpath("//span[text()='Please enter your last name.']"));
		        System.out.println("Element Present");
		        return false;

		    } catch (NoSuchElementException e) {
		        System.out.println("Error message was not displayed");
		        return true;
		    }
	}
	public boolean phoneErrorMessage() {
		 try {
			    driver.findElement(By.xpath("//span[text()='Please enter a valid phone number.']"));
		        System.out.println("Element Present");
		        return false;

		    } catch (NoSuchElementException e) {
		        System.out.println("Error message was not displayed");
		        return true;
		    }
	}
	public boolean emailErrorMessage() {
		 try {
			    driver.findElement(By.xpath("//span[text()='Please enter a valid email address.']"));
		        System.out.println("Element Present");
		        return false;

		    } catch (NoSuchElementException e) {
		        System.out.println("Error message was not displayed");
		        return true;
		    }
	}
}
