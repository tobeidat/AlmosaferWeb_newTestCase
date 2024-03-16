package almosaferNewTestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends parameters {
	@BeforeTest
	public void setup() {
		driver.manage().window().maximize();
		driver.get(urls[index]);
		
		WebElement welcomeScreen=driver.findElement(By.className("cta__saudi"));
		welcomeScreen.click();
	}
	@Test()
	public void myTest() throws InterruptedException, IOException {
		WebElement hotelTab=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelTab.click();
		Thread.sleep(2000);
		
		
		if(driver.getCurrentUrl().contains("en"))
		{	WebElement hotles=driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));

			hotles.sendKeys(englishCities[randomIndex]);
		}
		else
		{
			WebElement hotles=driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));

			hotles.sendKeys(arabicCities[randomIndex1]);
		}
		WebElement reservationSelectSelectElement=driver.findElement(By.className("tln3e3-1"));
		Select select =new Select(reservationSelectSelectElement);
		int num=rand.nextInt(2);
		select.selectByIndex(num);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement citiesList=driver.findElement(By.className("phbroq-4"));
		List<WebElement>allCities=citiesList.findElements(By.tagName("li"));
		allCities.get(1).click();
		
		WebElement HotelSearchBox=driver.findElement(By.className("sc-1vkdpp9-6"));
		HotelSearchBox.click();
		
		Thread.sleep(15000);
		
		Date currentDate=new Date();
		String currentDateAsString=currentDate.toString().replace(":", "-");
		
		TakesScreenshot src= ((TakesScreenshot)driver);
		
		File srcFile= src.getScreenshotAs(OutputType.FILE);
		
        File Dest = new File("src/screenshot"+currentDateAsString+".png");
		
		FileUtils.copyFile (srcFile,Dest);
		
		WebElement hotelsSection=driver.findElement(By.className("col-9"));

        List<WebElement> allPrices=hotelsSection.findElements(By.className("Price__Value"));
        int firstItems= Integer.parseInt(allPrices.get(0).getText());
        int lastItems= Integer.parseInt( allPrices.get(allPrices.size()-1).getText());
        
        Assert.assertEquals(firstItems > lastItems, true);
		
		
	}
	@AfterTest
	public void postTest() {}

}
