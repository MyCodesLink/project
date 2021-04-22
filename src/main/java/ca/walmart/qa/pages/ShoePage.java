package ca.walmart.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ca.walmart.qa.base.TestBase;
public class ShoePage extends TestBase {

@FindBy(xpath="//label[contains(text(),'Brand')]")WebElement Brand;
@FindBy(xpath="//span[contains(text(),'Nike')]")WebElement Nike;
@FindBy(xpath="//div[contains(text(),'Nike')]")WebElement NikeResult;
@FindBy(xpath="//label[contains(text(),'Price')]")WebElement Price;
@FindBy(xpath="//input[@placeholder='Min']")WebElement Minimum;
@FindBy(xpath="//input[@placeholder='Max']")WebElement Maximum;
@FindBy(xpath="//button[contains(text(),'Apply')]")WebElement ApplyBtn;
@FindBy(xpath="//div[@class='css-11krwza evego670']")WebElement PriceResult;
@FindBy(xpath="//label[contains(text(),'Availability')]")WebElement Availability;
@FindBy(xpath="//span[contains(text(),'Scheduled order')]")WebElement ScheduledOrder;
@FindBy(xpath="//div[contains(text(),'Scheduled order')]")WebElement AvailabilityResult;
@FindBy(xpath="//div[contains(text(),'Sold & Shipped by')]")WebElement SoldAndShipped;
@FindBy(xpath="//div[contains(text(),'Sold & Shipped by Walmart')]")WebElement SandSResult;
@FindBy(xpath="//label[contains(text(),'New Arrivals')]")WebElement NewArrivals;
@FindBy(xpath="//span[contains(text(),'New Arrivals')]")WebElement NewArrivalCB;
@FindBy(xpath="//div[contains(text(),'New Arrivals')]")WebElement NewArrivalResult;
@FindBy(xpath="//div[contains(text(),'5 stars only ')]")WebElement RatingResult;
@FindBy(xpath="//label[contains(text(),'Customer Rating')]")WebElement CustRating;
@FindBy(xpath="//input[@id='51']")WebElement FiveStarBtn;
@FindBy(xpath="//label[contains(text(),'Best Sellers')]")WebElement BestSeller;
@FindBy(xpath="//div[contains(text(),'Bestsellers')]")WebElement BestSellerResult;
@FindBy(xpath="//span[contains(text(),'Bestsellers')]")WebElement BestSellerCB;


public ShoePage() {
	PageFactory.initElements(driver,this);
}

public String selectPriceRange() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Price);
	Price.click();
	Minimum.sendKeys("50");
	Maximum.sendKeys("100");
	Thread.sleep(2000);
	ApplyBtn.click();
	return PriceResult.getText();
}	
public String chooseNikeBrand() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Brand);
	Brand.click();
	Nike.click();
	return NikeResult.getText();
	
}
public String chooseAvaibility() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Availability );
		Availability.click();
		ScheduledOrder.click();
		Thread.sleep(1000);
		return AvailabilityResult.getText();
	}

public String chooseSoldAndShippedBy() {
	SoldAndShipped.click();
	return SandSResult.getText();
}

public String chooseNewArrivals() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",NewArrivals );
	NewArrivals.click();
	NewArrivalCB.click();
	return NewArrivalResult.getText();
	
}
public String chooseCustomerRatings() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",CustRating );
	CustRating.click();
	FiveStarBtn.click();
	return RatingResult.getText();
	
}
public String chooseBestSeller() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",BestSeller );
	BestSeller.click();
	BestSellerCB.click();
	return BestSellerResult.getText();
}
	
}
