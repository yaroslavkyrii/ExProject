package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(xpath = ".//a[@href='https://avic.ua/logout']")
    private WebElement signOutButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignOutButtonVisible(){
        return signOutButton.isDisplayed();
    }
}