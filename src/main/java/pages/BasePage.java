package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class BasePage {
    protected WebDriverWait webDriverWait15;
    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait15 = new WebDriverWait(driver, 15);
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement){ //тайпфиэлемент главные (все баттоны, филды являются его на следниками)
            elementName = " '" + ((TypifiedElement) webElement).getName() + "' ";
        }
        return elementName;
    }
    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(getElementName(webElement) + " Element was clicked");
        } catch (Exception e) {
            printErrorMessageAndStopTest(e);
        }
    }
    private void printErrorMessageAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);  //логер писшет в консоль
        Assert.fail("Can not work with element" + e);   //асерт пишет в отчет
    }
    protected void enterTextIntoElement(WebElement webElement, String text) {
        if(text == null){
            return;
        }
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorMessageAndStopTest(e);
        }
    }
}