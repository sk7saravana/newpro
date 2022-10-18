package com.selenium;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Fb {


	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\krish\\eclipse-workspace\\MavenProject\\src\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      
        
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
		
        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("9047155482");
        driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("8526331154");
        driver.findElement(By.xpath("//button[contains(@name,'login')]")).click();
        Thread.sleep(5000);
        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");    
        
        driver.findElement(By.xpath("//select//following::option[contains(@value,'COG')]")).click();
        driver.quit();
        
        Actions a = new Actions(driver);
        a.contextClick(null).build().perform();
        a.doubleClick();
        a.dragAndDrop(null, null);
        a.moveToElement(null);
        a.keyDown(null, title);
        
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        WebElement findElement = driver.findElement(By.id("pass"));
        Select s = new Select(findElement);
        
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window(title);
        
        TakesScreenshot shot = (TakesScreenshot) driver;
        File screenshotAs = shot.getScreenshotAs(OutputType.FILE);
        File f = new File("path");
        FileUtils.copyFile(screenshotAs, f);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoview(true);", args)
	}

}
