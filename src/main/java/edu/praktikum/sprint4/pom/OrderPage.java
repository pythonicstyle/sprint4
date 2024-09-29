package edu.praktikum.sprint4.pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    // Локаторы для полей первой страницы заказа
    private final By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By deliverAddressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка перехода на следующую страницу формы заказа
    private final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Локаторы для полей второй страницы заказа
    private final By dateToDeliveryfield = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.xpath("//div[@class='Dropdown-placeholder']");

    // Кнопка "Заказать" на странице заказа
    private final By orderButton = By.xpath(
        "//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Локатор для модального окна с подтверждением заказа
    private final By confirmOrderWindow = By.xpath(
        "//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");

    // Кнопка "Подтвердить" в модальном окне подтверждении заказа
    private final By confirmOrderButton = By.xpath(
        "//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Локатор для модального окна с успешным оформлением заказа
    private final By successOrderMessage = By.className("Order_ModalHeader__3FDaJ");

    // Локаторы для нахождения тестовых данных на странице заказа
    public static final By METRO_STATION_CERKIZOVSKAYA = By.xpath("//button[@value='2']");
    public static final By DELIVERY_DATE_1_BUTTON = By.xpath(
        "//div[@aria-label='Choose понедельник, 23-е сентября 2024 г.']");
    public static final By RENTAL_PERIOD_5_DAYS = By.xpath(
        "//div[@class='Dropdown-option' and text()='пятеро суток']");
    public static final By SCOOTER_COLOR_BLACK = By.xpath("//input[@id='black']");

    public static final By METRO_STATION_OKTYABRSKAYA = By.xpath("//button[@value='104']");
    public static final By DELIVERY_DATE_2_BUTTON = By.xpath(
        "//div[@aria-label='Choose суббота, 5-е октября 2024 г.']");
    public static final By RENTAL_PERIOD_1_DAY = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    public static final By SCOOTER_COLOR_GREY = By.xpath("//input[@id='grey']");


    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    public OrderPage fillOrderFormPage1NameFields(String firstName, String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        webDriver.findElement(firstNameField).sendKeys(firstName);
        webDriver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public OrderPage fillOrderFormPage1DeliverAddressField(String deliveryAddress) {
        webDriver.findElement(deliverAddressField).sendKeys(deliveryAddress);
        return this;
    }

    public OrderPage fillOrderFormPage1MetroStationField(By metro) {
        webDriver.findElement(metroStationField).click();
        webDriver.findElement(metro).click();
        return this;
    }

    public OrderPage fillOrderFormPage1PhoneField(String phone) {
        webDriver.findElement(phoneField).sendKeys(phone);
        return this;
    }

    public OrderPage clickNextButton() {
        webDriver.findElement(nextButton).click();
        return this;
    }

    public OrderPage fillOrderFormPage2DateToDeliverField(By deliveryDate) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateToDeliveryfield));
        webDriver.findElement(dateToDeliveryfield).click();
        webDriver.findElement(deliveryDate).click();
        return this;
    }

    public OrderPage fillOrderFormPage2RentalPeriodField(By rentalPeriod) {
        webDriver.findElement(rentalPeriodField).click();
        webDriver.findElement(rentalPeriod).click();
        return this;
    }

    public OrderPage fillOrderFormPage2ScooterColorField(By scooterColor) {
        webDriver.findElement(scooterColor).click();
        return this;
    }

    public OrderPage clickCreateOrderButton() {
        WebElement order = wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        order.click();
        return this;
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderWindow));
        webDriver.findElement(confirmOrderButton).click();
    }

    public String getSuccessMessageText() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successOrderMessage));
        return successMessage.getText();
    }
}
