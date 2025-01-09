package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P06_SearchPage {


    public P06_SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul/li/a/i)[6]")
    WebElement homePageIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    WebElement searchPageMyAccount;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
    WebElement searchPageLogOut;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]")
    WebElement searchPageAddToCartButton;

    public void clickOnHomePageIcon() {
        homePageIcon.click();
    }

    public void clickOnSearchPageMyAccount() {
        searchPageMyAccount.click();
    }

    public void clickOnSearchPageLogOut() {
        searchPageLogOut.click();
    }

    public void clickOnsearchPageAddToCartButton() {
        searchPageAddToCartButton.click();
    }


}
