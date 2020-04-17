package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*Use Case #7 - Managing your cart*/

public class Managing {
    WebDriver  driver;

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
        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Signing in (No explanation of the steps because it's done in Use Case #2)
    public void SignIn(){

        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.id("join_neu_email_field")).sendKeys("marinko2994@gmail.com");
        driver.findElement(By.id("join_neu_password_field")).sendKeys("popcorn123");
        driver.findElement(By.xpath("//label[@class='checkbox-custom checkbox-large']")).click();
        driver.findElement(By.name("submit_attempt")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    //Managing the cart
    public void Cart_manage (){

        //Opening cart
        driver.findElement(By.xpath("//span[@class='inline-svg nav-icon etsy-icon-cart']")).click();

        //Waiting for the page to load
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //Checking checkbox for gift
        driver.findElement(By.xpath("//span[@class='checkbox-label pb-xs-2']")).click();

        //Wait for the second checkbox to show
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Checking checkbox for message
        driver.findElement(By.xpath("//span[@class='checkbox-label']")).click();

        //Wait for the second checkbox to be checked
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Sending random value to the textbox
        String uuid = UUID.randomUUID().toString();
        driver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter your message—make sure to include to/from names')]")).sendKeys(uuid);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    //Close the browser

    public void CloseBrowser() {
        driver.quit();
    }

}
