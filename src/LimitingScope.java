import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
		WebElement footerDriver  = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		int footerlinks = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footerlinks);
		
		WebElement coloumndriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		for(int i=1; i<coloumndriver.findElements(By.tagName("a")).size(); i++)
		{
		String ClickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonLinkTab);
		Thread.sleep(2000);
		
			}
		
	//4. Get the Open Windows Title 
	    Set<String>	abc = driver.getWindowHandles();
	    Iterator<String> it =abc.iterator();
	    
	    while (it.hasNext())
	    {
	    	driver.switchTo().window(it.next());
	    System.out.println(driver.getTitle());
	Thread.sleep(1000);

	    }
	}

}

