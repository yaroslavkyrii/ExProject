package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = ".//div[@class='header-bottom__right-icon']//i[@class='icon icon-user-big']")
    private WebElement userIcon;
    @FindBy(xpath = ".//form[@action='https://avic.ua/authorization']//input[@class='validate']")
    private WebElement loginField;
    @FindBy(xpath = ".//input[@class='validate show-password']")
    private WebElement passwordField;
    @FindBy(xpath = ".//button[@class='button-reset main-btn submit main-btn--green']")
    private WebElement signInButton;
    @FindBy(xpath = ".//div[text()=' Неверные данные авторизации.  ']")
    private WebElement invalidAuthorizationMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnUserIcon(){
        clickOnElement(userIcon);
    }

    public void clickOnLoginField(){
        loginField.clear();
    }

    public void fillLoginField(String login){
        enterTextIntoElement(loginField, login);
    }
    /*public void fillLoginFieldWithInvalidValue(String invalidLogin){
        loginField.sendKeys(invalidLogin);
        logger.info("Invalid LogIn was inputted into LoginInput");
    }*/

    public void clickOnPasswordField(){
        passwordField.clear();
    }

    public void fillPasswordField(String password){
        enterTextIntoElement(passwordField, password);
    }
    /*public void fillPasswordFieldWithInvalidValue(String invalidPassword){
        passwordField.sendKeys(invalidPassword);
        logger.info("Invalid Password was inputted into InputPass");
    }*/

    public void clickOnSignIn(){
        clickOnElement(signInButton);
        logger.info("Button SignIn was clicked");
    }

    public boolean isInvalidAuthorizationMessage(){
        return invalidAuthorizationMessage.isDisplayed();
    }
}