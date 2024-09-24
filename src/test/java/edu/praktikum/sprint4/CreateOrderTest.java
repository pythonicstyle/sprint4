package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.pom.OrderPage;
import edu.praktikum.sprint4.rules.BrowserRule;
import java.util.Set;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String phone;

    public CreateOrderTest(String firstName, String lastName, String deliveryAddress, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.phone = phone;
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
            { "Иван", "Иванов", "ул. Пушкина д.4", "89999999999" },
            };
    }

    @Test
    public void testOrderFlowTopButton() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.closeCookieWindow();
        mainPage.clickOrderButtonTop();



        OrderPage orderPage = new OrderPage(browserRule.getWebDriver());
        orderPage.fillOrderFormPage1NameFields(firstName, lastName);
        orderPage.fillOrderFormPage1DeliverAddressField(deliveryAddress);
        orderPage.fillOrderFormPage1MetroStationField();
        orderPage.fillOrderFormPage1PhoneField(phone);
        orderPage.clickNextButton();

        orderPage.fillDateToDeliverField();
        orderPage.fillRentalPeriodField();
        orderPage.clickScooterColorButton();
        orderPage.clickCreateOrderButton();
        orderPage.confirmOrder();

        assertTrue("Сообщение об успешном создании заказа не отображается", orderPage.isSuccessMessageVisible());
    }
}


//    @Test
//    public void testOrderFlowBottomButton() {
//        assertTrue("Сообщение об успешном создании заказа не отображается", orderPage.isSuccessMessageVisible());
//    }
