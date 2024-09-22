package edu.praktikum.sprint4;

import static org.junit.Assert.assertTrue;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.rules.BrowserRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;



@RunWith(Parameterized.class)
public class DropdownFaqCheck {

    private final By buttonLocator;
    private final By answerLocator;

    public DropdownFaqCheck(By buttonLocator, By answerLocator) {
        this.buttonLocator = buttonLocator;
        this.answerLocator = answerLocator;
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
            { MainPage.QUESTION_1, MainPage.ANSWER_1 },
            { MainPage.QUESTION_2, MainPage.ANSWER_2 },
            { MainPage.QUESTION_3, MainPage.ANSWER_3 },
            { MainPage.QUESTION_4, MainPage.ANSWER_4 },
            { MainPage.QUESTION_5, MainPage.ANSWER_5 },
            { MainPage.QUESTION_6, MainPage.ANSWER_6 },
            { MainPage.QUESTION_7, MainPage.ANSWER_7 },
            { MainPage.QUESTION_8, MainPage.ANSWER_8 },
        };
    }

    @Test
    public void checkFaqAnswers() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage.scrollPage(buttonLocator)
                .clickQuestionButton(buttonLocator);

        assertTrue(
            "Ответ на вопрос не отображается.",
            mainPage.isAnswerVisible(answerLocator)
        );
    }

}

