package ca.walmart.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.walmart.qa.base.TestBase;

public class RecommendationPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'People with similar interests also bought:')]")WebElement Title;
	@FindBy(xpath="//a[contains(text(),'Order History ')]")WebElement OrderHistory;
	@FindBy(id="view-orders-from-label")WebElement ViewOrder;
	@FindBy(xpath="//option[@aria-label='2011']")WebElement Year;
	@FindBy(xpath="//h1[@aria-label='Order History']")WebElement Heading;
	@FindBy(xpath="//a[contains(text(),'Start shopping!')]")WebElement StartShopping;
	@FindBy(css="#my-account-nav > section:nth-child(1) > ul > li.mobile-hide > a")WebElement MyAccount;
	@FindBy(css="#my-account-nav > section:nth-child(1) > ul > li:nth-child(6) > a")WebElement PersonalSettings;
	@FindBy(xpath="//div[contains(text(),'Create or edit your shopping lists.')]")WebElement Lists;
	@FindBy(name="embedded-search-form-input")WebElement SearchBox;
	@FindBy(css="#skip-to-main > h1")WebElement ProfileHeading;
	@FindBy(css="#my-account-nav > section:nth-child(1) > ul > li:nth-child(9) > a")WebElement SignOut;
	public RecommendationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleOfCategory() {
		return Title.getText();
	}
	
	public String getTitleOfHeading() throws InterruptedException {
		
		OrderHistory.click();
		Thread.sleep(2000);
		return Heading.getText();
		
	}
	public String verifyYearDisplayed() {
		OrderHistory.click();
		ViewOrder.click();
		return Year.getText();
	}
	public void clickOnStartShoppingLink() throws Exception {
		OrderHistory.click();
		Thread.sleep(2000);
		StartShopping.click();
		
	}
	public void goToMyAccountPage() {
		MyAccount.click();
			
	}
	public void goToMyList() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Lists );
		Lists.click();
	}
	public boolean verifySearchBox() {
		return SearchBox.isDisplayed();
	}
	public String goToPersonalSettings() {
		PersonalSettings.click();
		return ProfileHeading.getText();
	}
	public void signOut() {
		SignOut.click();
	}
}
