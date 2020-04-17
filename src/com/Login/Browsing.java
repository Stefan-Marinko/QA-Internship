package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/*Use Case #5 - Browsing through categories and searching for items*/

public class Browsing {
    WebDriver driver;

    //Launch the browser

    public void  LaunchBrowser(){
        //Put under comment the next three lines of code when testing Mozilla and uncomment the three lines of code under them

        /*System.setProperty("webdriver.chrome.driver", "F:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/

        /*Chrome doesnt work properly with .fullscreen() method, and there is an alternative way of doing it, but i can't get
         it to work properly as well, so i just maximized it*/


        //Put under comment the next three lines of code when testing Chrome and uncomment the three lines of code above

        System.setProperty("webdriver.gecko.driver", "F:\\Gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Hovering the mouse cursor over the category and clicking subcategory

    public void MouseHover() {
        WebElement ele = driver.findElement(By.id("catnav-primary-link-891"));
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Selecting subcategory
        driver.findElement(By.partialLinkText("Clocks")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    //Close the browser

    public void CloseBrowser() {
        driver.quit();
    }



}
