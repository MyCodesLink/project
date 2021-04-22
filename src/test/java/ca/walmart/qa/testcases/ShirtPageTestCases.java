package ca.walmart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.pages.ShirtPage;
import ca.walmart.qa.utility.UtilitiesForProject;

public class ShirtPageTestCases extends TestBase {
	ShirtPage shirtpage;
	HomePage homepage;
	
public ShirtPageTestCases() {
	super();
}
@BeforeMethod
	public void setUp() {
	initialization();
	shirtpage=new ShirtPage();
	homepage =new HomePage();
}
@Test
public void Search_TC36_Result() throws Exception {
	SoftAssert assert36 = new SoftAssert();
	homepage.enterTextForSearch("shirt");
	homepage.searchGildanShirt();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC36");
	boolean itemname=shirtpage.checkItemName();
	assert36.assertTrue(itemname);
	boolean itemprice=shirtpage.checkItemPrice();
	assert36.assertTrue(itemprice);
	boolean itemimage=shirtpage.checkItemImage();
	assert36.assertTrue(itemimage);
	boolean itemreview=shirtpage.checkItemReview();
	assert36.assertTrue(itemreview);
	boolean itemrating=shirtpage.checkItemRating();
	assert36.assertTrue(itemrating);
	assert36.assertAll();
}	




@AfterMethod
	public void tearDown(){
	driver.quit();
}


}
