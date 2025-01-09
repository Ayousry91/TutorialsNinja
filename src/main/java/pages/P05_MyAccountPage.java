package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_MyAccountPage {


    public P05_MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul/li/a/i)[6]")
    WebElement homePageIcon;

    public void clickOnHomePageIcon() {
        homePageIcon.click();
    }

}
