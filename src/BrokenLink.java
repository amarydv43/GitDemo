import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*
		String url = driver.findElement(By.xpath("//a[text()='SoapUI']")).getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respcode =	conn.getResponseCode();
		System.out.println(respcode);
		
		*/
		
		
SoftAssert a = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class= 'gf-li']/a"));
		
		for(WebElement link:links)
			
		{
			String Url = link.getAttribute("href");
			
			HttpURLConnection conn1 = (HttpURLConnection) new URL(Url).openConnection();
			
			conn1.setRequestMethod("HEAD");
			conn1.connect();
			
			int respCode = conn1.getResponseCode();
			System.out.println(respCode);
			
			a.assertTrue(respCode<400,"The link with Text"+link.getText()+" is broken with code" +respCode );
			
		}
		a.assertAll();



	}

}
