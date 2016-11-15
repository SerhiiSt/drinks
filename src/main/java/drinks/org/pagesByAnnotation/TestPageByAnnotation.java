package drinks.org.pagesByAnnotation;

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;


import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static drinks.org.libs.ConfigData.ui;

/**
 * Created by Sergio on 6/18/16.
 */
public class TestPageByAnnotation {
    WebDriver driver;
    Logger log;
    WebDriverWait waitForCondition;
    @FindBy(
            id = "firstDropdown"
    )
    WebElement drinkTemperature;
    @FindBy(
            id = "secondDropdown"
    )
    WebElement drinks;

    @FindBy(
            xpath = ".//*[@id='login-button']"
    )
    WebElement loginButton;

    @FindBy(
            css = "#login-email-field"
    )
    WebElement emailField;

    @FindBy(
            id = "login-password-field_"
    )
    WebElement passwordField;

    @FindBy(
            id = "log-in-button"
    )
    WebElement clickLoginButton;

    @FindBy(
            id = "user-header-dropdown"
    )
    WebElement isUserCreated;

    @FindBy(
            className = "result-iframe"
    )
    WebElement iframeLocator;

    @FindBy(
            id = "result"
    )
    WebElement result;




    public TestPageByAnnotation(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log = Logger.getLogger(TestPageByAnnotation.class);
        waitForCondition = new WebDriverWait(driver, 40L);

    }

    public void clearCookies() throws Exception {
        this.driver.manage().deleteAllCookies();
    }

    public void selectDrinkTemperature(String temperature) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {

         drinkTemperature.click();

        WebElement select = driver.findElement(By.id("firstDropdown"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (int i=1;i<options.size();i++) {
            if (temperature.equals(options.get(i).getText()))

                options.get(i).click();
                options.get(i).click();


        }


    }
    public void selectColdDrinkTemperature() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {

        drinkTemperature.click();

        WebElement select = driver.findElement(By.id("firstDropdown"));

        List<WebElement> options = select.findElements(By.tagName("option"));
        for (int i=1;i<options.size();i++) {

            if ("Cold".equals(options.get(i).getText()))


                options.get(i).click();


        }


    }



    public void changeIframe() {
        waitForCondition.until(ExpectedConditions.invisibilityOfElementLocated(By.className("drink")));
        WebElement iframe = driver.findElement(By.className("result-iframe"));
        driver.switchTo().frame(iframe);


    }


    public void selectDrink(String nameOfDrink) {
        drinks.click();
        // This is variant with simple for loop
        WebElement select = driver.findElement(By.id("secondDropdown"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (int i = 1; i < options.size(); i++) {
            if (nameOfDrink.equals(options.get(i).getText()))
                options.get(i).click();


        }

    }


    public void validateChosenDrink(String chosenDrink) {

        Assert.assertEquals(chosenDrink, result.getText());

    }


    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void inputEmailAddress(String email) {
        emailField.clear();
        emailField.sendKeys(new CharSequence[]{email});
        log.info(email + "was inputed into emailField");
    }

    public void inputPassword(String pass) {
        passwordField.click();
        passwordField.sendKeys(new CharSequence[]{pass});

    }

    public void clickLoginButton() {
        clickLoginButton.click();

    }

    public boolean isUserCreated() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        if (this.isUserCreated.isDisplayed()) {
            this.log.info("User has been created");
            return true;
        } else {
            this.log.error("User  has not been created");
            return false;
        }
    }



    public void openURL(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        log.debug("opened URL\' site");

    }

    public void quit() {
        driver.quit();
        log.debug("Quit from the browser");
    }

    public void clearCache() throws Exception {

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("R");

    }





}
