package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P05_MyAccountPage;
import pages.P06_SearchPage;
import utilCodes.DataStorage;

import java.util.List;
import java.util.Random;

import static drivers.DriverHolder.getDriver;

public class TC05_ChangeCurrency extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;

    @Test
    public void clickonCurrencyListandSelectRandomValue() throws InterruptedException {

        homePage = new P01_HomePage(getDriver());
        myAccountPage = new P05_MyAccountPage(getDriver());
        loginPage = new P02_LoginPage(getDriver());


        Thread.sleep(500);
        String elementpriceBeforeChange = homePage.getElementPrice();
        Thread.sleep(500);
        List<WebElement> elementstoSelect = homePage.clickOnCurrencyList();
        Random random = new Random();
        int randomIndex = random.nextInt(3);
        Thread.sleep(500);
        System.out.println("Your random indx is " + randomIndex);
        elementstoSelect.get(randomIndex).click();
        Thread.sleep(1000);
        String elementPriceAfterChange = homePage.getElementPrice();
        Thread.sleep(500);
        System.out.println("the change in prices with currencies is " + elementPriceAfterChange + " in stead of  " + elementpriceBeforeChange);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(elementPriceAfterChange, elementpriceBeforeChange);
        softAssert.assertAll();
    }
}
