package com.testng_parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class YahooTest {
    WebDriver driver;

    @Test
    @Parameters({"browser", "url", "emailId"})
    public void yahooTest(String browser, String url, String emailId) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.get(url);


        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(emailId);

        driver.findElement(By.id("login-signin")).click();

        driver.getCurrentUrl();
        driver.quit();

    }
}

