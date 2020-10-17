package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends GenericPage{
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "id_gender2")
    WebElement genderRadioButton;

    @FindBy (id = "customer_firstname")
    WebElement firstNameInput;

    @FindBy (id = "account-creation_form")
    WebElement accountCreationForm;


    public void setFirstName() {
        fluentWaitForElementDisplayed(accountCreationForm);
        String randomFirstName = randomAlphaNumeric(9);
        firstNameInput.click();
        firstNameInput.sendKeys(randomFirstName);
    }

//    public void fillingInFormCreateAnAccount(){
//        loginButton.click();
//        return new AuthenticationPage(driver);
//    }

//    public void userSingIn(String email, String password) {
//        clickLoginButton().signIn(email, password);
//    }
}
