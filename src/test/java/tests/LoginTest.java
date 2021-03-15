package tests;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //private WebDriver driver;
    //private static final String AVIC_URL = "https://avic.ua/";

    @Test(priority = 1)
    public void validLogin() {
        //driver.get(AVIC_URL);
        getLoginPage().clickOnUserIcon();
        getLoginPage().clickOnLoginField();
        getLoginPage().fillLoginField("380932714113");
        getLoginPage().clickOnPasswordField();
        getLoginPage().fillPasswordField("123456qwerty");
        getLoginPage().clickOnSignIn();
        checkExpectedResult("Greeting Message is not displayed", getHomePage().isGreetingMessageDisplayed());
    }

    @Test(priority = 2)
    public void isButtonSignOutVisible() {
        getLoginPage().clickOnUserIcon();
        getLoginPage().clickOnLoginField();
        getLoginPage().fillLoginField("380932714113");
        getLoginPage().clickOnPasswordField();
        getLoginPage().fillPasswordField("123456qwerty");
        getLoginPage().clickOnSignIn();
        getHomePage().clickOnGreetingCloseButton();
        getLoginPage().clickOnUserIcon();
        checkExpectedResult("Button SignOut is not displayed", getProfilePage().isSignOutButtonVisible());
    }
    @Test(priority = 3)
    public void isInvalidAuthorizationMessageDisplayed() {
        getLoginPage().clickOnUserIcon();
        getLoginPage().clickOnLoginField();
        getLoginPage().fillLoginField("980932714113");
        getLoginPage().clickOnPasswordField();
        getLoginPage().fillPasswordField("123456");
        getLoginPage().clickOnSignIn();
        checkExpectedResult("Authorization Message is not displayed", getLoginPage().isInvalidAuthorizationMessage());
    }
}