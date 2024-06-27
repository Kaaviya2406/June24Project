package org.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.sendKeys("IPhone",Keys.ENTER);
	WebElement lnkIphone = driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Blue'])[2]"));
	lnkIphone.click();
	
	String parentWindowId = driver.getWindowHandle();
	System.out.println(parentWindowId);
	
	Set<String> allWindowHandId = driver.getWindowHandles();
	System.out.println(allWindowHandId);
	
	List<String> li=new ArrayList<String>(allWindowHandId);
	int lastWindow = li.size()-1;
	driver.switchTo().window(li.get(0));
	driver.close();
	
}
}