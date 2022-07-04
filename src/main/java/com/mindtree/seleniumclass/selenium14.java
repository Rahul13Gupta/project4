package com.mindtree.seleniumclass;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium14 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//step 1
		driver.get("https://www.amazon.in/");
		//step 2
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("refrigrator");
		//step 3&4
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		//step 5
		WebElement we=driver.findElement(By.xpath("div[@data-asin='B08SC2ZTDP']//span[@class='a-price-WHOLE])"));
		String price1=we.getText();
		//String con=".00";
		//String price1=pri.concat(con);
		System.out.println(price1);
		//6
		driver.findElement(By.xpath("//img[contains(@alt,'Samsung 192 L 2')]")).click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String pid=it.next();
		String cid=it.next();
		driver.switchTo().window(cid);
		//7
		WebElement wc=driver.findElement(By.xpath("//div[@id='apex_desktop']//span[@class='a-price-whole']"));
		String price2=wc.getText();
		System.out.println(price2);
		if(price1.equals(price2))
		{
			System.out.println("price is same on both tab");
		}
		else
		{
			System.out.println("price is diffrent");
		}
	}
}
