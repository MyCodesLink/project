package ca.walmart.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.CellphonePage;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.utility.UtilitiesForProject;

public class CellphoneTestCases extends TestBase{
	HomePage homepage;
	CellphonePage cellphonepage;
	
public CellphoneTestCases() {
		super();
	}

	
	
@BeforeMethod
public void setUp() {
	initialization();
	homepage=new HomePage();
	cellphonepage = new CellphonePage();
	
}
@Test
public void Cart_TC53_ValidateCartItem() throws Exception {
	SoftAssert softassert53=new SoftAssert();
	homepage.goToCellphonePage();
	cellphonepage.addOneItemToCart();
	String result=cellphonepage.checkMessage();
	softassert53.assertEquals(result,"You have successfully updated your cart.");
	boolean image=cellphonepage.checkImageDisplay();
	softassert53.assertTrue(image);
	boolean price=cellphonepage.checkPriceDisplay();
	softassert53.assertTrue(price);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC53");
	softassert53.assertAll();
	}
@Test
public void Cart_TC54_ValidatecartPrice() throws Exception {
	SoftAssert softassert54=new SoftAssert();
	homepage.goToCellphonePage();
	cellphonepage.addMultipleItem();
	String quantity = cellphonepage.checkQuantity();
	System.out.println(quantity);
	softassert54.assertEquals(quantity, "3 items");
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC54");
	softassert54.assertAll();
}
@Test
public void Cart_TC55_ValidateCartFunctionality() throws Exception {
	homepage.goToCellphonePage();
	cellphonepage.addTwoItemToCart();
	String quantity = cellphonepage.checkQuantity();
	Assert.assertEquals(quantity, "2 items");
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC55");
	}
@Test
public void Cart_TC56_ValidateRemoveItem () throws Exception {
	homepage.goToCellphonePage();
	cellphonepage.addTwoItemToCart();
	cellphonepage.goToCartPage();
	cellphonepage.removeItem();
	String result=cellphonepage.checkCartQuantity();
	Assert.assertEquals(result,"1 item");
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC56");
}
@Test
public void Cart_TC57_ValidateRemoveAll() throws Exception {
	homepage.goToCellphonePage();
	cellphonepage.addTwoItemToCart();
	cellphonepage.goToCartPage();
	cellphonepage.removeSecondItem();
	Thread.sleep(3000);
	cellphonepage.removeItem();
	String result=cellphonepage.checkCartMessage();
	Assert.assertEquals(result,"Your shopping cart is currently empty");
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC57");
}
@Test
public void Cart_TC58_validateItemInfo() throws Exception {
	homepage.goToCellphonePage();
	cellphonepage.addOneItemToCart();
	String title=cellphonepage.checkIemDescription();
	Assert.assertEquals(title, "Samsung Galaxy A11 32GB - Crush Black - Unlocked | Walmart Canada");
}
@Test(enabled=false)
public void Cart_TC59_ValidateStatus() throws Exception {
	CellphoneTestCases cptc= new CellphoneTestCases();
	homepage.goToCellphonePage();
	cellphonepage.addOneItemToCart();
	driver.close();
	cptc.setUp();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".e1nkqonp3")).click();
	String result=cellphonepage.checkCartQuantity();
	Assert.assertEquals(result,"1 item");
	
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	
	
	

}
