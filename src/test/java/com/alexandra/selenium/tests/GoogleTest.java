package com.alexandra.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alrevian on 4/2/16.
 */
public class GoogleTest {

    @Test
    public void googleTest(){

        // create browser instance
        WebDriver driver = new FirefoxDriver();
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
    public void gmailTest(){
        // https://mail.google.com
        // id="Email"
        // fill your email
        // press id="next"
        // id="Passwd"
        // fill your pass
        // id="signIn"
    }


}
