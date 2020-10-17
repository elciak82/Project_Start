package tests_selenium.userSignIn;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.ForgotPasswordPage;
import pages.GenericPage;
import pages.HeaderPage;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static helpers.Configuration.getConfiguration;
import static helpers.Driver.initializeWebDriver;

public class CreateAnAccountTests {
    private WebDriver driver;
    private HeaderPage headerPage;


    @Before
    public void setUp() throws InterruptedException {
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
        headerPage = new HeaderPage(driver);

    }

    @Test
    public void createAnAccountTest() {
        headerPage.clickLoginButton()
                .createAnAccount()
                .setFirstName();


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
