package drinks.org.pagesByDriver;

import drinks.org.libs.WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.log4testng.Logger;


import java.io.IOException;

/**
 * Created by Sergio on 6/18/16.
 */
public class TestPageByDriver {
    WebDriver driver;
    WebElements web;
    Logger log;

    public TestPageByDriver(WebDriver driver) throws IOException {
        this.driver = driver;
        this.web = new WebElements(driver);
        this.log = Logger.getLogger(TestPageByDriver.class);
    }



    public void selectDrinkTemperature(String temperature) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        web.selectItemFromDropDownList("TestPage.DrinkTemperature", temperature);
        log.info("Chosen drink temperature");
    }

    public void selectDrink(String nameOfDrink) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        web.selectItemFromDropDownList("TestPage.Drinks",nameOfDrink);
        log.info("Chosen name of drink");
    }

    public void changeIframe() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, InterruptedException {

        web.swithToIframe("TestPage.Iframe");
        log.info("Chosen another iframe");
    }


}
