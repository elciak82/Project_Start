package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class GenericPage {
    WebDriver driver;

    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnoprstuvwxyz1234567890";

    GenericPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fluentWaitForElementDisplayed(WebElement elementToBeDisplayed) {
        new FluentWait<>(elementToBeDisplayed)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .until(WebElement::isDisplayed);
    }

    public String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public String generateRandomEmail(){
        String name = randomAlphaNumeric(6);
        return name + "@email.pl";
    }

}
