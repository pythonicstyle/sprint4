package edu.praktikum.sprint4.rules;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;
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

        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
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
