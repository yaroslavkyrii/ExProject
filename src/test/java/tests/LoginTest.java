package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLogin() {
        getLoginPage().clickOnUserIcon();
        getLoginPage().clickOnLoginField();
        getLoginPage().fillLoginField();
        getLoginPage().clickOnPasswordField();
        getLoginPage().fillPasswordField();
        getLoginPage().clickOnSignIn();
        Assert.assertTrue("Greeting Message is not displayed", getHomePage().isGreetingMessageDisplayed());
    }

    @Test(priority = 2)
    public void isButtonSignOutVisible() {
        getLoginPage().clickOnUserIcon();
        getLoginPage().clickOnLoginField();
        getLoginPage().fillLoginField();
        getLoginPage().clickOnPasswordField();
        getLoginPage().fillPasswordField();
        getLoginPage().clickOnSignIn();
        getHomePage().clickOnGreetingCloseButton();
        getLoginPage().clickOnUserIcon();
        Assert.assertTrue("Button SignOut is not displayed", getProfilePage().isSignOutButtonVisible());
    }
    @Test(priority = 3)
    public void isInvalidAuthorizationMessageDisplayed() {
        getLoginPage().clickOnUserIcon();
        getLoginPage().clickOnLoginField();
        getLoginPage().fillLoginFieldWithInvalidValue();
        getLoginPage().clickOnPasswordField();
        getLoginPage().fillPasswordFieldWithInvalidValue();
        getLoginPage().clickOnSignIn();
        Assert.assertTrue("Authorization Message is not displayed", getLoginPage().isInvalidAuthorizationMessage());
    }
}