package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P05_MyAccountPage;
import utilCodes.DataStorage;

import java.util.List;
import java.util.Random;

import static drivers.DriverHolder.getDriver;
import static utilCodes.Utilities.generateRandomInt;

public class TC06_SelectRandomCategory extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;

    int index = generateRandomInt(8);

    @Test
    public void hoverByMouseAndSelectRandomCategory() {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        myAccountPage = new P05_MyAccountPage(getDriver());

        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.loginDynamic(DataStorage.getEmail(), DataStorage.getPassword());
        myAccountPage.clickOnHomePageIcon();

        List<WebElement> categoryElements = homePage.categoriesMenuListLi;
        System.out.println("Category elements are " + categoryElements.size());
        Random random = new Random();
        int randomIndex = random.nextInt(categoryElements.size());
        System.out.println("random index is " + randomIndex);
        WebElement randomCategory = categoryElements.get(randomIndex);
        System.out.println("random category is " + randomCategory.getText());
        Actions actions = new Actions(getDriver());
        actions.moveToElement(randomCategory).perform();


    }

    @Test
    public void hoverByMouseAndSelectRandomCategory_P() {
        homePage = new P01_HomePage(getDriver());
        homePage.hoverToRandomCategory(index);

    }

}
