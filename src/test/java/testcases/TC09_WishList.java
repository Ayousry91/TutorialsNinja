package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P05_MyAccountPage;
import utilCodes.DataStorage;

import static drivers.DriverHolder.getDriver;

public class TC09_WishList extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;


    @Test
    public void addDifferentProductsToWishList() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        myAccountPage = new P05_MyAccountPage(getDriver());

        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.loginDynamic(DataStorage.getEmail(), DataStorage.getPassword());
        myAccountPage.clickOnHomePageIcon();

        homePage.clickOn_macbookAddtoWishList();
        homePage.clickOn_iphoneAddtoWishList();
        Thread.sleep(1000);
        System.out.println(homePage.successmessage.getText());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.successmessage.getText().contains("Success: You have added"));
        //softAssert.assertTrue(homePage.successmessage.getText().contains("wish list!"));

        softAssert.assertAll();


    }


}
