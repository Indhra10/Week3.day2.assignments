package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERailUncheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://erail.in/");
    
		WebElement frombox= driver.findElement(By.id("txtStationFrom"));
		frombox.clear();
		frombox.sendKeys("MS");
		frombox.sendKeys(Keys.ENTER);
		WebElement tobox= driver.findElement(By.id("txtStationTo"));
		tobox.clear();
		tobox.sendKeys("MDU");
		tobox.sendKeys(Keys.ENTER);
		
		WebElement checkbox=driver.findElement(By.id("chkSelectDateOnly"));
		checkbox.click();
		
		
		List<WebElement> trainNumber=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[1]"));
		
	
		for (WebElement webElement : trainNumber) {
			String S =webElement.getText();
			System.out.println("train number: " +S);
			
		}
		//set is declared to fetch the unique train names
		Set<String> strtrain=new LinkedHashSet<String>();
		//List is defined to sort and display the train names
		List<String> strLsort=new ArrayList<String>(); 
		List<WebElement> trainName=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		for (WebElement webElement : trainName) {
			String st=webElement.getText();
			
			strtrain.add(st);
			strLsort.add(st); 
			
		}
		System.out.println("train name: " +strtrain);
		
        Collections.sort(strLsort);
        
        for (String string : strLsort) {
        	
        	System.out.println(string);
			
		}
	}

	
}
