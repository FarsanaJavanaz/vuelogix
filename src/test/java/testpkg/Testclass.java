package testpkg;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import Basepkg.Baseclass;
import pagepkg.Pageclass;
import utilitypkg.Excelutilities;

public class Testclass extends Baseclass{
	Pageclass ob;
	@Test(enabled=false)
	public void loginwithvalidcredentials() throws IOException
	{
		ob=new Pageclass(driver);
		String xl="C:\\Users\\i\\Desktop\\zara.xlsx";
		String sheet="Sheet1";
		
		int rowcount=Excelutilities.getrowcount(xl,sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String number=Excelutilities.getcellvalues(xl, sheet, i, 0);
			System.out.println("number "+number);
			String passwords=Excelutilities.getcellvalues(xl, sheet, i, 1);
			System.out.println("password="+passwords);
			ob.login(number, passwords);
		}	
	}
	
	
	@Test(enabled=false)
	public void logovalidation()
	{
		boolean logo=driver.findElement(By.xpath("//*[@id=\"theme-app\"]/div/div/header/div[1]/a")).isDisplayed();
		if(logo)
		{
			System.out.println("logo present");
		}
		else
		{
			System.out.println("logo not present");
		}
	}
	
	@Test(enabled=false)
	public void buttontextvalidation()
	{
		ob=new Pageclass(driver);
		ob.button();
	}
	
	@Test(enabled=false)
	public void tiltleverification()
	{
		String title=driver.getTitle();
		System.out.println("title is"+title);
		String exp="LOG IN / CREATE ACCOUNT - ZARA India - Official Website";
		Assert.assertEquals(title, exp);
	}
	@Test(enabled=false)
	public void linksvalidation() throws IOException
	{
		List<WebElement>li=driver.findElements(By.tagName("a"));
		System.out.println("total number of links: "+li.size());
		for(WebElement ele:li)
		{
			String link=ele.getAttribute("href");
			verifylink();
		}
	}
	    private void verifylink() throws IOException {
		URL ob1=new URL(baseurl);
		HttpURLConnection con=(HttpURLConnection)ob1.openConnection();
		int responsecode=con.getResponseCode();
		if(responsecode==200)
		{
			System.out.println("succesfull links : "+baseurl);
		}
		else if(responsecode==404)
		{
			System.out.println("broken links: "+baseurl);
		}
		
	}
	
	@Test
	public void forgetpassword() throws InterruptedException
	{
	ob=new Pageclass(driver);
	ob.click();
	Thread.sleep(2000);
	}
	@Test
	public void help()
	{
		ob.help();
	}
	@Test
	public void registration()
	{
		ob.registration();	
	}
	@Test
	public void search()
	{
		ob.search();
	}
	@Test
	public void shoppingbag()
	{
		ob.shoppingbag();	
	}
	@Test(enabled=false)
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("C:\\Users\\i\\Desktop\\selinium\\login.png"));
		
		WebElement button=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div/div[1]/section/form/div[2]/button"));
		File buttonscreenshot=button.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(buttonscreenshot,new File("./screenshot/login.png"));
	}

}
