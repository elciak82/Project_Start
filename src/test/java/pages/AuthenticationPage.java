package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends GenericPage{
    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "[href='/cart']")
    WebElement cartIcon;

    @FindBy (css = "class=login")
    WebElement signIn;

}
