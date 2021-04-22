package ca.walmart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ca.walmart.qa.base.TestBase;

public class LaptopPage extends TestBase{
	@FindBy(xpath="//button[@data-automation='sort-by-dropdown']")WebElement SortBy;
	@FindBy(xpath="//span[@data-automation='filter-facet-item-text' and contains(text(),'Newest')]")WebElement Newest;
	@FindBy(xpath="//div[contains(text(),'Newest')]")WebElement NewestResult;
	@FindBy(xpath="//span[@data-automation='filter-facet-item-text' and contains(text(),'Top Rated')]")WebElement TopRated;
	@FindBy(xpath="//div[contains(text(),'Top Rated')]")WebElement TopRatedResult;
	@FindBy(xpath="//span[@data-automation='filter-facet-item-text' and contains(text(),'Price: Low to High')]")WebElement LowToHigh;
	@FindBy(xpath="//div[contains(text(),'Price: Low to High')]")WebElement LowToHighResult;
	@FindBy(xpath="//span[@data-automation='filter-facet-item-text' and contains(text(),'Popular')]")WebElement Popular;
	@FindBy(xpath="//div[contains(text(),'Popular')]")WebElement PopularResult;
	
	public LaptopPage() {
		PageFactory.initElements(driver, this);
	}
	
public 	String sortByNewest() throws InterruptedException {
	SortBy.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Newest);
		Newest.click();
		Thread.sleep(3000);
	return NewestResult.getText();
	}
	
public String sortByTopRated() throws InterruptedException {
	SortBy.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", TopRated);
		TopRated.click();
		Thread.sleep(3000);
	return TopRatedResult.getText();
}

public String sortByLowToHigh() throws InterruptedException {
	SortBy.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", LowToHigh);
		LowToHigh.click();
		Thread.sleep(3000);
	return LowToHighResult.getText();
}	
public String sortByPopular() throws InterruptedException {
	SortBy.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Popular);
		Popular.click();
		Thread.sleep(3000);
	return PopularResult.getText();
}	
public boolean selectMoreThanOne() {
	
	SortBy.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Newest);
	Newest.click();
	  try {
		  
	       driver.findElement(By.xpath("//div[contains(text(),'Top Rated')]"));
	        System.out.println("Element Present");
	        return false;

	    } catch (NoSuchElementException e) {
	        System.out.println("Element absent");
	        return true;
	    }
}
	
	
	
	


}
