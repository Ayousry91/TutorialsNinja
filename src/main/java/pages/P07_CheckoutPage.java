package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P07_CheckoutPage {


    public P07_CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label")
    WebElement selectnewaddress;

    @FindBy(id = "input-payment-firstname")
    WebElement firstname;
    @FindBy(id = "input-payment-lastname")
    WebElement lastname;
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @FindBy(id = "input-payment-city")
    WebElement city;

    @FindBy(id = "input-payment-country")
    public WebElement country;
    @FindBy(id = "input-payment-zone")
    public WebElement state;

    @FindBy(id = "button-payment-address")
    WebElement billingcontinuebutton;

    @FindBy(id = "button-shipping-address")
    WebElement shippingaddresscontinuebutton;

    @FindBy(id = "button-shipping-method") //button-shipping-address
    WebElement shippingMethodcontinuebutton;

    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
    WebElement termsandConditionsButton;

    @FindBy(id = "button-payment-method")
    WebElement paymentMEthodContinueButton;

    @FindBy(id = "button-confirm")
    WebElement confirmContinueButton;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement orderplacementSuccessMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement lastContinueButton;


    public void bilingDetails(String firstname, String lastname, String address, String city) {

        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.address.sendKeys(address);
        this.city.sendKeys(city);


    }

    public void clickonUseNewAddress() {
        selectnewaddress.click();
    }

    public void clickonbillingcontinuebutton() {
        billingcontinuebutton.click();
    }

    public void clickonshippingaddresscontinuebutton() {
        shippingaddresscontinuebutton.click();
    }

    public void clickonshippingMethodcontinuebutton() {
        shippingMethodcontinuebutton.click();
    }

    public void clickontermsandConditionsButton() {
        termsandConditionsButton.click();
    }

    public void clickonpaymentMEthodContinueButton() {
        paymentMEthodContinueButton.click();
    }

    public void clickonconfirmContinueButton() {
        confirmContinueButton.click();
    }

    public String getorderplacementSuccessMessage() {
        return orderplacementSuccessMessage.getText();
    }

    public void clickonlastContinueButton() {
        lastContinueButton.click();
    }


}
