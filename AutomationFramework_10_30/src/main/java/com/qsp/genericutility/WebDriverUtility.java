package com.qsp.genericutility;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	Actions act;
	
	public WebDriverUtility(WebDriver driver) {
		act=new Actions(driver);
	}
	
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	
	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).perform();
	}
	
	public void mouseHover(WebElement element) {
		act.moveToElement(element).perform();
	}
	
	public void scrollToElement(WebElement element) {
		act.scrollToElement(element).perform();
	}
	
	public void switchToWindow(WebDriver driver,String expetedUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			String actUrl = driver.switchTo().window(id).getCurrentUrl();
			if (actUrl.contains(expetedUrl)) {
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
}
