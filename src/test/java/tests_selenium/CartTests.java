package tests_selenium;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.MyAccountPage;

import static helpers.Driver.*;
import static helpers.Configuration.*;

public class CartTests {
    private WebDriver driver;
    private MyAccountPage loginPage;
    private HeaderPage headerPage;
    private String login;
    private String password;

    @Before
    public void setUp() throws InterruptedException {
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
        loginPage = new MyAccountPage(driver);
        headerPage = new HeaderPage(driver);
        login = getConfiguration().getLogin();
        password = getConfiguration().getPassword();
    }

    @Test
    public void firstTest() {
        System.out.println(login);
        headerPage.logIn(login, password);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
