package testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilCodes.DataStorage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import static drivers.DriverHolder.getDriver;

public class TC11_CreateOrder extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;
    P06_SearchPage searchPage;
    P07_CheckoutPage checkoutPage;


    @Test
    public void addDifferentProductsToShoppingCart() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        myAccountPage = new P05_MyAccountPage(getDriver());

        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.loginDynamic(DataStorage.getEmail(), DataStorage.getPassword());
        myAccountPage.clickOnHomePageIcon();

        homePage.clickOnSearchBoxAndSearchForAnyProduct("HP");
        searchPage = new P06_SearchPage(getDriver());
        searchPage.clickOnsearchPageAddToCartButton();

        getDriver().findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
        getDriver().findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();

        checkoutPage = new P07_CheckoutPage(getDriver());
        Faker faker = new Faker();

        //checkoutPage.clickonUseNewAddress();
        checkoutPage.bilingDetails(faker.name().firstName()
                , faker.name().lastName()
                , faker.address().fullAddress()
                , faker.address().city());

        Random random = new Random();
        Select countrySelect = new Select(checkoutPage.country);
        List<WebElement> countryOptions = countrySelect.getOptions();
        Thread.sleep(500);
        int randomCountryIndex = random.nextInt(countryOptions.size() - 1);
        countrySelect.selectByIndex(randomCountryIndex);

        Thread.sleep(1000);

        Select stateSelect = new Select(checkoutPage.state);
        List<WebElement> stateOptions = stateSelect.getOptions();
        int randomStateIndex = random.nextInt(stateOptions.size());
        stateSelect.selectByIndex(randomStateIndex);

        checkoutPage.clickonbillingcontinuebutton();
        Thread.sleep(500);
        checkoutPage.clickonshippingaddresscontinuebutton();
        Thread.sleep(1000);
        checkoutPage.clickonshippingMethodcontinuebutton();
        Thread.sleep(500);
        checkoutPage.clickontermsandConditionsButton();
        checkoutPage.clickonpaymentMEthodContinueButton();
        Thread.sleep(500);
        checkoutPage.clickonconfirmContinueButton();
        //String successMEssage= checkoutPage.getorderplacementSuccessMessage();
        Thread.sleep(1500);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getDriver().getPageSource().contains("Thanks for shopping with us online!"));
        softAssert.assertTrue(getDriver().getPageSource().contains("Your order has been placed!"));
        //softAssert.assertTrue(successMEssage.contains("Your order has been placed!"));
        softAssert.assertAll();
        checkoutPage.clickonlastContinueButton();


    }


}
