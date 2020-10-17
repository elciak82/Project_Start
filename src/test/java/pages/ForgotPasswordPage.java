package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends GenericPage{
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private static final String ERROR_MSG_INVALID_EMAIL_ADDRESS = "Invalid email address."; //już jest
    private static final String ERROR_MSG_NO_ACCOUNT = "There is no account registered for this email address.";
    private static final String CONFIRMATION_SENT = "A confirmation email has been sent to your address: ";
    @FindBy (id = "email")
    WebElement emailField;

    @FindBy (css = "[class = 'submit'] [type='submit']")
    WebElement retrievePasswordButton;

    @FindBy (className = "alert-success" )
    WebElement successMsg;

    @FindBy (css = "[class = 'alert alert-danger'] li")
    WebElement errorMsg;

    private void setEmail(String email) { //to już jest
        emailField.click();
        emailField.sendKeys(email);
    }

    public void sendEmailToChangePassword(String email){
        setEmail(email);
        retrievePasswordButton.click();
    }

    public String getSuccessMsg (){
        return successMsg.getText();
    }

    private String getErrorMsg() { //to już jest
        return errorMsg.getText();
    }

    public Boolean checkSuccessMsg (String email) {
        fluentWaitForElementDisplayed(successMsg);
        return getSuccessMsg().equals(CONFIRMATION_SENT + email);
    }

    public Boolean checkErrorMsgInvalidEmailAddress () { //to już jest
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_INVALID_EMAIL_ADDRESS);
    }

    public Boolean checkErrorMsgNoAccount () {
        fluentWaitForElementDisplayed(errorMsg);
        return getErrorMsg().equals(ERROR_MSG_NO_ACCOUNT);
    }


}
