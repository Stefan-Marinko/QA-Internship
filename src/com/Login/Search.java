package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/*Use Case #4 - Browsing through categories and searching for items */

public class Search {
    WebDriver driver;

    //Launching the browser

    public void  LaunchBrowser() throws InterruptedException {
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
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    //Searching for a tiara

    public void search() throws InterruptedException {
        //Entering keyword in the searchbox
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("tiara");

        //Clicking the search button
        driver.findElement(By.xpath("//span[@class='etsy-icon wt-nudge-b-1']")).click();

        //Waiting for the page to load
        Thread.sleep(2000);

        //Refreshing the page
        driver.navigate().refresh();

        //Waiting the page to load after refresh
        Thread.sleep(2000);

        //Scrolling down to see the items
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300);");

        //Waiting for the scroll to finish
        Thread.sleep(2000);

        //Choosing item
        driver.findElement(By.partialLinkText("Wedding tiara")).click();
        Thread.sleep(2000);

    }

    //Close the browser

    public void CloseBrowser(){
        driver.quit();
    }
}
