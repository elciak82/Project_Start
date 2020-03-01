package tests_selenium;

import helpers.Configuration;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static helpers.Configuration.getConfiguration;
import static helpers.Driver.initializeWebDriver;

public class CartTests {
    private WebDriver driver;
    public Configuration configuration;

    private final String login = configuration.getLogin();
    private final String password = configuration.getPassword();

    @Before
    public void setUp() throws InterruptedException {
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
//        this.loginPage = new LoginPage(driver);
//        loginPage.loginToPage(login, password);
    }

    @Test
    public void firstTest() {
        System.out.println("firstTest");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
