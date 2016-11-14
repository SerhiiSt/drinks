package drinks.test;

import drinks.org.libs.ConfigData;
import drinks.org.pagesByAnnotation.DrinksOrgByAnnotation;
import org.junit.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergio on 11/11/16.
 */
public class Test_001_ValidationOfHotDrinksByAnnotation {
    private static WebDriver driver;
    private static DrinksOrgByAnnotation drinksOrgByAnnotation;
    private static Logger log;
    private static Map<String, String> data = new HashMap();
    private static String appUrl;

    public static final String COFFEE ="Coffee";
    public static final String TEA = "Tea";

    public static final String HOT = "HOT";


    public Test_001_ValidationOfHotDrinksByAnnotation() {
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        drinksOrgByAnnotation = new DrinksOrgByAnnotation(driver);
        log = Logger.getLogger(Test_001_ValidationOfHotDrinksByAnnotation.class);
        // data = ExcelDriver.getData("/src/main/resources/testData.xls", "Test_000_ValidationOfHotDrinksByDriver");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);


    }




    @Test
    public void testHotCoffee() throws Exception {
           drinksOrgByAnnotation.testPage.openURL(appUrl);
           drinksOrgByAnnotation.testPage.changeIframe();
           drinksOrgByAnnotation.testPage.selectDrinkTemperature(HOT);
           drinksOrgByAnnotation.testPage.selectDrink(COFFEE);
           drinksOrgByAnnotation.testPage.validateChosenDrink("You have selected "+COFFEE+" drink which is "+HOT+"!");


    }
    @Test
    public void testHotTea() throws Exception {
        drinksOrgByAnnotation.testPage.openURL(appUrl);
        drinksOrgByAnnotation.testPage.changeIframe();
        drinksOrgByAnnotation.testPage.selectDrinkTemperature(HOT);
        drinksOrgByAnnotation.testPage.selectDrink(TEA);
        drinksOrgByAnnotation.testPage.validateChosenDrink("You have selected "+TEA+" drink which is "+HOT+"!");


    }


    @After
    public  void stopTest() throws Exception {
       // drinksOrgByAnnotation.testPage.locateElement();
        drinksOrgByAnnotation.testPage.clearCache();
        drinksOrgByAnnotation.testPage.quit();
    }


}
