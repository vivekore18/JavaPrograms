package Basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testcaseEBAY {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.ebay.com/");
		System.out.println(driver.getTitle());
		
		System.out.println("links in this page is :");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//footer section
		WebElement footer = driver.findElement(By.xpath(".//*[@id='glbfooter']"));
		System.out.println("links in footer sectuion :");
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//2nd col
		
		WebElement col = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		System.out.println("links in col ");
		System.out.println(col.findElements(By.tagName("a")).size());
		
		
		for(int i=0;i<col.findElements(By.tagName("a")).size();i++)
		{
			//System.out.println(col.findElements(By.tagName("a")).get(i).getText());
			if(col.findElements(By.tagName("a")).get(i).getText().contains("Site map"))
				System.out.println(driver.getTitle());
			
				col.findElements(By.tagName("a")).get(i).click();
				System.out.println(driver.getTitle());
			break;
			
		}
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("D://screenshot.png"));
		
		
		
		
		
		
		
	}

}
