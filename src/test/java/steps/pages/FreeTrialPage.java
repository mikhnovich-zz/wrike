package steps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.resources.EmailGenerator;


public class FreeTrialPage {
    @FindBy(xpath = "//div[@class = \"r\"]/form/button[contains(text(), 'Get started')]")
    public WebElement getStartedBtn;
    @FindBy(xpath = "//label/input[@type='email']")
    public WebElement emailOnTrialFornField;
    @FindBy (xpath = "//label/button[contains(text(),'Create')]")
    public WebElement createAccountBtn;
    private static String emailSuffix = "+wpt@wriketask.qaa";
    String generatedEmail;

    public String generateEmail() {
        for (int i = 0; i < 30; i++) {
            generatedEmail = EmailGenerator.generate(emailSuffix);
        }
        return generatedEmail;
    }

    public void createAccount() {
        getStartedBtn.click();
        emailOnTrialFornField.sendKeys(generateEmail());
    }


}
