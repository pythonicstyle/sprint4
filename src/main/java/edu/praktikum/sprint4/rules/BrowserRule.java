package edu.praktikum.sprint4.rules;

import static java.time.temporal.ChronoUnit.SECONDS;

import edu.praktikum.sprint4.pom.MainPage;
import java.time.Duration;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserRule extends ExternalResource {

    private WebDriver webDriver;

    protected void before() {
//        String browser = System.getProperty("browser");
//
//        if ("chrome".equals(browser)) {
//            webDriver = new ChromeDriver();
//        } else if ("firefox".equals(browser)) {
//            webDriver = new FirefoxDriver();
//        }

        webDriver = new ChromeDriver();
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
