package edu.praktikum.sprint4.constants;

import org.openqa.selenium.By;

public class Constants {
    public static final String FIRSTNAME1 = "Андрей";
    public static final String LASTNAME1 = "Петров";
    public static final String ADDRESS1 = "ул. Пушкина д.4";
    public static final String PHONE1 = "89999999999";

    public static final String FIRSTNAME2 = "Николай";
    public static final String LASTNAME2 = "Васильев";
    public static final String ADDRESS2 = "парк Горького";
    public static final String PHONE2 = "89876543210";

    public static final String SUCCESSMESSAGE = "Заказ оформлен";
    public static final String ERRORMESSAGE = "Что-то пошло не так.";

    public static final String BROWSER = System.getProperty("browser");
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Локаторы для нахождения тестовых данных для оформления заказа
    public static final By METROSTATIONVALUECERKIZOVSKAYA = By.xpath("//button[@value='2']");
    public static final By CHOOSEDELIVERYDATE1BUTTON = By.xpath(
        "//div[@aria-label='Choose понедельник, 23-е сентября 2024 г.']");
    public static final By CHOOSERENTALPERIOD5DAYS = By.xpath(
        "//div[@class='Dropdown-option' and text()='пятеро суток']");
    public static final By SCOOTERCOLORBLACK = By.xpath("//input[@id='black']");

    public static final By METROSTATIONVALUEOKTYABRSKAYA = By.xpath("//button[@value='104']");
    public static final By CHOOSEDELIVERYDATE2BUTTON = By.xpath(
        "//div[@aria-label='Choose суббота, 5-е октября 2024 г.']");
    public static final By CHOOSERENTALPERIOD1DAY = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    public static final By SCOOTERCOLORGREY = By.xpath("//input[@id='grey']");

    //Локаторы для нахождения вопросов на FAQ
    public static final By QUESTION_1 = By.xpath("//div[@id='accordion__heading-0']");
    public static final By QUESTION_2 = By.xpath("//div[@id='accordion__heading-1']");
    public static final By QUESTION_3 = By.xpath("//div[@id='accordion__heading-2']");
    public static final By QUESTION_4 = By.xpath("//div[@id='accordion__heading-3']");
    public static final By QUESTION_5 = By.xpath("//div[@id='accordion__heading-4']");
    public static final By QUESTION_6 = By.xpath("//div[@id='accordion__heading-5']");
    public static final By QUESTION_7 = By.xpath("//div[@id='accordion__heading-6']");
    public static final By QUESTION_8 = By.xpath("//div[@id='accordion__heading-7']");

    //Локаторы для нахождения ответов на FAQ
    public static final By ANSWER_1 = By.xpath(
        "//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или')]");
    public static final By ANSWER_2 = By.xpath(
        "//p[contains(text(),'Пока что у нас так: один заказ — один самокат')]");
    public static final By ANSWER_3 = By.xpath(
        "//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат')]");
    public static final By ANSWER_4 = By.xpath(
        "//p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]");
    public static final By ANSWER_5 = By.xpath(
        "//p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить')]");
    public static final By ANSWER_6 = By.xpath(
        "//p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на')]");
    public static final By ANSWER_7 = By.xpath(
        "//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет')]");
    public static final By ANSWER_8 = By.xpath(
        "//p[contains(text(),'Да, обязательно. Всем самокатов!')]");
}
