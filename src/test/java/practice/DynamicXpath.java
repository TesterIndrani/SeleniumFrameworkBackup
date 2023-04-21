package practice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicXpath {

		public static void main(String[] args) throws Throwable {

			EdgeDriver driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        driver.get("https://www.makemytrip.com/flights/");
	        driver.findElement(By.xpath("//span[text()='Departure']")).click();
	        
	        Thread.sleep(1000);

	        String month = "April 2023";
	        String date = "30";

	driver.findElement(By.xpath("//div[text()='"+month+"']"
			+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	//Note: making month and date as variable and creating Dynamic xpath 
	
		}

	}

