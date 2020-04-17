package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/*Use Case #7 - Filtering and adding items to cart*/

public class Filtering {
    WebDriver driver;

    //Launch the browser

    public void  LaunchBrowser(){
        //Put under comment the next three lines of code when testing Mozilla and uncomment the three lines of code under them

        /*System.setProperty("webdriver.chrome.driver", "F:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/

        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");        //This is the code for chrome fullscreen, but the rest of the code doesn't work then
        WebDriver driver = new ChromeDriver(options);*/

        /*Chrome doesnt work properly with .fullscreen() method, and there is an alternative way of doing it, but i can't get
         it to work properly as well, so i just maximized it*/


        //Put under comment the next three lines of code when testing Chrome and uncomment the three lines of code above

        System.setProperty("webdriver.gecko.driver", "F:\\Gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.etsy.com/c/jewelry-and-accessories?ref=catnav-10855");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Filtering

    public void Filtering_and_adding(){
        //Scrolling down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");

        //Wait for scroll to reach elements
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Entering minimum and maximum price
        driver.findElement(By.id("search-filter-min-price-input")).sendKeys("10");
        driver.findElement(By.name("max")).sendKeys("50");
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--transparent wt-btn--icon price-submit']")).click();

        //Wait
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //The page refreshes, scroll down again
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,400);");

        //Wait for scroll to reach elements
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Choosing location
        driver.findElement(By.id("shop-location-radio-custom")).click();
        driver.findElement(By.id("shop-location-input")).sendKeys("Serbia");
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--transparent wt-btn--icon wt-nudge-b-4 shop-location-submit']")).click();

        //Sorting
        driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Top Customer Reviews")).click();

        //Scrolling again because the page reloads
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,300);");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Choosing item
        driver.findElement(By.partialLinkText("Coffin wallet")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Changing tested tab and adding to cart
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Selecting quantity from a dropdown list and adding to cart
        WebElement quantity = driver.findElement(By.id("inventory-variation-select-quantity"));
        Select dropdown = new Select(quantity);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        dropdown.selectByIndex(3);
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    //Close the browser

    public void CloseBrowser() {
        driver.quit();
    }
}
