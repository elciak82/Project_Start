package tests_selenium.userSignIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.HeaderPage;

import static helpers.Configuration.getConfiguration;
import static helpers.Driver.initializeWebDriver;

public class UserForgotPasswordTests {
    private WebDriver driver;
    private HeaderPage headerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private String email;

    @Before
    public void setUp() throws InterruptedException {
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
        headerPage = new HeaderPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        email = getConfiguration().getEmail();

    }

    @Test
    public void forgotPasswordSendEmail() {
        headerPage.clickLoginButton()
                .clickForgotPassword()
                .sendEmailToChangePassword(email);
        Assert.assertTrue(forgotPasswordPage.checkSuccessMsg(email));
    }

    @Test
    public void forgotPasswordIncorrectEmail() {
        headerPage.clickLoginButton()
                .clickForgotPassword()
                .sendEmailToChangePassword("incorrectEmail");
        Assert.assertTrue(forgotPasswordPage.checkErrorMsgInvalidEmailAddress());
    }

    @Test
    public void forgotPasswordNoAccount() {
        headerPage.clickLoginButton()
                .clickForgotPassword()
                .sendEmailToChangePassword("noAccount@email.pl");
        Assert.assertTrue(forgotPasswordPage.checkErrorMsgNoAccount());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
