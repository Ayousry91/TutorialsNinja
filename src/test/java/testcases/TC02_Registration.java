package testcases;

import utilCodes.DataStorage;
import utilCodes.Utilities;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_Registration_Page;

import static drivers.DriverHolder.getDriver;
import static utilCodes.Utilities.generateRandomPhoneNumber;

public class TC02_Registration extends TestBase {

    P01_HomePage homePage = new P01_HomePage(getDriver());
    P03_Registration_Page registerPage = new P03_Registration_Page(getDriver());
    Utilities util = new Utilities();
    DataStorage dataStorage = new DataStorage();
    // Generate random data for registration
    String firstName = util.generateRandomString();
    String lastName = util.generateRandomString();
    String phoneNumber = generateRandomPhoneNumber();
    String email = util.generateRandomEmail();
    String password = util.generateRandomString();


    @Test(enabled = false)
    public void registerWithValidData_P() {


        P01_HomePage homePage = new P01_HomePage(getDriver());

        P03_Registration_Page registerPage = new P03_Registration_Page(getDriver());

        homePage.clickOn_myAccount();
        homePage.clickOn_registerBTN();

    }

    @Test
    public void registerNewAccount() throws InterruptedException {

        homePage = new P01_HomePage(getDriver());
        Thread.sleep(700);
        homePage.clickOn_myAccount();
        homePage.clickOn_registerBTN();
        // Generate random data for registration
        registerPage = new P03_Registration_Page(getDriver());
        util = new Utilities();
        String firstName = util.generateRandomString();
        String lastName = util.generateRandomString();
        String phoneNumber = generateRandomPhoneNumber();
        email = util.generateRandomEmail();
        password = util.generateRandomString();

        // Save the generated data to DataStorage class
        dataStorage.setFirstName(firstName);
        dataStorage.setLastName(lastName);
        dataStorage.setPhoneNumber(phoneNumber);
        dataStorage.setEmail(email);
        dataStorage.setPassword(password);
        registerPage.register_new_Account(dataStorage.getFirstName(), dataStorage.getLastName(), dataStorage.getEmail(), dataStorage.getPhoneNumber(), dataStorage.getPassword());
        System.out.println("You registered successfully using the following data " + "  //  " + dataStorage.getFirstName() + "  //  " + dataStorage.getLastName() + "  //  " + dataStorage.getEmail() + "  //  " + dataStorage.getPhoneNumber() + "  //  " + dataStorage.getPassword());

    }


}

