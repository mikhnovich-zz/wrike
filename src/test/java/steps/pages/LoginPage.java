package steps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//a[contains(text(), 'Create account')]")
    public WebElement createAccountLink;
}
