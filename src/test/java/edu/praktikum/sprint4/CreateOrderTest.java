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
                FIRSTNAME1,
                LASTNAME1,
                ADDRESS1,
                PHONE1,
                METROSTATIONVALUECERKIZOVSKAYA,
                CHOOSEDELIVERYDATE1BUTTON,
                CHOOSERENTALPERIOD5DAYS,
                SCOOTERCOLORBLACK
            },
            {
                FIRSTNAME2,
                LASTNAME2,
                ADDRESS2,
                PHONE2,
                METROSTATIONVALUEOKTYABRSKAYA,
                CHOOSEDELIVERYDATE2BUTTON,
                CHOOSERENTALPERIOD1DAY,
                SCOOTERCOLORGREY
            },
        };
    }

    @Test
    public void testOrderFlowTopButton() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.closeCookieWindow();
        mainPage.clickOrderButtonTop();

        OrderPage orderPage = new OrderPage(browserRule.getWebDriver());
        orderPage.fillOrderFormPage1NameFields(firstName, lastName)
            .fillOrderFormPage1DeliverAddressField(deliveryAddress)
            .fillOrderFormPage1MetroStationField(metroStation)
            .fillOrderFormPage1PhoneField(phone)
            .clickNextButton()
            .fillOrderFormPage2DateToDeliverField(deliveryDate)
            .fillOrderFormPage2RentalPeriodField(rentalPeriod)
            .fillOrderFormPage2ScooterColorButton(scooterColor)
            .clickCreateOrderButton()
            .confirmOrder();

        assertTrue(ERRORMESSAGE, orderPage.getSuccessMessageText().contains(SUCCESSMESSAGE));
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
            .fillOrderFormPage2ScooterColorButton(scooterColor)
            .clickCreateOrderButton()
            .confirmOrder();

        assertTrue(ERRORMESSAGE, orderPage.getSuccessMessageText().contains(SUCCESSMESSAGE));
    }
}
