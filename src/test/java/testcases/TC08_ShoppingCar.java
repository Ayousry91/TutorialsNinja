package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P05_MyAccountPage;
import utilCodes.DataStorage;

import static drivers.DriverHolder.getDriver;

public class TC08_ShoppingCar extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;


    @Test
    public void addDifferentProductsToShoppingCart() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        myAccountPage = new P05_MyAccountPage(getDriver());

        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.loginDynamic(DataStorage.getEmail(), DataStorage.getPassword());
        myAccountPage.clickOnHomePageIcon();
        Thread.sleep(1000);
        homePage.clickOn_macbookAddToCart();
        //homePage.clickOniphoneAddToCart();
        System.out.println(homePage.successmessage.getText());
        System.out.println(homePage.cartButtonText.getText());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.successmessage.getText().contains("Success: You have added"));
        softAssert.assertTrue(homePage.successmessage.getText().contains("to your shopping cart!"));
        softAssert.assertTrue(homePage.cartButtonText.getText().contains(" item(s)"));
        softAssert.assertAll();

        Thread.sleep(500);
        homePage.clickOnBlackCartButton();
        homePage.clickOnRemoveFirstItemfromCart();



    }


}
