package com.alexandra.selenium.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by alrevian on 4/2/16.
 */
public class GoogleTest {

    private WebDriver driver;
    @Before
    public void before(){
        driver = new FirefoxDriver();
    }

    @Test
    public void googleTest() {
        // open url
        driver.get("http://www.google.com");
        // find element on page by id/name/xpath
        WebElement inputField = driver.findElement(By.id("lst-ib"));
        // fill input field
        inputField.sendKeys("Cheese!"); // send also a "\n"
        // find button for input element
        WebElement searchButton = driver.findElement(By.name("btnG"));
        // click on button
        searchButton.click();

        /*List<WebElement> findElements = driver.findElements(By.xpath("/[@id='rso']//h3/a"));

        // this are all the links you like to visit
        for (WebElement webElement : findElements)
        {
            System.out.println(webElement.getAttribute("href"));
        }*/
    }

    @Test
    public void gmailTest() throws InterruptedException {

        driver.get("https://mail.google.com");
        // id="Email"
        WebElement inputField = driver.findElement(By.id("Email"));
        // fill your email
        inputField.sendKeys("alexrouxroux");
        // press id="next"
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
        // id="Passwd"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputPasswordField = driver.findElement(By.id("Passwd"));
        // fill your pass
        inputPasswordField.sendKeys("qaz12wsx");
        // id="signIn"
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

    }


    @Test
    public void tunaLoginTest() throws InterruptedException {
        driver.get("http://radiotuna.com/");
        WebElement tunaLogin = driver.findElement(By.id("loginButton"));
        tunaLogin.click();
        WebElement tunaName = driver.findElement(By.id("UserName"));
        tunaName.sendKeys("Alrevian");
        WebElement tunaPass = driver.findElement(By.id("Password"));
        tunaPass.sendKeys("qaz12wsx");
        WebElement tunaLoginButton = driver.findElement(By.xpath(".//*[@id='loginForm']/form/fieldset/input"));
        tunaLoginButton.click();


        WebElement genresTab = driver.findElement(By.id("styleTreeTab"));
        // element present
        Assert.assertNotNull("Genres tab not present", genresTab);
        Assert.assertTrue("Genres tab is not visible", genresTab.isDisplayed());


        // text on page/element present
        Assert.assertEquals("Top page message not equals expected",
                "Our new mobile and tablet-friendly site is now available - try it out here",
                driver.findElement(By.id("mobileSiteMessage")).getText());

        // page title
        Assert.assertEquals("Page title is as expected",
                "Online Radio Stations, Internet Radio, Free Music | Radio Tuna",
                driver.getTitle());

    }

    @After
    public void after(){
        driver.quit();
    }
}
