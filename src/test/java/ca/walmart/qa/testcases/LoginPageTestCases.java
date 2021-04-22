package ca.walmart.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ca.walmart.qa.base.TestBase;
import ca.walmart.qa.pages.HomePage;
import ca.walmart.qa.pages.LoginPage;
import ca.walmart.qa.utility.ExcelUtils;
import ca.walmart.qa.utility.UtilitiesForProject;



public class LoginPageTestCases extends TestBase  {
		LoginPage loginpage;
		HomePage homepage;
		ExcelUtils excelutils;
				//To access all methods of LoginPage throughout the class
//To call constructor from TestBase for reading properties from file
public LoginPageTestCases()  {
		super();
	}
	
@BeforeMethod
	public void setUp() {
	initialization();
	 loginpage= new LoginPage();
	 homepage= new HomePage();
	excelutils=new ExcelUtils("C:\\Users\\DIRECTOR\\eclipse-workspace\\walmartProject\\src\\main\\java\\ca\\walmart\\qa\\testdata\\ProjectTestData.xlsx", "Sheet1");
	  homepage.goToLoginPage();
	  
	 
}
@Test
	public void loginPageTitleCheck() {
	String title=loginpage.validateLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Walmart Canada");
	
}
@Test
	public void Login_TC1_FirstnameMoreThan2Char() throws Exception  {
	String fn=ExcelUtils.getStringCellData(1, 0);
	System.out.println(fn);
	loginpage.enterFirstAndLastname(fn, "");
	boolean message=loginpage.checkFnameErrorMessage();
	Assert.assertTrue(message);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC1");
	System.out.println("First name field accepted more than 2 characters");

}
@Test
	public void Login_TC2_FirstnameLessThan2Char() throws Exception  {
	String fn=ExcelUtils.getStringCellData(2, 0);
	loginpage.enterFirstAndLastname(fn, "");
	boolean errorMessage=loginpage.invalidFirstnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC2");
	Assert.assertTrue(errorMessage, "Please enter a valid First Name was not displayed");
		
}
@Test
	public void Login_TC3_FirstnameSpecialChar() throws Throwable  {
	String fn =ExcelUtils.getStringCellData(3, 0);
	loginpage.enterFirstAndLastname(fn, "");
	boolean errorMessage=loginpage.invalidFirstnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC3");
	Assert.assertTrue(errorMessage, "Please enter a valid First Name was not displayed");
		
}
@Test
public void Login_TC4_BlankFirstnameMsg() throws Throwable  {
	loginpage.enterFirstAndLastname("", "");
	boolean errorMessage=loginpage.blankFirstnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC4");
	Assert.assertTrue(errorMessage, "Please enter your First Name was not displayed");
	
}
@Test
public void Login_TC5_FirstnameErrorMsg() throws Throwable  {
	String fn = ExcelUtils.getNumericCellData(4, 0);
	loginpage.enterFirstAndLastname(fn, "");
	boolean errorMessage= loginpage.invalidFirstnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC5");
	Assert.assertTrue(errorMessage, "Please enter a valid First Name was not displayed");
	
}
@Test
public void Login_TC6_LastnameMoreThan2Char() throws Exception {
	String fn=ExcelUtils.getStringCellData(1, 0);
	String ln=ExcelUtils.getStringCellData(1, 1);
	loginpage.enterFirstAndLastname(fn, ln);
	loginpage.enterPhone("");
	boolean message=loginpage.checkLnameErrorMessage();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC6");
	Assert.assertTrue(message);
	System.out.println("Last name field accepted more than 2 characters");
	
	}
@Test
public void Login_TC7_LastnameLessthan2Char() throws Exception {
	String fn=ExcelUtils.getStringCellData(1, 0);
	String ln=ExcelUtils.getStringCellData(2, 1);
	loginpage.enterFirstAndLastname(fn, ln);
	loginpage.enterPhone("");
	boolean errorMessage=loginpage.invalidLastnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC7");
	Assert.assertTrue(errorMessage, "Please enter a valid Last Name was not displayed");
	
}
@Test
public void Login_TC8_LastnameSpecialChar() throws Exception {
	String fn=ExcelUtils.getStringCellData(1, 0);
	String ln=ExcelUtils.getStringCellData(3, 1);
	loginpage.enterFirstAndLastname(fn, ln);
	loginpage.enterPhone("");
	boolean errorMessage=loginpage.invalidLastnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC8");
	Assert.assertTrue(errorMessage, "Please enter a valid Last Name was not displayed");
	
}
@Test
public void Login_TC9_BlankLastnameMsg() throws Exception {
	String fn=ExcelUtils.getStringCellData(1, 0);
	loginpage.enterFirstAndLastname(fn, "");
	loginpage.enterPhone("");
	String errorMessage=loginpage.textOfBlankLnameMsg();
	System.out.println(errorMessage);
	Assert.assertEquals(errorMessage, "Please enter your last name.");
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC9");
}
@Test
public void Login_TC10_LastnameErrorMsg() throws Exception {
	String fn=ExcelUtils.getStringCellData(1, 0);
	String ln= ExcelUtils.getNumericCellData(4,1); 
	loginpage.enterFirstAndLastname(fn, ln);
	loginpage.enterPhone("");
	boolean errorMessage=loginpage.invalidLastnameMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC10");
	Assert.assertTrue(errorMessage, "Please enter a valid Last Name was not displayed");
}
@Test
public void Login_TC11_blankPhone() throws Exception {
	loginpage.enterPhone("");
	loginpage.enterEmail("");
	boolean errorMessage=loginpage.phoneErrorMessage();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC11");
	Assert.assertTrue(errorMessage, "Please enter a valid phone number was  displayed");
}
@Test
public void Login_TC12_Exact10Phone() throws Exception {
	String pn=ExcelUtils.getNumericCellData(1, 2);
	loginpage.enterPhone(pn);
	loginpage.enterEmail("");
	boolean errorMessage=loginpage.phoneErrorMessage();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC12");
	Assert.assertTrue(errorMessage, "Please enter a valid phone number was  displayed");
}
@Test
public void Login_TC13_Lessthan10Phone() throws Exception  {
	String pn=ExcelUtils.getNumericCellData(2, 2);
	loginpage.enterPhone(pn);
	loginpage.enterEmail("");
	boolean errorMessage = loginpage.phoneMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC13");
	Assert.assertTrue(errorMessage, "Please enter a valid phone number was not  displayed");
}
@Test
public void Login_TC14_Morethan10Phone() throws Exception  {
	//String pn=ExcelUtils.getNumericCellData(3, 2);
	loginpage.enterPhone("12345678900");
	loginpage.enterEmail("");
	boolean errorMessage = loginpage.phoneMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC14");
	Assert.assertTrue(errorMessage, "Please enter a valid phone number was not  displayed");
}
@Test
public void Login_TC15_ErrorMessagePhone() throws Exception  {
	String pn=ExcelUtils.getStringCellData(4, 2);
	loginpage.enterPhone(pn);
	loginpage.enterEmail("");
	String errorMessage=loginpage.textOfPhoneMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC15");
	Assert.assertEquals(errorMessage,"Please enter valid phone number.");
	
}
@Test
public void Login_TC16_ValidEmail() throws Exception {
	String em=ExcelUtils.getStringCellData(1, 3);
	loginpage.enterEmail(em);
	loginpage.enterPhone("");
	boolean errorMessage=loginpage.emailErrorMessage();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC16");
	Assert.assertTrue(errorMessage);
	System.out.println("Email field accepted input");
	
}
@Test
public void Login_TC17_InvalidEmail() throws Exception {
	String em=ExcelUtils.getStringCellData(2, 3);
	loginpage.enterEmail(em);
	loginpage.enterPhone("");
	boolean errorMessage=loginpage.invalidEmailMsg();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC17");
	Assert.assertTrue(errorMessage, " Please enter a valid email address was not  displayed");

}
@Test
public void Login_TC18_PasswordMoreThan6() throws Exception {
	String pw =ExcelUtils.getStringCellData(1, 4);
	loginpage.enterPassword(pw);
	loginpage.enterPhone("");
	String password=loginpage.getValueOfPassword();
	System.out.println(password);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC18");
	Assert.assertEquals(password, "tester");
	
}
@Test
public void Login_TC19_PasswordLessThan6() throws Exception  {
	String pw =ExcelUtils.getStringCellData(2, 4);
	loginpage.enterPassword(pw);
	loginpage.enterPhone("");
	boolean Message=loginpage.passwordLength();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC19");
	Assert.assertTrue(Message, "Your password must be at least 6 characters long message not displayed");
}
@Test
public void Login_TC20_EncryptPassword() throws Exception {
	String pw =ExcelUtils.getStringCellData(1, 4);
	loginpage.enterPassword(pw);
	String password=loginpage.getValueOfPassword();
	System.out.println(password);
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC20");
	Assert.assertEquals(password, "tester");
}
@Test
public void Login_TC21_ShowPassword() throws Exception  {
	String pw =ExcelUtils.getStringCellData(1, 4);
	loginpage.enterPassword(pw);
	Thread.sleep(3000);
	boolean button= loginpage.ClickOnShow();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC21");
	Assert.assertTrue(button);
}
@Test
public void Login_TC22_StrongPassword() throws Exception  {
	String pw =ExcelUtils.getStringCellData(3, 4);
	loginpage.enterPassword(pw);
	String strength= loginpage.strengthOfPassword();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC22");
	Assert.assertEquals(strength,"Password Strength: strong" );
	}

@Test
public void Login_TC23_CharAndSpecialCharPassword() throws Exception  {
	String pw =ExcelUtils.getStringCellData(4, 4);
	loginpage.enterPassword(pw);
	String strength= loginpage.strengthOfPassword();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC23");
	Assert.assertEquals(strength,"Password Strength: moderate" );
	}
@Test
public void Login_TC24_SpecialCharAndCharPassword() throws Exception {
	String pw =ExcelUtils.getStringCellData(5, 4);
	loginpage.enterPassword(pw);
	String strength= loginpage.strengthOfPassword();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC24");
	Assert.assertEquals(strength,"Password Strength: moderate" );
}
@Test
public void Login_TC25_CharacterPassword() throws Exception {
	String pw =ExcelUtils.getStringCellData(6, 4);
	loginpage.enterPassword(pw);
	String strength= loginpage.strengthOfPassword();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC25");
	Assert.assertEquals(strength,"Password Strength: weak" );
	}
@Test
public void Login_TC26_SpecialCharacterPassword() throws Exception  {
	String pw =ExcelUtils.getStringCellData(7, 4);
	loginpage.enterPassword(pw);
	String strength= loginpage.strengthOfPassword();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC26");
	Assert.assertEquals(strength,"Password Strength: weak" );
}
@Test 
public void Login_TC27_NumberPassword() throws Exception  {
	String pw =ExcelUtils.getNumericCellData(8, 4);
	loginpage.enterPassword(pw);
	String strength= loginpage.strengthOfPassword();
	UtilitiesForProject.takeScreenshotOfTest(driver, "TC27");
	Assert.assertEquals(strength,"Password Strength: weak" );
	}



@AfterMethod
public void tearDown() {
driver.quit();
}




	
	

}
