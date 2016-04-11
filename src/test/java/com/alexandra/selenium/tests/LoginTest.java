package com.alexandra.selenium.tests;

/**
 * Created by ag on 07/04/16.
 */


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.gha.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a.UserBar-lnk")).click();
        driver.findElement(By.id("login-user-name")).clear();
        driver.findElement(By.id("login-user-name")).sendKeys("AmeliaP");
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys("zaq12wsx");
        driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();

        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/ul/li[3]/a")).click();

        WebElement membershipCard = driver.findElement(By.cssSelector(".CreditCard.CreditCard--Md>img"));
        Assert.assertTrue("Membership card is not visible", membershipCard.isDisplayed());

        WebElement membershipLevel = driver.findElement(By.xpath(".//*[@id='body']/div[3]/div[1]/div[2]/div/div[2]/div/dl/dd[1]/span"));
        Assert.assertEquals("Wrong membership level", "GOLD", membershipLevel.getText());

        WebElement memberId = driver.findElement(By.xpath(".//*[@id='body']/div[3]/div[1]/div[2]/div/div[2]/div/dl/dd[2]"));
        Assert.assertEquals("Wrong member ID", "8114752148", memberId.getText());

        WebElement memberEmail = driver.findElement(By.id("member-data-email"));
        Assert.assertTrue("Email is not editable!", memberEmail.isEnabled());

        WebElement birthDate = driver.findElement(By.id("date-birth"));
        Assert.assertFalse("Birthday is editable!",birthDate.isEnabled());


        WebElement upperText = driver.findElement(By.cssSelector(".acc-Header-info .u-block"));
        Assert.assertEquals("Level and Id not the same", upperText.getText(), membershipLevel.getText() + " " + memberId.getText());

//        System.out.println(upperText.getText());
//        System.out.println(membershipLevel.getText() + " " + memberId.getText());

//        WebElement newPassword = driver.findElement(By.id("create-password"));
//        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
//        Assert.assertSame(newPassword, confirmPassword);

//       When I should use assertSame ??

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
