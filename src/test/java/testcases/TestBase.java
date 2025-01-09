package testcases;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.*;
import static pages.PageBase.quitBrowser;

public class TestBase {

    //static WebDriver driver;
    @Parameters("browsername")
    @BeforeClass
    public void driverSetup(String browsername) {
        //driver = new ChromeDriver();
        // driver.manage().window().maximize();
        setDriver(DriverFactory.getNewInstance(browsername));

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        getDriver().get("https://tutorialsninja.com/demo/index.php?route=common/home");


    }


    @AfterClass
    public void tearDown() {
      //  getDriver().quit();
        quitBrowser(getDriver());

    }
}
