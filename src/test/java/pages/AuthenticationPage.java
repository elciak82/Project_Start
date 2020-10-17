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

    private static final String ERROR_MSG_INVALID_PASSWORD = "Invalid password.";
    private static final String ERROR_MSG_INVALID_EMAIL_ADDRESS = "Invalid email address."; //już jest
    private static final String ERROR_MSG_REQUIRED_PASSWORD = "Password is required.";
    private static final String ERROR_MSG_REQUIRED_EMAIL = "An email address required.";
    private static final String ERROR_MSG_AUTH_FAILED = "Authentication failed.";

    @FindBy (id = "SubmitLogin")
    WebElement signInButton;

    @FindBy (id = "email")
    WebElement emailField;

    @FindBy (id = "passwd")
    WebElement passwdField;

    @FindBy (id = "email_create")
    WebElement emailCreateAccount;

    @FindBy (css = "[class = 'alert alert-danger'] li")
    WebElement errorMsg;

    @FindBy (css = "[title='Recover your forgotten password']")
    WebElement forgotPassword;

    @FindBy (id = "SubmitCreate")
    WebElement createAnAccountButton;

    private void setEmail(String email) { //już jest
        emailField.click();
        emailField.sendKeys(email);
    }

    private void setPasswdField(String password) {
        passwdField.click();
        passwdField.sendKeys(password);
    }

    private void setEmailCreateAccount(String email) { //już jest
        emailCreateAccount.click();
        emailCreateAccount.sendKeys(email);
    }

    private String getErrorMsg() {
        return errorMsg.getText();
    }

    private void clickSignInButton(){
        signInButton.click();
    }

    private void clickAnAccountButton(){
        createAnAccountButton.click();
    }

    public ForgotPasswordPage clickForgotPassword(){
        forgotPassword.click();
        return new ForgotPasswordPage (driver);
    }

    public MyAccountPage signIn(String email, String password) {
        fluentWaitForElementDisplayed(signInButton);
        setEmail(email);
        setPasswdField(password);
        clickSignInButton();
        return new MyAccountPage(driver);
    }

    public CreateAnAccountPage createAnAccount() {
        fluentWaitForElementDisplayed(createAnAccountButton);
        String newEmail= generateRandomEmail();
        setEmailCreateAccount(newEmail);
        clickAnAccountButton();
        return new CreateAnAccountPage(driver);
    }

    public Boolean checkErrorMsgInvalidPassword () {
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_INVALID_PASSWORD);
    }

    public Boolean checkErrorMsgInvalidEmailAddress () { //to juz jest
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_INVALID_EMAIL_ADDRESS);
    }

    public Boolean checkErrorMsgRequiredPassword() {
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_REQUIRED_PASSWORD);
    }

    public Boolean checkErrorMsgInvalidRequiredEmail () {
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_REQUIRED_EMAIL);
    }

    public Boolean checkErrorMsgInvalidAuthFailed () {
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_AUTH_FAILED);
    }

}
