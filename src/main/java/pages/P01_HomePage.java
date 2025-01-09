package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static pages.PageBase.hoverAndClickONAWebElement;
import static pages.PageBase.hoverToWebElement;

public class P01_HomePage {


    public final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@title=\"My Account\"]")
    WebElement myAccount;

    @FindBy(xpath = "(//ul/li/a)[4]")
    WebElement loginBTN;

    @FindBy(xpath = "(//ul/li/a)[3]")
    WebElement registerBTN;

    @FindBy(xpath = "//input[@name=\"search\"]")
    WebElement searchbox;

    @FindBy(xpath = "(//button[@type=\"button\"])[4]")
    WebElement searchIconButton;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/button/i")
    public WebElement currencyList;

    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[1]/button")
    WebElement euroCurrency;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[2]/button")
    WebElement poundSterling;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[3]/button")
    WebElement uSDollar;

    @FindBy(xpath = "(//div/P/span)[2]")
    public WebElement elementPrice;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]")
    public WebElement categoriesMenu;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li")
    public List<WebElement> categoriesMenuListLi;

    @FindBy(xpath = "(//*[@id=\"menu\"]/div[2]/ul/li/div)")
    public List<WebElement> subCategoryElementsLi;

    @FindBy(xpath = "(//div/div/button)[2]")
    WebElement macbookProduct;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
    WebElement iphoneProduct;

    @FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible'])[1]")
    public WebElement successmessage;

    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement cartButtonText;

    @FindBy(xpath = "(//i[@class='fa fa-heart'])[2]")
    public WebElement macbookAddtoWishList;

    @FindBy(xpath = "(//i[@class='fa fa-heart'])[3]")
    public WebElement iphoneAddtoWishList;

    @FindBy(xpath = "(//i[@class='fa fa-exchange'])[1]")
    public WebElement macbookaddtoCompareList;

    @FindBy(xpath = "(//i[@class='fa fa-exchange'])[2]")
    public WebElement iphoneAddtoCompareList;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]")
    public WebElement checkoutbutton;

    @FindBy(xpath = "//div[@id=\"cart\"]")
    WebElement blackCartButton;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr[1]/td[5]/button/i")
    WebElement removefirstitem;

    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr[2]/td[5]/button/i")
    WebElement removeSecondItem;


    public void clickOn_myAccount() {
        myAccount.click();

    }

    public void clickOn_loginBTN() {
        loginBTN.click();
    }

    public void clickOn_registerBTN() {
        registerBTN.click();
    }

    public void clickOnSearchBoxAndSearchForAnyProduct(String searchkey) {

        searchbox.sendKeys(searchkey);
        searchIconButton.click();

    }

    public List<WebElement> clickOnCurrencyList() {
        currencyList.click();
        List<WebElement> currencyButtons = new ArrayList<>();
        currencyButtons.add(euroCurrency);
        currencyButtons.add(poundSterling);
        currencyButtons.add(uSDollar);
        return currencyButtons;
    }

    public String getElementPrice() {
        String elementPrice = this.elementPrice.getText();
        return elementPrice;
    }

    public void clickOn_macbookAddToCart() {
        macbookProduct.click();
    }

    public void clickOniphoneAddToCart() {
        iphoneProduct.click();
    }

    public void getSuccessMessageText() {
        successmessage.getText();
    }

    public void clickOn_macbookAddtoWishList() {
        macbookAddtoWishList.click();
    }

    public void clickOn_iphoneAddtoWishList() {
        iphoneAddtoWishList.click();
    }

    public void clickOn_macbookaddtoCompareList() {
        macbookaddtoCompareList.click();
    }

    public void clickOn_iphoneAddtoCompareList() {
        iphoneAddtoCompareList.click();
    }

    public void clickOn_cartButton() {
        cartButtonText.click();
    }


    public void clickOnBlackCartButton() {
        blackCartButton.click();
    }

    public void clickOnRemoveFirstItemfromCart() {
        removefirstitem.click();
    }

    public void clickOnRemoveSecondItemfromCart() {
        removeSecondItem.click();
    }

    public void hoverToRandomCategory(int index) {
        WebElement category = driver.findElement(By.xpath("(//div/ul[@class=\"nav navbar-nav\"]/li)[" + index + "]"));
        hoverToWebElement(driver, category);

    }

    public void hoverToSubRandomCategory(int indexsub) {
        WebElement subCategory = driver.findElement(By.xpath("(//div/ul[@class=\"list-unstyled\"]/li)[" + indexsub + "]"));
        hoverAndClickONAWebElement(driver, subCategory);
    }

}
