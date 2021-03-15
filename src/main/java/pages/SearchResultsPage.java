package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResultsPage extends BasePage{
    WebDriverWait webDriverWait15;

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> listOfSearchedElements;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        webDriverWait15 = new WebDriverWait(driver, 15);
    }

    public int getSearchResultsCount() {
        return getSearchedElements().size();
    }

    public List<WebElement> getSearchedElements(){
        return listOfSearchedElements;
    }
    public void waitNumbersOfSearchResultsToBe(int numberOfResults){
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait15.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='prod-cart__descr']"), numberOfResults));
    }
    public void getElements() {
        for (WebElement webElement : getSearchedElements()) {
            assertTrue(webElement.getText().contains("MacBook Air"));
        }
    }
}