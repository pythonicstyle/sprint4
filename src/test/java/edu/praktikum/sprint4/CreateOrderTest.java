package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.pom.OrderPage;
import edu.praktikum.sprint4.rules.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static edu.praktikum.sprint4.constants.Constants.*;
import static edu.praktikum.sprint4.pom.OrderPage.*;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final By metroStation;
    private final String phone;
    private final By deliveryDate;
    private final By rentalPeriod;
    private final By scooterColor;


    public CreateOrderTest(
        String firstName, String lastName, String deliveryAddress, String phone, By metroStation,
        By deliveryDate, By rentalPeriod, By scooterColor
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.metroStation = metroStation;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            {
                FIRSTNAME_1,
                LASTNAME_1,
                ADDRESS_1,
                PHONE_1,
                METRO_STATION_CERKIZOVSKAYA,
                DELIVERY_DATE_1_BUTTON,
                RENTAL_PERIOD_5_DAYS,
                SCOOTER_COLOR_BLACK
            },
            {
                FIRSTNAME_2,
                LASTNAME_2,
                ADDRESS_2,
                PHONE_2,
                METRO_STATION_OKTYABRSKAYA,
                DELIVERY_DATE_2_BUTTON,
                RENTAL_PERIOD_1_DAY,
                SCOOTER_COLOR_GREY
            },
        };
    }

    @Test
    public void testOrderFlowTopButton() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.closeCookieWindow()
                .clickOrderButtonTop();

        OrderPage orderPage = new OrderPage(browserRule.getWebDriver());
        orderPage.fillOrderFormPage1NameFields(firstName, lastName)
            .fillOrderFormPage1DeliverAddressField(deliveryAddress)
            .fillOrderFormPage1MetroStationField(metroStation)
            .fillOrderFormPage1PhoneField(phone)
            .clickNextButton()
            .fillOrderFormPage2DateToDeliverField(deliveryDate)
            .fillOrderFormPage2RentalPeriodField(rentalPeriod)
            .fillOrderFormPage2ScooterColorField(scooterColor)
            .clickCreateOrderButton()
            .confirmOrder();

        assertTrue(ERROR_MESSAGE, orderPage.getSuccessMessageText().contains(SUCCESS_MESSAGE));
    }


    @Test
    public void testOrderFlowBottomButton() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.closeCookieWindow()
                .clickOrderButtonBottom();

        OrderPage orderPage = new OrderPage(browserRule.getWebDriver());
        orderPage.fillOrderFormPage1NameFields(firstName, lastName)
            .fillOrderFormPage1DeliverAddressField(deliveryAddress)
            .fillOrderFormPage1MetroStationField(metroStation)
            .fillOrderFormPage1PhoneField(phone)
            .clickNextButton()
            .fillOrderFormPage2DateToDeliverField(deliveryDate)
            .fillOrderFormPage2RentalPeriodField(rentalPeriod)
            .fillOrderFormPage2ScooterColorField(scooterColor)
            .clickCreateOrderButton()
            .confirmOrder();

        assertTrue(ERROR_MESSAGE, orderPage.getSuccessMessageText().contains(SUCCESS_MESSAGE));
    }
}
