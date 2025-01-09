package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class P03_Registration_Page {

    public P03_Registration_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(id = "input-firstname")
    WebElement fname;

    @FindBy(id = "input-lastname")
    WebElement lname;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "(//div/div/input)[8]")
    WebElement agreePrivacyPolicyBTN;

    @FindBy(xpath = "(//div/div/input)[9]")
    WebElement continueBTN;

    @FindBy(xpath = "//span[text()=\"My Account\"]")
    WebElement myAccount;

    @FindBy(xpath = "(//li/ul/li/a)[5]")
    WebElement lOgOUT;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement continueButton;

    //Action Methods
    public void register_new_Account(String fname, String lname, String email, String telephone, String password) throws InterruptedException {
        this.fname.sendKeys(fname);
        this.lname.sendKeys(lname);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
        agreePrivacyPolicyBTN.click();
        continueBTN.click();
        Thread.sleep(5000);
        myAccount.click();
        lOgOUT.click();
        Thread.sleep(2000);
        continueButton.click();


    }

    public void clickOnMyAccOuntbutton() {
        myAccount.click();
    }

    public void clickOnLogOutButton() {
        lOgOUT.click();
    }

}
