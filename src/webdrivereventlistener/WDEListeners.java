package webdrivereventlistener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {

	public static void main(String[] args) {
		String baseUrl = "https://www.expedia.com/";
		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		HandleEvents he = new HandleEvents();
		edriver.register(he);
		edriver.get(baseUrl);
		edriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div/div/div/ul/li[2]/a/span")).click();
	}

}
