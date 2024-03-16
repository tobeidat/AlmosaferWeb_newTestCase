package almosaferNewTestCases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();

	String[] urls = { "https://www.almosafer.com/ar", "https://www.almosafer.com/en" };
	String[] englishCities = { "jeddah", "muscat" };
	String[] arabicCities = { "دبي", "الرياض" };

	Random rand = new Random();
	int index = rand.nextInt(urls.length);
	int randomIndex = rand.nextInt(englishCities.length);
	int randomIndex1 = rand.nextInt(arabicCities.length);

}
