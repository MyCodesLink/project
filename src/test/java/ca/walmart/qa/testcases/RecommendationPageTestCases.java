package ca.walmart.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.pages.RecommendationPage;
import ca.walmart.qa.utility.UtilitiesForProject;

public class RecommendationPageTestCases extends TestBase {

	RecommendationPage recommendationpage;
	HomePage homepage;
	public RecommendationPageTestCases() {
		super();
	}
	
@BeforeMethod
public void setUp() throws Exception {
	initialization();
	recommendationpage = new RecommendationPage();
	homepage = new HomePage();
	homepage.goToMyRecommendationPage();
	
	
}
@Test
public void MyAccount_TC61_ClickOrderHistoryLink () throws Exception {
	String heading=recommendationpage.getTitleOfHeading();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC61");
	Assert.assertEquals(heading, "Order History");
}

@Test
public void OrderHistory_TC62_SelectYear() throws Exception {
	String year=recommendationpage.verifyYearDisplayed();
	UtilitiesForProject.takeScreenshotOfTest(driver,"TC62");
	Assert.assertEquals(year, "2011");
	
}
@Test
public void OrderHistory_TC64_StartShoppingLink() throws Exception {
	recommendationpage.clickOnStartShoppingLink();
	String url=driver.getCurrentUrl();
	UtilitiesForProject.takeScreenshotOfTest(driver,"TC64");
	Assert.assertEquals(url, "https://www.walmart.ca/en");
	
}
@Test
public void MyList_TC65_ViewAndAccess() throws Exception {
	recommendationpage.goToMyAccountPage();
	recommendationpage.goToMyList();
	String url=driver.getCurrentUrl();
	UtilitiesForProject.takeScreenshotOfTest(driver,"TC65");
	Assert.assertEquals(url, "https://www.walmart.ca/en/shopping-list");
	
}
@Test
public void MyList_TC66_Searchbox() throws Exception {
	recommendationpage.goToMyAccountPage();
	recommendationpage.goToMyList();
	boolean result=recommendationpage.verifySearchBox();
	UtilitiesForProject.takeScreenshotOfTest(driver,"TC66");
	Assert.assertTrue(result);
}
@Test
public void PersonalSetting_TC69_ViewAndAccess() throws Exception {
	recommendationpage.goToMyAccountPage();
	String heading=recommendationpage.goToPersonalSettings();
	UtilitiesForProject.takeScreenshotOfTest(driver,"TC69");
	Assert.assertEquals(heading, "Profile settings");
	}
@Test
public void Signout_TC75_ViewAndAccess() throws Exception {
	recommendationpage.goToMyAccountPage();
	recommendationpage.signOut();
	String url=driver.getCurrentUrl();
	UtilitiesForProject.takeScreenshotOfTest(driver,"TC69");
	Assert.assertEquals(url,"https://www.walmart.ca/en");
	
}

@AfterMethod
public void tearDown() {
	driver.quit();
	
}

	
	
	
	
	

}
