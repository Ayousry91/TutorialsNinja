package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P05_MyAccountPage;
import utilCodes.DataStorage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static drivers.DriverHolder.getDriver;
import static utilCodes.Utilities.generateRandomInt;


public class TC07_SelectRandomSubCategory extends TestBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P05_MyAccountPage myAccountPage;

    int index = generateRandomInt(3);
    int a = generateRandomInt(2);  // Generates a random number between 0 and 1, then adds 1
    int b = generateRandomInt(2) + 2;  // Generates a random number between 0 and 1, then adds 3
    int c = generateRandomInt(5) + 5;  // Generates a random number between 0 and 4, then adds 5


    @Test
    public void hoverByMouseAndSelectRandomSubCategory() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());
        myAccountPage = new P05_MyAccountPage(getDriver());
        homePage.clickOn_myAccount();
        homePage.clickOn_loginBTN();
        loginPage.loginDynamic(DataStorage.getEmail(), DataStorage.getPassword());

        myAccountPage.clickOnHomePageIcon();

        List<WebElement> categoryElements = homePage.categoriesMenuListLi;

        System.out.println("Category elements are " + categoryElements.size());
        Thread.sleep(500);
        Random random = new Random();
        int randomIndex = random.nextInt(3);
        System.out.println("random index is " + randomIndex);
        Thread.sleep(500);
        WebElement randomCategory = categoryElements.get(randomIndex);
        System.out.println("random category is " + randomCategory.getText());
        Thread.sleep(500);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(randomCategory).perform();
        Thread.sleep(500);
        List<WebElement> subCategoryElementsLi = homePage.subCategoryElementsLi;

        Thread.sleep(500);
        int randomSubIndex = random.nextInt(subCategoryElementsLi.size() - 1);
        WebElement randomSubCategory = subCategoryElementsLi.get(randomSubIndex);
        Thread.sleep(1000);
        // Click on the randomly selected sub-category
        actions.moveToElement(randomSubCategory).click().build().perform();

    }

    @Test
    public void hoverByMouseAndSelectRandomSubCategory_P() {
        homePage = new P01_HomePage(getDriver());
        homePage.hoverToRandomCategory(index);
        //homePage.hoverToSubRandomCategory(indexsub);
        switch (index) {
            case 1:
                homePage.hoverToSubRandomCategory(a);
                System.out.println("a: " + a);//code to be executed
                break; //optional
            case 2:
                homePage.hoverToSubRandomCategory(b);
                System.out.println("b: " + b);//code to be executed
                break;
            case 3:
                homePage.hoverToSubRandomCategory(c);
                System.out.println("c: " + c);

                break;


        }

    }

}