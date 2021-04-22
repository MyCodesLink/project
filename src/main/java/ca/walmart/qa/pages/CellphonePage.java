package ca.walmart.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ca.walmart.qa.base.TestBase;

public class CellphonePage extends TestBase  {
@FindBy(css="img[alt='Samsung Galaxy A11 32GB - Crush Black - Unlocked']")WebElement PhoneImg;	
@FindBy(xpath="//span[@data-automation='atcmodal-price']")WebElement PhonePrice;
@FindBy(xpath="//button[contains(text(),'Add to cart')]")	WebElement AddToCartBtn;
@FindBy(css="#atc-root > div.css-k87n7e.elsmchb1 > div.css-8atqhb.elsmchb4 > div > div.css-1m7agb8.elsmchb5 > img")WebElement CartImage;
@FindBy(css="#atc-root > div.css-q5jqi5.elsmchb3 > div.css-1kkxwdu.elsmchb10")WebElement Message;	
@FindBy(xpath="//button[@data-automation='increase-qty']")WebElement AddBtn;	
@FindBy(css="#atc-root > div.css-k87n7e.elsmchb1 > div.css-j8zhxy.elsmchb11 > div.css-22gbgz.elsmchb14")WebElement SubTotal;	
@FindBy(css="#atc-root > div.css-k87n7e.elsmchb1 > div.css-j8zhxy.elsmchb11 > div.css-1nqkqc7.elsmchb15")WebElement Quantity;	
@FindBy(xpath="//button[contains(text(),'Continue Shopping')]")WebElement ContinueShopping;
@FindBy(xpath="//button[contains(text(),'Checkout')]")WebElement CheckOut;
@FindBy(css="#\\36 000201761094 > div:nth-child(2) > div.css-hxnh9q.ei50f4d20 > button > span")WebElement Remove;
@FindBy(css="#DC7671DDD38449909F39FB5381C7B02D > div:nth-child(2) > div.css-hxnh9q.ei50f4d20 > button > span")WebElement Remove2;
@FindBy(css="#product-results > div:nth-child(5) > div > a > div > div.css-1b5wmcr.epettpn2 > img")WebElement PhoneImg2;
@FindBy(xpath="//span[contains(text(),'1 item')]")WebElement CartQuantity;
@FindBy(xpath="//span[contains(text(),'Your shopping cart is currently empty')]")WebElement CartMessage;
@FindBy(css=".e1nkqonp3")WebElement Cart;
@FindBy(css="#\\36 000201761094 > div:nth-child(1) > div.css-e5r8f1.ei50f4d10 > a")WebElement Description;
	public CellphonePage() {
		PageFactory.initElements(driver, this);
	}
public void addOneItemToCart() throws InterruptedException {
	PhoneImg.click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",AddToCartBtn );
	AddToCartBtn.click();
		}
public void addTwoItemToCart() throws InterruptedException {
	PhoneImg.click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",AddToCartBtn );
	AddToCartBtn.click();
	ContinueShopping.click();
	driver.navigate().back();
	PhoneImg2.click();
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("arguments[0].scrollIntoView();",AddToCartBtn );
	AddToCartBtn.click();
	driver.navigate().back();
}
public void addMultipleItem() throws Exception {
	PhoneImg.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",AddBtn );
	Thread.sleep(7000);
	AddBtn.click();
	AddBtn.click();
	AddToCartBtn.click();
}
public void goToCartPage() {
	Cart.click();
}
public void removeItem() {
	 Remove.click();
}
public void removeSecondItem() {
	Remove2.click();
}
public String checkCartMessage() {
	return CartMessage.getText();
}

public String checkMessage() {
	return Message.getText();
}
public boolean checkImageDisplay() {
	return CartImage.isDisplayed();
}
public boolean checkPriceDisplay() {
	return PhonePrice.isDisplayed();
}
public void addQuantity() {
	AddBtn.click();
}
public String checkCartQuantity() {
	 return CartQuantity.getText();
}
public String checkSubtotal() {
	return SubTotal.getText();
}
public String  checkQuantity() {
	return Quantity.getText();
}
public String checkIemDescription() {
	CheckOut.click();
	Description.click();
	return driver.getTitle();
}
}
