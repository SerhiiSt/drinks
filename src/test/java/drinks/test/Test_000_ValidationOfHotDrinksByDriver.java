package drinks.test;

import drinks.org.libs.ConfigData;
import drinks.org.pagesByDriver.DrinksOrgByDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergio on 11/11/16.
 */
public class Test_000_ValidationOfHotDrinksByDriver {
    private static WebDriver driver;
    private static DrinksOrgByDriver drinksOrgByDriver;
    private static Logger log;
    private static Map<String, String> data = new HashMap();
    private static String appUrl;


    public static final String COFFEE ="Coffee";
    public static final String TEA = "Tea";
    public static final String HOT = "HOT";


    public Test_000_ValidationOfHotDrinksByDriver(){}

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        drinksOrgByDriver = new DrinksOrgByDriver(driver);
        log = Logger.getLogger(Test_000_ValidationOfHotDrinksByDriver.class);
       // data = ExcelDriver.getData("/src/main/resources/testData.xls", "Test_000_ValidationOfHotDrinksByDriver");
        appUrl = ConfigData.getCfgValue("Application_URL");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        drinksOrgByDriver.webElements.openURL(appUrl);
        drinksOrgByDriver.testPageByDriver.changeIframe();
        drinksOrgByDriver.testPageByDriver.selectDrinkTemperature(HOT);
        drinksOrgByDriver.testPageByDriver.selectDrink(COFFEE);


    }

    @AfterClass
    public static void stopTest() {
        drinksOrgByDriver.webElements.quit();
    }


}
