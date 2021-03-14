package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest{

    private String SEARCH_KEYWORD = "MacBook Air";
    private String EXPECTED_SEARCH_QUERY = "query=MacBook+Air";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }
    @Test(priority = 2)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultPage().getSearchedElements()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
    @Test(priority = 3)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().waitNumbersOfSearchResultsToBe(12);
        assertEquals(getSearchResultPage().getSearchResultsCount(), 12);
    }
}