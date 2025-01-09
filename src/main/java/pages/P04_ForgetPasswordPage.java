package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_ForgetPasswordPage {


    public P04_ForgetPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "input-email")
    WebElement eMailAddressinputfield;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    WebElement suCCEssMsg;

    public void enterEmailAddressAndClickOnContinueButton(String email) {

        eMailAddressinputfield.sendKeys(email);
        continueButton.click();


    }

    public String getSuccessMessageForForgetPassword() {
        suCCEssMsg.getText();
        return suCCEssMsg.getText();

    }


}
