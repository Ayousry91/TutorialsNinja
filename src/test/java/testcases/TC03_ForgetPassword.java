package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P04_ForgetPasswordPage;
import pages.P05_MyAccountPage;
import utilCodes.DataStorage;

import static drivers.DriverHolder.getDriver;

public class TC03_ForgetPassword extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;
    P04_ForgetPasswordPage forgetPassword;
    DataStorage dataStorage;

    @Test
    public void forgetPassword() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());

        forgetPassword = new P04_ForgetPasswordPage(getDriver());
        dataStorage = new DataStorage();

        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.clickOnForgottenPasswordButton();
        System.out.println("You are about to reset the password for the following email " + DataStorage.getEmail());
        forgetPassword.enterEmailAddressAndClickOnContinueButton(DataStorage.getEmail());
        Thread.sleep(1000);
        Assert.assertTrue(forgetPassword.getSuccessMessageForForgetPassword().contains("An email with a confirmation link has been sent your email address."));

    }

}
