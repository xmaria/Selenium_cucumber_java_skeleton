package CucumberTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


public class LoginPage {
	public static WebDriver driver=null;
	static  By loginFormLocator=By.id("login_form");
	static By usernameLocator= By.id("email");
	static  By passwordLocator= By.id("pass");
	static  By loginLocator= By.id("loginbutton");
	static By homePageLocator= By.cssSelector("[data-click='home_icon'] a");
	static  By userNavigationLocator= By.id("userNavigationLabel");
	static By logoutLocator= By.xpath("//span[contains(text(),'Log Out')]");
	static Actions action=null;
	
	
	public static void launchUrl() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	}
	
	
	public static void verifyLoginPageLoads() {
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(loginFormLocator));
		
	}
	
	
	public static void enterLoginCreds() {
		WebElement userName= driver.findElement(usernameLocator);	
		WebElement password= driver.findElement(passwordLocator);
		action= new Actions(driver);
		
		userName.clear();
		userName.sendKeys("*********");
		password.clear();
		password.sendKeys("*********");
		action.sendKeys(Keys.RETURN);
		action.perform();
		
	}
	
	public static void clickButton(String arg) throws Exception {
		
		By matchLocator=null;
		
		switch(arg){
		case "LogIn":
			matchLocator= loginLocator;
			break;
			
		case "Navigation toolbar":
			matchLocator= userNavigationLocator;
			break;
			
		case "Logout":
			matchLocator= logoutLocator;
			break;
		
		default:
			System.out.println("Invalid button or link");
			throw new Exception("Invalid button or link");
			
		}
		
		WebElement locator= driver.findElement(matchLocator);
		locator.click();	
		
	}
	
		
	public static void verifyHomePageLoads() {
		WebDriverWait wait= new WebDriverWait(driver,10);
		WebElement homePage= wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLocator));
		System.out.println("Checking for home page");
		String homeText=homePage.getText();
		
		assertEquals(homeText,"Home");
		System.out.println("Home assert passed");
	}
	
	
		public static void teardown(){
		driver.close();
		
		}



}
