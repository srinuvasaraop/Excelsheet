package datadriventesting;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class DataDrivenTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "testdata")
	public void loginTest(String mail, String psw, String dataprovided) {
		try {
			driver.get("https://admin-demo.nopcommerce.com/login");
			WebElement findElement = driver.findElement(By.id("Email"));
			findElement.clear();
			findElement.sendKeys(mail);
			// Thread.sleep(5000);
			WebElement findElement2 = driver.findElement(By.id("Password"));
			findElement2.clear();
			findElement2.sendKeys(psw);
			// Thread.sleep(5000);
			WebElement element = driver
					.findElement(By
							.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
			element.click();
			Thread.sleep(5000);
			String actual_title = driver.getTitle();
			String Excepected_title = "Dashboard / nopCommerce administration";
			if (dataprovided.equals("Valid")) {
				if (actual_title.equals(Excepected_title))

				{
					driver.findElement(
							By.xpath("/html/body/div[3]/nav/div/ul/li[3]/a"))
							.click();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			} else if (dataprovided.equals("Invalid")) {
				if (actual_title.equals(Excepected_title))

				{
					driver.findElement(
							By.xpath("/html/body/div[3]/nav/div/ul/li[3]/a"))
							.click();
					Assert.assertFalse(true);
				} else {
					Assert.assertFalse(false);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@DataProvider(name = "testdata")
	public String[][] getdata() throws IOException {
		/*
		 * String logindata[][] = { { "admin@yourstore.com", "admin", "Valid" },
		 * { "admin@yourstore.com", "adm", "Invalid" }, { "adm@yourstore.com",
		 * "admin", "Invalid" }, { "adm@yourstore.com", "adm", "Invalid" }};
		 */
		//String path =".\\datafiles\\loginData.xlsx";
		XLUtility xutil = new XLUtility(".\\datafiles\\loginData.xlsx");
		int totalrows = xutil.getRowCcount("Sheet1");
		int totalcols = xutil.getCellCount("Sheet1", totalrows);
		String loginData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
			loginData[i - 1][j] = xutil.getCellData("Sheet1", i, j);
			}
		}

		return loginData;
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
