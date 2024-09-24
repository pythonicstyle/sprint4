package edu.praktikum.sprint4;

import static edu.praktikum.sprint4.constants.Constants.ERRORMESSAGE;
import static edu.praktikum.sprint4.constants.Constants.*;
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
    public static Object[][] getTestData() {
        return new Object[][] {
            { QUESTION_1, ANSWER_1 },
            { QUESTION_2, ANSWER_2 },
            { QUESTION_3, ANSWER_3 },
            { QUESTION_4, ANSWER_4 },
            { QUESTION_5, ANSWER_5 },
            { QUESTION_6, ANSWER_6 },
            { QUESTION_7, ANSWER_7 },
            { QUESTION_8, ANSWER_8 },
            };
    }

    @Test
    public void checkFaqAnswers() {

        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage.scrollPage(buttonLocator)
            .clickQuestionButton(buttonLocator);

        assertTrue(ERRORMESSAGE, mainPage.isAnswerVisible(answerLocator));
    }

}

