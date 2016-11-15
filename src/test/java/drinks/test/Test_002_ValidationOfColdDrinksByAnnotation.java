package drinks.test;

/**
 * Created by Sergio on 11/13/16.
 */

import drinks.org.libs.ConfigData;
import drinks.org.pagesByAnnotation.DrinksOrgByAnnotation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test_002_ValidationOfColdDrinksByAnnotation {
    private static WebDriver driver;
    private static DrinksOrgByAnnotation drinksOrgByAnnotation;
    private static Logger log;
    private static Map<String, String> data = new HashMap();
    private static String appUrl;

    public static final String COCA_COLA ="Coca cola";
    public static final String PEPSI = "Pepsi";
    public static final String ICE_TEA = "Ice Tea";

    public static final String COLD = "COLD";

    public Test_002_ValidationOfColdDrinksByAnnotation() {
    }

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        drinksOrgByAnnotation = new DrinksOrgByAnnotation(driver);
        log = Logger.getLogger(Test_001_ValidationOfHotDrinksByAnnotation.class);
        // data = ExcelDriver.getData("/src/main/resources/testData.xls", "Test_000_ValidationOfHotDrinksByDriver");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void stopTest() {

        drinksOrgByAnnotation.testPage.quit();
    }

    @Test
    public void testColdCocaCola() throws Exception {
        drinksOrgByAnnotation.testPage.openURL(appUrl);
        drinksOrgByAnnotation.testPage.changeIframe();
        drinksOrgByAnnotation.testPage.selectColdDrinkTemperature();
        drinksOrgByAnnotation.testPage.selectDrink(COCA_COLA);
        drinksOrgByAnnotation.testPage.validateChosenDrink("You have selected "+COCA_COLA+" drink which is "+COLD+"!");


    }
    @Test
    public void testColdPepsi() throws Exception {
        drinksOrgByAnnotation.testPage.openURL(appUrl);
        drinksOrgByAnnotation.testPage.changeIframe();
        drinksOrgByAnnotation.testPage.selectColdDrinkTemperature();
        drinksOrgByAnnotation.testPage.selectDrink(PEPSI);
        drinksOrgByAnnotation.testPage.validateChosenDrink("You have selected "+PEPSI+" drink which is "+COLD+"!");


    }

    @Test
    public void testColdIceTea() throws Exception {
        drinksOrgByAnnotation.testPage.openURL(appUrl);
        drinksOrgByAnnotation.testPage.changeIframe();
        drinksOrgByAnnotation.testPage.selectColdDrinkTemperature();
        drinksOrgByAnnotation.testPage.selectDrink(ICE_TEA);
        drinksOrgByAnnotation.testPage.validateChosenDrink("You have selected "+ICE_TEA+" drink which is "+COLD+"!");

    }


}
