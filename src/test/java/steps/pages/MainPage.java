package steps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//div[@class=\"r\"]/form/a[contains(text(), 'Login')]")
    public WebElement loginBtn;

}
