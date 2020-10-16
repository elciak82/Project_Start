package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends GenericPage{
    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "login")
    WebElement loginButton;

    @FindBy (id = "SubmitLogin")
    WebElement submitLogin;

    @FindBy (id = "email")
    WebElement email;

    @FindBy (id = "passwd")
    WebElement passwd;

//    public LoginPage openCartPage(){
//        GenericPage genericPage = new GenericPage(driver);
//        genericPage.fluentWaitForElementDisplayed(cartIcon);
//        cartIcon.click();
//        return new LoginPage(driver);
//    }

    public MyAccountPage logIn(String login, String password) {
        GenericPage genericPage = new GenericPage(driver);
        genericPage.fluentWaitForElementDisplayed(loginButton);
        loginButton.click();
        email.click();
        email.sendKeys(login);
        passwd.click();
        passwd.sendKeys(password);
        submitLogin.click();
        return new MyAccountPage(driver);


    }
}
