package ca.walmart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ca.walmart.qa.base.TestBase;

public class HomePage extends TestBase {
	Actions actions= new Actions (driver);
	
	@FindBy(xpath="//input[@type='text'and @class='e1xoeh2i1 css-ymj5ct eesbt950']")WebElement Searchbox;
	@FindBy(xpath="//button[@type='submit']")WebElement SearchBtn;
	@FindBy(css="#skip-to-main > nav > ol > li:nth-child(2) > span.css-1fno8zx.e16uoh2c2")WebElement SearchResult;
	@FindBy(xpath="//p[text()='Gildan® Adult T Shirt']")WebElement GildanShirt;
	@FindBy(xpath="//span[@data-automation='sign-in-message']")WebElement SignIn;
	@FindBy(xpath="//a[@href='/create-account']")WebElement CreateAccount;
//	@FindBy(xpath="//div[contains(text(),'Best Match')]")WebElement BestMatch;
	@FindBy(xpath="//span[contains(text(),'Sign in')]")WebElement SignInBtn;
	@FindBy(id="username")WebElement UserName;
	@FindBy(id="password")WebElement Password;
	@FindBy(xpath="//button[contains(text(),'Sign in')]")WebElement Sign;
	@FindBy(xpath=" //a[contains(text(),'My recommendations')]")WebElement MyRecommendations;
	
	

public HomePage() {
		PageFactory.initElements(driver,this);
	}
public String validateSearch(String search) {
	Searchbox.sendKeys(search);
	SearchBtn.click();
	return SearchResult.getText();
	
}

public void enterTextForSearch(String txt ) {
	Searchbox.sendKeys(txt);
	SearchBtn.click();
}


public ShirtPage searchGildanShirt() {
	GildanShirt.click();
	return new ShirtPage();
}

public String verifyTextOfResult() {
	return SearchResult.getText();
}
public void signIntoAccount() throws Exception {
	actions.moveToElement(SignIn).build().perform();
	SignInBtn.click();
	Thread.sleep(2000);
	UserName.sendKeys(prop.getProperty("username"));
	Password.sendKeys(prop.getProperty("password"));
	Sign.click();
	
	
}
public LoginPage goToLoginPage() {
	 actions.moveToElement(SignIn).build().perform();
	 CreateAccount.click();
	return new LoginPage();
}
public ShoePage goToShoePage() {
	Searchbox.sendKeys("mens shoes");
	SearchBtn.click();
	return new ShoePage();
}
public LaptopPage goToLaptopPage() { 
	Searchbox.sendKeys("laptop");
	SearchBtn.click();
	return new LaptopPage();
}
public CellphonePage goToCellphonePage() {
	Searchbox.sendKeys("cellphone");
	SearchBtn.click();
	return new CellphonePage();
}

public RecommendationPage goToMyRecommendationPage() throws Exception {
	 actions.moveToElement(SignIn).build().perform();
	 SignInBtn.click();
	 Thread.sleep(9000);
	 UserName.sendKeys(prop.getProperty("username"));
	Password.sendKeys(prop.getProperty("password"));
	Sign.click();
	Thread.sleep(9000);
	actions.moveToElement(SignIn).build().perform();
	MyRecommendations.click(); 
	return new RecommendationPage();
	 
}
}
