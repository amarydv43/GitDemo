import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.asserts.SoftAssert;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Amar");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"alertbtn\"]")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Amar");

		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Thread.sleep(2000);
		String getAlert = driver.switchTo().alert().getText();
//		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(getAlert, "Hello Amar, Are you sure you want to confirm?");
		driver.switchTo().alert().dismiss();

	}

}
