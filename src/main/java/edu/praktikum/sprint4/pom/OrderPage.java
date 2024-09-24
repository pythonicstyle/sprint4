package edu.praktikum.sprint4.pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    // Локаторы для первой страницы заказа
    private final By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By deliverAddressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By metroStationValue = By.xpath("//button[@value='1']");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
//    private final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    private final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    // Локаторы для второй страницы заказа
    private final By submitButton = By.xpath("//button[contains(text(), 'Создать')]");
    private final By dateToDeliverfield = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By chooseDateButton = By.xpath("//div[@aria-label='Choose понедельник, 23-е сентября 2024 г.']");
    private final By rentalPeriodField = By.xpath("//div[@class='Dropdown-placeholder']");
    private final By chooseRentalPeriodButton = By.xpath("//div[@class='Dropdown-option' and text()='пятеро суток']");
    private final By chooseScooterColorButton = By.xpath("//input[@id='black']");

    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By confirmOrderWindow = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    private final By confirmOrderButton = By.xpath("//button[contains(text(),'Да')]");

    private final By successOrderWindow = By.className("Order_ModalHeader__3FDaJ");
    private final By successOrderInfo = By.className("Order_Text__2broi");



    private By successMessage = By.id("success-message");



    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    public void fillOrderFormPage1NameFields(String firstName, String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        webDriver.findElement(firstNameField).sendKeys(firstName);
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void fillOrderFormPage1DeliverAddressField(String deliveryAddress) {
        webDriver.findElement(deliverAddressField).sendKeys(deliveryAddress);
    }

    public void fillOrderFormPage1MetroStationField() {
        webDriver.findElement(metroStationField).click();
        webDriver.findElement(metroStationValue).click();
    }

    public void fillOrderFormPage1PhoneField(String phone) {
        webDriver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    public void fillDateToDeliverField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateToDeliverfield));
        webDriver.findElement(dateToDeliverfield).click();
        webDriver.findElement(chooseDateButton).click();
    }

    public void fillRentalPeriodField() {
        webDriver.findElement(rentalPeriodField).click();
        webDriver.findElement(chooseRentalPeriodButton).click();
    }

    public void clickScooterColorButton() {
        webDriver.findElement(chooseScooterColorButton).click();
    }

    public void clickCreateOrderButton() {
        WebElement order = wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        order.click();
    }

    public void confirmOrder() {
        webDriver.findElement(confirmOrderWindow).isDisplayed();
        webDriver.findElement(confirmOrderButton).click();
    }

    public boolean isSuccessMessageVisible() {
        WebElement successMessage = wait.until(ExpectedConditions.elementToBeClickable(successOrderWindow));
        return webDriver.findElement(successOrderWindow).isDisplayed();
    }
}
