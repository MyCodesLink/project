package ca.walmart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.walmart.qa.base.TestBase;

public class ShirtPage extends TestBase {
	@FindBy(xpath="//h1[text()='Gildan® Adult T Shirt']")WebElement ShirtName;
	@FindBy(xpath="//span[@class='css-s3vnpn esdkp3p2']/span")WebElement ShirtPrice;
	@FindBy(css="#main-image")WebElement ShirtImage;
	@FindBy(xpath="//div[@class='css-1n8ppzk e1sr67l90']")WebElement ShirtRating;
	@FindBy(xpath="//div[@aria-label='based on 13 reviews.']/button")WebElement ShirtReview;
	@FindBy(xpath="//div[contains(text(),'Online Savings')]")WebElement OnlineSaving;
	@FindBy(xpath="//label[@for='32']")WebElement Clearance;
	@FindBy(xpath="//div[@data-automation='selected-filter-32']")WebElement ClearanceResult;
	@FindBy(xpath="//div[contains(text(),'Reduced Price')]")WebElement ReducedPrice;
	@FindBy(xpath="//div[contains(text(),'Best Match')]")WebElement BestMatch;
	
	
	public ShirtPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkItemName() {
	return	ShirtName.isDisplayed();
		
			}
	public boolean checkItemPrice() {
		return ShirtPrice.isDisplayed();
	}
	public boolean checkItemImage() {
		return ShirtImage.isDisplayed();
	}
	public boolean checkItemRating() {
		return ShirtRating.isDisplayed();
	}
	public boolean checkItemReview() {
		return ShirtReview.isDisplayed();
	}
//	public String acessSortbyOption( ) throws InterruptedException {
//		BestMatch.click();
//		Thread.sleep(2000);
//		Newest.click();
//		return driver.findElement(By.xpath("//div[contains(text(),'Newest')]")).getText();
//			
//	}
	


	public String checkOnlineSaving() throws InterruptedException {
		OnlineSaving.click();
		Clearance.click();
		return ClearanceResult.getText();
		
				
	}

}
