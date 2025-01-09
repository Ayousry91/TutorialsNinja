package testcases;

import utilCodes.DataStorage;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import java.lang.String;

import static drivers.DriverHolder.getDriver;
import static utilCodes.DataStorage.email;
import static utilCodes.DataStorage.password;

public class TC01_Login extends TestBase {
    P01_HomePage homePage = new P01_HomePage(getDriver());
    P02_LoginPage loginPage = new P02_LoginPage(getDriver());

    @Test(enabled = false)
    public void loginWithValidData_P() {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P02_LoginPage loginPage = new P02_LoginPage(getDriver());
        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.login("lhda@Testawy.com", "esha");
    }

    @Test(enabled = false)
    public void loginWithInvalidData1_N() {
        P01_HomePage homePage = new P01_HomePage(getDriver());
        P02_LoginPage loginPage = new P02_LoginPage(getDriver());
        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();


    }


    @Test()
    public void loginwithDynamicData_P() throws InterruptedException {

//        Thread.sleep(1000);
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        System.out.println("You logged in  successfully using the following data " + " //  " + email + "  //  " + password);

        Thread.sleep(1000);
        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        String email = DataStorage.getEmail();
        String password = DataStorage.getPassword();
        loginPage.loginDynamic(email, password);
        System.out.println("You logged in  successfully using the following data " + " //  " + email + "  //  " + password);
        Thread.sleep(2000);
    }
}
