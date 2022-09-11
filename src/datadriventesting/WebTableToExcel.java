package datadriventesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableToExcel {

	public static void main(String[] args) throws IOException {
		try {
			WebDriver driver;
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
			String path = ".\\datafiles\\population.xlsx";
			XLUtility xlutil = new XLUtility(path);

			// Write headers in excel sheet
			xlutil.setCellData(path, 0, 0, "Country/Dependency");
			xlutil.setCellData(path, 0, 1, "UN Region");
			xlutil.setCellData(path, 0, 2, "Population");
			xlutil.setCellData(path, 0, 3, "Percentage Of the World");
			xlutil.setCellData(path, 0, 4, "Date");
			xlutil.setCellData(path, 0, 5, "Source");
		
			// capture table rows
			WebElement table = driver
					.findElement(By
							.xpath("/html[1]/body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]"));
			int rows = table.findElements(By.xpath("tr")).size();
			for (int i = 1; i <= 5; i++) {
				String CountryDependency = table
						.findElement(By.xpath("tr["+i+"]/td[2]")).getText();
				String UNRegion = table.findElement(
						By.xpath("tr["+i+"]/td[3]")).getText();
				String Population = table.findElement(
						By.xpath("tr["+i+"]/td[4]")).getText();
				String PercentageOftheWorld = table.findElement(
						By.xpath("tr["+i+ "]/td[5]")).getText();
				String date = table.findElement(
						By.xpath("tr["+i+"]/td[6]")).getText();
				String source = table
						.findElement(By.xpath("tr["+i+"]/td[7]")).getText();
				

				System.out.println(  CountryDependency + UNRegion
						+ Population + PercentageOftheWorld + date + source);

				xlutil.setCellData("Sheet1", i, 0, CountryDependency);
				xlutil.setCellData("Sheet1", i, 1, UNRegion);
				xlutil.setCellData("Sheet1", i, 2, Population);
				xlutil.setCellData("Sheet1", i, 3, PercentageOftheWorld);
				xlutil.setCellData("Sheet1", i, 4, date);
				xlutil.setCellData("Sheet1", i, 5, source);
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
