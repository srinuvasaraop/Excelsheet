package fileupload;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadWindows {

	public static void main(String[] args) {
		try{
			WebDriver driver;
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    driver.get("https://www.monsterindia.com/");
		    driver.findElement(By.xpath("//div/a/span[contains(text(),'Upload Resume')]")).click();
		    
		    //sendkeys("file upload") only works  html page contains <type> tag.
		  WebElement  upload=driver.findElement(By.xpath("//body/div[@id='themeDefault']/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click();", upload);
		    
		    Robot robot=new Robot();
		    robot.delay(5000);
		    StringSelection ss = new StringSelection("C:\\Users\\srinuvas\\Desktop\\dakshinamurthy stotram.pdf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
	catch(Exception e)
	{
	e.printStackTrace();	
	}
    }

}
