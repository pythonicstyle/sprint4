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


    public static final By QUESTION_1 = By.xpath(
        "//div[@id='accordion__heading-0']");
    public static final By ANSWER_1 = By.xpath(
        "//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или')]");
    public static final By QUESTION_2 = By.xpath(
        "//div[@id='accordion__heading-1']");
    public static final By ANSWER_2 = By.xpath(
        "//p[contains(text(),'Пока что у нас так: один заказ — один самокат')]");
    public static final By QUESTION_3 = By.xpath(
        "//div[@id='accordion__heading-2']");
    public static final By ANSWER_3 = By.xpath(
        "//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат')]");
    public static final By QUESTION_4 = By.xpath(
        "//div[@id='accordion__heading-3']");
    public static final By ANSWER_4 = By.xpath(
        "//p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]");
    public static final By QUESTION_5 = By.xpath(
        "//div[@id='accordion__heading-4']");
    public static final By ANSWER_5 = By.xpath(
        "//p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить')]");
    public static final By QUESTION_6 = By.xpath(
        "//div[@id='accordion__heading-5']");
    public static final By ANSWER_6 = By.xpath(
        "//p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на')]");
    public static final By QUESTION_7 = By.xpath(
        "//div[@id='accordion__heading-6']");
    public static final By ANSWER_7 = By.xpath(
        "//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет')]");
    public static final By QUESTION_8 = By.xpath(
        "//div[@id='accordion__heading-7']");
    public static final By ANSWER_8 = By.xpath(
        "//p[contains(text(),'Да, обязательно. Всем самокатов!')]");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

    }

    public MainPage open() {
        String url = "https://qa-scooter.praktikum-services.ru/";
        webDriver.get(url);
        return this;
    }

    public MainPage scrollPage(By buttonLocator) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(buttonLocator));
        return this;
    }

    public MainPage clickQuestionButton(By buttonLocator) {
        WebElement questionButton = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        questionButton.click();
        return this;
    }

    public boolean isAnswerVisible(By answeLocator) {
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(answeLocator));
        return answer.isDisplayed();
    }
}


