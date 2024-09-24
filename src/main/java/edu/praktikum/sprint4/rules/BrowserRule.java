package edu.praktikum.sprint4.rules;

import static edu.praktikum.sprint4.constants.Constants.BROWSER;
import static edu.praktikum.sprint4.constants.Constants.URL;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserRule extends ExternalResource {

    private WebDriver webDriver;

    protected void before() {

        if ("chrome".equals(BROWSER)) {
            webDriver = new ChromeDriver();
        } else {
            webDriver = new FirefoxDriver();
        }
        webDriver.get(URL);
    }

    protected void after() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
