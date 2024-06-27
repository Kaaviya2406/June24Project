package org.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowshandling {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	WebElement txtSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
	txtSearchBox.sendKeys("IPhone",Keys.ENTER);
	WebElement lnkIPhone = driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 (128GB) - Blue'])[2]"));
	lnkIPhone.click();
	String parentWindowId = driver.getWindowHandle();
	System.out.println(parentWindowId);
	Set<String> allWindowId = driver.getWindowHandles();
	System.out.println(allWindowId);
	
	List<String> li=new ArrayList<String>();
	li.addAll(allWindowId);
	
	String childId = li.get(1);
	driver.switchTo().window(childId);
	WebElement btnAddToCart = driver.findElement(By.id("add-to-cart-button"));
	btnAddToCart.click();
	
	
	
	
	
	
	
	
}
}
