package steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static steps.tests.TestScenario.driver;

public class QAFormPage {
    @FindBy(xpath = "//label[@class=\"switch\"]/button")
    List<WebElement> answers;
    @FindBy(xpath = "//button[ contains(@class,'survey-submit')]")
    public WebElement submitResultsBtn;
    @FindBy(xpath = "//div[contains(@class, 'wg-cell')]/p/button")
    public WebElement resendEmailBtn;

    @FindBy(xpath = "//ul[contains(@class,'wg-footer')]/li/a[contains(@href,'twitter')]/*[name() = 'svg']")
    public WebElement check;

    @FindBy(xpath = "//li/a[contains(@href, 'twitter')]")
    public WebElement twitterLink;

    public void fillInQASection() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class=\"switch\"]/button")));

        Random gen = new Random();
        WebElement answer1;
        WebElement answer2;
        WebElement answer3;
        answer1 = answers.get(gen.nextInt(answers.subList(0, 2).size()));
        answer1.click();
        answer2 = answers.get(gen.nextInt(answers.subList(3, 7).size()) + 3);
        answer2.click();
        answer3 = answers.get(gen.nextInt(answers.subList(7, 9).size()) + 7);
        answer3.click();
    }


}

