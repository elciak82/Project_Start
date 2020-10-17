package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends GenericPage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "icon-list-ol")
    WebElement orderHistoryAndDetails;

    @FindBy (className = "icon-ban-circle")
    WebElement myCreditSlips;

    @FindBy (className = "icon-building")
    WebElement myAddresses;

    @FindBy (className = "icon-user")
    WebElement myPersonalInformation;

    @FindBy (className = "icon-heart")
    WebElement myWishlists;

    public Boolean myAccountIsVisible(){
        return orderHistoryAndDetails.isDisplayed();
    }
}
