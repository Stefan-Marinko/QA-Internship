package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/*Use Case #2 - Log in to Etsy website */

public class Main {
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
        driver.get("https://www.etsy.com/c/jewelry-and-accessories?ref=catnav-10855");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    //Signing in

    public void SignIn() throws InterruptedException {

        //Clicking sign in button in the top right
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();

        //Waiting for the login popup window to show
        Thread.sleep(3000);

        //Entering credentials and uncheking checkbox
        driver.findElement(By.id("join_neu_email_field")).sendKeys("marinko2994@gmail.com");
        driver.findElement(By.id("join_neu_password_field")).sendKeys("popcorn123");

        //Waiting for the supervisor to notice the checkbox is checked
        Thread.sleep(3000);

        //Unckecking
        driver.findElement(By.xpath("//label[@class='checkbox-custom checkbox-large']")).click();

        //Waiting for the supervisor to see everything entered
        Thread.sleep(3000);

        //Clicking Sign in
        driver.findElement(By.name("submit_attempt")).click();
        Thread.sleep(3000);
    }

    //Close the browser

    public void CloseBrowser() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        //Use Case #2 - Log in to Etsy website
	    Main obj = new Main();
	    obj.LaunchBrowser();
	    obj.SignIn();
	    obj.CloseBrowser();

	    //Use Case #4 - Browsing through categories and searching for items
	    Search obj1 = new Search();
	    obj1.LaunchBrowser();
	    obj1.search();
	    obj1.CloseBrowser();

	    //Use Case #5 - Browsing through categories and searching for items
        Browsing obj2 = new Browsing();
        obj2.LaunchBrowser();
        obj2.MouseHover();
        obj2.CloseBrowser();

        //Use Case #7 - Filtering and adding items to cart
        Filtering obj3 = new Filtering();
        obj3.LaunchBrowser();
        obj3.Filtering_and_adding();
        obj3.CloseBrowser();

        //Use Case #7 - Managing your cart
        Managing obj4 = new Managing();
        obj4.LaunchBrowser();
        obj4.SignIn();
        obj4.Cart_manage();
        obj4.CloseBrowser();
    }
}
