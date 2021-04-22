package ca.walmart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.pages.ShirtPage;
import ca.walmart.qa.pages.ShoePage;
import ca.walmart.qa.utility.UtilitiesForProject;


public class ShoePageTestCases extends TestBase{
	HomePage homepage;
	ShoePage shoepage;
	ShirtPage shirtpage;
	public ShoePageTestCases() {
		super();
	}
	
@BeforeMethod
public void setUp() {
	initialization();
	homepage = new HomePage();
	shoepage = new ShoePage();
	shirtpage = new ShirtPage();
}
@Test
public void Filter_TC39_NewArrival() throws Exception {
	homepage.goToShoePage();
	String result= shoepage.chooseNewArrivals();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC39");
	Assert.assertEquals(result, "New Arrivals");
}
@Test
public void Filter_TC40_CheckRatings() throws Exception {
	homepage.goToShoePage();
	String result=shoepage.chooseCustomerRatings();
	Thread.sleep(1000);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC40");
	Assert.assertEquals(result,"5 stars only");
	
}
@Test
public void Filter_TC41_CheckOnlineSaving() throws InterruptedException {
	homepage.enterTextForSearch("shirt");
	String result=shirtpage.checkOnlineSaving();
	Assert.assertEquals(result,"Clearance" );
	}
@Test
public void Filter_TC42_BestSeller() throws Exception {
	homepage.goToShoePage();
	String result=shoepage.chooseBestSeller();
	Thread.sleep(1000);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC42");
	Assert.assertEquals(result,"Bestsellers");
	
}
@Test
public void Filter_TC43_Brand() throws Exception {
	homepage.goToShoePage();
	String result= shoepage.chooseNikeBrand();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC43");
	Assert.assertEquals(result,"Nike");
} 

@Test
public void Filter_TC44_Price() throws Exception {
	homepage.goToShoePage();
	String result=shoepage.selectPriceRange();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC44");
	Assert.assertEquals(result, "$50 - $100");
}
@Test
public void Filter_TC45_Avaibility() throws Exception {
	homepage.goToShoePage();
	String result= shoepage.chooseAvaibility();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC45");
	Assert.assertEquals(result, "Scheduled order");
}
@Test
public void Filter_TC46_SoldAndShippedby() throws Exception {
	homepage.goToShoePage();
	String result=shoepage.chooseSoldAndShippedBy();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC46");
	Assert.assertEquals(result,"Sold & Shipped by Walmart");
	
}


@AfterMethod
public void tearDown() {
	driver.quit();
}




	
	
	
}
