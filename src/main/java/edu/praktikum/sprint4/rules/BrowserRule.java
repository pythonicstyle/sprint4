package edu.praktikum.sprint4.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserRule extends ExternalResource {

    private WebDriver webDriver;

    protected void before() {
        String browser = System.getProperty("browser");

        if ("firefox".equals(browser)) {
            webDriver = new FirefoxDriver();
        } else {
            webDriver = new ChromeDriver();
        }

//        WebDriver webDriver = new ChromeDriver();
//        WebDriver webDriver = new FirefoxDriver();
        String url = "https://qa-scooter.praktikum-services.ru/";
        webDriver.get(url);

    }

    protected void after() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
