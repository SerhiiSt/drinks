package drinks.org.pagesByDriver;

import drinks.org.libs.WebElements;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by Sergio on 11/10/16.
 */
public class DrinksOrgByDriver {
    WebDriver driver;
    public WebElements webElements;
    public TestPageByDriver testPageByDriver;

    public DrinksOrgByDriver(WebDriver driver) throws IOException {
        webElements = new WebElements(driver);
        testPageByDriver = new TestPageByDriver(driver);

    }
}
