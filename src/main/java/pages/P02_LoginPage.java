package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_LoginPage {
    public final WebDriver driver;

    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value=\"Login\"]")
    WebElement loginBTN;

    @FindBy(xpath = "(//div/a)[6]")
    WebElement forgottenPasswordButton;

    public void login(String staticEmail, String staticPassword) {
        this.email.sendKeys(staticEmail);
        this.password.sendKeys(staticPassword);
        loginBTN.click();
    }


    public void loginDynamic(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginBTN.click();
    }


    public void clickOnForgottenPasswordButton() {
        forgottenPasswordButton.click();
    }
}
