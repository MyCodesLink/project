package ca.walmart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.pages.LaptopPage;
import ca.walmart.qa.pages.ShoePage;
import ca.walmart.qa.utility.UtilitiesForProject;

public class LaptopPageTestCases extends TestBase{
	HomePage homepage;
	LaptopPage laptoppage;
	ShoePage shoepage;
	
public LaptopPageTestCases() {
		super();
	}
	
@BeforeMethod
public void setUp() {
	initialization();
	homepage=new HomePage();
	laptoppage=new LaptopPage();
	shoepage= new ShoePage();
}
@Test
public void Sort_TC47_Newest() throws Exception {
	homepage.goToLaptopPage();
	String result= laptoppage.sortByNewest();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC47");
	Assert.assertEquals(result, "Newest");
}
@Test
public void Sort_TC_48_Rating() throws Exception {
	homepage.goToLaptopPage();
	String result= laptoppage.sortByTopRated();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC48");
	Assert.assertEquals(result, "Top Rated");
}
@Test
public void Sort_TC_49_Price() throws Exception {
	homepage.goToLaptopPage();
	String result= laptoppage.sortByLowToHigh();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC49");
	Assert.assertEquals(result, "Price: Low to High");
}

@Test
public void Sort_TC_50_Popular() throws Exception {
	homepage.goToLaptopPage();
	String result= laptoppage.sortByPopular();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC50");
	Assert.assertEquals(result, "Popular");
}
@Test
public void Sort_TC51_SingleSelect() throws Exception {
	homepage.goToLaptopPage();
	boolean result=laptoppage.selectMoreThanOne();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC51");
	Assert.assertTrue(result);
		
}
@Test
public void SortFilter_TC52_Validate() throws Exception {
	SoftAssert softassert52 = new SoftAssert();
	homepage.goToLaptopPage();
	String filtertext=shoepage.chooseCustomerRatings();
	softassert52.assertEquals(filtertext,"5 stars only");
	String sorttext=laptoppage.sortByLowToHigh();
	softassert52.assertEquals(sorttext,"Price: Low to High" );
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC52");
	softassert52.assertAll();
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	

}
