package ca.walmart.qa.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.pages.ShirtPage;
import ca.walmart.qa.utility.UtilitiesForProject;





public class HomePageTestCases extends TestBase {
	HomePage homepage;
	ShirtPage shirtpage;
	Actions actions;
public HomePageTestCases() {
		super();
	}
@BeforeMethod
	public void setUp() {
	initialization();
	homepage=new HomePage();
	shirtpage=new ShirtPage();
	actions=new Actions(driver);
	}
@Test
public void Login_TC31_signinYouraccount() throws Exception {
	homepage.signIntoAccount();
	String url=driver.getCurrentUrl();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC32");
	Assert.assertEquals(url, "https://www.walmart.ca/sign-in?from=%2Fen");
	
	}

@Test
	public void Search_TC32_KeywordSearch () throws Exception  {
	String result=homepage.validateSearch("health");
	Thread.sleep(2000);	
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC32");
	Assert.assertEquals(result,"Search: health");
		
			}
@Test
	public void Search_TC33_DescriptionText() throws Exception {
	String result=homepage.validateSearch("shirts for mens");
	Thread.sleep(2000);	
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC33");
	Assert.assertEquals(result,"Search: shirts for mens");
}

@Test
	public void Search_TC34_ItemNumber() throws Exception {
	String result=homepage.validateSearch("1019194");
	Thread.sleep(2000);	
	homepage.enterTextForSearch("1019194");
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC34");
	Assert.assertEquals(result,"Search: 1019194" );
	
}
@Test
	public void Search_TC35_PartialitemNumber() throws Exception {
	String result=homepage.validateSearch("101919");
	Thread.sleep(2000);	
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC35");
	Assert.assertEquals(result,"Search: 101919" );
	
}

@Test
public void Search_TC37_PageItemCount() throws Exception {
	homepage.enterTextForSearch("shirt");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	Thread.sleep(3000);
	List <WebElement>list= driver.findElements(By.xpath("//button[contains(text(),'Choose options')]"));
	int a = list.size();
	List <WebElement>list1= driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
	int b= list1.size();
	int totalCount=a+b;
	System.out.println(totalCount);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC36");
	Assert.assertEquals(totalCount,60);
	
	}
@Test
public void Access_TC60_RecommendationPage() throws Exception {
	homepage.goToMyRecommendationPage();
	Thread.sleep(15000);
	String url = driver.getCurrentUrl();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC60");
	Assert.assertEquals(url,"https://www.walmart.ca/my-account/recommendations");
	
}






@AfterMethod
	public void tearDown() {
	driver.quit();
	}	
	
	
}
