package week3.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioSelections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
	        ChromeDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        
	    driver.navigate().to(" https://www.ajio.com/");
	        
	   driver.findElement(By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input")).sendKeys("Bags men");
       driver.findElement(By.linkText("MEN")).click();
       driver.findElement(By.xpath("//div[@class='column column-3']/div[@class='third-level']/div[2]/span/a")).click();
      
       List<WebElement> noOfImages=driver.findElements(By.tagName("img"));
       System.out.println("The number of backpacks listed in AJIO for men: " +noOfImages.size());
	}

}
