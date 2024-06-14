package pagepkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Pageclass {
	ChromeDriver driver;
	@FindBy(name="logonId")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"main\"]/article/div/div[2]/div/div[1]/section/form/div[2]/button/div")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"main\"]/article/div/div[3]/div[2]/button/span")
	WebElement logout;
	
	@FindBy(xpath="//*[@id=\"main\"]/article/div/div[2]/div/div[1]/section/a/span")
	WebElement forgetpassword;
	
	@FindBy(xpath="//*[@id=\"theme-app\"]/div/div/header/div[2]/div/a")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"main\"]/article/div/div[2]/div/div[2]/section/button/div/span")
	WebElement register;
	
	@FindBy(xpath="//*[@id=\"theme-app\"]/div/div/header/div[3]/a[1]/span")
	WebElement help;
	
	@FindBy(xpath="//*[@id=\"theme-app\"]/div/div/header/div[3]/a[2]/span[1]")
	WebElement shoppingbag;
	
	
	
	
	public Pageclass(ChromeDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String emailid, String passwords)
	{
		email.clear();
		email.sendKeys(emailid);
		password.clear();
		password.sendKeys(passwords);
		login.click();
	}
	public void logout()
	{
		logout.click();
	}
	public void button()
	{
		String act=login.getText();
		String exp="LOG IN";
		Assert.assertEquals(act, exp);
	}
	public void click()
	{
		forgetpassword.click();
		/*driver.navigate().back();
		driver.navigate().refresh();*/
	}
	public void search()
	{
		search.sendKeys("lipstick");
		/*driver.navigate().back();
		driver.navigate().refresh();*/
	}
	public void registration()
	{
		register.click();
		driver.navigate().back();
		driver.navigate().refresh();
	}
	public void help()
	{
		
		help.click();
		/*driver.navigate().back();
		driver.navigate().refresh();*/
	}
	public void shoppingbag()
	{
		shoppingbag.click();
		/*driver.navigate().back();
		driver.navigate().refresh();*/
	}
	



}
