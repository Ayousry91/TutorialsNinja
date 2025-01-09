package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P05_MyAccountPage;
import pages.P06_SearchPage;
import utilCodes.DataStorage;

import static drivers.DriverHolder.getDriver;

public class TC04_ProductSearch extends TestBase {

    P05_MyAccountPage myAccountPage;
    DataStorage dataStorage;
    P02_LoginPage loginPage;
    P01_HomePage homePage;
    P06_SearchPage searchPage;

    @Test
    public void productSearch() throws InterruptedException {

        myAccountPage = new P05_MyAccountPage(getDriver());
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        dataStorage = new DataStorage();

        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.loginDynamic(DataStorage.getEmail(), DataStorage.getPassword());
        myAccountPage.clickOnHomePageIcon();

        homePage.clickOnSearchBoxAndSearchForAnyProduct("mac");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getDriver().getPageSource().contains("Products meeting the search criteria"));
        softAssert.assertEquals(getDriver().getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=product/search&search=mac");
        softAssert.assertAll();




    }


}
