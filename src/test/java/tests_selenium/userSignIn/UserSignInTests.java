package tests_selenium.userSignIn;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.MyAccountPage;

import static helpers.Driver.*;
import static helpers.Configuration.*;

public class UserSignInTests {
    private WebDriver driver;
    private MyAccountPage myAccountPage;
    private HeaderPage headerPage;
    private AuthenticationPage authenticationPage;
    private String email;
    private String password;

    @Before
    public void setUp() throws InterruptedException {
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
        headerPage = new HeaderPage(driver);
        myAccountPage = new MyAccountPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        email = getConfiguration().getEmail();
        password = getConfiguration().getPassword();
    }

    @Test
    public void correctSignInTest() {
        headerPage.userSingIn(email, password);
        Assert.assertTrue(myAccountPage.myAccountIsVisible());
    }

    @Test
    public void tooShortPasswordTest() {
        String tooShortPassword = "pass";
        headerPage.userSingIn(email, tooShortPassword);
        Assert.assertTrue(authenticationPage.checkErrorMsgInvalidPassword());
    }

    @Test
    public void incorrectPasswordTest() {
        String incorrectPassword = "incorrectPassword";
        headerPage.userSingIn(email, incorrectPassword);
        Assert.assertTrue(authenticationPage.checkErrorMsgInvalidAuthFailed());
    }

    @Test
    public void incorrectLoginTest() {
        String incorrectLogin = "incorrectLogin";
        headerPage.userSingIn(incorrectLogin, password);
        Assert.assertTrue(authenticationPage.checkErrorMsgInvalidEmailAddress());
    }

    @Test
    public void requiredPasswordTest() {
        String requiredPassword = "";
        headerPage.userSingIn(email, requiredPassword);
        Assert.assertTrue(authenticationPage.checkErrorMsgRequiredPassword());
    }

    @Test
    public void requiredLoginTest() {
        String requiredLogin = "";
        headerPage.userSingIn(requiredLogin, password);
        Assert.assertTrue(authenticationPage.checkErrorMsgInvalidRequiredEmail());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
