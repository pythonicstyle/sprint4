package edu.praktikum.sprint4.pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    // Кнопки "Заказать" на главной странице
    private final By orderButtonTop = By.xpath(
        "//button[@class='Button_Button__ra12g']");
    public static final By orderButtonBottom = By.xpath(
        "//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Локаторы для куки
    private final By cookieField = By.className("App_CookieText__1sbqp");
    private final By cookieButton = By.id("rcc-confirm-button");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    public MainPage scrollPage(By buttonLocator) {
        ((JavascriptExecutor) webDriver).executeScript(
            "arguments[0].scrollIntoView();",
            webDriver.findElement(buttonLocator)
        );
        return this;
    }

    public void clickQuestionButton(By buttonLocator) {
        WebElement questionButton = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        questionButton.click();
    }

    public boolean isAnswerVisible(By answerLocator) {
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return answer.isDisplayed();
    }

    // кнокпка заказа в хэдере
    public void clickOrderButtonTop() {
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(orderButtonTop));
        orderButton.click();
    }

    // кнокпка заказа со страницы
    public void clickOrderButtonBottom() {
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(orderButtonBottom));
        orderButton.click();
    }

    public MainPage closeCookieWindow() {
        if (webDriver.findElement(cookieField).isDisplayed()) {
            webDriver.findElement(cookieButton).click();
        }
        return this;
    }
}




