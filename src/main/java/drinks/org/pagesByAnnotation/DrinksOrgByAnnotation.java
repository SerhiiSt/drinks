package drinks.org.pagesByAnnotation;

import drinks.org.libs.WebElements;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by Sergio on 11/10/16.
 */
public class DrinksOrgByAnnotation {
    WebDriver driver;
    public TestPageByAnnotation testPage;


    public DrinksOrgByAnnotation(WebDriver driver) throws IOException {
        WebElements webElements = new WebElements(driver);
        this.testPage = new TestPageByAnnotation(driver);

    }
}
