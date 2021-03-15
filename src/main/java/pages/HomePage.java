package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = ".//div[text()='Вы успешно авторизовались!']")
    private WebElement greetingMessage;

    @FindBy(xpath = ".//button[@type='button']")
    private WebElement greetingCloseButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchField;

    public void searchByKeyword(final String searchWord){
        searchField.sendKeys(searchWord, Keys.ENTER);
    }

    public boolean isGreetingMessageDisplayed() {
        return greetingMessage.isDisplayed();
    }

    public void clickOnGreetingCloseButton(){
        clickOnElement(greetingCloseButton);
        logger.info("Greeting Message was closed");
    }
}