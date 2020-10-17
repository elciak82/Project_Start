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

    public AuthenticationPage clickLoginButton(){
        loginButton.click();
        return new AuthenticationPage(driver);
    }

    public void userSingIn(String email, String password) {
        clickLoginButton().signIn(email, password);
    }
}
